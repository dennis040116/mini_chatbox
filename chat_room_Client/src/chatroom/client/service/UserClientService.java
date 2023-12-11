package chatroom.client.service;


import chatroom.common.Message;
import chatroom.common.MessageType;
import chatroom.common.User;


import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.InetAddress;
import java.net.Socket;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class UserClientService {

    private User u=new User();
    private Socket socket;

    public void commuteWithServer(String uid){
//        boolean b=false;
        u.setUid(uid);

        try {
            socket=new Socket(InetAddress.getLocalHost(),9999);

            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
            oos.writeObject(u);

            ObjectInputStream ois = new ObjectInputStream(socket.getInputStream());
            Message ms = (Message)ois.readObject();

            if(ms.getMesType().equals(MessageType.MESSAGE_LOGIN_SUCCEED)){
                ClientConnectServerThread c_cst = new ClientConnectServerThread(socket);
                c_cst.start();
                ClientThreadPool.addClientConnectServerThread(uid,c_cst);

//                b=true;
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

//    public void logout(){
//        Message message=new Message();
//        message.setMesType(MessageType.MESSAGE_CLIENT_EXIT);
//        message.setSender(u.getUid());
//
//        try {
//            ObjectOutputStream oos = new ObjectOutputStream(socket.getOutputStream());
//            oos.writeObject(message);
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
//    }
}
