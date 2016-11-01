package edu.temple.lab3withfragments;

import android.content.res.Configuration;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class PalletteActivity extends AppCompatActivity {
    public final String[] actualColors = {"Red", "Yellow", "Blue", "Green", "Magenta"};
    public final String EXTRA_MESSAGE = "PalletteActivity";

    public Bundle bundle = new Bundle();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pallette);

        bundle.putStringArray(EXTRA_MESSAGE, actualColors);
        
        boolean isLandscape = findViewById(R.id.framePortrait) == null;

        if(!isLandscape){
            PalletteFragment pf = new PalletteFragment();
            pf.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.framePortrait, pf)
                    .commit();
        }
        if(isLandscape){
            PalletteFragment pf = new PalletteFragment();
            pf.setArguments(bundle);
            getFragmentManager()
                    .beginTransaction()
                    .add(R.id.frameList, pf)
                    .commit();
        }

    }
}
