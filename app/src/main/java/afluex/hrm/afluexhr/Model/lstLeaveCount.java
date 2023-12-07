package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class lstLeaveCount {
    @SerializedName("LeaveAppID")
    @Expose
    private String leaveAppID;
    @SerializedName("EmployeeID")
    @Expose
    private String employeeID;
    @SerializedName("LeaveName")
    @Expose
    private String leaveName;
    @SerializedName("LeaveLimit")
    @Expose
    private String leaveLimit;
    @SerializedName("UsedLeave")
    @Expose
    private String usedLeave;
    @SerializedName("RemainingLeave")
    @Expose
    private String remainingLeave;

    public String getLeaveAppID() {
        return leaveAppID;
    }

    public void setLeaveAppID(String leaveAppID) {
        this.leaveAppID = leaveAppID;
    }

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getLeaveLimit() {
        return leaveLimit;
    }

    public void setLeaveLimit(String leaveLimit) {
        this.leaveLimit = leaveLimit;
    }

    public String getUsedLeave() {
        return usedLeave;
    }

    public void setUsedLeave(String usedLeave) {
        this.usedLeave = usedLeave;
    }

    public String getRemainingLeave() {
        return remainingLeave;
    }

    public void setRemainingLeave(String remainingLeave) {
        this.remainingLeave = remainingLeave;
    }
}
