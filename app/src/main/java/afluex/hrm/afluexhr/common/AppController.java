package afluex.hrm.afluexhr.common;

import android.app.Application;




public class AppController extends Application {
    private static AppController mInstance;

    @Override
    public void onCreate() {
        super.onCreate();
        mInstance = this;
//        CalligraphyConfig.initDefault(new CalligraphyConfig.Builder()
//                .setDefaultFontPath("fonts/montserrat_medium.ttf")
//                .setFontAttrId(R.attr.fontPath)
//                .build());


//        ViewPump.init(ViewPump.builder()
//                .addInterceptor(new CalligraphyInterceptor(
//                        new CalligraphyConfig.Builder()
//
//                                .setDefaultFontPath("fonts/montserrat_medium.ttf")
//                                .setFontAttrId(R.attr.fontPath)
//                                .build()))
//                .build());
    }

    public static synchronized AppController getInstance() {
        return mInstance;
    }

    public void setConnectivityListener(ConnectivityReceiver.ConnectivityReceiverListener listener) {
        ConnectivityReceiver.connectivityReceiverListener = listener;
    }
}
