package com.example.ewan.myapplication.demo;

import com.example.ewan.myapplication.R;
import com.example.ewan.myapplication.view.BallMoveView;
import com.example.ewan.myapplication.view.CoordinateView;

import java.util.Timer;
import java.util.TimerTask;

/**
 * Created by Administrator on 2017/10/9.
 */

public class ChapterThree {
    private static BallMoveView ballMoveView;
    private static CoordinateView coorDinateView;

    public static void practicalOne() {
        /**
         * @param 绘制可以水平移动的小球
         * */
//        ballMoveView = (BallMoveView) findViewById(R.id.ballMoveView);

        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ballMoveView.postInvalidate();
            }
        }, 200, 50);
    }
    public static void practicalTwo(){
        /**
         * @param 绘制平移、缩放、钟表盘
         * */
//        coorDinateView= (CoordinateView) findViewById(R.id.coorDinateView);
        new Timer().schedule(new TimerTask() {
            @Override
            public void run() {
                ballMoveView.postInvalidate();
            }
        }, 200, 50);
    }
}
