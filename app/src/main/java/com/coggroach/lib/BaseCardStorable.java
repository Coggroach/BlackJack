package com.coggroach.lib;

import java.util.ArrayList;

public abstract class BaseCardStorable
{
	protected ArrayList<Card> cards;
	
	protected BaseCardStorable()
	{
		cards = new ArrayList<Card>();
	}
		
	public ArrayList<Card> getCards()
	{
		return this.cards;
	}
	
	public boolean addCard(Card c)
	{
		return this.cards.add(c);
	}
	
	public boolean contains(Card c)
	{
		return this.cards.contains(c);
	}
	
	public boolean removeCard(Card c)
	{
		return this.cards.remove(c);
	}
}
