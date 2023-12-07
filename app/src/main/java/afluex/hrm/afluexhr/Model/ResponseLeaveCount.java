package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseLeaveCount {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("EmployeeID")
    @Expose
    private String employeeID;
 @SerializedName("lstLeaveCount")
    @Expose
    private ArrayList<lstLeaveCount>lstLeaveCount;

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

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public ArrayList<afluex.hrm.afluexhr.Model.lstLeaveCount> getLstLeaveCount() {
        return lstLeaveCount;
    }

    public void setLstLeaveCount(ArrayList<afluex.hrm.afluexhr.Model.lstLeaveCount> lstLeaveCount) {
        this.lstLeaveCount = lstLeaveCount;
    }
}
