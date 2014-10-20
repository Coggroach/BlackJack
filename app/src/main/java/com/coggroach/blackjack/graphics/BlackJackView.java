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
        this.cardGraphics.loadBitmaps();

        this.cardIndexList = new ArrayList<Integer>();
        this.wordSheet = new ArrayList<BoundBitmap>();
        this.wordIndex = -1;

        Point btnPoint = new Point(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.75F));
        Point btnPoint2 = new Point(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.85F));
        Point lblPoint = new Point(cardGraphics.getWidthFraction(0.1F), 0);
        this.cardVector = new Vector(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.1F));

        this.background = new BoundBitmap(Bitmap.createScaledBitmap(cardGraphics.getAssetHelper().getBitmap("Background.png"), this.getWidth(), this.getHeight(), false), new Point(0, 0));
        this.btnHit = new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("ButtonHit.png"), btnPoint);
        this.btnStick = new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("ButtonStick.png"), btnPoint2);
        this.lblTitle = new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("Title.png"), lblPoint);

        Point wPoint = new Point(cardGraphics.getWidthFraction(0.1F), cardGraphics.getHeightFraction(0.5F));

        this.wordSheet.add(new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("WordBust.png"), wPoint));
        this.wordSheet.add(new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("WordUnder.png"), wPoint));
        this.wordSheet.add(new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("WordFinish.png"), wPoint));

        this.wordSheet.add(new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("WordLose.png"), wPoint));
        this.wordSheet.add(new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("WordDraw.png"), wPoint));
        this.wordSheet.add(new BoundBitmap(cardGraphics.getAssetHelper().getBitmap("WordWin.png"), wPoint));
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

            v = v.add(new Vector(120, 0));
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
