package homework1;

import org.junit.jupiter.api.Test;

import java.math.BigDecimal;

public class AudiFuelTest {

    @Test
    public void checkAudiConsumedFuel() {
        BigDecimal mileage = BigDecimal.valueOf(293);
        BigDecimal consumption = BigDecimal.valueOf(6.2);


        AudiFuelConsumtionCalc audiFuelConsumtionCalc = new AudiFuelConsumtionCalc();
        System.out.println("Audi consumed litres of diesel fuel = "
                + audiFuelConsumtionCalc.finalFuelConsumed (mileage,consumption));





    }
}
