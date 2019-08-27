package com.oyo.lock;

import org.smartboot.socket.MessageProcessor;
import org.smartboot.socket.StateMachineEnum;
import org.smartboot.socket.transport.AioQuickServer;
import org.smartboot.socket.transport.AioSession;

import java.io.IOException;

/**
 * @author liurui
 * @time 2019-08-14 20:18
 */
public class Server {
    //private static int num = 0;

    public static boolean flag = false;

    public static void main(String[] args) throws IOException, InterruptedException {



        // 1
        AioQuickServer<String> server = new AioQuickServer<String>(8080, new StringProtocol(), new MessageProcessor<String>() {
            public void process(AioSession<String> session, String msg) {
                System.out.println("接受到客户端消息:" + msg);

                byte[] response = "Hi Client!".getBytes();
                byte[] head = {(byte) response.length};
                try {
                    session.writeBuffer().write(head);
                    session.writeBuffer().write(response);
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }

            public void stateEvent(AioSession<String> session, StateMachineEnum stateMachineEnum, Throwable throwable) {
//                if (stateMachineEnum.equals(StateMachineEnum.SESSION_CLOSED)) {
//                    System.out.println("客户端关闭了");
//                }


                switch (stateMachineEnum) {
                    case NEW_SESSION:
                        flag = true;
                        System.out.println("开启新会话:" + session.getSessionID());
                        break;
                    case SESSION_CLOSED:
                        System.out.println("会话关闭:" + session.getSessionID());
                        break;
                    default:
                        break;
                }




            }
        });
        //2
        server.start();

        Thread.sleep(2000);
        if (flag == false) {
            System.out.println("客户端没有运行，请启动客户端");
        }
    }


}
