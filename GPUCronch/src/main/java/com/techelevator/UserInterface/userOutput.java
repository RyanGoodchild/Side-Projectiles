package com.techelevator.UserInterface;

import com.techelevator.Models.GraphicsCard;

public class userOutput {
    GraphicsCard graphicsCard = new GraphicsCard();

    public userOutput() {
    }

    public void displayGPUHeader(GraphicsCard graphicsCard) {
        System.out.println("************************************************");
        System.out.println("                  Brand: " + graphicsCard.getBrand() + "        ");
        System.out.println("                  Model: " + graphicsCard.getModel() + "        ");
        System.out.println("************************************************");
        System.out.println("        Hashrate: " + graphicsCard.getHashRate() + "     Network: " + graphicsCard.getTopNetwork());
        System.out.println("************************************************");
        System.out.println();
    }

    public void displayProfitabilityCard(GraphicsCard graphicsCard) {
        displayGPUHeader(graphicsCard);
        System.out.println();
        System.out.println("Daily Profit: $" + graphicsCard.cardProfitDaily(graphicsCard));
        System.out.println("Monthly Profit: $" + graphicsCard.cardProfitMonthly(graphicsCard));
        System.out.println("Annual Profit: $" + graphicsCard.cardProfitAnnual(graphicsCard));
        System.out.println();
    }

    public void displayPayoffCard(GraphicsCard graphicsCard) {
        displayGPUHeader(graphicsCard);
        System.out.println();
        System.out.println("NEW");
        System.out.println("This card is $" + graphicsCard.getNewCost() + " new.");
        System.out.println("It will take " + graphicsCard.daysToPayoffNewCard(graphicsCard) + " days to pay off a NEW card.");
        System.out.println();
        System.out.println("USED");
        System.out.println("This card is $" + graphicsCard.getUsedCost() + " used.");
        System.out.println("It will take " + graphicsCard.daysToPayoffUsedCard(graphicsCard) + " days to pay off a USED card.");
        System.out.println();
    }

    public void displayPowerStatsCard(GraphicsCard graphicsCard) {
        displayGPUHeader(graphicsCard);
        System.out.println();
        System.out.println("Max Watts: " + graphicsCard.getWattsTotal());
        System.out.println("AVG mining Watts: " + graphicsCard.getWattsMining());
        System.out.println();
        System.out.println("Daily electric cost is $" + graphicsCard.dailyElectricCost(graphicsCard));
        System.out.println("Your monthly electric bill will increase by $" + (30* graphicsCard.dailyElectricCost(graphicsCard)));
        System.out.println();

    }
}
