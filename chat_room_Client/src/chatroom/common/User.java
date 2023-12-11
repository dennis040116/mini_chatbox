package chatroom.common;

import java.io.Serializable;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class User implements Serializable {
    private String uid;
    private static final long serialVersionUID=1L;

    public User(){}

    public User(String uid) {
        this.uid = uid;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }
}
