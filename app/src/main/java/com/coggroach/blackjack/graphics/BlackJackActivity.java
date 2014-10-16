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

import com.coggroach.blackjack.BlackJackHand;

import com.coggroach.lib.Deck;


public class BlackJackActivity extends Activity
{
    BlackJackView view;
    Deck deck;
    BlackJackHand hand;

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
                    view.drawCard(deck.draw());
                    break;
            }
            return false;
        }
    };

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        view = new BlackJackView(this);
        deck = new Deck();
        hand = new BlackJackHand();
        deck.shuffle();

        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);

        setContentView(view);//R.layout.activity_black_jack);

        view.setOnTouchListener(this.listener);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        //getMenuInflater().inflate(R.menu.black_jack, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        //int id = item.getItemId();
        //if (id == R.id.action_settings)
        //{
         //   return true;
        //}
        return super.onOptionsItemSelected(item);
    }
}
