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

public class SingapuraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_singapura);

        ViewPager2 locationsViewPager = findViewById(R.id.locationViewPager2);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationRWS = new TravelLocation();
        travelLocationRWS.imageurl = "https://i.pinimg.com/originals/74/90/d4/7490d4c8f44f69daf2f27fedcb1662c1.jpg";
        travelLocationRWS.title = "Universal Studio";
        travelLocationRWS.location = "Resort World Sentosa";
        travelLocationRWS.starRating = 9.0f;
        travelLocations.add(travelLocationRWS);

        TravelLocation travelLocationMerlion = new TravelLocation();
        travelLocationMerlion.imageurl = "https://www.blackxperience.com/assets/content/blackattitude/blackspot/tya-bisa-ngapain-aja-sih-di-taman-merlion-singapura-21.jpg";
        travelLocationMerlion.title = "Patung Merlion";
        travelLocationMerlion.location = "Merlion";
        travelLocationMerlion.starRating = 8.0f;
        travelLocations.add(travelLocationMerlion);

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
