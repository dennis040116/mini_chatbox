package chatroom.server.service;

import java.util.HashMap;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class ServerThreadPool {
    private static HashMap<String, ServerThread> hm =new HashMap<>();

    public static HashMap<String, ServerThread> getHm(){
        return hm;
    }
    public static void addServerThread(String uid, ServerThread st){
        hm.put(uid,st);
    }

    public static void removeServerThread(String uid){
        hm.remove(uid);
    }
    public static ServerThread getServerThread(String uid){
        return hm.get(uid);
    }
}
