package com.coggroach.blackjack.graphics;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Rect;
import android.os.Environment;
import android.view.MotionEvent;
import android.view.View;

import com.coggroach.lib.EnumCardSuits;
import com.coggroach.lib.EnumCardValues;

import java.io.FileOutputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Random;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackView extends View
{
    private float xTouch, yTouch;
    private boolean isTouch;

    private Bitmap background;
    private ArrayList<Bitmap> cardSheet;

    private Bitmap master;

    public BlackJackView(Context c)
    {
        super(c);

        this.xTouch = 0;
        this.yTouch = 0;
        this.isTouch = false;

        this.background = BlackJackAssetHelper.getBitmap(c, "Background.jpg");
        this.cardSheet = new ArrayList<Bitmap>();

        for(EnumCardSuits suit : EnumCardSuits.values())
        {
            for(EnumCardValues value : EnumCardValues.values())
            {
                cardSheet.add( BlackJackAssetHelper.getBitmap(c, suit.getName().toString() + String.valueOf(value.getId() + 1) + ".png") );
            }
        }
    }

    @Override
    public boolean onTouchEvent(MotionEvent event)
    {
        super.onTouchEvent(event);

        this.xTouch = event.getX();
        this.yTouch = event.getY();

        switch(event.getAction())
        {
            case MotionEvent.ACTION_DOWN:
                //this.isTouch = true;
                this.invalidate();
                break;
            case MotionEvent.ACTION_MOVE:
                //this.isTouch = true;
                this.invalidate();
                break;
            case MotionEvent.ACTION_UP:
                //this.isTouch = false;
                break;
            default:
        }

        return true;
    }

    public void onDrawBackground(Canvas c)
    {
        c.drawBitmap(Bitmap.createScaledBitmap(this.background, this.getRight(), this.getBottom(), false), 0, 0, null);
    }

    public void onDrawCard(Canvas c)
    {
        //c.drawBitmap(Bitmap.createScaledBitmap(Bitmap.createBitmap(this.cardSheet, 0, 0, 68, 96), 3*68, 3*96, false), xTouch, yTouch, null);
        Bitmap card = this.cardSheet.get(new Random().nextInt(this.cardSheet.size()));
        if(card != null)
            c.drawBitmap(card, xTouch, yTouch, null);
    }



    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        this.onDrawBackground(c);
        this.onDrawCard(c);
        //c.drawBitmap(background, this.getWidth()/2 - background.getWidth()/2, this.getHeight()/2 - background.getHeight()/2, null);
        //c.drawBitmap(scaleBitmap(), 0, 0, null);
    }
}
