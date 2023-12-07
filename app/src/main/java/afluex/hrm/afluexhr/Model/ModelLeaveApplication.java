package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelLeaveApplication {
    @SerializedName("LeaveID")
    @Expose
    private String leaveID;
    @SerializedName("LeaveName")
    @Expose
    private String leaveName;
    @SerializedName("UsedLeave")
    @Expose
    private String usedLeave;
    @SerializedName("LeaveLimit")
    @Expose
    private String leaveLimit;
    @SerializedName("RemainingLeave")
    @Expose
    private String remainingLeave;

    public String getLeaveID() {
        return leaveID;
    }

    public void setLeaveID(String leaveID) {
        this.leaveID = leaveID;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getUsedLeave() {
        return usedLeave;
    }

    public void setUsedLeave(String usedLeave) {
        this.usedLeave = usedLeave;
    }

    public String getLeaveLimit() {
        return leaveLimit;
    }

    public void setLeaveLimit(String leaveLimit) {
        this.leaveLimit = leaveLimit;
    }

    public String getRemainingLeave() {
        return remainingLeave;
    }

    public void setRemainingLeave(String remainingLeave) {
        this.remainingLeave = remainingLeave;
    }
}
