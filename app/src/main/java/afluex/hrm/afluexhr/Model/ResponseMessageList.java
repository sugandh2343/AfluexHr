package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseMessageList {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("lstList")
    @Expose
    private ArrayList<lstList> lstList;

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public ArrayList<afluex.hrm.afluexhr.Model.lstList> getLstList() {
        return lstList;
    }

    public void setLstList(ArrayList<afluex.hrm.afluexhr.Model.lstList> lstList) {
        this.lstList = lstList;
    }
}
