package com.cookandroid.project13_2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.os.SystemClock;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.SeekBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    TextView tv1, tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn1 = (Button) findViewById(R.id.btn1);

        SeekBar seekBar1 = (SeekBar) findViewById(R.id.seekBar1);
        SeekBar seekBar2 = (SeekBar) findViewById(R.id.seekBar2);

        tv1 = (TextView) findViewById(R.id.tv1);
        tv2 = (TextView) findViewById(R.id.tv2);

        btn1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                new Thread() {
                    public void run() {
                        for (int i = seekBar1.getProgress(); i<100; i+=2) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seekBar1.setProgress(seekBar1.getProgress()+2);
                                    tv1.setText("1번 진행률 : " + seekBar1.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();

                new Thread() {
                    public void run() {
                        for (int i = seekBar2.getProgress(); i<100; i++) {
                            runOnUiThread(new Runnable() {
                                @Override
                                public void run() {
                                    seekBar2.setProgress(seekBar2.getProgress()+1);
                                    tv2.setText("2번 진행률 : " + seekBar2.getProgress() + "%");
                                }
                            });
                            SystemClock.sleep(100);
                        }
                    }
                }.start();
            }
        });
    }
}