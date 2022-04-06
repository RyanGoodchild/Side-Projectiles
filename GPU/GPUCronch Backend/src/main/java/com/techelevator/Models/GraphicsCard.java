package com.techelevator.Models;

public class GraphicsCard {

    private String brand;
    private String model;
    private String topNetwork;
    private int wattsTotal;
    private int wattsMining;
    private String hashRate;
    private double usedCost;
    private double newCost;
    private double dailyIncome;


    private final double costPerKWHLocal = 0.105;
    private final int hoursMiningPerDay = 24;
    private final int convertKWHtoWH = 1000;


    //***********************************************************************

    public GraphicsCard() {
    }

    public GraphicsCard(String brand, String model, String topNetwork,
                        int wattsTotal, int wattsMining, String hashRate, double usedCost,
                        double newCost, double dailyIncome) {
        this.brand = brand;
        this.model = model;
        this.topNetwork = topNetwork;
        this.wattsTotal = wattsTotal;
        this.wattsMining = wattsMining;
        this.hashRate = hashRate;
        this.usedCost = usedCost;
        this.newCost = newCost;
        this.dailyIncome = dailyIncome;
    }

    //***********************************************************************

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getTopNetwork() {
        return topNetwork;
    }

    public void setTopNetwork(String topNetwork) {
        this.topNetwork = topNetwork;
    }

    public int getWattsTotal() {
        return wattsTotal;
    }

    public void setWattsTotal(int wattsTotal) {
        this.wattsTotal = wattsTotal;
    }

    public int getWattsMining() {
        return wattsMining;
    }

    public void setWattsMining(int wattsMining) {
        this.wattsMining = wattsMining;
    }

    public String getHashRate() {
        return hashRate;
    }

    public void setHashRate(String hashRate) {
        this.hashRate = hashRate;
    }

    public double getUsedCost() {
        return usedCost;
    }

    public void setUsedCost(double usedCost) {
        this.usedCost = usedCost;
    }

    public double getNewCost() {
        return newCost;
    }

    public void setNewCost(double newCost) {
        this.newCost = newCost;
    }

    public double getDailyIncome() {
        return dailyIncome;
    }

    public void setDailyIncome(double dailyIncome) {
        this.dailyIncome = dailyIncome;
    }

    public double getCostPerKWHLocal() {
        return costPerKWHLocal;
    }

    public int getHoursMiningPerDay() {
        return hoursMiningPerDay;
    }

    public int getConvertKWHtoWH() {
        return convertKWHtoWH;
    }

    //***********************************************************************
    public double cardProfitDaily(GraphicsCard graphicsCard) {
        return graphicsCard.getDailyIncome() - graphicsCard.dailyElectricCost(graphicsCard);
    }

    public double cardProfitMonthly(GraphicsCard graphicsCard) {
        return  30 * (graphicsCard.getDailyIncome() - graphicsCard.dailyElectricCost(graphicsCard));
    }

    public double cardProfitAnnual(GraphicsCard graphicsCard) {
        return  365 * (graphicsCard.getDailyIncome() - graphicsCard.dailyElectricCost(graphicsCard));
    }

    public int daysToPayoffUsedCard(GraphicsCard graphicsCard) {
       return  (int) (graphicsCard.getUsedCost() / cardProfitDaily(graphicsCard));
    }

    public int daysToPayoffNewCard(GraphicsCard graphicsCard) {
        return  (int) (graphicsCard.getNewCost() / cardProfitDaily(graphicsCard));
    }

    public double dailyElectricCost(GraphicsCard graphicsCard) {
       return costPerKWHLocal * graphicsCard.getWattsMining() * hoursMiningPerDay / convertKWHtoWH;
    }



}
