package com.filano.sikemastekber.Activity;

import android.Manifest;
import android.animation.Animator;
import android.app.Activity;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.FaceDetector;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.airbnb.lottie.LottieAnimationView;
import com.filano.sikemastekber.R;

public class FaceActivity extends AppCompatActivity {

    private static final int CAMERA_REQUEST = 1888;
    private ImageView imageView, imageView2;
    private static final int MY_CAMERA_PERMISSION_CODE = 100;
    private Button photoButton;
    private LottieAnimationView animationView;
    boolean flag=false, first=true, verif=false;
    private int loop;

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_face);
        imageView = this.findViewById(R.id.imageView1);
        imageView2 = this.findViewById(R.id.imageView2);
        photoButton = this.findViewById(R.id.btnFace);
        animationView = this.findViewById(R.id.animfacerecog);
        animationView.addAnimatorListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if(verif){
                    Intent openMainActivity= new Intent(FaceActivity.this, MainActivity.class);
                    openMainActivity.setFlags(Intent.FLAG_ACTIVITY_REORDER_TO_FRONT);
                    startActivityIfNeeded(openMainActivity, 0);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                loop++;
                if (loop==5){
                    flag = true;
                    doneAnimation();
                    Toast.makeText(FaceActivity.this, "Face cocok", Toast.LENGTH_SHORT).show();
                    verif=true;
                }
            }
        });


        photoButton.setOnClickListener(new View.OnClickListener()
        {
            @Override
            public void onClick(View v)
            {
               if(!flag){
                   if(!first){
                       notmatch();
                       Toast.makeText(FaceActivity.this, "Face tidak cocok", Toast.LENGTH_SHORT).show();
                   }
                   if (checkSelfPermission(Manifest.permission.CAMERA) != PackageManager.PERMISSION_GRANTED)
                       requestPermissions(new String[]{Manifest.permission.CAMERA}, MY_CAMERA_PERMISSION_CODE);
                   else {
                       Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                       startActivityForResult(cameraIntent, CAMERA_REQUEST);
                       first=false;
                   }
               }else{
                   loop= 0;
                   imageView2.setAlpha(0.5f);
                   loadingAnimation();
                   photoButton.setText("Foto Ulang");
                   flag=false;
               }
            }
        });
    }

    @Override
    public void onRequestPermissionsResult(int requestCode, @NonNull String[] permissions, @NonNull int[] grantResults) {
        super.onRequestPermissionsResult(requestCode, permissions, grantResults);
        if (requestCode == MY_CAMERA_PERMISSION_CODE) {
            if (grantResults[0] == PackageManager.PERMISSION_GRANTED) {
                Toast.makeText(this, "camera permission granted", Toast.LENGTH_LONG).show();
                Intent cameraIntent = new Intent(android.provider.MediaStore.ACTION_IMAGE_CAPTURE);
                startActivityForResult(cameraIntent, CAMERA_REQUEST);
            } else {
                Toast.makeText(this, "camera permission denied", Toast.LENGTH_LONG).show();
            }
        }
    }

    protected void onActivityResult(int requestCode, int resultCode, Intent data)
    {
        if (requestCode == CAMERA_REQUEST && resultCode == Activity.RESULT_OK)
        {
            Bitmap photo = (Bitmap) data.getExtras().get("data");
            imageView.setImageBitmap(photo);
            photoButton.setText("Validasi Wajah");
            photoButton.setCompoundDrawables(null,null,null,null);
            imageView2.setImageDrawable(null);
            imageView2.setBackground(getDrawable(R.color.colorPrimaryDark));
            imageView2.setAlpha(0f);
            flag=true;
        }
    }

    private void loadingAnimation() {
        animationView.setAnimation(R.raw.loader);
        animationView.setScale(0.4f);
        animationView.playAnimation();
        animationView.loop(true);
    }

    public void doneAnimation(){
        animationView.setAnimation(R.raw.checkanimation);
        animationView.playAnimation();
        animationView.loop(false);
        photoButton.setText("Pindai Wajah");
        photoButton.setEnabled(true);
        photoButton.setBackground(this.getDrawable(R.drawable.button_style));
    }

    public void notmatch(){
        animationView.setAnimation(R.raw.errorcross);
        animationView.playAnimation();
        animationView.loop(false);
    }
}

