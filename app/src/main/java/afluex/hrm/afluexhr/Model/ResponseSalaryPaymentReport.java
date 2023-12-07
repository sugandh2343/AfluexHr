package afluex.hrm.afluexhr.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class ResponseSalaryPaymentReport {
    @SerializedName("Status")
    @Expose
    private String status;
    @SerializedName("Message")
    @Expose
    private String message;

    @SerializedName("lstSalaryPaymentRepor")
    @Expose
    private ArrayList<lstSalaryPaymentRepor> lstSalaryPaymentRepor;

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

    public ArrayList<afluex.hrm.afluexhr.Model.lstSalaryPaymentRepor> getLstSalaryPaymentRepor() {
        return lstSalaryPaymentRepor;
    }

    public void setLstSalaryPaymentRepor(ArrayList<afluex.hrm.afluexhr.Model.lstSalaryPaymentRepor> lstSalaryPaymentRepor) {
        this.lstSalaryPaymentRepor = lstSalaryPaymentRepor;
    }
}
