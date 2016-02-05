package com.paxw.game2048;

import android.content.Context;
import android.graphics.Color;
import android.view.Gravity;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.ScaleAnimation;
import android.widget.FrameLayout;
import android.widget.TextView;



/**
 * Created by lichuang on 2016/2/1.
 */
public class Card extends FrameLayout {
    private MyTextView label;
    public  static  int width;
    private Context context;
    public Card(Context context) {
        super(context);
        this.context= context;
        LayoutParams lp = null;

        View background = new View(getContext());
        lp = new LayoutParams(-1, -1);
        lp.setMargins(15, 15, 0, 0);
        background.setBackgroundColor(Color.argb(88,204,192,178));
        addView(background, lp);

        label = new MyTextView(getContext());
        label.setTextSize(Utils.dip2px(getContext(),18));
        label.setTextColor(Color.parseColor("#99000000"));
        label.setGravity(Gravity.CENTER);

        lp = new LayoutParams(-1, -1);
        lp.setMargins(5, 5, 0, 0);
        addView(label, lp);

        setNum(0);
    }

    public void setNum(int num){
        this.num = num;


        // FIXME: 2016/2/1 这些都他妈是什么颜色啊
        switch (num) {
            case 0:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0x00000000);
                label.setTextColor(Color.parseColor("#99000000"));
                break;
            case 2:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xffeee4da);
                label.setTextColor(Color.parseColor("#99000000"));
                break;
            case 4:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xffede0c8);
                label.setTextColor(Color.parseColor("#99000000"));
                break;
            case 8:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xfff2b179);
                label.setTextColor(Color.WHITE);
                break;
            case 16:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xfff59563);
                label.setTextColor(Color.WHITE);
                break;
            case 32:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xfff67c5f);
                label.setTextColor(Color.WHITE);
                break;
            case 64:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xfff65e3b);
                label.setTextColor(Color.WHITE);
                break;
            case 128:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xffedcf72);
                label.setTextColor(Color.WHITE);
                break;
            case 256:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xffedcc61);
                label.setTextColor(Color.WHITE);
                break;
            case 512:
                label.setTextSize(Utils.dip2px(context,18));
                label.setBackgroundColor(0xffedc850);
                label.setTextColor(Color.WHITE);
                break;
            case 1024:
                label.setTextSize(Utils.dip2px(context,12));
                label.setBackgroundColor(0xffedc53f);
                label.setTextColor(Color.WHITE);
                break;
            case 2048:
                label.setTextSize(Utils.dip2px(context,12));
                label.setBackgroundColor(0xffedc22e);
                label.setTextColor(Color.WHITE);
                break;
            case 4096:
                label.setTextSize(Utils.dip2px(context,12));
                label.setBackgroundColor(0xffedc22e);
                label.setTextColor(Color.WHITE);
                break;
            case 8192:
                label.setTextSize(Utils.dip2px(context,12));
                label.setBackgroundColor(0xffedc22e);
                label.setTextColor(Color.WHITE);
                break;
            case 16384:
                label.setTextSize(Utils.dip2px(context,12));
                label.setBackgroundColor(0xffedc22e);
                label.setTextColor(Color.WHITE);
                break;
            default:
                label.setTextSize(Utils.dip2px(context,12));
                label.setBackgroundColor(0xff3c3a32);
                break;
        }
        if (num<=0) {
            label.setText("");
        }else{
            label.setText(String.valueOf(num));

        }
    }
    private int num = 0;

    public int getNum() {
        return num;
    }

    /**
     *
     * @param another 另外一个card
     * @return 两个card上的数是否是相同的
     */
    public boolean equals(Card another) {
        return getNum()==another.getNum();
    }

    public TextView getLabel(){
        return label;
    }

    /**
     * 添加缩放的动画
     */
    public void addScaleAnimation(){
        ScaleAnimation sa = new ScaleAnimation(0.1f, 1, 0.1f, 1, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
        sa.setDuration(300);
        setAnimation(null);
        getLabel().startAnimation(sa);
    }


}
