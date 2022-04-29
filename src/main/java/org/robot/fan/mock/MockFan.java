package org.robot.fan.mock;

import java.util.Arrays;

public class MockFan {

    private static Integer maxGivenTemp;
    private static Integer thresholdTemp;

    public static void setMaxGivenTemp(Integer int1) {
        maxGivenTemp = int1;
    }

    public static void setThresholdTemp(Integer int1) {
        thresholdTemp = int1;
    }

    public static int getDutyCycle() {
        return Arrays.stream(dutyCycle.values()).filter(e -> e.threshold >= maxGivenTemp).findFirst().get().dutyCycle;
    }

    private enum dutyCycle {
        VALUE_1(20,25),
        VALUE_2(35,28),
        VALUE_3(45,36),
        VALUE_4(55,44),
        VALUE_5(65,52),
        VALUE_6(75,100);
        int threshold;
        int dutyCycle;

        dutyCycle(int threshold, int dutyCycle) {
            this.threshold = threshold;
            this.dutyCycle = dutyCycle;
        }
    }
}
