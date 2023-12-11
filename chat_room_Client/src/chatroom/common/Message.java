package chatroom.common;

import java.io.Serializable;

/**
 * @author: dennis
 * @dennis's java_study
 */
public class Message implements Serializable {
    private static final long serialVersionUID=1L;
    private String content;
    private String sender;
    private String mesType;

    public String getMesType() {
        return mesType;
    }

    public void setMesType(String mesType) {
        this.mesType = mesType;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }
}
