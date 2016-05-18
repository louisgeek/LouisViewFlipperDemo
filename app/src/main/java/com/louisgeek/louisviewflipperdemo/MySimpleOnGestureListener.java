package com.louisgeek.louisviewflipperdemo;

import android.util.Log;
import android.view.GestureDetector;
import android.view.MotionEvent;

/**
 * Created by louisgeek on 2016/5/17.
 */
public class MySimpleOnGestureListener  extends GestureDetector.SimpleOnGestureListener {

    private static final String TAG = "MySimpleListener";
    public MySimpleOnGestureListener() {
        super();
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {

        Log.d(TAG, "onSingleTapUp:手指离开屏幕的一瞬间");
        return super.onSingleTapUp(e);
    }

    @Override
    public void onLongPress(MotionEvent e) {
        super.onLongPress(e);
        Log.d(TAG, "onLongPress:长按并且没有松开");
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        Log.d(TAG, "onScroll:在触摸屏上滑动");
        return super.onScroll(e1, e2, distanceX, distanceY);
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        Log.d(TAG, "onFling:迅速滑动，并松开");
        return super.onFling(e1, e2, velocityX, velocityY);
    }

    @Override
    public void onShowPress(MotionEvent e) {
        super.onShowPress(e);
        Log.d(TAG, "onShowPress:手指按下一段时间,不过还没到长按");
    }

    @Override
    public boolean onDown(MotionEvent e) {
        Log.d(TAG, "onDown:按下");
        return super.onDown(e);
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        Log.d(TAG, "onDoubleTap: 在双击的第二下");
        return super.onDoubleTap(e);
    }

    /**
     * 通知DoubleTap手势中的事件，包含down、up和move事件（这里指的是在双击之间发生的事件，例如在同一个地方双击会产生DoubleTap手势，而在DoubleTap手势里面还会发生down和up事件，这两个事件由该函数通知）；双击的第二下Touch down和up都会触发，可用e.getAction()区分。
     * @param e
     * @return
     */
    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return super.onDoubleTapEvent(e);
    }

    /**
     * 用来判定该次点击是SingleTap而不是DoubleTap，如果连续点击两次就是DoubleTap手势，如果只点击一次，系统等待一段时间后没有收到第二次点击则判定该次点击为SingleTap而不是DoubleTap，然后触发SingleTapConfirmed事件。这个方法不同于onSingleTapUp，他是在GestureDetector确信用户在第一次触摸屏幕后，没有紧跟着第二次触摸屏幕，也就是不是“双击”的时候触发
     * @param e
     * @return
     */
    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return super.onSingleTapConfirmed(e);
    }

    @Override
    public boolean onContextClick(MotionEvent e) {
        return super.onContextClick(e);
    }
}
