package com.example.arihant.multifragment;



import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.ActionBarActivity;
import android.support.v4.app.Fragment;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;


public class Activity_main extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.menu_container, new PlaceholderFragment())
                    .commit();
        }
    }


    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        Fragment frag;
        FragmentTransaction frag_trans;
        Button arsenal,mancity,schalke;
        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_main, container, false);
            arsenal=(Button)rootView.findViewById(R.id.btnarsenal);
            mancity=(Button)rootView.findViewById(R.id.btncity);
            schalke=(Button)rootView.findViewById(R.id.btnschalke);
            frag=new Frag_1();
            frag_trans=getFragmentManager().beginTransaction().add(R.id.container, frag);
            frag_trans.commit();
            arsenal.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    frag=new Frag_1();
                    frag_trans=getFragmentManager().beginTransaction().replace(R.id.container, frag);
                    frag_trans.commit();

                }
            });
            mancity.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    frag=new Frag_2();
                    frag_trans=getFragmentManager().beginTransaction().replace(R.id.container, frag);
                    frag_trans.commit();

                }
            });
            schalke.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    frag=new Frag_3();
                    frag_trans=getFragmentManager().beginTransaction().replace(R.id.container, frag);
                    frag_trans.commit();

                }
            });

            return rootView;
        }
    }
}
