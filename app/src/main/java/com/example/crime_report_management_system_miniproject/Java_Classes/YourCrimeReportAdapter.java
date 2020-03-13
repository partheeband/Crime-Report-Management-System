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

import java.util.List;
import com.squareup.picasso.Picasso;

public class YourCrimeReportAdapter extends RecyclerView.Adapter<YourCrimeReportAdapter.YourCrimeReportViewHolder> {
    private Context mCtx;
    private List<PostCrimeHelper> YourCrimeList;
    public YourCrimeReportAdapter(Context mCtx, List<PostCrimeHelper> YourCrimeList) {
        this.mCtx = mCtx;
        this.YourCrimeList = YourCrimeList;
    }

    @NonNull
    @Override
    public YourCrimeReportAdapter.YourCrimeReportViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_layout_crimereport_row, parent, false);
        return new YourCrimeReportViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull YourCrimeReportViewHolder holder, int position) {
        PostCrimeHelper postCrime = YourCrimeList.get(position);

        //set data to views
        holder.ret.setText(postCrime.getCondition());
        holder.titlere.setText(postCrime.getTitle());
        holder.detailre.setText(postCrime.getDescription());
        holder.typere.setText(postCrime.getType());
        Picasso.get().load(postCrime.getImage()).into(holder.imagere);
    }

    @Override
    public int getItemCount() {
        return YourCrimeList.size();
    }

    class YourCrimeReportViewHolder extends RecyclerView.ViewHolder {

    TextView titlere,detailre,ret,typere;
    ImageView imagere;

    public YourCrimeReportViewHolder(@NonNull View itemView) {
        super(itemView);

        titlere = itemView.findViewById(R.id.reTitle);
        detailre = itemView.findViewById(R.id.reDesc);
        imagere = itemView.findViewById(R.id.reImage);
        ret = itemView.findViewById(R.id.reText);
        typere = itemView.findViewById(R.id.reType);
    }
}
}
