package edu.temple.lab3withfragments;

/**
 * Created by alber on 10/24/2016.
 */


import android.content.Context;
import android.graphics.Color;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;

/**
 * Created by alber on 9/21/2016.
 */
public class ColorAdapter extends ArrayAdapter {
    public String[] colors;
    public String[] actualColors;

    public ColorAdapter(Context context, int resource, Object[] objects, Object[] actualObjects){
        super(context, resource, objects);
        this.colors = (String[]) objects;
        actualColors= (String[]) actualObjects;
    }

    @Override
    public int getPosition(Object item) {
        return super.getPosition(item);
    }

    public View getView(int position, View convertView, ViewGroup parent){
        View v = super.getView(position, convertView, parent);
        v.setBackgroundColor(Color.parseColor(actualColors[position]));
        return v;
    }


}
