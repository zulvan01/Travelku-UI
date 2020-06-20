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

public class BelandaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_belanda);

        ViewPager2 locationsViewPager = findViewById(R.id.locationViewPager5);

        List<TravelLocation> travelLocations = new ArrayList<>();

        TravelLocation travelLocationvangogh = new TravelLocation();
        travelLocationvangogh.imageurl = "https://upload.wikimedia.org/wikipedia/commons/0/08/Van_Gogh_Museum_Amsterdam.jpg";
        travelLocationvangogh.title = "Van Gogh";
        travelLocationvangogh.location = "Amsterdam";
        travelLocationvangogh.starRating = 7.0f;
        travelLocations.add(travelLocationvangogh);

        TravelLocation travelLocationRijks = new TravelLocation();
        travelLocationRijks.imageurl = "https://www.liawisata.com/wp-content/uploads/2019/03/rijksmuseum-770x440.jpg";
        travelLocationRijks.title = "Rijksmuseum";
        travelLocationRijks.location = "Amsterdam";
        travelLocationRijks.starRating = 7.0f;
        travelLocations.add(travelLocationRijks);

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
