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

public class CoordinateView extends View {

    public CoordinateView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint mPaint = new Paint(Paint.ANTI_ALIAS_FLAG);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);
        //保存现场
        canvas.save();
        for (int i = 0; i < 10; i++) {
            canvas.drawRect(10, 10, 100, 100, mPaint);
            //平移
            canvas.translate(30, 30);
        }
        //恢复现场
        canvas.restore();
        //平移坐标，让接下来的图形绘制在上一次图形的下面
        canvas.translate(0, 500);
        canvas.save();
        for (int i = 0; i < 10; i++) {
            canvas.drawRect(0, 0, 300, 300, mPaint);
            //缩放
            canvas.scale(0.9f, 0.9f, 150, 150);
        }
        canvas.restore();
        //平移坐标，让接下来的图形绘制在上一次图形的下面
        canvas.translate(100, 350);
        canvas.save();
        canvas.drawCircle(100, 100, 100, mPaint);
        for (int i = 0; i < 12; i++) {
            canvas.drawLine(150, 100, 200, 100, mPaint);
            canvas.rotate(30, 100, 100);
        }
        canvas.restore();
    }
}
