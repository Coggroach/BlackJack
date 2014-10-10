package com.coggroach.blackjack;

import com.coggroach.lib.Card;
import com.coggroach.lib.Hand;

import java.util.Iterator;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackHand extends Hand
{
    int total;

    public BlackJackHand()
    {
        super(5);
        total = 0;
    }

    public int getTotal()
    {
        total = 0;

        Iterator<Card> HandIterator = this.getCards().iterator();
        while(HandIterator.hasNext())
        {
            Card card = HandIterator.next();
            total += BlackJackRules.values(card);
        }

        return total;
    }


}
