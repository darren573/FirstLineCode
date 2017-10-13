package com.example.ewan.myapplication.demo;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.RectF;

/**
 * Created by Administrator on 2017/9/27.
 */

public class ChapterTwo {
    public static void practicalOne() {
        /**
         * @param 绘制圆
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        RectF rectf = new RectF(50, 100, 150, 200);
        mPaint.setColor(Color.GREEN);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(1);
        mCanvas.drawOval(rectf, mPaint);
        /**
         * @param 绘制弧线
         * */
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.FILL_AND_STROKE);
        mCanvas.drawArc(rectf, -30, -60, true, mPaint);//true为扇形，false为弧线
//        mImageView.setImageBitmap(mBitmap);
    }
    public static void praticalTwo(){
        /**
         * @param 绘制路径
         * @param 五角星
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(1);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        Path mPath = new Path();
        mPath.moveTo(0, 150);//起点
        mPath.rLineTo(300, 0);//使用相对定位，计算下一点坐标，并使用直线连接
        mPath.rLineTo(-300, 150);
        mPath.rLineTo(150,-300);
        mPath.rLineTo(150,300);
        mPath.close();
        mCanvas.drawPath(mPath, mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }
    public static void praticalThree(){
        /**
         * @param 往path中添加图形
         * @param 五角星
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setStrokeWidth(2);
        Path mPath = new Path();
        //矩形
        mPath.addRect(new RectF(10, 10, 300, 100), Path.Direction.CCW);
        //圆角矩形，四个角弧度不一样，float数组中2个数确定一个弧度
        mPath.addRoundRect(new RectF(10, 120, 300, 220), new float[]{10, 20, 20, 10, 30, 40, 40, 30}, Path.Direction.CCW);
        //椭圆
        mPath.addOval(new RectF(10, 240, 300, 340), Path.Direction.CCW);
        //圆
        mPath.addCircle(60, 390, 50, Path.Direction.CCW);
        //弧线
        mPath.addArc(new RectF(10, 500, 300, 600), -30, -60);
        mCanvas.drawPath(mPath, mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }
    public static void praticalFour(){
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setStrokeWidth(3);
        mPaint.setColor(Color.BLUE);
        mPaint.setStyle(Paint.Style.STROKE);
        mPaint.setAntiAlias(true);
        Path mPath = new Path();
        mPath.moveTo(100, 100);
        mPath.arcTo(new RectF(100,50,400,150),-30,-60,false);
//        mPath.quadTo(200, 20, 400, 400);
        mCanvas.drawPath(mPath, mPaint);
//        mPaint.reset();
//        mPaint.setColor(Color.RED);
//        mPaint.setStrokeWidth(10);
//        mPaint.setStyle(Paint.Style.FILL);
//        mCanvas.drawPoints(new float[]{100,100,200,10,400,400},mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }
    public static void praticalFive(){
        /**
         * @param 绘制贝塞尔曲线
         * */
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStrokeWidth(2);
        mPaint.setStyle(Paint.Style.STROKE);//可修改画笔风格
        Path path1 = new Path();
        path1.addRect(new RectF(10,10,210,210), Path.Direction.CCW);
        Path path2 = new Path();
        path2.addCircle(170,170,80, Path.Direction.CCW);
//        path1.op(path2, Path.Op.REVERSE_DIFFERENCE);//反差集
//        path1.op(path2, Path.Op.DIFFERENCE);//差集
//        path1.op(path2, Path.Op.UNION);//并集
//        path1.op(path2, Path.Op.XOR);//补集
        path1.op(path2, Path.Op.INTERSECT);//交集
        mCanvas.drawPath(path1,mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }
    public static void praticalSix(){
        Bitmap mBitmap = Bitmap.createBitmap(500, 800, Bitmap.Config.ARGB_8888);
        Canvas mCanvas = new Canvas(mBitmap);
        Paint mPaint = new Paint();
        mPaint.setAntiAlias(true);
        mPaint.setStyle(Paint.Style.FILL);
        mPaint.setStrokeWidth(2);
        mPaint.setTextSize(24);
        String text = "Android 自定义组件开发详解";
        mCanvas.drawText(text, 50, 50, mPaint);
        Path mPath = new Path();
        mPath.moveTo(30,200);
        mPath.quadTo(100,100,300,500);
        mCanvas.drawTextOnPath(text,mPath,15,25,mPaint);
        mPaint.setColor(Color.RED);
        mPaint.setStyle(Paint.Style.STROKE);
        mCanvas.drawPath(mPath,mPaint);
//        mImageView.setImageBitmap(mBitmap);
    }
}
