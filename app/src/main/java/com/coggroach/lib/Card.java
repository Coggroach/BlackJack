package com.coggroach.lib;

public class Card
{
	private EnumCardSuits suit;
	private EnumCardValues value;
		
	public Card(EnumCardSuits i, EnumCardValues j)
	{
		this.suit = i;
		this.value = j;
	}
	
	public boolean equals(Card c)
	{
		return this.suit == c.getSuit() && this.value == c.getValue();
	}
	
	public String getName()
	{
		return  value.getName() + " Of " + suit.getName();
	}
	
	public EnumCardSuits getSuit()
	{
		return this.suit;
	}
	
	public EnumCardValues getValue()
	{
		return this.value;
	}

    public int getIndex()
    {
        return suit.getId()*EnumCardValues.values().length + value.getId();
    }
}
