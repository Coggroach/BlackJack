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

        //

    }

    public void onHit()
    {
        onHit(player);
    }

    public int onStick()
    {
        return this.onStick(player);
    }

    public void onHit(BlackJackHand hand)
    {
        if(hand.getTotal() < 21)
        {
            deck.draw(hand);
        }
    }

    public int onStick(BlackJackHand hand)
    {
        if (hand.getTotal() < 16)
            return BlackJackCase.CASE_HAND_UNDER;

        if (Bust(hand))
            return BlackJackCase.CASE_HAND_BUST;

        return BlackJackCase.CASE_HAND_FINISH;
    }

    public int onFinish()
    {
        if(player.getTotal() < dealer.getTotal())
            return BlackJackCase.CASE_LOSE;

        if (player.getTotal()==dealer.getTotal())
            return BlackJackCase.CASE_DRAW;

        if (player.getTotal()>dealer.getTotal()&&player.getTotal()==21)
            return BlackJackCase.CASE_BLACKJACK;

        return BlackJackCase.CASE_WIN;
    }

    public boolean Bust(BlackJackHand hand)
    {
        if (hand.getTotal() <= 21)
            return false;
        else
            return true;
    }

}
