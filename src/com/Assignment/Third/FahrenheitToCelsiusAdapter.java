package com.Assignment.Third;

public class FahrenheitToCelsiusAdapter extends CelsiusTempLiquid{

    private FahrenheitTempLiquid farTempLiquid;
    public FahrenheitToCelsiusAdapter(FahrenheitTempLiquid farTempLiquid) {
        super(farTempLiquid.getBoilingTemperature());
        this.farTempLiquid = farTempLiquid;
    }

    @Override
    public double getBoilingTemperature() {
        return (super.getBoilingTemperature() - 32) * (5.0 / 9.0);
    }
}
