package chatroom.client.service;

import chatroom.common.Message;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.net.Socket;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class ClientConnectServerThread extends Thread{
    private Socket socket;

    public ClientConnectServerThread(Socket socket){
        this.socket=socket;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {
        while(true){

            try {
//                System.out.println("Client Waiting Message from Server");
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms = (Message)ois.readObject();
                System.out.println(ms.getSender()+" to everyone:"+ms.getContent());
            } catch (Exception e) {
                try {
                    System.out.println("Server Exception");

                    socket.close();
                    System.exit(1);

                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
//                e.printStackTrace();
            }
        }
    }
}
