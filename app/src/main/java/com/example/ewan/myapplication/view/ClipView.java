package com.example.ewan.myapplication.view;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;

import com.example.ewan.myapplication.R;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ClipView extends View {

    public ClipView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Bitmap mBitmap = BitmapFactory.decodeResource(getResources(), R.drawable.timg);
        //绘制狗狗完整图片
        canvas.drawBitmap(mBitmap,0,0,null);
        //平移坐标
        canvas.translate(0,500);
        //定义裁剪区
        canvas.clipRect(new Rect(100,100,500,500));
        //再次绘制狗狗图片
        canvas.drawBitmap(mBitmap,0,0,null);
    }
}
