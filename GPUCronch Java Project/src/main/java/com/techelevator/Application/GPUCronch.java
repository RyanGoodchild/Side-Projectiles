package com.techelevator.Application;

import com.techelevator.Models.GraphicsCard;
import com.techelevator.UserInterface.userOutput;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class GPUCronch {
    GraphicsCard graphicsCard = new GraphicsCard();
    static userOutput userOutput = new userOutput();


    public static void main(String[] args) {
        System.out.println("Welcome to the GPU Croncher!!!");
        System.out.println("Time to Cronch Cronch Cronch.");

//**************************************GPU IMPORT FILE READER***********************************************
        File file = new File("GPU-data-files/gpu.csv");
        List<GraphicsCard> GPUlist = new ArrayList<>();

        try {
            Scanner fileInput = new Scanner(file);
            while (fileInput.hasNext()) {
                String line = fileInput.nextLine();
                String[] lineArray = line.split(",");
                GraphicsCard tempCard = new GraphicsCard(lineArray[0], lineArray[1], lineArray[2], Integer.parseInt(lineArray[3]),
                        Integer.parseInt(lineArray[4]), lineArray[5], Double.parseDouble(lineArray[6]), Double.parseDouble(lineArray[7]), Double.parseDouble(lineArray[8]));
                GPUlist.add(tempCard);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
//************************MENU SELECTION***************************************
        userOutput.displayGPUHeader(GPUlist.get(1));
        userOutput.displayProfitabilityCard(GPUlist.get(1));
        userOutput.displayPayoffCard(GPUlist.get(1));
        userOutput.displayPowerStatsCard(GPUlist.get(1));
        userOutput.displayCardList(GPUlist);
//        private void mainMenu() {
//            while (true) {
//
//
//            }
//        }
        userOutput.displayMainMenu();


        userOutput.displayCardList(GPUlist);


    }
}
