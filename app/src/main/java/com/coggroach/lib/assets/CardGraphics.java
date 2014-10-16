package com.coggroach.lib.assets;

import android.content.Context;
import android.graphics.Bitmap;

import com.coggroach.lib.Card;
import com.coggroach.lib.EnumCardSuits;
import com.coggroach.lib.EnumCardValues;

import java.util.ArrayList;

/**
 * Created by TARDIS on 16/10/2014.
 */
public class CardGraphics
{
    private AssetHelper assetHelper;
    private ArrayList<Bitmap> cardSheet;
    public int CARD_BACK_INDEX = EnumCardSuits.values().length * EnumCardValues.values().length;
    private int maxWidth;
    private int maxHeight;

    public CardGraphics(Context c)
    {
        this.cardSheet = new ArrayList<Bitmap>();
        this.assetHelper = new AssetHelper(c);
    }

    public CardGraphics(Context c, int i, int j)
    {
        this(c);
        this.maxWidth = i;
        this.maxHeight = j;
    }

    public void setMaxWidth(int i)
    {
        this.maxWidth = i;
    }

    public void setMaxHeight(int i)
    {
        this.maxHeight = i;
    }

    public void loadBitmaps()
    {
        for(EnumCardSuits suit : EnumCardSuits.values())
        {
            for(EnumCardValues value : EnumCardValues.values())
            {
                Bitmap bitmap = assetHelper.getBitmap(suit.getName().toString() + String.valueOf(value.getId() + 1) + ".png");
                cardSheet.add(bitmap);
                        //Bitmap.createScaledBitmap(bitmap, getScalingFraction(0.25F), getScalingFraction(0.25F), false));
            }
        }
        cardSheet.add( Bitmap.createScaledBitmap(assetHelper.getBitmap("Background.jpg"), cardSheet.get(0).getWidth(), cardSheet.get(0).getHeight(), false ));
    }

    public AssetHelper getAssetHelper()
    {
        return assetHelper;
    }

    public int getScalingFraction(float f)
    {
        return getScalingFraction(f, Math.max(maxWidth, maxHeight));
    }

    public int getScalingFraction(float f, int i)
    {
        if(f <= 1.0F)
        {
            return (int) (f * i);
        }
        return 0;
    }

    public int getHeightFraction(float f)
    {
        return getScalingFraction(f, maxHeight);
    }

    public int getWidthFraction(float f)
    {
        return getScalingFraction(f, maxWidth);
    }

    public Bitmap getCardBitmap(Card c)
    {
        if(cardSheet != null && cardSheet.size() > 0)
        {
            return cardSheet.get(c.getIndex());
        }
        return null;
    }

    public ArrayList<Bitmap> getCardSheet()
    {
        return cardSheet;
    }
}
