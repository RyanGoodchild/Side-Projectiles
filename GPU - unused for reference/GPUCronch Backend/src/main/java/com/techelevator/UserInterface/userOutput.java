package com.techelevator.UserInterface;

import com.techelevator.Models.GraphicsCard;

import java.util.List;

public class userOutput {
    GraphicsCard graphicsCard = new GraphicsCard();

    public userOutput() {
    }

    //******************************GPU DISPLAYS*****************************************
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
        System.out.println("Your monthly electric bill will increase by $" + (30 * graphicsCard.dailyElectricCost(graphicsCard)));
        System.out.println();

    }


    //********************************MENU DISPLAYS******************************************

    public void displayMainMenu() {
        System.out.println("Hello, what would you like to do?");
        System.out.println();
        System.out.println("1. View All Graphics Cards");
        System.out.println("2. Access Single Card Data");
        System.out.println("3. Build a 6 card rig");
        System.out.println("4. Build a 10 card rig");
    }

    public void displayCardList(List<GraphicsCard> gpuList) {
        System.out.println("******************************************************************************");
        System.out.printf("%-6s %-5s %10s %8s %5s %9s %10s %10s\n", "Brand", "Model", "Network", "Power", "Hashrate", "Cost-Used", "Cost-New", "DailyIncome");
        for (GraphicsCard card : gpuList) {
            System.out.printf("%-6s %-8s %8s %5sw %7sMH $%9s $%8s $%5s\n", card.getBrand(), card.getModel(), card.getTopNetwork(), card.getWattsMining(), card.getHashRate(),
                    card.getUsedCost(), card.getNewCost(), card.getDailyIncome());
        }
        System.out.println("******************************************************************************");
    }

    public void singleCardOptions() {


    }

    public void sixCardRigOptions() {

    }

    public void tenCardRigOptions() {

    }
}
