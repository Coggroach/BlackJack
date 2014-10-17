package com.coggroach.blackjack.graphics;

import android.app.Activity;
import android.graphics.Point;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

import com.coggroach.blackjack.BlackJackCase;
import com.coggroach.blackjack.BlackJackGame;
import com.coggroach.blackjack.BlackJackHand;

import com.coggroach.lib.Deck;


public class BlackJackActivity extends Activity
{
    BlackJackView view;
    BlackJackGame game;

    View.OnTouchListener listener = new View.OnTouchListener()
    {
        @Override
        public boolean onTouch(View v, MotionEvent event)
        {
            switch(view.getBoundBitmap(new Point((int) event.getX(),(int) event.getY())).getId())
            {
                case 0:
                    view.drawCard();
                    break;

                case 1:
                    game.onHit();
                    break;

                case 2:
                    EvaluateStatus (game.onStick());
                    break;
            }
            return false;
        }
    };

    protected void EvaluateStatus (int CaseStatus)
    {
        switch(CaseStatus)
        {
            case BlackJackCase.CASE_HAND_BUST:
                game.onFinish();
                break;

            case BlackJackCase.CASE_HAND_UNDER:
                break;

            case BlackJackCase.CASE_HAND_FINISH:
                //game.DealerPlay();
                break;
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        view = new BlackJackView(this);

        game = new BlackJackGame();
        game.initDeal();

        //draw to view

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(view);//R.layout.activity_black_jack);

        view.setOnTouchListener(this.listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        return super.onOptionsItemSelected(item);
    }
}
