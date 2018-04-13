package com.tecmm.tala.redimensionaimagen;

import android.media.ImageWriter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.ImageView;
import android.widget.SeekBar;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    ImageView image;
    SeekBar seekBar;
    private int iWidth = 65;
    private int iHeight = 52;
    float density;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        density = displayMetrics.densityDpi;
        image = (ImageView) findViewById(R.id.imageView);
        seekBar = (SeekBar) findViewById(R.id.seekBar2);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean b) {
                float width = (progress + iWidth) * density / 160;
                float height = (progress + iHeight) * density / 160;
                image.getLayoutParams().height = (int)height;
                image.getLayoutParams().width = (int)width;
                image.requestLayout();
                if (progress == seekBar.getMax())
                    Toast.makeText(getApplicationContext(),"Llego al limite",Toast.LENGTH_LONG).show();
                else if(progress == 0) {
                    Toast.makeText(getApplicationContext(), "Llego al minimo", Toast.LENGTH_LONG).show();
                }
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
}
}
