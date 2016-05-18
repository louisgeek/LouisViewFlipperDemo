package com.louisgeek.louisviewflipperdemo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ViewFlipper;

public class MainActivity extends AppCompatActivity {

    private final static int INTERVAL= 200;   //最小距离
    ViewFlipper idvf;

    //手指按下的点为(x1, y1)手指离开屏幕的点为(x2, y2)
    float x1 = 0;
    float x2 = 0;
    float y1 = 0;
    float y2 = 0;

    /**
     * setInAnimation：设置View进入屏幕时使用的动画
     setOutAnimation：设置View退出屏幕时使用的动画
     showNext：调用该方法来显示ViewFlipper里的下一个View
     showPrevious：调用该方法来显示ViewFlipper的上一个View
     setFilpInterval：设置View之间切换的时间间隔
     startFlipping：使用上面设置的时间间隔来开始切换所有的View，切换会循环进行
     stopFlipping：停止View切换

     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
         idvf = (ViewFlipper) findViewById(R.id.id_vf);
        Button idbtn = (Button) findViewById(R.id.id_btn);
        idbtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,NextActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
        Button idbtn2 = (Button) findViewById(R.id.id_btn2);
        idbtn2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(MainActivity.this,GesturesDemoActivity.class);
                MainActivity.this.startActivity(intent);
            }
        });
         idvf = (ViewFlipper) findViewById(R.id.id_vf);

       View view04=LayoutInflater.from(this).inflate(R.layout.view_flipper_04,null);
        idvf.addView(view04);
        //idvf.startFlipping();


    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case  MotionEvent.ACTION_DOWN:
                //当手指按下的时候
                x1 = event.getX();
                y1 = event.getY();
                break;
            case  MotionEvent.ACTION_UP:
                //当手指离开的时候
                x2 = event.getX();
                y2 = event.getY();
                if(y1 - y2 > INTERVAL) {
                    //Toast.makeText(MainActivity.this, "向上滑", Toast.LENGTH_SHORT).show();
                } else if(y2 - y1 > INTERVAL) {
                    //Toast.makeText(MainActivity.this, "向下滑", Toast.LENGTH_SHORT).show();
                } else if(x1 - x2 > INTERVAL) {
                    idvf.setInAnimation(this,R.anim.left_in);
                    idvf.setOutAnimation(this,R.anim.left_out);
                    idvf.showNext();
                    //Toast.makeText(MainActivity.this, "向左滑", Toast.LENGTH_SHORT).show();
                } else if(x2 - x1 > INTERVAL) {
                    idvf.setInAnimation(this,R.anim.right_in);
                    idvf.setOutAnimation(this,R.anim.right_out);
                    idvf.showPrevious();
                    //Toast.makeText(MainActivity.this, "向右滑", Toast.LENGTH_SHORT).show();
                }
                break;
            case  MotionEvent.ACTION_MOVE:
                break;
            default:
                break;

        }
        return super.onTouchEvent(event);
    }
}
