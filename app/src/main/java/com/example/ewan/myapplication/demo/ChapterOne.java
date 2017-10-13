package com.example.ewan.myapplication.demo;

import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;

import com.example.ewan.myapplication.R;


/**
 * Created by Administrator on 2017/9/26.
 */

public class ChapterOne {
    public static void praticalOne() {
        /**
         * @param 绘制一句话和一个矩形
         * */
        Bitmap mBitmap = Bitmap.createBitmap(400, 400, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);//画布
        Paint mPaint = new Paint();//画笔
        mPaint.setStyle(Paint.Style.FILL);//画笔风格
        mPaint.setAntiAlias(true);//设置抗锯齿
        mPaint.setTextAlign(Paint.Align.CENTER);//设置文本对齐方式
        mPaint.setTextSkewX(0.5f);//设置倾斜
        mPaint.setTextSize(14.f);//设置文本字体大小
        mPaint.setUnderlineText(true);//设置下划线
        mPaint.setFakeBoldText(true);//设置粗体
        mPaint.setColor(Color.BLUE);//设置画笔颜色
        mPaint.setStrokeJoin(Paint.Join.ROUND);//设置拐角样式
        mPaint.setStrokeCap(Paint.Cap.ROUND);//设置落笔的样式
        mCanvas.drawText("darren573", 50, 100, mPaint);
        //绘制一个矩形
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(20);
        mPaint.setStrokeJoin(Paint.Join.ROUND);
        mCanvas.drawRect(new Rect(30, 200, 350, 350), mPaint);

        //mImageView.setImageBitmap(mBitmap);
    }

    public static void praticalTwo() {
        /**
         * @param 缩放
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Bitmap bitmap = BitmapFactory.decodeResource(Resources.getSystem(), R.mipmap.ic_launcher);
        //原大小绘制
        mCanvas.drawBitmap(bitmap, 0, 0, null);
        //对图片进行缩放
        int bitmapWidth = bitmap.getWidth();
        int bitmapHeight = bitmap.getHeight();
        Rect src = new Rect(0, 0, bitmapWidth, bitmapHeight);
        Rect dst = new Rect(0, 0, bitmapWidth * 3, bitmapHeight * 3);
        mCanvas.drawBitmap(bitmap, src, dst, null);
//        mImageView.setImageBitmap(mBitmap);
    }

    public static void praticalThree() {
        /**
         * @param 绘制点
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(4);
        mCanvas.drawPoint(120, 20, mPaint);//在(x,y)处绘制一个点
        mPaint.setColor(Color.BLUE);
        mPaint.setStrokeWidth(4);
        float[] ps = new float[]{10, 10, 50, 50, 50, 100, 50, 150};//从下标0开始每两个数组合绘制成一个点
        mCanvas.drawPoints(ps, mPaint);
        mPaint.setColor(Color.GREEN);
        /**
         * @param 从一个数组中的第offset处开始取出count个数字
         * @param 两个组成一个点忽略多余的
         * */
//        mCanvas.drawPoints(ps,4,4,mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }

    public static void praticalFour() {
        /**
         * @param 绘制线
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.RED);
        mPaint.setStrokeWidth(1);
        final int offsetDy = 50;
        for (int i = 5; i < 10; i++) {
            mCanvas.drawLine(10, offsetDy * i, 300, offsetDy * i, mPaint);
        }
//        mImageView.setImageBitmap(mBitmap);
    }

    public static void praticalFive() {
        /**
         * @param 绘制矩形
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setColor(Color.GREEN);
        /**
         * @param canvas.drawRoundRect(startX,startY,stopX,stopY,x,y,paint)
         * @param 4.3以下会出现NoSuchMethodError异常
         * @param 需要写成canvas.drawRoundRect(RectF rectf,x,y,paint)
         * */
//        mCanvas.drawRoundRect(10, 10, 400, 300, 50, 30, mPaint);
        mPaint.setStyle(Paint.Style.STROKE);
        mCanvas.drawRoundRect(new RectF(10, 320, 400, 600), 30, 50, mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }
}
