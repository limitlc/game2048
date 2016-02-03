package com.paxw.game2048;

import android.content.Context;

public class Score {
    private int score = 0;
    private static final String SP_KEY_BEST_SCORE = "bestScore";
    private Context context;
    private AddScoreListener listener;
    public Score(){

    }
    public Score(Context context ,AddScoreListener listener){
        this.context = context;
        this.listener = listener;
    }

    public void clearScore() {
        score = 0;
    }

    public int getScore() {
        return score;
    }

    public void addScore(int s) {
        score += s;
        listener.showScore(score);
        saveBestScore(Math.max(score, getBestScore()));
        listener.showBestScore(getBestScore());
    }

    /**
     * 也就是为了保存上最好的成绩
     * @param s
     */
    public void saveBestScore(int s) {
        if (s>Utils.getBestScore(context))
             Utils.setScore(context,s);
    }

    /**
     *  此方法也就是为了获得最好分数
     */
    public int getBestScore() {
        return Utils.getBestScore(context);
    }

    interface  AddScoreListener{
        void showScore(int score);
        void showBestScore(int bscore);

    }


}