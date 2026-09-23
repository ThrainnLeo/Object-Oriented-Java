package Ps;

import cardutils.Card;
import cardutils.Deck;
import cardutils.Pile;

import java.util.ArrayList;
import java.util.List;


public class PsLogic implements IPsLogic{
    private Card nextCard;
    private Deck deck;
    private List<Pile> piles;

    public PsLogic (){
        deck = new Deck();
        piles = new ArrayList<>(5);
        for(int i = 0; i < 5; i++){
            piles.add(new Pile());
        }
        this.nextCard = null;
        initNewGame();
    }


    public void initNewGame(){
        this.deck.fill();
        this.deck.shuffle();
        for(Pile pile : piles){
            pile.clear();
        }
        this.nextCard = null;
    }

    public int getCardCount(){
        int count = 0;
        for(Pile pile : piles){
            count += pile.getSize();
        }
        return count;
    }

    @Override
    public Card pickNextCard() throws IllegalStateException {
        if(nextCard != null){
            throw new IllegalStateException("A card has already been picked but not placed");
        }
        nextCard = deck.dealCard();
        return nextCard;
    }

    @Override
    public void addCardToPile(int pileIndex){
        if(nextCard == null){
            throw new IllegalStateException("No card has been picked yet");
        }

        piles.get(pileIndex).add(nextCard);
        nextCard = null;
    }

    @Override
    public List<Pile> getPiles() { //kolla om det verkligen är 5 st kopior eller ej
        return new  ArrayList<>(piles);
    }

    @Override
    public boolean isGameOver() {
        return getCardCount() == 25;
    }

    @Override
    public int getPoints() {
        int totPoints = 0;
        for(Pile pile : piles){
            PokerCombo combo = PokerHands.getPokerCombo(pile);
            totPoints += combo.getCombos();
        }
        return totPoints;
    }

    @Override
    public String toString() {
        StringBuilder string = new StringBuilder();
        for (int i = 0; i < piles.size(); i++) {
            string.append(i).append("[ ");
            List<Card> cards = piles.get(i).getCards();
            for (int j = 0; j < cards.size(); j++) {
                string.append(cards.get(j).toShortString());
                if(j < cards.size() - 1){
                    string.append(", ");
                }
            }
            string.append("]");
            string.append("\n");
        }
        return string.toString();
    }
}
