package com.coggroach.Test;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Environment;

import com.coggroach.blackjack.graphics.BlackJackAssetHelper;

import java.io.BufferedInputStream;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * Created by TARDIS on 10/10/2014.
 */
public class TestAssets
{
    public static void main(String[] args)
    {
        onDrawSplitCards();
    }

    private static Bitmap master;

    public static void onDrawSplitCards()
    {
        try {
            master = BitmapFactory.decodeStream(new BufferedInputStream(new FileInputStream("E:/Development/Android Studio/Projects/BlackJack/app/src/main/assets/CardTextureSheet.png")));
        }
        catch (IOException ex)
        {

        }
        for(int i = 0; i < 6; i++)
        {
            for(int j = 0; j < 9; j++)
            {
                Bitmap output = Bitmap.createBitmap(master, 0 + j*380, 0 + i*528, 380, 528);

                FileOutputStream out = null;
                try
                {
                    out = new FileOutputStream(Environment.getExternalStorageDirectory().getPath() + "output" + i + "_" + j + ".png");
                    output.compress(Bitmap.CompressFormat.PNG, 90, out);
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
                finally
                {
                    try
                    {
                        if (out != null)
                            out.close();
                    }
                    catch (IOException e)
                    {
                        e.printStackTrace();
                    }
                }
            }
        }
    }
}
