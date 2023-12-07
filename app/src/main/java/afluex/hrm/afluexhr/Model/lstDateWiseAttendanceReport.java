package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class lstDateWiseAttendanceReport {
    @SerializedName("EmployeeID")
    @Expose
    private String employeeID;
    @SerializedName("EmployeeName")
    @Expose
    private String employeeName;
    @SerializedName("EmployeeLoginId")
    @Expose
    private String employeeLoginId;
    @SerializedName("ISHalfDay")
    @Expose
    private String iSHalfDay;
    @SerializedName("Attendance")
    @Expose
    private String attendance;
    @SerializedName("AttendanceDate")
    @Expose
    private String attendanceDate;

    public String getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(String employeeID) {
        this.employeeID = employeeID;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getEmployeeLoginId() {
        return employeeLoginId;
    }

    public void setEmployeeLoginId(String employeeLoginId) {
        this.employeeLoginId = employeeLoginId;
    }

    public String getISHalfDay() {
        return iSHalfDay;
    }

    public void setISHalfDay(String iSHalfDay) {
        this.iSHalfDay = iSHalfDay;
    }

    public String getAttendance() {
        return attendance;
    }

    public void setAttendance(String attendance) {
        this.attendance = attendance;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }
}
