package chatroom.common;

import java.io.Serializable;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class User implements Serializable {

    private static final long serialVersionUID=1L;
    private String uid;


    public User(String uid) {
        this.uid = uid;
    }

    public User() {
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
