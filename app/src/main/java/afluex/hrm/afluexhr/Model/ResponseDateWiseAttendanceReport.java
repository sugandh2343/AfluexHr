package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseDateWiseAttendanceReport {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("lstDateWiseAttendanceReport")
    @Expose
    private ArrayList<lstDateWiseAttendanceReport> lstDateWiseAttendanceReport;
    @SerializedName("AttendType")
    @Expose
    private ArrayList<Modelddleave> AttendType;
    @SerializedName("ISHalfFullDay")
    @Expose
    private ArrayList<Modelddleave> ISHalfFullDay;


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

    public ArrayList<afluex.hrm.afluexhr.Model.lstDateWiseAttendanceReport> getLstDateWiseAttendanceReport() {
        return lstDateWiseAttendanceReport;
    }

    public void setLstDateWiseAttendanceReport(ArrayList<afluex.hrm.afluexhr.Model.lstDateWiseAttendanceReport> lstDateWiseAttendanceReport) {
        this.lstDateWiseAttendanceReport = lstDateWiseAttendanceReport;
    }

    public ArrayList<Modelddleave> getAttendType() {
        return AttendType;
    }

    public void setAttendType(ArrayList<Modelddleave> attendType) {
        AttendType = attendType;
    }

    public ArrayList<Modelddleave> getISHalfFullDay() {
        return ISHalfFullDay;
    }

    public void setISHalfFullDay(ArrayList<Modelddleave> ISHalfFullDay) {
        this.ISHalfFullDay = ISHalfFullDay;
    }
}
