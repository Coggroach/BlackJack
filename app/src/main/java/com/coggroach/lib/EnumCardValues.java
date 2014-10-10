package com.coggroach.lib;

public enum EnumCardValues
{
	ACE(0, "Ace"),
	TWO(1, "Two"),
	THREE(2, "Three"),
	FOUR(3, "Four"),
	FIVE(4, "Five"),
	SIX(5, "Six"),
	SEVEN(6, "Seven"),
	EIGHT(7, "Eight"),
	NINE(8, "Nine"),
	TEN(9, "Ten"),
	JACK(10, "Jack"),
	QUEEN(11, "Queen"),
	KING(12, "King");
	
	private int id;
	private String name;
	
	EnumCardValues(int i, String s)
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
