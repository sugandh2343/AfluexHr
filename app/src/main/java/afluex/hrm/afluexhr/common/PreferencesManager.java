package afluex.hrm.afluexhr.common;

import android.content.Context;
import android.content.SharedPreferences;


public class PreferencesManager {


    //app login variables
    private static final String PREF_NAME = "com.hmgreencitycustomer";
    private static final String Full_Name = "Full_Name";
    private static final String UserId = "UserId";
    private static final String UserType = "UserType";
    private static final String ProfilePic = "ProfilePic";
    private static final String Contact = "Contact";
    private static final String Token = "Token";
    private static final String LoginId = "LoginId";
    private static final String Password = "Password";
    private static final String Email = "Email";
    private static final String CustomerID = "CustomerID";
    private static final String producyInfoId = "producyInfoId";
    private static final String vendorId = "vendorId";

    public static PreferencesManager sInstance;
    private final SharedPreferences mPref;
    private static Context context;

    private static final String IS_FIRST_TIME_LAUNCH = "IsFirstTimeLaunch";
    private static final String IS_FIRST_INTRO = "IS_FIRST_INTRO";

    private PreferencesManager(Context context) {
        mPref = context.getSharedPreferences(PREF_NAME, Context.MODE_PRIVATE);
    }

    //for fragment
    public static synchronized void initializeInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
    }

    //for getting instance
    public static synchronized PreferencesManager getInstance(Context context) {
        if (sInstance == null) {
            sInstance = new PreferencesManager(context);
        }
        return sInstance;
    }

    public boolean clear() {
        return mPref.edit().clear().commit();
    }

    //Full_Name
    public void setProducyInfoId(String value) {
        mPref.edit().putString(producyInfoId, value).apply();
    }

    public String getProducyInfoId() {
        return mPref.getString(producyInfoId, "");
    }

    //Email
    public void setEmail(String value) {
        mPref.edit().putString(Email, value).apply();
    }

    public String getEmail() {
        return mPref.getString(Email, "");
    }

    //UserId
    public void setVendorId(String value) {
        mPref.edit().putString(vendorId, value).apply();
    }

    public String getVendorId() {
        return mPref.getString(vendorId, "");
    }

    //Full_Name
    public void setFull_Name(String value) {
        mPref.edit().putString(Full_Name, value).apply();
    }

    public String getFull_Name() {
        return mPref.getString(Full_Name, "");
    }

    //UserId
    public void setUserId(String value) {
        mPref.edit().putString(UserId, value).apply();
    }

    public String getUserId() {
        return mPref.getString(UserId, "");
    }

    //UserType
    public void setUserType(String value) {
        mPref.edit().putString(UserType, value).apply();
    }

    public String getUserType() {
        return mPref.getString(UserType, "");
    }

    //ProfilePic
    public void setProfilePic(String value) {
        mPref.edit().putString(ProfilePic, value).apply();
    }

    public String getProfilePic() {
        return mPref.getString(ProfilePic, "");
    }

    //Contact
    public void setContact(String value) {
        mPref.edit().putString(Contact, value).apply();
    }

    public String getContact() {
        return mPref.getString(Contact, "");
    }

    //Token
    public void setToken(String value) {
        mPref.edit().putString(Token, value).apply();
    }

    public String getToken() {
        return mPref.getString(Token, "");
    }

    //LoginId
    public void setLoginId(String value) {
        mPref.edit().putString(LoginId, value).apply();
    }

    public String getLoginId() {
        return mPref.getString(LoginId, "");
    }

    //Password
    public void setPassword(String value) {
        mPref.edit().putString(Password, value).apply();
    }

    public String getPassword(String value) {
        return mPref.getString(Password, "");
    }
    public void setCustomerID(String value) {
        mPref.edit().putString(CustomerID, value).apply();
    }
    public String getCustomerID() {
        return mPref.getString(CustomerID, "");
    }



    //IS_FIRST_TIME_LAUNCH
    public void setIsFirstTimeLaunch(boolean value) {
        mPref.edit().putBoolean(IS_FIRST_TIME_LAUNCH, value).apply();
    }

    public boolean getIsFirstTimeLaunch() {
        return mPref.getBoolean(IS_FIRST_TIME_LAUNCH, true);
    }

    //setIsFirstIntro
    public void setIsFirstIntro(boolean value) {
        mPref.edit().putBoolean(IS_FIRST_INTRO, value).apply();
    }

    public boolean getIsFirstIntro() {
        return mPref.getBoolean(IS_FIRST_INTRO, false);
    }

    public boolean logout(){
        SharedPreferences sharedPreferences=context.getSharedPreferences(PREF_NAME,Context.MODE_PRIVATE);
        SharedPreferences.Editor editor=sharedPreferences.edit();
        editor.clear();
        editor.apply();
        return true;

    }

}
