package chatroom.client.service;



import java.util.HashMap;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class ClientThreadPool {
    private static HashMap<String, ClientConnectServerThread> hm=new HashMap<>();

    public static void addClientConnectServerThread(String uid,ClientConnectServerThread c_cst){
        hm.put(uid,c_cst);
    }

    public static ClientConnectServerThread getThread(String uid){
        return hm.get(uid);
    }
}
