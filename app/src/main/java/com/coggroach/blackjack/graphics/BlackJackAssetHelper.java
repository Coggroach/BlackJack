package com.coggroach.blackjack.graphics;

import android.content.Context;
import android.content.res.AssetManager;
import android.content.res.Resources;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapRegionDecoder;
import android.graphics.Rect;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TARDIS on 13/10/2014.
 */
public class BlackJackAssetHelper
{
    public static InputStream getInputStream(Context c, String s)
    {
        try
        {
            return c.getResources().getAssets().open(s);
        }
        catch (IOException ex)
        {
            ex.printStackTrace();
        }
        return null;
    }

    public static Bitmap getBitmap(Context c, String s)
    {
        return BitmapFactory.decodeStream(BlackJackAssetHelper.getInputStream(c, s));
    }
}
