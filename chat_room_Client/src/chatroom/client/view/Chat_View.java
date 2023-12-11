package chatroom.client.view;

import chatroom.client.service.MessageClientService;
import chatroom.client.service.UserClientService;
import chatroom.client.utils.Utility;


/**
 * @author: dennis
 * @dennis's java_study
 */
public class Chat_View {

    private boolean loop=true;
    
    private UserClientService ucs=new UserClientService();
    private MessageClientService mc=new MessageClientService();
    public static void main(String[] args) {
        new Chat_View().mainPage();

    }

    private void mainPage(){

        while(loop){
            System.out.println("===============" +
                    "Welcome to My Chatroom================");
            System.out.print("please enter your uid:");
            String uid= Utility.readString(50);
            ucs.commuteWithServer(uid);
            System.out.println("================Welcome (User:"+uid+") ===============");
            System.out.println("\nwhat you want to say to everyone:");
            while (true) {

                String s=Utility.readString(10000000);
                mc.sendMessageToAll(s,uid);
            }
        }

    }
}
