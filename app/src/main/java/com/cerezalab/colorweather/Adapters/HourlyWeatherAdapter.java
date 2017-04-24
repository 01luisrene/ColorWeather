package com.cerezalab.colorweather.Adapters;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.cerezalab.colorweather.Hour;
import com.cerezalab.colorweather.R;

import java.util.ArrayList;

/**
 * Created by LUIS on 17/04/2017.
 */

public class HourlyWeatherAdapter extends BaseAdapter {

    ArrayList<Hour> hours;
    Context context;

    public HourlyWeatherAdapter(Context context, ArrayList<Hour> hours){
        this.context = context;
        this.hours = hours;
    }

    @Override
    public int getCount() {
        if(hours == null)
            return 0;
         return hours.size();

    }

    @Override
    public Object getItem(int i) {
        return hours.get(i);
    }

    @Override
    public long getItemId(int i) {
        return 0;
    } //No lo usamos por ahora

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {

        ViewHolder viewHolder;
        Hour hour = hours.get(i);

        if(view == null){

            view = LayoutInflater.from(context).inflate(R.layout.hourly_list_item,  viewGroup, false);
            viewHolder = new ViewHolder();

            viewHolder.title = (TextView) view.findViewById(R.id.hourlyTitleTextView);
            viewHolder.description = (TextView) view.findViewById(R.id.hourlyDescriptionTextView);

            view.setTag(viewHolder);

        }else{

            viewHolder = (ViewHolder) view.getTag();
        }

        viewHolder.title.setText(hour.getTitle());
        viewHolder.description.setText(hour.getWeatherDescription());

        return view;
    }

    static class ViewHolder{
        TextView title;
        TextView description;
    }
}
