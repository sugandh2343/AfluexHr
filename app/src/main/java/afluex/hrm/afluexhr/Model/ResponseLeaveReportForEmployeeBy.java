package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseLeaveReportForEmployeeBy {
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
    @SerializedName("FromDate")
    @Expose
    private String fromDate;
    @SerializedName("ToDate")
    @Expose
    private String toDate;
    @SerializedName("LeaveStatus")
    @Expose
    private String leaveStatus;

  @SerializedName("lstleavereports")
    @Expose
    private ArrayList<lstleavereports> lstleavereports;

  @SerializedName("ddlLeave")
    @Expose
    private ArrayList<Modelddleave> ddlLeave;
@SerializedName("RequestStatus")
    @Expose
    private ArrayList<Modelddleave> RequestStatus;

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

    public String getLeaveStatus() {
        return leaveStatus;
    }

    public void setLeaveStatus(String leaveStatus) {
        this.leaveStatus = leaveStatus;
    }

    public ArrayList<afluex.hrm.afluexhr.Model.lstleavereports> getLstleavereports() {
        return lstleavereports;
    }

    public void setLstleavereports(ArrayList<afluex.hrm.afluexhr.Model.lstleavereports> lstleavereports) {
        this.lstleavereports = lstleavereports;
    }

    public ArrayList<Modelddleave> getDdlLeave() {
        return ddlLeave;
    }

    public void setDdlLeave(ArrayList<Modelddleave> ddlLeave) {
        this.ddlLeave = ddlLeave;
    }

    public ArrayList<Modelddleave> getRequestStatus() {
        return RequestStatus;
    }

    public void setRequestStatus(ArrayList<Modelddleave> requestStatus) {
        RequestStatus = requestStatus;
    }
}
