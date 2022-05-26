package Cards;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class Card {
    private int number;
    private int card;
    private String suit;
}
