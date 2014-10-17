package com.coggroach.lib.assets;

import android.graphics.Bitmap;
import android.graphics.Point;

/**
 * Created by TARDIS on 16/10/2014.
 */
public class BoundBitmap
{
    private Bitmap bitmap;
    private Point point;
    private int id;

    public BoundBitmap(int id, Bitmap b, Point p)
    {
        this.bitmap = b;
        this.point = p;
        this.id = id;
    }

    public boolean contains(Point p)
    {
        if(p.x < point.x + bitmap.getWidth() && p.y < point.y + bitmap.getHeight() && p.x > point.x && p.y > point.y)
        {
            return true;
        }
        return false;
    }

    public int getId()
    {
        return this.id;
    }

    public Bitmap getBitmap()
    {
        return this.bitmap;
    }

    public void setPoint(Point p)
    {
        this.point = p;
    }
}
