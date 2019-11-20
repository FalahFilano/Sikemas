package com.filano.sikemastekber.Activity;

import android.animation.Animator;
import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffColorFilter;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.filano.sikemastekber.R;

public class BluetoothActivity extends AppCompatActivity {
    private int loop, reloop;
    boolean flag=false;
    private TextView textView;
    private Button button;
    public LottieAnimationView animationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bluetooth);

        animationView = findViewById(R.id.animdone);
        textView = findViewById(R.id.tvBt);
        button = findViewById(R.id.btnBt);
        button.setEnabled(true);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!flag){
                    Toast.makeText(BluetoothActivity.this,"Bluetooth tidak ditemukan", Toast.LENGTH_SHORT).show();
                    playAnimation();

                }
                else{
                    startActivity(new Intent(BluetoothActivity.this, FaceActivity.class));
                }
            }
        });

        playAnimation();
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {

            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                loop++;
                if (loop==2){
                    flag = true;
                    doneAnimation();
                }
            }
        });
    }

    private void playAnimation() {
        loop=0;
        if (reloop!=0) textView.setText("Mencari bluetooth Adapter... "+reloop);
        reloop++;
        animationView.setAnimation(R.raw.findbluetooth);
        animationView.setColorFilter(getResources().getColor(R.color.white), PorterDuff.Mode.SRC_ATOP);
        animationView.playAnimation();
        animationView.loop(true);
    }

    public void doneAnimation(){
        animationView.setAnimation(R.raw.checkanimation);
        animationView.playAnimation();
        animationView.loop(false);
        textView.setText("Kamu Berada di IF - 106");
        button.setText("Pindai Wajah");
        button.setEnabled(true);
        button.setBackground(this.getDrawable(R.drawable.button_style));
    }
}
