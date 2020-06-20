package com.dicoding.assosiate.travelku;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager2.widget.CompositePageTransformer;
import androidx.viewpager2.widget.MarginPageTransformer;
import androidx.viewpager2.widget.ViewPager2;


import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;
import java.util.List;

public class IndonesiaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_indonesia);

        ViewPager2 locationsViewPager = findViewById(R.id.locationViewPager);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationYogyakarta = new TravelLocation();
        travelLocationYogyakarta.imageurl = "https://cdn.statically.io/img/www.alodiatour.com/wp-content/uploads/2018/04/Foto-Tugu-Jogja.jpg";
        travelLocationYogyakarta.title = "Tugu Putih";
        travelLocationYogyakarta.location = "Yogyakarta";
        travelLocationYogyakarta.starRating = 8.0f;
        travelLocations.add(travelLocationYogyakarta);

        TravelLocation travelLocationBorobudurView = new TravelLocation();
        travelLocationBorobudurView.imageurl = "https://anekatempatwisata.com/wp-content/uploads/2018/04/Candi-Borobudur.jpg";
        travelLocationBorobudurView.title = "Borobudur";
        travelLocationBorobudurView.location = "Magelang";
        travelLocationBorobudurView.starRating = 7.5f;
        travelLocations.add(travelLocationBorobudurView);

        locationsViewPager.setAdapter(new TravelLocationAdapter(travelLocations));

        locationsViewPager.setClipToPadding(false);
        locationsViewPager.setClipChildren(false);
        locationsViewPager.setOffscreenPageLimit(3);
        locationsViewPager.getChildAt(0).setOverScrollMode(RecyclerView.OVER_SCROLL_NEVER);

        CompositePageTransformer compositePageTransformer = new CompositePageTransformer();
        compositePageTransformer.addTransformer(new MarginPageTransformer(40));
        compositePageTransformer.addTransformer(new ViewPager2.PageTransformer() {
            @Override
            public void transformPage(@NonNull View page, float position) {
                float r = 1 - Math.abs(position);
                page.setScaleY(0.95f + r * 0.05f);
            }
        });

        locationsViewPager.setPageTransformer(compositePageTransformer);
    }

    public void btn_Loading(View view) {
        startActivity(new Intent(getApplicationContext(), LoadingActivity.class));

    }
}
