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
        if(hasCardsInDeck())
        {
            Card c = this.getCards().get(this.getCards().size() - 1);
            this.getCards().remove(this.getCards().size() - 1);
            return c;
        }
        return null;
	}

    public boolean hasCardsInDeck()
    {
        return this.getCards().size() >= 1;
    }
	
	public void draw(BaseCardStorable hand)
	{	
		if(hasCardsInDeck())
		{
			hand.addCard(this.draw());
		}
	}
	
	public void addToDeckFrom(BaseCardStorable hand)
	{
		this.getCards().addAll(hand.getCards());
		hand.getCards().clear();
	}
}
