package com.example.ewan.myapplication.view;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created by Administrator on 2017/10/9.
 */

public class BallMoveView extends View {
    /**
     * 小球的水平位置
     */
    private int x;
    /**
     * 小球的垂直位置，固定为100
     */
    private static final int Y = 100;
    /**
     * 小球的半径
     */
    private static final int RADIUS = 30;
    /**
     * 小球的颜色
     */
    private static final int COLOR = Color.RED;
    private Paint mPaint;
    /**
     * 移动的方向
     */
    private boolean direction;

    public BallMoveView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(COLOR);
        x = RADIUS;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //根据x,Y的坐标及半径画出一个小球
        canvas.drawCircle(x, Y, RADIUS, mPaint);
        //改变x坐标的值，调用invalidate()方法后，
        //小球将因x的值发生改变而移动
        int width = this.getMeasuredWidth();
        if (x < RADIUS) {
            direction = true;
        }
        if (x >= width - RADIUS) {
            direction = false;
        }
        x = direction ? x + 5 : x - 5;
    }
}
