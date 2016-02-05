package com.paxw.game2048;

import android.content.Context;
import android.content.DialogInterface;
import android.graphics.Color;
import android.graphics.Point;
import android.support.v7.app.AlertDialog;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by lichuang on 2016/2/1.
 */
public class My2048View extends LinearLayout implements View.OnTouchListener {
    private float startX,startY,offsetX,offsetY;
    /**
     * 行数和列数
     */
    private int LINES = 4;

    private Card[][] cardsMap ;

    private Score score;
    private List<Point> emptyPoints = new ArrayList<>();
    public My2048View(Context context) {
        super(context);
        initView();
    }
    public My2048View(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView();
    }

    private void initView(){
        cardsMap = new Card[LINES][LINES];
        setOrientation(LinearLayout.VERTICAL);
        setBackgroundColor(Color.GRAY);
        setOnTouchListener(this);
    }


    private int padding = 2;
    /**
     *
     * 第一次调用是在测量之后此方法主要是为了计算card 的宽
     *
     * @param w 现在的宽
     * @param h 现在的高
     * @param oldw 老的宽
     * @param oldh 老的高
     */
    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh) {
        super.onSizeChanged(w, h, oldw, oldh);
        Card.width = (Math.min(w, h)-(LINES+1)*padding)/LINES;
        addCard();
        startGame();

    }


    private void addCard(){
        /**
         * 每个位置的对象
         */
        Card c;

        LinearLayout line;
        LinearLayout.LayoutParams lineLp;

        for (int y = 0; y < LINES; y++) {
            line = new LinearLayout(getContext());
            lineLp = new LinearLayout.LayoutParams(-1, Card.width);
            addView(line, lineLp);

            for (int x = 0; x < LINES; x++) {
                c = new Card(getContext());
                line.addView(c, Card.width, Card.width);

                cardsMap[x][y] = c;
            }
        }


    }


    /**
     * 开始游戏
     */
    public void startGame() {
        //所有点清空添加两个随机数
        for (int y = 0; y < LINES; y++) {
            for (int x = 0; x < LINES; x++) {
                cardsMap[x][y].setNum(0);
            }
        }
        //开始游戏要添加两次随机数
        addRandomNum();
        addRandomNum();
    }



    /**
     * 添加随机数
     */
    private void addRandomNum(){
        emptyPoints.clear();
        for (int y = 0; y < LINES; y++) {
            for (int x = 0; x < LINES; x++) {
                if (cardsMap[x][y].getNum()<=0) {
                    emptyPoints.add(new Point(x, y));
                }
            }
        }

        if (emptyPoints.size()>0) {

            Point p = emptyPoints.remove((int)(Math.random()*emptyPoints.size()));
            cardsMap[p.x][p.y].setNum(Math.random()>0.1?2:4);
            cardsMap[p.x][p.y].addScaleAnimation();
        }
    }

    /**
     * 判断的临界值 5px
     */
    private final int criticalValue = 5;
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        switch ( event.getAction() ){
            case MotionEvent.ACTION_DOWN:
                startX = event.getX();
                startY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                offsetX = event.getX() - startX;
                offsetY = event.getY()-startY;
                if (Math.abs(offsetX)>Math.abs(offsetY)){
                    //横向移动是不是要保证大于某个值才移动啊
                    if (offsetX>criticalValue){
                        //向右
                        updataR();
                    }
                    else if (offsetX< -criticalValue){
                        //向左
                        updataL();
                    }

                }else{
                    //纵向移动
                    if (offsetY>criticalValue){
                        //向下
                        updataD();
                    }
                    else if (offsetY< -criticalValue){
                        //向上
                        updataU();
                    }
                }
                break;


        }
        return true;
    }

    /**
     * 向上移动更新ui
     */
    private void updataU() {
        boolean merge = false;

        for (int x = 0; x < LINES; x++) {
            for (int y = 0; y < LINES; y++) {

                for (int y1 = y+1; y1 < LINES; y1++) {
                    if (cardsMap[x][y1].getNum()>0) {

                        if (cardsMap[x][y].getNum()<=0) {

                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);

                            y--;

                            merge = true;
                        }else if (cardsMap[x][y].equals(cardsMap[x][y1])) {

                            cardsMap[x][y].setNum(cardsMap[ x ][ y ].getNum() * 2);
                            cardsMap[x][y1].setNum(0);
                            score.addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }

                        break;

                    }
                }
            }
        }

        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }

    /**
     * 向下移动更新ui
     *
     */
    private void updataD() {

        boolean merge = false;

        for (int x = 0; x < LINES; x++) {
            for (int y = LINES-1; y >=0; y--) {

                for (int y1 = y-1; y1 >=0; y1--) {
                    if (cardsMap[x][y1].getNum()>0) {

                        if (cardsMap[x][y].getNum()<=0) {

                            cardsMap[x][y].setNum(cardsMap[x][y1].getNum());
                            cardsMap[x][y1].setNum(0);

                            y++;
                            merge = true;
                        }else if (cardsMap[x][y].equals(cardsMap[x][y1])) {

                            cardsMap[x][y].setNum(cardsMap[x][y].getNum()*2);
                            cardsMap[x][y1].setNum(0);
                            score.addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }

                        break;
                    }
                }
            }
        }

        if (merge) {
            addRandomNum();
            checkComplete();
        }


    }

    /**
     * 向左移动更新ui
     */
    private void updataL() {
        boolean merge = false;

        for (int y = 0; y < LINES; y++) {
            for (int x = 0; x < LINES; x++) {

                for (int x1 = x+1; x1 < LINES; x1++) {
                    if (cardsMap[x1][y].getNum()>0) {

                        if (cardsMap[x][y].getNum()<=0) {
                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);

                            x--;
                            merge = true;

                        }else if (cardsMap[x][y].equals(cardsMap[x1][y])) {

                            cardsMap[x][y].setNum(cardsMap[x][y].getNum()*2);
                            cardsMap[x1][y].setNum(0);
                            score.addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }

                        break;
                    }
                }
            }
        }

        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }

    /**
     * 向右移动更新ui
     */
    private void updataR() {
        boolean merge = false;

        for (int y = 0; y < LINES; y++) {
            for (int x = LINES-1; x >=0; x--) {

                for (int x1 = x-1; x1 >=0; x1--) {
                    if (cardsMap[x1][y].getNum()>0) {

                        if (cardsMap[x][y].getNum()<=0) {

                            cardsMap[x][y].setNum(cardsMap[x1][y].getNum());
                            cardsMap[x1][y].setNum(0);

                            x++;
                            merge = true;
                        }else if (cardsMap[x][y].equals(cardsMap[x1][y])) {

                            cardsMap[x][y].setNum(cardsMap[ x ][ y ].getNum() * 2);
                            cardsMap[x1][y].setNum(0);
                            score.addScore(cardsMap[x][y].getNum());
                            merge = true;
                        }

                        break;
                    }
                }
            }
        }

        if (merge) {
            addRandomNum();
            checkComplete();
        }
    }

    /**
     * 判断游戏是否结束了
     */
    private void checkComplete(){

        boolean complete = true;

        ALL:
        for (int y = 0; y < LINES; y++) {
            for (int x = 0; x < LINES; x++) {
                //只要有一个坐标为0总之这个逻辑就是判断是不是有可以合并的
                if (cardsMap[x][y].getNum()==0||
                        (x>0&&cardsMap[x][y].equals(cardsMap[x-1][y]))||
                        (x<LINES-1&&cardsMap[x][y].equals(cardsMap[x+1][y]))||
                        (y>0&&cardsMap[x][y].equals(cardsMap[x][y-1]))||
                        (y<LINES-1&&cardsMap[x][y].equals(cardsMap[x][y+1]))) {

                    complete = false;
                    break ALL;
                }
            }
        }

        if (complete) {
            //如果游戏是结束的状态那么弹出对话框完成游戏结束或者重新开始
            new AlertDialog.Builder(getContext()).setTitle("Finished").setMessage("Game Over").setPositiveButton("start again?", new DialogInterface.OnClickListener() {

                @Override
                public void onClick(DialogInterface dialog, int which) {
                    startGame();
                }
            }).show();
        }

    }

    public void setScore(Score score) {
        this.score = score;

    }
}
