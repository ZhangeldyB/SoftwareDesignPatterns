package com.Assignment.Third;

public class Bolier{
    private double maxBoilingTemperature ;

    public double getBoilingTemperature() {
        return maxBoilingTemperature;
    }


    public Bolier(double boilingTemperature) {
        this.maxBoilingTemperature = boilingTemperature;
    }
    public void IsBoiled(CelsiusTempLiquid cesTempLiquid) {
        if (maxBoilingTemperature >= cesTempLiquid.getBoilingTemperature()) {
            System.out.println("It Could be boiled using this boiler");
        }else{
            System.out.println("This boiler cannot boil that");
        }
    }
}
