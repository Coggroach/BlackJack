package com.coggroach.lib.assets;

import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Point;

/**
 * Created by TARDIS on 16/10/2014.
 */
public class BoundBitmap
{
    private Bitmap bitmap;
    private Point point;

    public BoundBitmap(Bitmap b, Point p)
    {
        this.bitmap = b;
        this.point = p;
    }

    public boolean contains(Point p)
    {
        if(p.x < point.x + bitmap.getWidth() && p.y < point.y + bitmap.getHeight() && p.x > point.x && p.y > point.y)
        {
            return true;
        }
        return false;
    }

    public Bitmap getBitmap()
    {
        return this.bitmap;
    }

    public void setPoint(Point p)
    {
        this.point = p;
    }

    public Point getPoint()
    {
        return this.point;
    }

    public void draw(Canvas c)
    {
        c.drawBitmap(bitmap, point.x, point.y, null);
    }
}
