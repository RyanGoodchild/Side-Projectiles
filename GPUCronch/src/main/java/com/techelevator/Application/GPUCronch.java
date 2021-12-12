package com.techelevator.Application;

import com.techelevator.Models.GraphicsCard;
import com.techelevator.UserInterface.userOutput;

public class GPUCronch {
    GraphicsCard graphicsCard = new GraphicsCard();
    static userOutput userOutput = new userOutput();


    public static void main(String[] args) {
        System.out.println("Welcome to the GPU Croncher!!!");
        System.out.println("Time to Cronch Cronch Cronch.");


        GraphicsCard rx5500xt = new GraphicsCard("AMD", "RX5500XT", "Ethereum", 130, 65,
                "27.59", 450, 900, 1.30);


        userOutput.displayGPUHeader(rx5500xt);

        userOutput.displayProfitabilityCard(rx5500xt);

        userOutput.displayPayoffCard(rx5500xt);

        userOutput.displayPowerStatsCard(rx5500xt);


    }
}
