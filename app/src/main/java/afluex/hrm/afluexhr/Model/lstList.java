package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class lstList {
    @SerializedName("MessageID")
    @Expose
    private String messageID;
    @SerializedName("RequestCode")
    @Expose
    private String requestCode;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("MessageDate")
    @Expose
    private String messageDate;
    @SerializedName("MessageStatus")
    @Expose
    private String messageStatus;

    public String getMessageID() {
        return messageID;
    }

    public void setMessageID(String messageID) {
        this.messageID = messageID;
    }

    public String getRequestCode() {
        return requestCode;
    }

    public void setRequestCode(String requestCode) {
        this.requestCode = requestCode;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getMessageDate() {
        return messageDate;
    }

    public void setMessageDate(String messageDate) {
        this.messageDate = messageDate;
    }

    public String getMessageStatus() {
        return messageStatus;
    }

    public void setMessageStatus(String messageStatus) {
        this.messageStatus = messageStatus;
    }
}
