package com.paxw.game2048;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.umeng.analytics.MobclickAgent;
import com.umeng.update.UmengUpdateAgent;

public class MainActivity extends AppCompatActivity implements Score.AddScoreListener, View.OnClickListener {

    private ActionBar supportActionBar;
    private My2048View gameView;
    private TextView score;
    private TextView bestScore;
    private Button btnNewGame;
    private LinearLayout gameContainer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //检测自动更新配置是否正确不想使用直接false或者注释掉
        UmengUpdateAgent.setUpdateCheckConfig(true);
        //所有网络状态都更新
        UmengUpdateAgent.setUpdateOnlyWifi(false);
        UmengUpdateAgent.update(this);
        MobclickAgent.setSessionContinueMillis(60000);
        setContentView(R.layout.activity_main);
        supportActionBar = this.getSupportActionBar();
       supportActionBar.setTitle(2048 + "");
        gameView = (My2048View) findViewById(R.id.gameView);
        score = (TextView) findViewById(R.id.score);
        score.setText(0+"");
        bestScore = (TextView) findViewById(R.id.bestScore);
        bestScore.setText(Utils.getBestScore(this)+"");
        btnNewGame = (Button) findViewById(R.id.btnNewGame);
        gameContainer = (LinearLayout) findViewById(R.id.gameContainer);
        gameContainer.setLayoutParams(new LinearLayout.LayoutParams(Utils.getScreenWidth(this),Utils.getScreenWidth(this)));
        Score score = new Score(this,this);
        gameView.setScore(score);
        btnNewGame.setOnClickListener(this);
    }

    @Override
    public void showScore(int s) {
        score.setText(s + "");
    }

    @Override
    public void showBestScore(int bs) {
        bestScore.setText(bs+"");
    }


    public void onResume() {
        super.onResume();
        MobclickAgent.onResume(this);
    }
    public void onPause() {
        super.onPause();
        MobclickAgent.onPause(this);
    }

    @Override
    public void onClick(View v) {
        gameView.startGame();
        gameView.setScore(new Score(this,this));
        score.setText(""+0);
    }
}
