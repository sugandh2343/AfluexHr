package afluex.hrm.afluexhr.common;




public interface MvpView {
    void showLoading();

    void hideLoading();

    void openActivityOnTokenExpire();

    void onError(int resId);

    void onError(String message);

    void showMessage(String message);

    void showMessage(int resId);

    boolean isNetworkConnected();

    void hideKeyboard();

    void sendUnUsedEPin(String epinNo, String from);

    void getvehicledata(String vehiclename, String vehicleid);

    void getAccpetRejectBooking(String id, String bookid, String action, String remark, String reason);

    void getClick(int position, String value);
}
