package com.example.labtest;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class VehicleFeeCalculatorTest {

    VehicleFeeCalculator calculator = new VehicleFeeCalculator();

    @Test
    public void testTwoWheelerOneHour() {
        assertEquals(10.0, calculator.calculateFee("two-wheeler", 1));
    }

    @Test
    public void testTwoWheelerMultiHour() {
        assertEquals(30.0, calculator.calculateFee("two-wheeler", 3));
    }

    @Test
    public void testFourWheelerOneHour() {
        assertEquals(20.0, calculator.calculateFee("four-wheeler", 1));
    }

    @Test
    public void testFourWheelerMultiHour() {
        assertEquals(60.0, calculator.calculateFee("four-wheeler", 3));
    }

    @Test
    public void testPartialHour() {
        assertEquals(20.0, calculator.calculateFee("two-wheeler", 1.5));
    }

    @Test
    public void testZeroDuration() {
        assertEquals(0.0, calculator.calculateFee("two-wheeler", 0));
    }

    @Test
    public void testNegativeDuration() {
        assertThrows(IllegalArgumentException.class, () ->
            calculator.calculateFee("two-wheeler", -1)
        );
    }

    @Test
    public void testInvalidVehicleType() {
        assertThrows(IllegalArgumentException.class, () ->
            calculator.calculateFee("truck", 2)
        );
    }
}
