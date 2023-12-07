package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseLeaveApllication {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("LeaveID")
    @Expose
    private String leaveID;
    @SerializedName("EmployeeID")
    @Expose
    private String employeeID;
@SerializedName("lstleaveapplication")
    @Expose
    private ArrayList<ModelLeaveApplication> leaveApplicationArrayList;
@SerializedName("ddlLeave")
    @Expose
    private ArrayList<Modelddleave> modelddleaveArrayList;

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

    public String getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(String leaveID) {
        this.leaveID = leaveID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public ArrayList<ModelLeaveApplication> getLeaveApplicationArrayList() {
        return leaveApplicationArrayList;
    }

    public void setLeaveApplicationArrayList(ArrayList<ModelLeaveApplication> leaveApplicationArrayList) {
        this.leaveApplicationArrayList = leaveApplicationArrayList;
    }

    public ArrayList<Modelddleave> getModelddleaveArrayList() {
        return modelddleaveArrayList;
    }

    public void setModelddleaveArrayList(ArrayList<Modelddleave> modelddleaveArrayList) {
        this.modelddleaveArrayList = modelddleaveArrayList;
    }
}
