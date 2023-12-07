package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseAttendnace {
    @SerializedName("FK_EmpID")
    @Expose
    private String fKEmpID;
    @SerializedName("FromDate")
    @Expose
    private Object fromDate;
    @SerializedName("ToDate")
    @Expose
    private Object toDate;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("listAttenndace")
    @Expose
    private ArrayList<ModelAttendanceList> listAttenndace;

    public String getFKEmpID() {
        return fKEmpID;
    }

    public void setFKEmpID(String fKEmpID) {
        this.fKEmpID = fKEmpID;
    }

    public Object getFromDate() {
        return fromDate;
    }

    public void setFromDate(Object fromDate) {
        this.fromDate = fromDate;
    }

    public Object getToDate() {
        return toDate;
    }

    public void setToDate(Object toDate) {
        this.toDate = toDate;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public String getfKEmpID() {
        return fKEmpID;
    }

    public void setfKEmpID(String fKEmpID) {
        this.fKEmpID = fKEmpID;
    }

    public ArrayList<ModelAttendanceList> getListAttenndace() {
        return listAttenndace;
    }

    public void setListAttenndace(ArrayList<ModelAttendanceList> listAttenndace) {
        this.listAttenndace = listAttenndace;
    }
}
