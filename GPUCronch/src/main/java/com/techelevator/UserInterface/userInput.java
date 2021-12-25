package com.techelevator.UserInterface;

import com.techelevator.Models.GraphicsCard;

import java.util.List;
import java.util.Locale;

public class userInput {

    public void getCardSelection(String chosenCard, List<GraphicsCard> cardList) {

        for(GraphicsCard card : cardList)
        if (chosenCard.toUpperCase().equals(card.getModel())) {

        }
    }
}
