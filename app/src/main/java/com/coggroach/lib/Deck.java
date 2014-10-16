package com.coggroach.lib;

import java.util.Collections;
import java.util.Random;


public class Deck extends BaseCardStorable
{
	public Deck()
	{
		super(); //EnumCardSuits.values().length * EnumCardValues.values().length);
		
		for(EnumCardSuits suit : EnumCardSuits.values())
		{
			for(EnumCardValues value : EnumCardValues.values())
			{
				this.addCard(new Card(suit, value));
			}
		}		
	}
	
	public void shuffle()
	{
		Collections.shuffle(this.getCards(), new Random());
	}
	
	public Card draw()
	{
		Card c = this.getCards().get(0);		
		this.getCards().remove(0);		
		return c;
	}
	
	public void draw(Hand hand)
	{	
		if(hand.canDraw())
		{
			hand.addCard(this.draw());
		}
	}
	
	public void addToDeckFrom(Hand hand)
	{
		this.getCards().addAll(hand.getCards());
		hand.emptyHand();
	}
}
