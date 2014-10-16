package com.coggroach.lib.assets;

import android.app.Application;
import android.content.Context;
import android.content.res.AssetManager;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TARDIS on 13/10/2014.
 */
public class AssetHelper
{
    private Context context;

    public AssetHelper(Context c)
    {
        this.context = c;
    }

    public InputStream getInputStream(Context c, String s)
    {
        if(c != null)
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

    public InputStream getInputStream(String s)
    {
        return getInputStream(context, s);
    }

    public Bitmap getBitmap(Context c, String s)
    {
        return BitmapFactory.decodeStream(getInputStream(c, s));
    }

    public Bitmap getBitmap(String s)
    {
        return getBitmap(context, s);
    }
}
