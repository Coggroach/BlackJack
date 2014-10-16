package com.coggroach.blackjack;

import com.coggroach.lib.BaseCardStorable;
import com.coggroach.lib.Card;
import com.coggroach.lib.EnumCardValues;

import java.util.Iterator;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackHand extends BaseCardStorable
{
    int total;

    public BlackJackHand()
    {
        super();
        total = 0;
    }

    public int getTotal()
    {
        total = 0;

        Iterator<Card> HandIterator = this.getCards().iterator();
        while(HandIterator.hasNext())
        {
            Card card = HandIterator.next();
            total += BlackJackRuleBook.values(card);
        }

        return total;
    }

    public boolean hasAces()
    {
        Iterator<Card> HandIterator = this.getCards().iterator();
        while(HandIterator.hasNext())
        {
            Card card = HandIterator.next();
            if(card.getValue() == EnumCardValues.ACE)
                return true;
        }
        return false;
    }
}
