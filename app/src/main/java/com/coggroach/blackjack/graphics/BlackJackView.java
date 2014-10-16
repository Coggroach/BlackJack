package com.coggroach.blackjack.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.view.View;
import android.widget.RelativeLayout;

import java.io.IOException;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackView extends View
{
    Bitmap background;

    public BlackJackView(Context c)
    {
        super(c);
        try
        {
            background = BitmapFactory.decodeStream(c.getResources().getAssets().open("background.png"));
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }

    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        c.drawBitmap(background, 0, 0, null);
    }


}
