package com.lacuz.advancedcustomview.season.rain;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * 雨滴视图, DELAY时间重绘, 绘制NUM_SNOWFLAKES个雨滴
 * 核心内容：
 1.绘制下雨场景的个体、雨点（直线）
 2.让直线动起来
 3.处理边界问题
 4.构造雨点对象
 5.雨点大小设置
 6.速度设置和角度设置等
 7.添加多个雨点
 8.抽离可以在 XML 中影响的属性
 9.在代码中解析样式属性并使用其控制雨的变化
 */  
public class RainView extends View {
  
    private static final int NUM_SNOWFLAKES = 150; // 雨滴数量  
    private static final int DELAY = 5; // 延迟  
    private RainFlake[] mSnowFlakes; // 雨滴  
  
    public RainView(Context context) {  
        super(context);  
    }  
  
    public RainView(Context context, AttributeSet attrs) {
        super(context, attrs);  
    }  
  
    public RainView(Context context, AttributeSet attrs, int defStyleAttr) {  
        super(context, attrs, defStyleAttr);  
    }  
  
    @Override   
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {  
        super.onSizeChanged(w, h, oldw, oldh);  
        if (w != oldw || h != oldh) {  
            initSnow(w, h);  
        }  
    }  
  
    private void initSnow(int width, int height) {  
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG); // 抗锯齿
        paint.setColor(0x80ffffff); // 雨滴的颜色
        paint.setStyle(Paint.Style.FILL); // 填充;  
        mSnowFlakes = new RainFlake[NUM_SNOWFLAKES];  
        //mSnowFlakes所有的雨滴都生成放到这里面  
        for (int i = 0; i < NUM_SNOWFLAKES; ++i) {  
            mSnowFlakes[i] = RainFlake.create(width, height, paint);  
        }  
    }  
  
    @Override   
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);  
        //for返回SnowFlake  
        for (RainFlake s : mSnowFlakes) {  
            //然后进行绘制  
            s.draw(canvas);  
        }  
        // 隔一段时间重绘一次, 动画效果  
        getHandler().postDelayed(runnable, DELAY);  
    }  
  
    // 重绘线程  
    private Runnable runnable = new Runnable() {  
        @Override  
        public void run() {  
            //自动刷新  
            invalidate();  
        }  
    };  
}  