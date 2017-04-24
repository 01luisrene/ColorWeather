package com.cerezalab.colorweather;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.TextView;

import com.cerezalab.colorweather.Adapters.MinutelyWeatherAdapter;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;


public class MinutelyWeatherActivity extends Activity {

    @BindView(R.id.minutelyRecyclerView) RecyclerView minutelyyRecyclerView;
    @BindView(R.id.minutelyNoDataTextView) TextView noDataTextView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_minutely_weather);
        ButterKnife.bind(this);

        Intent intent = getIntent();

        ArrayList<Minute> minutes = intent.getParcelableArrayListExtra(MainActivity.MINUTE_ARRAYY_LIST);

        if(minutes != null && !minutes.isEmpty()){

            noDataTextView.setVisibility(View.GONE);

            minutelyyRecyclerView.setVisibility(View.VISIBLE);

            MinutelyWeatherAdapter minutelyWeatherAdapter = new MinutelyWeatherAdapter(this, minutes);

            minutelyyRecyclerView.setAdapter(minutelyWeatherAdapter);

            RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(this);

            minutelyyRecyclerView.setLayoutManager(layoutManager);
            minutelyyRecyclerView.setHasFixedSize(true);

        }else{
            //Desplagar no data textview y volver recyclerView invisible

            noDataTextView.setVisibility(View.VISIBLE);
            minutelyyRecyclerView.setVisibility(View.GONE);
        }



    }
}
