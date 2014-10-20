package com.coggroach.lib.assets;

import android.graphics.Point;

public class Vector
{
	private int X, Y;
	
	public Vector()
	{
		this.X = 0;
		this.Y = 0;
	}
	
	public Vector(Point p)
	{
		this.X = p.x;
		this.Y = p.y;
	}
	
	public Vector(int x, int y)
	{
		this.X = x;
		this.Y = y;
	}
	
	public Vector negate()
	{
		return new Vector(X*-1, Y*-1);
	}
	
	public Vector add(Vector v)
	{
		return new Vector( X + v.getXVector(), Y + v.getYVector());
	}
	
	public Vector subtract(Vector v)
	{
		return add(v.negate());
	}
	
	public Vector rotateRightAngle()
	{
		return new Vector(Y, X);
	}
	
	public Vector rotate(double radians)
	{
        int x =  (int) (X*Math.cos(radians) + Y*Math.sin(radians));
        int y =  (int) (-X*Math.sin(radians) + Y*Math.cos(radians));
		
		return new Vector(x, y);
	}
	
	public void print()
	{
		System.out.println("(" + X + ", " + Y + ")");
	}
	
	public Vector toIsometric()
	{
        int isoX = this.X - this.Y;
        int isoY = (this.Y + this.Y)/2;
		return new Vector(isoX, isoY);
	}
	
	public Vector xAxialProjection()
	{
		return new Vector(this.X, this.Y*-1);
	}
	
	public Vector yAxialProjection()
	{
		return new Vector(this.X*-1, this.Y);
	}
	
	public Vector xOthoProjection()
	{
		return new Vector(0, this.Y);
	}
	
	public Vector yOthoProjection()
	{
		return new Vector(this.X, 0);
	}
	
	public Vector scale(int s0, int s1)
	{
		return new Vector(s0*X, s1*Y);
	}
	
	public static double getRadians(double degrees)
	{
		return degrees* Math.PI/180;
	}
	
	public int getXVector()
	{
		return X;
	}
	
	public int getYVector()
	{
		return Y;
	}

    public Point toPoint()
    {
        return new Point(this.X, this.Y);
    }

    public Point addVectorToPoint(Vector v)
    {
        return new Point(X + v.getXVector(), Y + v.getYVector());
    }

    public Point subtractVectorFromPoint(Vector v)
    {
        return addVectorToPoint(v.negate());
    }

    public Vector subtractPointFromPoint(Point p)
    {
        return new Vector(X - p.x, Y - p.y);
    }
}
