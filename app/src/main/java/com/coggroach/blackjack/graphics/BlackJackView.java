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
import com.coggroach.lib.assets.Vector;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.concurrent.CancellationException;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackView extends View
{
    private CardGraphics cardGraphics;

    private BoundBitmap background;
    private BoundBitmap btnHit;
    private BoundBitmap btnStick;
    private BoundBitmap lblTitle;

    private ArrayList<BoundBitmap> wordSheet;
    private int wordIndex;

    private Vector cardVector;
    private ArrayList<Integer> cardIndexList;

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

        this.cardIndexList = new ArrayList<Integer>();
        this.wordSheet = new ArrayList<BoundBitmap>();
        this.wordIndex = -1;

        Point btnPoint = new Point(cardGraphics.getWidthFraction(0.27902F), cardGraphics.getHeightFraction(0.6667F));
        Point btnPoint2 = new Point(cardGraphics.getWidthFraction(0.27902F), cardGraphics.getHeightFraction(0.8333F));
        Point lblPoint = new Point(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.02F));
        this.cardVector = new Vector(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.1F));

        this.background = CreateScaledBoundBitmap("Background.png", this.getWidth(), this.getHeight(), new Point(0,0));
        this.btnHit = CreateScaledBoundBitmap("ButtonHit.png", cardGraphics.getWidthFraction(0.44196F), cardGraphics.getHeightFraction(0.14F), btnPoint);
        this.btnStick = CreateScaledBoundBitmap("ButtonStick.png", cardGraphics.getWidthFraction(0.44196F), cardGraphics.getHeightFraction(0.14F), btnPoint2);
        this.lblTitle = CreateScaledBoundBitmap("Title.png", cardGraphics.getWidthFraction(0.2598F), cardGraphics.getHeightFraction(0.05F), lblPoint);

        Point wPoint = new Point(cardGraphics.getWidthFraction(0.27902F), cardGraphics.getHeightFraction(0.5F));

        this.wordSheet.add(CreateScaledBoundBitmap("WordBust.png", cardGraphics.getWidthFraction(0.11618F), cardGraphics.getHeightFraction(0.05F), wPoint));
        this.wordSheet.add(CreateScaledBoundBitmap("WordUnder.png", cardGraphics.getWidthFraction(0.14804F), cardGraphics.getHeightFraction(0.05F), wPoint));
        this.wordSheet.add(CreateScaledBoundBitmap("WordFinish.png", cardGraphics.getWidthFraction(0.140196F), cardGraphics.getHeightFraction(0.05F), wPoint));

        this.wordSheet.add(CreateScaledBoundBitmap("WordLose.png", cardGraphics.getWidthFraction(0.111275F), cardGraphics.getHeightFraction(0.05F), wPoint));
        this.wordSheet.add(CreateScaledBoundBitmap("WordDraw.png", cardGraphics.getWidthFraction(0.14313725F), cardGraphics.getHeightFraction(0.05F), wPoint));
        this.wordSheet.add(CreateScaledBoundBitmap("WordWin.png", cardGraphics.getWidthFraction(0.09755F), cardGraphics.getHeightFraction(0.05F), wPoint));

        this.cardGraphics.loadBitmaps();
    }

    public BoundBitmap CreateScaledBoundBitmap(String s, int w, int h, Point p)
    {
        return new BoundBitmap(Bitmap.createScaledBitmap(cardGraphics.getAssetHelper().getBitmap(s), w, h, false), p);
    }

    public int getViewId(Point p)
    {
        if(this.btnHit.contains(p))
            return 1;

        if(this.btnStick.contains(p))
            return 2;

        return 0;
    }

    public void setDrawHand(BaseCardStorable hand)
    {
        if(hand != null && this.cardIndexList != null)
        {
            this.cardIndexList.clear();
            for(int i = 0; i < hand.getCards().size(); i++)
            {
                this.cardIndexList.add(Integer.valueOf(hand.getCards().get(i).getIndex()));
            }
            this.invalidate();
        }
    }

    public void setWordIndex(int i)
    {
        if(this.wordSheet.size() > i)
        {
            this.wordIndex = i;
            this.invalidate();
        }
    }

    public void onDrawBackground(Canvas c)
    {
        if(c != null)// && this.background.getBitmap() != null)
            c.drawBitmap(this.background.getBitmap(), 0, 0, null);
    }

    public void onDrawCard(Canvas c)
    {
        Vector v = this.cardVector;

        for(int i = 0; i < this.cardIndexList.size(); i++)
        {
            Bitmap card = this.cardGraphics.getCardSheet().get(this.cardIndexList.get(i).intValue());
            c.drawBitmap(card, v.getXVector(), v.getYVector(), null);

            v = v.add(new Vector(cardGraphics.getWidthFraction(0.1F), 0));
        }
    }

    public void onDrawButton(Canvas c)
    {
        this.btnHit.draw(c);
        this.btnStick.draw(c);
    }

    public void onDrawTitle(Canvas c)
    {
        this.lblTitle.draw(c);
    }

    public void onDrawWord(Canvas c)
    {
        if(this.wordIndex >= 0)
            this.wordSheet.get(this.wordIndex).draw(c);
    }

    @Override
    public void onDraw(Canvas c)
    {
        super.onDraw(c);
        this.onDrawBackground(c);
        this.onDrawTitle(c);
        this.onDrawButton(c);
        this.onDrawCard(c);
        this.onDrawWord(c);
    }
}
