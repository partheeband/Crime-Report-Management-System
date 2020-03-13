package com.example.crime_report_management_system_miniproject;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.RatingBar;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AdminViewCriminalDetailsAdapter extends RecyclerView.Adapter<AdminViewCriminalDetailsAdapter.AdminViewCriminalDetailsViewHolder> {
    private Context mCtx;
    private List<CriminalDetailsHelper> criminalDetailsList;

    public AdminViewCriminalDetailsAdapter(AdminViewCriminalDetailsActivity mCtx, List<CriminalDetailsHelper> criminalDetailsList) {
        this.mCtx = mCtx;
        this.criminalDetailsList = criminalDetailsList;
    }

    @NonNull
    @Override
    public AdminViewCriminalDetailsViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(mCtx).inflate(R.layout.list_layout_view_criminal_details, parent, false);
        return new AdminViewCriminalDetailsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull AdminViewCriminalDetailsViewHolder holder, int position) {
        CriminalDetailsHelper criminalDetailsHelper = criminalDetailsList.get(position);
        holder.textViewName.setText(criminalDetailsHelper.name);
        holder.textViewAge.setText(criminalDetailsHelper.age);
        holder.textViewCriminalIdentificationMark.setText(criminalDetailsHelper.identificatinMark);
        holder.textViewCriminalId.setText(criminalDetailsHelper.id);
        holder.textViewCrimeType.setText(criminalDetailsHelper.type);
        holder.textViewArrestedDate.setText(criminalDetailsHelper.arrestedDate);
        holder.textViewImprisionedYears.setText(criminalDetailsHelper.imprisionedYears);
        holder.textViewPrisionCellId.setText(criminalDetailsHelper.prisonCellId);

        holder.ratingBar.setRating(Float.parseFloat(criminalDetailsHelper.rating));
    }

    @Override
    public int getItemCount() {
        return criminalDetailsList.size();
    }


    class AdminViewCriminalDetailsViewHolder extends RecyclerView.ViewHolder {
        TextView textViewName,textViewAge,textViewCriminalId,textViewCriminalIdentificationMark,textViewCrimeType,textViewArrestedDate,textViewImprisionedYears,textViewPrisionCellId;
        RatingBar ratingBar;

        public AdminViewCriminalDetailsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName=itemView.findViewById(R.id.textViewName);
            textViewAge=itemView.findViewById(R.id.textViewAge);
            textViewCriminalIdentificationMark=itemView.findViewById(R.id.textViewCriminalIdentificationMark);
            textViewCriminalId=itemView.findViewById(R.id.textViewCriminalId);
            textViewCrimeType=itemView.findViewById(R.id.textViewCrimeType);
            textViewArrestedDate=itemView.findViewById(R.id.textViewArrestedDate);
            textViewImprisionedYears=itemView.findViewById(R.id.textViewImprisonedYear);
            textViewPrisionCellId=itemView.findViewById(R.id.textViewPrisonCellId);
            ratingBar = itemView.findViewById(R.id.ratingBar);
        }
    }
}
