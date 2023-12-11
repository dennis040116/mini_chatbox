package chatroom.server.service;

import chatroom.common.Message;


import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.HashMap;
import java.util.Iterator;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class ServerThread extends Thread{
    private Socket socket;
    private String uid;

    public ServerThread(Socket socket, String uid) {
        this.socket = socket;
        this.uid = uid;
    }

    public Socket getSocket() {
        return socket;
    }

    @Override
    public void run() {

        while(true){
            try {
                System.out.println("Server is in connect with user"+uid);
                ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
                Message ms =(Message) ois.readObject();

                HashMap<String,ServerThread>hm= ServerThreadPool.getHm();
                Iterator<String> iterator=hm.keySet().iterator();
                while(iterator.hasNext()){
                    String uid=iterator.next().toString();
                    if(!uid.equals(ms.getSender())){
                        ObjectOutputStream oos=
                                new ObjectOutputStream(hm.get(uid).getSocket().getOutputStream());
                        oos.writeObject(ms);
                    }
                }

            } catch (Exception e) {
                try {
                    System.out.println("user"+uid+" exit");
                    ServerThreadPool.removeServerThread(uid);
                    socket.close();
                    break;
                } catch (IOException ioException) {
                    ioException.printStackTrace();
                }
//                e.printStackTrace();
            }
        }
    }
}
