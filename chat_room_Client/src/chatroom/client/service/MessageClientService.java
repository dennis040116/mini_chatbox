package chatroom.client.service;


import chatroom.common.Message;

import java.io.IOException;
import java.io.ObjectOutputStream;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class MessageClientService {

    public void sendMessageToAll(String content,String senderId){
        Message message=new Message();
        message.setSender(senderId);
        message.setContent(content);
//        System.out.println(senderId+" send to everyone:"+content);

        try {
            ObjectOutputStream oos = new ObjectOutputStream(ClientThreadPool.getThread(senderId).getSocket().getOutputStream());
            oos.writeObject(message);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
