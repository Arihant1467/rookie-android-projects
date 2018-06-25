package com.example.arihant.arsenalplayers;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import java.util.ArrayList;




public class ArsenalAdapter extends BaseAdapter {
    Context context;
    int layoutId;
    ArrayList<Arsenal> arsenalArrayList;
    public ArsenalAdapter(Context context,int layoutId,ArrayList<Arsenal> arsenalArrayList)
    {
        this.context=context;
        this.layoutId=layoutId;
        this.arsenalArrayList=arsenalArrayList;
    }

    @Override
    public int getCount() {
        return arsenalArrayList.size();
    }

    @Override
    public Arsenal getItem(int position) {
        return arsenalArrayList.get(position);
    }

    @Override
    public long getItemId(int position) {
        return position;
    }

    @Override
    public View getView(int position, View convertView, ViewGroup parent) {
        /*LayoutInflater inflater=(LayoutInflater)
                context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);

        View itemView=inflater.inflate(resource, null);*/
        LayoutInflater inflater=(LayoutInflater)context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View itemView=inflater.inflate(layoutId,null);
        ImageView imgview=(ImageView)itemView.findViewById(R.id.image);
        Arsenal a1=arsenalArrayList.get(position);
        imgview.setImageResource(a1.getImageId());
        return null;
    }
}
