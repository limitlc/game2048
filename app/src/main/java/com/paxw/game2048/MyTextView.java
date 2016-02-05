package com.paxw.game2048;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.widget.TextView;

/**
 * Created by lichuang on 2016/2/4.
 */
public class MyTextView extends TextView {

    private  int radius,paintStrokeWidth ,padding;
    private Paint paint;

    public MyTextView(Context context) {
        super(context);
        init();
    }

    public MyTextView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }
    private void init(){
        //圆角矩形
        radius = Utils.dip2px(this.getContext(),8);
        paintStrokeWidth =  Utils.dip2px(this.getContext(),8);
        padding = paintStrokeWidth / 2;
        paint = new Paint();
        paint.setAntiAlias(true);
        paint.setColor(Color.GRAY);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(paintStrokeWidth);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        RectF rectF = new RectF(0 , 0 , getWidth() , getHeight());
        canvas.drawRoundRect(rectF, radius, radius, paint);

    }
}
