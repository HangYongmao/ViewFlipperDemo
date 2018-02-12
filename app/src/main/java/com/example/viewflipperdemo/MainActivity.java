package com.example.viewflipperdemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private ViewFlipper flipper;
    private int[] resId = {R.drawable.pic1, R.drawable.pic2, R.drawable.pic3, R.drawable.pic4};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        flipper = (ViewFlipper) findViewById(R.id.flipper);

        // 动态导入的方式为ViewFlipper加入子View
        for (int i = 0; i < resId.length; i++) {
            flipper.addView(getImageView(resId[i]));
        }
        // 为ViewFlipper添加进入时的动画效果
        flipper.setInAnimation(this, R.anim.left_in);
        // 为ViewFlipper添加退出时的动画效果
        flipper.setOutAnimation(this, R.anim.left_out);
        // 设置ViewFlipper的时间间隔
        flipper.setFlipInterval(3000);
        flipper.startFlipping();
    }

    private ImageView getImageView(int resId) {
        ImageView image = new ImageView(this);
        //image.setImageResource(resId);
        image.setBackgroundResource(resId);
        return image;
    }
}
