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

public class NewYorkActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_new_york);

        ViewPager2 locationsViewPager = findViewById(R.id.locationViewPager3);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationLiberty = new TravelLocation();
        travelLocationLiberty.imageurl = "https://p4.wallpaperbetter.com/wallpaper/226/754/338/landmark-new-york-nyc-statue-of-liberty-wallpaper-preview.jpg";
        travelLocationLiberty.title = "Patung Liberty";
        travelLocationLiberty.location = "Pulau Liberty";
        travelLocationLiberty.starRating = 8.5f;
        travelLocations.add(travelLocationLiberty);

        TravelLocation travelLocationManhattan = new TravelLocation();
        travelLocationManhattan.imageurl = "https://1.bp.blogspot.com/-C0KDh7jTvhE/WuPrCr00htI/AAAAAAAAAf4/VTGpZZt5r3Ic_8ojXsC_iH1HTzhGBpscgCLcBGAs/s1600/TIMES%2BSQUARE.jpg";
        travelLocationManhattan.title = "Times Square";
        travelLocationManhattan.location = "Manhattan";
        travelLocationManhattan.starRating = 8.5f;
        travelLocations.add(travelLocationManhattan);

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
