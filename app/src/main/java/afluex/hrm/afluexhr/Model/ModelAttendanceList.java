package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ModelAttendanceList {

    @SerializedName("LoginID")
    @Expose
    private String loginID;
    @SerializedName("Name")
    @Expose
    private String name;
    @SerializedName("FatherName")
    @Expose
    private String fatherName;
    @SerializedName("DOB")
    @Expose
    private String dob;
    @SerializedName("Gender")
    @Expose
    private String gender;
    @SerializedName("MobileNo")
    @Expose
    private String mobileNo;
    @SerializedName("EmailID")
    @Expose
    private String emailID;
    @SerializedName("PerAddress")
    @Expose
    private String perAddress;
    @SerializedName("LocAddress")
    @Expose
    private String locAddress;
    @SerializedName("AttendanceDate")
    @Expose
    private String attendanceDate;
    @SerializedName("InTime")
    @Expose
    private String inTime;
    @SerializedName("OutTime")
    @Expose
    private String outTime;
    @SerializedName("UploadFile")
    @Expose
    private String uploadFile;
    @SerializedName("Latitude")
    @Expose
    private String latitude;
    @SerializedName("Longitude")
    @Expose
    private String longitude;
    @SerializedName("PunchIn")
    @Expose
    private String punchIn;
    @SerializedName("PunchOut")
    @Expose
    private String punchOut;
    @SerializedName("OutLatitude")
    @Expose
    private String outLatitude;
    @SerializedName("OutLongitude")
    @Expose
    private String outLongitude;

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getFatherName() {
        return fatherName;
    }

    public void setFatherName(String fatherName) {
        this.fatherName = fatherName;
    }

    public String getDob() {
        return dob;
    }

    public void setDob(String dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMobileNo() {
        return mobileNo;
    }

    public void setMobileNo(String mobileNo) {
        this.mobileNo = mobileNo;
    }

    public String getEmailID() {
        return emailID;
    }

    public void setEmailID(String emailID) {
        this.emailID = emailID;
    }

    public String getPerAddress() {
        return perAddress;
    }

    public void setPerAddress(String perAddress) {
        this.perAddress = perAddress;
    }

    public String getLocAddress() {
        return locAddress;
    }

    public void setLocAddress(String locAddress) {
        this.locAddress = locAddress;
    }

    public String getAttendanceDate() {
        return attendanceDate;
    }

    public void setAttendanceDate(String attendanceDate) {
        this.attendanceDate = attendanceDate;
    }

    public String getInTime() {
        return inTime;
    }

    public void setInTime(String inTime) {
        this.inTime = inTime;
    }

    public String getOutTime() {
        return outTime;
    }

    public void setOutTime(String outTime) {
        this.outTime = outTime;
    }

    public String getUploadFile() {
        return uploadFile;
    }

    public void setUploadFile(String uploadFile) {
        this.uploadFile = uploadFile;
    }

    public String getLatitude() {
        return latitude;
    }

    public void setLatitude(String latitude) {
        this.latitude = latitude;
    }

    public String getLongitude() {
        return longitude;
    }

    public void setLongitude(String longitude) {
        this.longitude = longitude;
    }

    public String getPunchIn() {
        return punchIn;
    }

    public void setPunchIn(String punchIn) {
        this.punchIn = punchIn;
    }

    public String getPunchOut() {
        return punchOut;
    }

    public void setPunchOut(String punchOut) {
        this.punchOut = punchOut;
    }

    public String getOutLatitude() {
        return outLatitude;
    }

    public void setOutLatitude(String outLatitude) {
        this.outLatitude = outLatitude;
    }

    public String getOutLongitude() {
        return outLongitude;
    }

    public void setOutLongitude(String outLongitude) {
        this.outLongitude = outLongitude;
    }
}
