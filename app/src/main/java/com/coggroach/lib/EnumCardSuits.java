package com.coggroach.lib;

public enum EnumCardSuits
{
	HEARTS(0, "Hearts"),
	SPADES(1, "Spades"),
	DIAMONDS(2, "Diamonds"),
	CLUBS(3, "Clubs");
	
	private int id;
	private String name;
	
	EnumCardSuits(int i, String s)
	{
		this.id = i;
		this.name = s;
	}
	
	public int getId()
	{
		return this.id;
	}
	
	public String getName()
	{
		return this.name;
	}
}
