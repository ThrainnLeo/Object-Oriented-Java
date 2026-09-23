package Ps;

import cardutils.Pile;
import cardutils.Rank;
import cardutils.Suit;

public class PokerHands {
    private void PokerHands(){
    }

    public static PokerCombo getPokerCombo(Pile hand){
        if(isFour_Of_A_Kind(hand)){
            return PokerCombo.FOUR_OF_A_KIND;
        } else if (isFlush(hand)) {
            return PokerCombo.FLUSH;
        } else if (isFull_House(hand)) {
            return PokerCombo.FULL_HOUSE;
        } else if (isThree_Of_A_Kind(hand)) {
            return PokerCombo.THREE_OF_A_KIND;
        } else if (isTwo_Pair(hand)) {
            return PokerCombo.TWO_PAIR;
        } else if (isPair(hand)) {
            return PokerCombo.PAIR;
        }else return PokerCombo.NONE;

    }


    private static boolean isFour_Of_A_Kind(Pile hand){
        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 4){
                return true;
            }
        }
        return false;
    }

    private static boolean isFlush(Pile hand){
        for(Suit suit : Suit.values()){
            if(hand.noOfSuit(suit) == 5){
                return true;
            }
        }
        return false;
    }

    private static boolean isFull_House(Pile hand){
        boolean hasThree =  false;
        boolean hasPair =  false;

        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 3){
                hasThree = true;
            }
        }
        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 2){
                hasPair = true;
            }
        }
        return hasThree && hasPair;
    }

    private static boolean isThree_Of_A_Kind(Pile hand){
        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 3){
                return true;
            }
        }
        return false;
    }

    private static boolean isTwo_Pair(Pile hand){
        int pairs = 0;
        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 2){
                pairs++;
            }
        }
        return pairs == 2;
    }

    private static boolean isPair(Pile hand){
        for(Rank rank : Rank.values()){
            if(hand.noOfRank(rank) == 2){
                return true;
            }
        }
        return false;
    }
}
