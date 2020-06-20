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

public class AustraliaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_australia);

        ViewPager2 locationsViewPager = findViewById(R.id.locationViewPager4);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationSidney = new TravelLocation();
        travelLocationSidney.imageurl = "https://1.bp.blogspot.com/-WEavUghkqF4/VSz5ECr5QgI/AAAAAAAABHI/bxEgVDlAfCk/s1600/Sydney%2BOpera%2BHouse.jpg";
        travelLocationSidney.title = "Gedung Opera";
        travelLocationSidney.location = "Sidney";
        travelLocationSidney.starRating = 9.0f;
        travelLocations.add(travelLocationSidney);

        TravelLocation travelLocationMelbourne = new TravelLocation();
        travelLocationMelbourne.imageurl = "https://securityelectronicsandnetworks.com/wp-content/uploads/2016/11/U-of-M-1024x520.jpg";
        travelLocationMelbourne.title = "Melbourne University";
        travelLocationMelbourne.location = "Melbourne";
        travelLocationMelbourne.starRating = 9.5f;
        travelLocations.add(travelLocationMelbourne);

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
