package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class lstleavereports {
    @SerializedName("LeaveAppID")
    @Expose
    private String leaveAppID;
    @SerializedName("EmployeeID")
    @Expose
    private String employeeID;
    @SerializedName("EmployeeLeaveID")
    @Expose
    private String employeeLeaveID;
    @SerializedName("UsedLeave")
    @Expose
    private String usedLeave;
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("Remark")
    @Expose
    private String remark;
    @SerializedName("RequestRemark")
    @Expose
    private String RequestRemark;
    @SerializedName("LeaveStatus")
    @Expose
    private String leaveStatus;
    @SerializedName("ApprovedDate")
    @Expose
    private String approvedDate;
    @SerializedName("ApprovedBy")
    @Expose
    private String approvedBy;
    @SerializedName("EmployeeName")
    @Expose
    private String employeeName;
    @SerializedName("LeaveName")
    @Expose
    private String leaveName;
    @SerializedName("Name")
    @Expose
    private String name;

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

    public String getEmployeeLeaveID() {
        return employeeLeaveID;
    }

    public void setEmployeeLeaveID(String employeeLeaveID) {
        this.employeeLeaveID = employeeLeaveID;
    }

    public String getUsedLeave() {
        return usedLeave;
    }

    public void setUsedLeave(String usedLeave) {
        this.usedLeave = usedLeave;
    }

    public String getFromDate() {
        return fromDate;
    }

    public void setFromDate(String fromDate) {
        this.fromDate = fromDate;
    }

    public String getToDate() {
        return toDate;
    }

    public void setToDate(String toDate) {
        this.toDate = toDate;
    }

    public String getRemark() {
        return remark;
    }

    public void setRemark(String remark) {
        this.remark = remark;
    }

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public String getApprovedDate() {
        return approvedDate;
    }

    public void setApprovedDate(String approvedDate) {
        this.approvedDate = approvedDate;
    }

    public String getApprovedBy() {
        return approvedBy;
    }

    public void setApprovedBy(String approvedBy) {
        this.approvedBy = approvedBy;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getLeaveName() {
        return leaveName;
    }

    public void setLeaveName(String leaveName) {
        this.leaveName = leaveName;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }


    public String getRequestRemark() {
        return RequestRemark;
    }

    public void setRequestRemark(String requestRemark) {
        RequestRemark = requestRemark;
    }
}
