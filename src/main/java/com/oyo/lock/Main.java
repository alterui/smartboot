package com.oyo.lock;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * @author liurui
 * @time 2019-08-14 20:26
 */
public class Main {
    static ExecutorService executorService = Executors.newSingleThreadExecutor();
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {


        AioQuickClient<String> client = new AioQuickClient<String>("127.0.0.1", 8081, new StringProtocol(), new MessageProcessor<String>() {
            public void process(AioSession<String> session, String msg) {
                System.out.println(msg);
            }

            public void stateEvent(AioSession<String> session, StateMachineEnum stateMachineEnum, Throwable throwable) {
            }
        });

        long l = System.currentTimeMillis();
        AioSession<String> session = client.start();
        System.out.println(System.currentTimeMillis()-l);


        executorService.execute(()->{
            byte[] msgBody = "Hello Server!".getBytes();
            byte[] msgHead = {(byte) msgBody.length};
            try {


                session.writeBuffer().write(msgHead);
                session.writeBuffer().write(msgBody);
                session.writeBuffer().flush();
            } catch (IOException e) {
                e.printStackTrace();
            }
        });



    }

    public static void close() {
        //
        System.out.println("关闭主程序");
    }
}
