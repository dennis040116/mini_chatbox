package chatroom.server.service;

import chatroom.common.Message;
import chatroom.common.MessageType;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class Chat_Server {
    private ServerSocket ss=null;

    public static void main(String[] args) {
        new Chat_Server();
    }

    public Chat_Server(){

        try {
            System.out.println("Server listens on port 9999");
            ss=new ServerSocket(9999);
            while(true){
                Socket socket=ss.accept();

                ObjectInputStream ois =
                        new ObjectInputStream(socket.getInputStream());
                ObjectOutputStream oos=
                        new ObjectOutputStream(socket.getOutputStream());
                chatroom.common.User ur =(chatroom.common.User)ois.readObject();
                Message ms=new Message();
                ms.setMesType(MessageType.MESSAGE_LOGIN_SUCCEED);
                oos.writeObject(ms);
                ServerThread serverThread =
                        new ServerThread(socket, ur.getUid());
                serverThread.start();
                ServerThreadPool.addServerThread(ur.getUid(),serverThread);

            }
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            try {
                ss.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
