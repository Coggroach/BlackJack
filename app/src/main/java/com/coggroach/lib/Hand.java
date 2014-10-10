package com.coggroach.lib;


public class Hand extends BaseCardStorable
{
	private int maxCards;
	
	public Hand(int i)
	{
		super();
		this.maxCards = i;
	}
	
	public void emptyHand()
	{
		this.getCards().clear();
	}
	
	public boolean hasMaxCards()
	{
		return !(maxCards > this.getCards().size());
	}
	
	@Override
	public boolean addCard(Card c)
	{
		if(!hasMaxCards())
		{
			return super.addCard(c);
		}
		return false;
	}
}
