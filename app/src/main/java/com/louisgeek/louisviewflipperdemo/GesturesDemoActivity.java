package com.louisgeek.louisviewflipperdemo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;

public class GesturesDemoActivity extends AppCompatActivity {

    GestureDetector gestureDetector;
    MySimpleOnGestureListener2 mySimpleOnGestureListener2;
    private final static String TAG = "GesturesDemoActivity";

    private final static int MIN_MOVE = 200;   //最小距离
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gestures_demo);

      /** MySimpleOnGestureListener mySimpleOnGestureListener=new MySimpleOnGestureListener();*/
        mySimpleOnGestureListener2=new MySimpleOnGestureListener2(MIN_MOVE,this);
        gestureDetector=new GestureDetector(this,mySimpleOnGestureListener2);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
       // return super.onTouchEvent(event);
        return gestureDetector.onTouchEvent(event);
    }
}
