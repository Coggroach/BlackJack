package com.coggroach.blackjack;

import com.coggroach.lib.Deck;

/**
 * Created by TARDIS on 11/10/2014.
 */
public class BlackJackGame
{
    Deck deck;
    BlackJackHand dealer;
    BlackJackHand player;

    public BlackJackGame()
    {
        deck = new Deck();
        dealer = new BlackJackHand();
        player = new BlackJackHand();
    }

    public void initDeal()
    {
        deck.shuffle();
    }

}
