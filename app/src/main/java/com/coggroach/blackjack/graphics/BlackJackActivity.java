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
            switch(view.getViewId(new Point((int) event.getX(),(int) event.getY())))
            {
                case 0:
                    view.setDrawHand(game.getPlayer());
                    break;

                case 1:
                    if(!game.onHit())
                        view.setWordIndex(0);
                    view.setDrawHand(game.getPlayer());
                    break;

                case 2:
                    evaluateStatus(game.onStick());
                    break;
            }
            return false;
        }
    };

    protected void evaluateStatus(int CaseStatus)
    {
        switch(CaseStatus)
        {
            case BlackJackCase.CASE_HAND_BUST:
                //game.onFinish();
                view.setWordIndex(0);
                game.onNewGame();
                view.setDrawHand(game.getPlayer());
                break;

            case BlackJackCase.CASE_HAND_UNDER:
                view.setWordIndex(1);
                break;

            case BlackJackCase.CASE_HAND_FINISH:
                //game.DealerPlay();
                view.setWordIndex(2);
                game.onNewGame();
                view.setDrawHand(game.getPlayer());
                break;
            default:
                view.setWordIndex(-1);
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

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(view);

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
