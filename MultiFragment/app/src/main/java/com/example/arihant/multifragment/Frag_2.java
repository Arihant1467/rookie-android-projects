package com.example.arihant.multifragment;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by Arihant on 13/03/2015.
 */
public class Frag_2 extends Fragment
{
    public Frag_2()
    {

    }

    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState)
    {
        View v=inflater.inflate(R.layout.fragment_2,container,false);
        return v;
    }


}
