package edu.temple.lab3withfragments;


import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;


/**
 * A simple {@link Fragment} subclass.
 */
public class PalletteFragment extends Fragment {


    public PalletteFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_pallette, container, false);
        Bundle b = getArguments();
        final String[] col = b.getStringArray("PalletteActivity");

        //create Adapter, the second parameter is from an API of predetermined views, SO
        //THERES NO NEED TO CREATE THEM IN A RESOURCE FILE
        ColorAdapter myAdapter = new ColorAdapter(getActivity(), android.R.layout.simple_list_item_1,
                                           col, col );

        ListView lv = (ListView) v.findViewById(R.id.lv);

        //give the listView the ColorAdapter
        lv.setAdapter(myAdapter);

        //give the listView an OnItemClickListener
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String str = col[position];
                String key = "color";
                Bundle c = new Bundle();
                c.putString(key, str);
                CanvassFragment cf = new CanvassFragment();
                cf.setArguments(c);

                if(getResources().getConfiguration().orientation
                        == Configuration.ORIENTATION_PORTRAIT) {
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.framePortrait, cf)
                            .addToBackStack(null)
                            .commit();
                }
                if(getResources().getConfiguration().orientation
                        == Configuration.ORIENTATION_LANDSCAPE){
                    getFragmentManager()
                            .beginTransaction()
                            .replace(R.id.frameColor, cf)
                            .commit();
                }
            }
        });
        return v;
    }

}
