package com.louisgeek.louisviewflipperdemo;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.widget.Toast;

/**
 * Created by louisgeek on 2016/5/17.
 */
public class MySimpleOnGestureListener2 extends GestureDetector.SimpleOnGestureListener{

    int MIN_MOVE;
    Context context;
    public MySimpleOnGestureListener2(int MIN_MOVE,Context context) {
        this.MIN_MOVE=MIN_MOVE;
        this.context=context;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {

        if(e1.getY() - e2.getY() > MIN_MOVE){
            context.startActivity(new Intent(context, GesturesDemoActivity.class));
            Toast.makeText(context, "通过手势启动Activity", Toast.LENGTH_SHORT).show();
        }else if(e1.getY() - e2.getY()  < MIN_MOVE){
            ((Activity)context).finish();
            Toast.makeText(context,"通过手势关闭Activity",Toast.LENGTH_SHORT).show();
        }

        //return super.onFling(e1, e2, velocityX, velocityY);
        return true;
    }
}