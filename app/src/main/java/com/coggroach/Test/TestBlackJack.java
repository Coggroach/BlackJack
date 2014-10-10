package com.coggroach.Test;

import com.coggroach.blackjack.BlackJackHand;
import com.coggroach.lib.Deck;
import com.coggroach.lib.Hand;

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

        System.out.println(hand.getCards().get(0).getName());
        System.out.println(hand.getTotal());



    }
}
