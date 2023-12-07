package afluex.hrm.afluexhr.Adapter;

import static android.os.Build.VERSION_CODES.R;

import android.content.Context;
import android.icu.text.SimpleDateFormat;
import android.location.Address;
import android.location.Geocoder;
import android.os.Build;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.io.IOException;
import java.text.ParseException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;

import afluex.hrm.afluexhr.Model.ModelAttendanceList;
import afluex.hrm.afluexhr.R;

public class AdapterAttendance extends RecyclerView.Adapter<AdapterAttendance.HolderAttendance> {
    private Context context;
    private ArrayList<ModelAttendanceList> attendnaceArrayList;

    public AdapterAttendance(Context context, ArrayList<ModelAttendanceList> attendnaceArrayList) {
        this.context = context;
        this.attendnaceArrayList = attendnaceArrayList;
    }

    @NonNull
    @Override
    public HolderAttendance onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(afluex.hrm.afluexhr.R.layout.layout_attendance_list_single_row, parent, false);
        return new HolderAttendance(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HolderAttendance holder, int position) {
        ModelAttendanceList modelAttendance = attendnaceArrayList.get(position);
        holder.txt_students_name.setText(modelAttendance.getAttendanceDate());
        holder.txt_from.setText(modelAttendance.getInTime());
        holder.txt_to.setText(modelAttendance.getOutTime());
        Log.e("LCheck", "1" + modelAttendance.getLatitude());
        Log.e("LCheck", "2" + modelAttendance.getLongitude());
        Log.e("LCheck", "3" + modelAttendance.getOutLatitude());
        Log.e("LCheck", "4" + modelAttendance.getOutLongitude());
//        holder.txt_reason.setText(modelAttendance.getLatitude()+" , "+modelAttendance.getLongitude());
//        holder.txt_status.setText(modelAttendance.getOutLatitude()+" , "+modelAttendance.getOutLongitude());


        if (modelAttendance.getLatitude() != null && modelAttendance.getLongitude() != null && !modelAttendance.getLatitude().equals("N/A") && !modelAttendance.getLongitude().equals("N/A")) {
            Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
            try {
                List<Address> addresses = geocoder.getFromLocation(
                        Double.parseDouble(modelAttendance.getLatitude()), Double.parseDouble(modelAttendance.getLongitude()), 1);
                if(addresses.size()>0){
                    holder.txt_reason.setText(addresses.get(0).getAddressLine(0));
                }else{
                    holder.txt_reason.setText("-");

                }

            } catch (IOException e) {
                e.printStackTrace();
                holder.txt_reason.setText("-");

            }catch (IllegalArgumentException e){
                e.printStackTrace();
                holder.txt_reason.setText("-");
            }

        } else {
            holder.txt_reason.setText("-");
        }
        if (modelAttendance.getOutLatitude() != null && modelAttendance.getOutLongitude() != null &&
                !modelAttendance.getOutLatitude().equals("N/A") &&
                !modelAttendance.getOutLongitude().equals("N/A")) {
            Geocoder geocoder = new Geocoder(context, Locale.ENGLISH);
            try {
                List<Address> addresses1 = geocoder.getFromLocation(
                        Double.parseDouble(modelAttendance.getOutLatitude()), Double.parseDouble(modelAttendance.getOutLongitude()), 1);
                if (addresses1.size() > 0) {
                    holder.txt_status.setText(addresses1.get(0).getAddressLine(0));
                } else {
                    holder.txt_status.setText("-");

                }

            } catch (IOException e) {
                e.printStackTrace();
                holder.txt_status.setText("-");

            }catch (IllegalArgumentException e){
                e.printStackTrace();
                holder.txt_status.setText("-");
            }
        } else {
            holder.txt_status.setText("-");
        }

        if (modelAttendance.getPunchIn().equals("In") && modelAttendance.getPunchOut().equals("Out")) {
            SimpleDateFormat simpleDateFormat = null;
            Date date1 = null, date2 = null;
            int days, hours, min;
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                simpleDateFormat = new SimpleDateFormat("HH:mm");
            }


            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
                try {
                    date1 = simpleDateFormat.parse(modelAttendance.getInTime());
                    date2 = simpleDateFormat.parse(modelAttendance.getOutTime());
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }

            }


            long difference = (date2.getTime() - date1.getTime());
            if (difference < 0) {
                Date dateMax = null;
                try {
                    dateMax = simpleDateFormat.parse("24:00");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
                Date dateMin = null;
                try {
                    dateMin = simpleDateFormat.parse("00:00");
                } catch (ParseException e) {
                    throw new RuntimeException(e);
                }
//                difference = (dateMax.getTime() - date2.getTime()) + (date1.getTime() - dateMin.getTime());
            }
            days = (int) (difference / (1000 * 60 * 60 * 24));
            hours = (int) ((difference - (1000 * 60 * 60 * 24 * days)) / (1000 * 60 * 60));
            min = (int) (difference - (1000 * 60 * 60 * 24 * days) - (1000 * 60 * 60 * hours)) / (1000 * 60);
            hours = (hours < 0 ? -hours : hours);
            String workingHours = String.valueOf(hours) + "hrs" + "-" + String.valueOf(min) + "min";
            holder.txt_working_hours.setText(workingHours);
        } else {
            holder.txt_working_hours.setText("-");
        }


    }

    @Override
    public int getItemCount() {
        return attendnaceArrayList.size();
    }

    public class HolderAttendance extends RecyclerView.ViewHolder {
        TextView txt_students_name, txt_from, txt_to, txt_reason, txt_status, txt_working_hours;

        public HolderAttendance(@NonNull View itemView) {
            super(itemView);
            txt_students_name = itemView.findViewById(afluex.hrm.afluexhr.R.id.txt_students_name);
            txt_from = itemView.findViewById(afluex.hrm.afluexhr.R.id.txt_from);
            txt_to = itemView.findViewById(afluex.hrm.afluexhr.R.id.txt_to);
            txt_reason = itemView.findViewById(afluex.hrm.afluexhr.R.id.txt_reason);
            txt_status = itemView.findViewById(afluex.hrm.afluexhr.R.id.txt_status);
            txt_working_hours = itemView.findViewById(afluex.hrm.afluexhr.R.id.txt_working_hours);
        }
    }
}