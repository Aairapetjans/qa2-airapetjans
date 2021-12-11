package homework1;

import java.math.BigDecimal;

public class AudiFuelConsumtionCalc {

    public BigDecimal finalFuelConsumed(BigDecimal mileage, BigDecimal consumption){
        return mileage.divide(BigDecimal.valueOf(100)).multiply(consumption);


    }

}
