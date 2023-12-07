package afluex.hrm.afluexhr.Retrofit;

import com.google.gson.JsonObject;


import afluex.hrm.afluexhr.Model.CommonResponse;
import afluex.hrm.afluexhr.Model.CommponPuchInPuchOutResponse;
import afluex.hrm.afluexhr.Model.ResponseAttendnace;
import afluex.hrm.afluexhr.Model.ResponseDateWiseAttendanceReport;
import afluex.hrm.afluexhr.Model.ResponseLeaveApllication;
import afluex.hrm.afluexhr.Model.ResponseLeaveCount;
import afluex.hrm.afluexhr.Model.ResponseLeaveReportForEmployeeBy;
import afluex.hrm.afluexhr.Model.ResponseLogin;
import afluex.hrm.afluexhr.Model.ResponseMessageList;
import afluex.hrm.afluexhr.Model.ResponseSalaryPaymentReport;
import afluex.hrm.afluexhr.Model.lstList;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.Multipart;
import retrofit2.http.POST;
import retrofit2.http.Part;

public interface ApiServices {
    @POST("WebAPI/login")
    Call<ResponseLogin> getLogin(@Body JsonObject login);

    @POST("WebAPI/LeaveApplication")
    Call<ResponseLeaveApllication> getLeaveApplication(@Body JsonObject login);

    @POST("WebAPI/SaveLeaveApplication")
    Call<CommonResponse> SaveLeaveApplication(@Body JsonObject login);

    @POST("WebAPI/Message")
    Call<CommonResponse> SaveMessage(@Body JsonObject login);

    @POST("WebAPI/LeaveCount")
    Call<ResponseLeaveCount> LeaveCount(@Body JsonObject login);

    @POST("WebAPI/SalaryPaymentReport")
    Call<ResponseSalaryPaymentReport> SalaryPaymentReport(@Body JsonObject login);

    @POST("WebAPI/DateWiseAttendanceReport")
    Call<ResponseDateWiseAttendanceReport> DateWiseAttendanceReport(@Body JsonObject login);

    @POST("WebAPI/MessagesList")
    Call<ResponseMessageList> MessagesList(@Body JsonObject login);
    @POST("WebAPI/LeaveReportForEmployeeBy")
    Call<ResponseLeaveReportForEmployeeBy> LeaveReportForEmployeeBy(@Body JsonObject login);

@POST("WebAPI/SaveAttendance")
    Call<CommponPuchInPuchOutResponse> SaveAttendance	(@Body JsonObject login);

@POST("WebAPI/SavePunchOutAttendance")
    Call<CommponPuchInPuchOutResponse> SavePunchOutAttendance	(@Body JsonObject login);

@POST("WebAPI/GetAttenndaceList")
    Call<ResponseAttendnace> GetAttenndaceList	(@Body JsonObject login);


}