package com.coggroach.lib;


public class Hand extends BaseCardStorable
{
	protected int maxCards;
    protected boolean hasMaxCards;

    public Hand(int i)
    {
        this(i, true);
    }
	
	public Hand(int i, boolean b)
	{
		super();
		this.maxCards = i;
        this.hasMaxCards = b;
	}
	
	public void emptyHand()
	{
		this.getCards().clear();
	}
	
	public boolean isAtMaxCards()
	{
		return !(maxCards > this.getCards().size());
	}

    public boolean canDraw()
    {
        return !isAtMaxCards() || this.hasMaxCards;
    }
	
	@Override
	public boolean addCard(Card c)
	{
		if(canDraw())
		{
			return super.addCard(c);
		}
		return false;
	}

    public void draw(Deck deck)
    {
        deck.draw(this);
    }

    public int getMaxCards()
    {
        return this.maxCards;
    }
}
