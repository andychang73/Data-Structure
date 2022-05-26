package Cards;

import Utils.RandomUtil;
import lombok.Data;

@Data
public class Cards {

    private Card[][] cards;
    private String[] suits;

    public Cards(){
        suits = new String[]{"黑桃", "紅心", "方塊", "梅花"};
        cards = init();
    }

    private Card[][] init(){
        int k = 0;
        int j = 0;
        Card[][] cards = new Card[4][13];
        for(int i = 0; i < 52; i++){
            cards[k][j++] = new Card(i, ((i % 13 ) + 1), suits[i /13]);
            if(j >= 13){
                k++;
                j = 0;
            }
        }
        return cards;
    }

    public void shuffle(){
        for(int i = 0 ; i < 52; i++){
            int random = RandomUtil.generate(i, 51);
            int h = i / 13;
            int p = i % 13;
            int k = random / 13;
            int j = random % 13;
            Card temp = cards[h][p];
            cards[h][p] = cards[k][j];
            cards[k][j] = temp;
        }
    }

    private void printCards(){
        for (Card[] value : cards) {
            for (Card card : value) {
                System.out.print(card.getNumber() + "\t" + card.getCard() + card.getSuit() + "\t");
            }
            System.out.println();
        }
    }
}
