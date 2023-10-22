package com.Assignment.Third;

public class AdapterRunner {
    public static void main(String[] args) {
        CelsiusTempLiquid waterCel = new CelsiusTempLiquid(100);
        FahrenheitTempLiquid waterFar = new FahrenheitTempLiquid(211);

        Bolier boiler = new Bolier(105);

        boiler.IsBoiled(waterCel);
//        boiler.IsBoiled(waterFar);
        FahrenheitToCelsiusAdapter fca = new FahrenheitToCelsiusAdapter(waterFar);
        boiler.IsBoiled(fca);

        CelsiusTempLiquid glycerolCel = new CelsiusTempLiquid(290);
        boiler.IsBoiled(glycerolCel);
    }
}
