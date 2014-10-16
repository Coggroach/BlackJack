package com.coggroach.blackjack.graphics;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.RadioButton;

import com.coggroach.blackjack.R;

import com.coggroach.blackjack.R;


public class BlackJackActivity extends Activity
{
    BlackJackView view;
<<<<<<< HEAD:app/src/main/java/com/coggroach/blackjack/graphics/BlackJackActivity.java

=======
>>>>>>> 0db0a99e027229289c64039225ed37c9eca03a28:app/src/main/java/com/coggroach/blackjack/graphics/BlackJackActivity.java
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        view = new BlackJackView(this);
<<<<<<< HEAD:app/src/main/java/com/coggroach/blackjack/graphics/BlackJackActivity.java
=======

>>>>>>> 0db0a99e027229289c64039225ed37c9eca03a28:app/src/main/java/com/coggroach/blackjack/graphics/BlackJackActivity.java
        setContentView(view);//R.layout.activity_black_jack);
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
