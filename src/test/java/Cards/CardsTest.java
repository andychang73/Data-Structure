package Cards;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;

public class CardsTest {

    private Cards cards;
    private Map<Integer, Card> cardMap;

    @Before
    public void init(){
        cards = new Cards();
        cardMap = getCardMap(cards.getCards());
    }

    @Test
    public void testInitSuccess(){
        Card[][] cardDeck = cards.getCards();

        for(Card[] card : cardDeck){
            for(Card c : card){
                Assert.assertEquals(c, cardMap.get(c.getNumber()));
            }
        }
    }

    @Test
    public void testShuffle(){
        cards.shuffle();
        Card[][] cardDeck = cards.getCards();

        for(Card[] card : cardDeck){
            for(Card c : card){
                Assert.assertEquals(c, cardMap.get(c.getNumber()));
            }
        }
    }

    private Map<Integer,Card> getCardMap(Card[][] cards){
        Map<Integer, Card> map = new HashMap<>();
        for (Card[] card : cards) {
            for (Card value : card) {
                map.put(value.getNumber(), value);
            }
        }
        return map;
    }
}
