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
        //shuffle
        deck.shuffle();

        //draw for dealer and player
        deck.draw(dealer);
        deck.draw(dealer);
        deck.draw(player);
        deck.draw(player);
    }

    public BlackJackHand getPlayer()
    {
        return this.player;
    }

    public boolean onHit()
    {
        return onHit(player);
    }

    public int onStick()
    {
        return this.onStick(player);
    }

    public boolean onHit(BlackJackHand hand)
    {
        if(hand.getTotal() < 21)
        {
            deck.draw(hand);
            return true;
        }
        return false;
    }

    public int onStick(BlackJackHand hand)
    {
        if (hand.getTotal() < 16)
            return BlackJackCase.CASE_HAND_UNDER;

        else if(isBust(hand))
            return BlackJackCase.CASE_HAND_BUST;

        else
            return BlackJackCase.CASE_HAND_FINISH;
    }

    public int onFinish()
    {
        if(player.getTotal() > dealer.getTotal())
            return BlackJackCase.CASE_WIN;

        if (player.getTotal() == dealer.getTotal())
            return BlackJackCase.CASE_DRAW;

        if (player.getTotal() > dealer.getTotal() && player.getTotal() == 21)
            return BlackJackCase.CASE_BLACKJACK;

        return BlackJackCase.CASE_LOSE;
    }

    public void onNewGame()
    {
        deck.addToDeckFrom(player);
        deck.addToDeckFrom(dealer);
        deck.shuffle();
    }

    public boolean isBust(BlackJackHand hand)
    {
        if(hand.getTotal() <= 21)
            return false;
        else
            return true;
    }

}
