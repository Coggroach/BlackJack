package com.coggroach.blackjack.graphics;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;
import android.view.View;

import com.coggroach.lib.BaseCardStorable;
import com.coggroach.lib.Card;
import com.coggroach.lib.EnumCardSuits;
import com.coggroach.lib.EnumCardValues;
import com.coggroach.lib.assets.AssetHelper;
import com.coggroach.lib.assets.BoundBitmap;
import com.coggroach.lib.assets.CardGraphics;

import java.util.ArrayList;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackView extends View
{
    private CardGraphics cardGraphics;

    private Point pTouch;

    private BoundBitmap background;

    private BoundBitmap button;
    private Point buttonPoint;

    private Point cardPoint;
    private int randCard;

    public BlackJackView(Context c)
    {
        super(c);
        this.cardGraphics = new CardGraphics(c);

    }

    @Override
    protected void onSizeChanged(int xNew, int yNew, int xOld, int yOld)
    {
        super.onSizeChanged(xNew, yNew, xOld, yOld);

        this.cardGraphics.setMaxWidth(this.getWidth());
        this.cardGraphics.setMaxHeight(this.getHeight());
        this.cardGraphics.loadBitmaps();

        this.pTouch = new Point();
        this.buttonPoint = new Point(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.75F));
        this.cardPoint = new Point(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.1F));
        this.randCard = 0;

        this.background = new BoundBitmap(0, Bitmap.createScaledBitmap(cardGraphics.getAssetHelper().getBitmap("Background.jpg"), this.getWidth(), this.getHeight(), false), new Point(0, 0));
        this.button = new BoundBitmap(1, cardGraphics.getAssetHelper().getBitmap("Button.png"), this.buttonPoint);
    }

    public BoundBitmap getBoundBitmap(Point p)
    {
        this.pTouch.set((int) p.x,(int) p.y);

        if(this.button.contains(p))
            return this.button;


        return this.background;
    }

    public void drawCard(Card c)
    {
        if(c != null)
        {
            this.randCard = c.getIndex();
            this.invalidate();
        }
    }

    public void drawCard()
    {
        this.randCard = cardGraphics.CARD_BACK_INDEX;
        this.invalidate();
    }

    public void onDrawBackground(Canvas c)
    {
        if(c != null && this.background.getBitmap() != null)
            c.drawBitmap(this.background.getBitmap(), 0, 0, null);
    }

    public void onDrawCard(Canvas c)
    {
        Bitmap card = cardGraphics.getCardSheet().get(randCard);
        if(card != null)
            c.drawBitmap(card, this.cardPoint.x, this.cardPoint.y, null);
    }

    public void onDrawButton(Canvas c)
    {
        c.drawBitmap(this.button.getBitmap(), this.buttonPoint.x, this.buttonPoint.y, null);
    }


    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        this.onDrawBackground(c);
        this.onDrawCard(c);
        this.onDrawButton(c);
    }
}
