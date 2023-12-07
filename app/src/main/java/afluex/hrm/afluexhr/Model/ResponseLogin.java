package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class ResponseLogin {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;
    @SerializedName("LoginID")
    @Expose
    private String loginID;
    @SerializedName("PK_EmployeeID")
    @Expose
    private String pKEmployeeID;
    @SerializedName("UserType")
    @Expose
    private String userType;
    @SerializedName("EmployeeName")
    @Expose
    private String employeeName;
    @SerializedName("ProfilePic")
    @Expose
    private String profilePic;

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

    public String getLoginID() {
        return loginID;
    }

    public void setLoginID(String loginID) {
        this.loginID = loginID;
    }

    public String getPKEmployeeID() {
        return pKEmployeeID;
    }

    public void setPKEmployeeID(String pKEmployeeID) {
        this.pKEmployeeID = pKEmployeeID;
    }

    public String getUserType() {
        return userType;
    }

    public void setUserType(String userType) {
        this.userType = userType;
    }

    public String getEmployeeName() {
        return employeeName;
    }

    public void setEmployeeName(String employeeName) {
        this.employeeName = employeeName;
    }

    public String getProfilePic() {
        return profilePic;
    }

    public void setProfilePic(String profilePic) {
        this.profilePic = profilePic;
    }
}
