package com.coggroach.blackjack;

import com.coggroach.lib.Card;
import com.coggroach.lib.RuleBook;

/**
 * Created by richarja on 10/10/14.
 */
public class BlackJackRules extends RuleBook
{
    public static int values (Card card)
    {
        if (card!=null)
        {
            switch (card.getValue().getId())
            {
                case 0:
                    return 11;
                case 10:
                case 11:
                case 12:
                    return 10;
            }
            return card.getValue().getId()+1;
        }
        return 0;
    }
}
