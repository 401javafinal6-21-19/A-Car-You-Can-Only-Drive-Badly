package BadDriving;

import org.junit.Assert;
import org.junit.Test;

public class SteeringTest {

    GpioTest wheel1 = new GpioTest();
    GpioTest wheel2 = new GpioTest();
    GpioTest wheel3 = new GpioTest();
    GpioTest wheel4 = new GpioTest();

    Steering steering = new Steering();

    @Test
    public void steeringButtonDepressedTest(){}

    @Test
    public void steeringButtonReleasedTest(){}

    @Test
    public void forwardTest(){

        steering.forward(wheel1, wheel2, wheel3, wheel4);

        Assert.assertEquals("Pin 1 is not being set to high on forward", "high", wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to high on forward", "high", wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to high on forward", "high", wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to high on forward", "high", wheel4.getState());


    }

    @Test
    public void stopTest(){

        steering.stop(wheel1, wheel2, wheel3, wheel4);

        Assert.assertEquals("Pin 1 is not being set to low on forward", "low", wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to low on forward", "low", wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to low on forward", "low", wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to low on forward", "low", wheel4.getState());

    }

    @Test
    public void leftTest(){}

    @Test
    public void rightTest(){}

}