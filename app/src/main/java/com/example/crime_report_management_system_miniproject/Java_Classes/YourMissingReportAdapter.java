package com.example.crime_report_management_system_miniproject.Java_Classes;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.crime_report_management_system_miniproject.R;
import com.squareup.picasso.Picasso;

import java.util.List;

public class YourMissingReportAdapter extends RecyclerView.Adapter<YourMissingReportAdapter.YourMissingReportViewHolder> {
    private Context mCtx;
    private List<MissingReportHelper> YourMissingList;
    public YourMissingReportAdapter(Context mCtx, List<MissingReportHelper> YourMissingList) {
        this.mCtx = mCtx;
        this.YourMissingList = YourMissingList;
    }

    @NonNull
    @Override
    public YourMissingReportAdapter.YourMissingReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_layout_missingreport_row2, parent, false);
        return new YourMissingReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YourMissingReportViewHolder holder, int position) {
        MissingReportHelper missingreport = YourMissingList.get(position);

        holder.namex.setText(missingreport.getName());
        holder.agex.setText(missingreport.getAge());
        Picasso.get().load(missingreport.getImage()).into(holder.imagex);
        holder.cityx.setText(missingreport.getCity());
        holder.genderx.setText(missingreport.getGender());
        holder.dcx.setText(missingreport.getDresscolor());
        holder.descx.setText(missingreport.getDescription());


    }

    @Override
    public int getItemCount() {
        return YourMissingList.size();
    }

    class YourMissingReportViewHolder extends RecyclerView.ViewHolder {

    TextView namex,agex,cityx,genderx,dcx,descx,addx;
    ImageView imagex;

    public YourMissingReportViewHolder(@NonNull View itemView) {
        super(itemView);

        //Views
        namex = itemView.findViewById(R.id.namem);
        agex = itemView.findViewById(R.id.agem);

        imagex = itemView.findViewById(R.id.imagem);

         cityx = itemView.findViewById(R.id.citym);
         genderx = itemView.findViewById(R.id.genderm);
         dcx = itemView.findViewById(R.id.dresscolorm);
         descx = itemView.findViewById(R.id.descm);
         addx = itemView.findViewById(R.id.addressm);
    }
}
}
