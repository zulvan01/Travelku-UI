package com.dicoding.assosiate.travelku;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.flaviofaria.kenburnsview.KenBurnsView;
import com.squareup.picasso.Picasso;

import java.util.List;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

public class TravelLocationAdapter extends RecyclerView.Adapter<TravelLocationAdapter.TravelLocationViewHolder>{

    private List<TravelLocation> travelLocations;

    public TravelLocationAdapter(List<TravelLocation> travelLocations) {
        this.travelLocations = travelLocations;
    }

    @NonNull
    @Override
    public TravelLocationViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new TravelLocationViewHolder(
                LayoutInflater.from(parent.getContext()).inflate(
                        R.layout.item_container_location,
                        parent,
                        false
                )
        );
    }

    @Override
    public void onBindViewHolder(@NonNull TravelLocationViewHolder holder, int position) {
    holder.setLocationData(travelLocations.get(position));
    }

    @Override
    public int getItemCount() {
        return travelLocations.size();
    }

    static class TravelLocationViewHolder extends RecyclerView.ViewHolder {

        private KenBurnsView kbvLocations;
        private TextView textTitle1, textLocations, textStarRating;

        public TravelLocationViewHolder(@NonNull View itemView) {
            super(itemView);
            kbvLocations = itemView.findViewById(R.id.kbvLocation);
            textTitle1 = itemView.findViewById(R.id.textTitle1);
            textLocations = itemView.findViewById(R.id.textLocations);
            textStarRating = itemView.findViewById(R.id.textStarRating);
        }

        void setLocationData(TravelLocation travelLocation) {
            Picasso.get().load(travelLocation.imageurl).into(kbvLocations);
            textTitle1.setText(travelLocation.title);
            textLocations.setText(travelLocation.location);
            textStarRating.setText(String.valueOf(travelLocation.starRating));
        }
    }
}
