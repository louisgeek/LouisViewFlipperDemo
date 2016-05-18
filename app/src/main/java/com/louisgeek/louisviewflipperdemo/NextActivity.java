package com.louisgeek.louisviewflipperdemo;

import android.graphics.Matrix;
import android.graphics.PointF;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageView;

public class NextActivity extends AppCompatActivity {

    // 縮放控制
    private Matrix matrix = new Matrix();
    private Matrix savedMatrix = new Matrix();

    // 不同状态的表示：
    private static final int NONE = 0;
    private static final int DRAG = 1;
    private static final int ZOOM = 2;
    private int touchMode = NONE;
    PointF startPointF;
    PointF middlePointF;
    private float distance = 1f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_next);
        ImageView idiv = (ImageView) findViewById(R.id.id_iv);
        idiv.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                ImageView imageView = (ImageView) v;

               int action= event.getAction();

                switch (action&MotionEvent.ACTION_MASK){
                    //单指
                    case MotionEvent.ACTION_DOWN:
                        matrix.set(imageView.getMatrix());
                        savedMatrix.set(imageView.getMatrix());
                        touchMode=DRAG;
                        startPointF=new PointF(event.getX(),event.getY());
                        break;
                    // 双指
                    case MotionEvent.ACTION_POINTER_DOWN:
                        distance=dealDistance(event);
                        if (distance > 10f) {
                            savedMatrix.set(matrix);
                            middlePointF = findMiddlePoint(event);
                            touchMode = ZOOM;
                        }
                        break;

                    case MotionEvent.ACTION_MOVE:
                        if (touchMode == DRAG) {
                            // 是一个手指拖动
                            matrix.set(savedMatrix);
                            matrix.postTranslate(event.getX() - startPointF.x, event.getY() - startPointF.y);
                        } else if (touchMode == ZOOM) {
                            // 两个手指滑动
                            float newDistance = dealDistance(event);
                            if (newDistance > 10f) {
                                matrix.set(savedMatrix);
                                float scale = newDistance / distance;
                                matrix.postScale(scale, scale, middlePointF.x, middlePointF.y);
                            }
                        }
                        break;
                    // 手指放开
                    case MotionEvent.ACTION_UP:
                    case MotionEvent.ACTION_POINTER_UP:
                        touchMode = NONE;
                        break;

                }
                // 设置ImageView的Matrix
                imageView.setImageMatrix(matrix);

                //return false;
                return true;
            }
        });
    }

    private float dealDistance(MotionEvent event) {
        float x = event.getX(0) - event.getX(1);
        float y = event.getY(0) - event.getY(1);
        float distance= (float) Math.sqrt(x * x + y * y);
        return  distance;
    }
    private PointF findMiddlePoint(MotionEvent event) {
        float x = event.getX(0) + event.getX(1);
        float y = event.getY(0) + event.getY(1);
        PointF pointF=new PointF(x/2,y/2);
        return  pointF;
    }

}
