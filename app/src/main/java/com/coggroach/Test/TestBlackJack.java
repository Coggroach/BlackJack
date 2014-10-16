package com.coggroach.Test;

import com.coggroach.blackjack.BlackJackHand;
import com.coggroach.lib.Card;
import com.coggroach.lib.Deck;
import com.coggroach.lib.Hand;

import java.util.Iterator;

/**
 * Created by richarja on 10/10/14.
 */
public class TestBlackJack
{
    public static void main(String[] odds)
    {
        Deck deck = new Deck();
        BlackJackHand hand = new BlackJackHand();

        deck.shuffle();

        deck.draw(hand);
        deck.draw(hand);
        deck.draw(hand);
        deck.draw(hand);
        deck.draw(hand);

        Iterator<Card> iCard = hand.getCards().iterator();

        while(iCard.hasNext())
        {
            Card c = iCard.next();
            System.out.println(c.getName());
        }

        System.out.println(hand.getTotal());
    }
}
