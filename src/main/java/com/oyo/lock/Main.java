package com.oyo.lock;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioQuickClient;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;
import java.util.concurrent.ExecutionException;

/**
 * @author liurui
 * @time 2019-08-14 20:26
 */
public class Main {
    public static void main(String[] args) throws InterruptedException, ExecutionException, IOException {
        AioQuickClient<String> client = new AioQuickClient<String>("127.0.0.1", 8080, new StringProtocol(), new MessageProcessor<String>() {
            public void process(AioSession<String> session, String msg) {
                System.out.println(msg);
            }

            public void stateEvent(AioSession<String> session, StateMachineEnum stateMachineEnum, Throwable throwable) {
            }
        });

        long l = System.currentTimeMillis();
        AioSession<String> session = client.start();
        System.out.println(System.currentTimeMillis()-l);
        byte[] msgBody = "Hello Server!".getBytes();
        byte[] msgHead = {(byte) msgBody.length};
        try {
            session.writeBuffer().write(msgHead);
            session.writeBuffer().write(msgBody);
            session.writeBuffer().flush();
        } catch (IOException e) {
            e.printStackTrace();
        }

        long l1 = System.currentTimeMillis();
        AioSession<String> session1 = client.start();
        System.out.println(System.currentTimeMillis()-l1);



        long l11 = System.currentTimeMillis();
        AioSession<String> session11 = client.start();
        System.out.println(System.currentTimeMillis()-l11);


        long l2 = System.currentTimeMillis();
        AioSession<String> session2 = client.start();
        System.out.println(System.currentTimeMillis()-l2);
    }

    public static void close() {
        //
        System.out.println("关闭主程序");
    }
}
