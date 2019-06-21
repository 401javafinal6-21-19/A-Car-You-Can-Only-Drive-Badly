package BadDriving;

import org.junit.Assert;
import org.junit.Test;

public class SteeringTest {

    GpioTest wheel1 = new GpioTest();
    GpioTest wheel2 = new GpioTest();
    GpioTest wheel3 = new GpioTest();
    GpioTest wheel4 = new GpioTest();

    SteeringMock car = new SteeringMock();

    String forward = "forward";
    String stop = "stop";
    String left = "left";
    String right = "right";

    @Test
    public void steeringButtonDepressedTestForward(){
        car.steeringButtonDepressed(forward);

        Assert.assertEquals("Pin 1 is not being set to high on forward", "high", car.wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to high on forward", "high", car.wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to high on forward", "high", car.wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to high on forward", "high", car.wheel4.getState());
    }

    @Test
    public void steeringButtonDepressedTestStop(){
        car.steeringButtonDepressed(stop);

        Assert.assertEquals("Pin 1 is not being set to low on stop", "low", car.wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to low on stop", "low", car.wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to low on stop", "low", car.wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to low on stop", "low", car.wheel4.getState());
    }

    @Test
    public void steeringButtonDepressedTestLeft(){

        car.steeringButtonDepressed(left);

        Assert.assertEquals("Pin 1 is not being set to low on left", "low", car.wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to low on left", "low", car.wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to high on left", "high", car.wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to high on left", "high", car.wheel4.getState());
    }

    public void steeringButtonDepressedTestRight(){

        car.steeringButtonDepressed(right);

        Assert.assertEquals("Pin 1 is not being set to high on right", "high", car.wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to high on right", "high", car.wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to low on right", "low", car.wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to low on right", "low", car.wheel4.getState());
    }

    public void steeringButtonDepressedTestDefault(){
        car.steeringButtonDepressed("default");

        Assert.assertEquals("Pin 1 is not being set to low on stop", "low", car.wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to low on stop", "low", car.wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to low on stop", "low", car.wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to low on stop", "low", car.wheel4.getState());
    }


    @Test
    public void forwardTest(){

        car.forward(wheel1, wheel2, wheel3, wheel4);

        Assert.assertEquals("Pin 1 is not being set to high on forward", "high", wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to high on forward", "high", wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to high on forward", "high", wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to high on forward", "high", wheel4.getState());


    }

    @Test
    public void stopTest(){

        car.stop(wheel1, wheel2, wheel3, wheel4);

        Assert.assertEquals("Pin 1 is not being set to low on stop", "low", wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to low on stop", "low", wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to low on stop", "low", wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to low on stop", "low", wheel4.getState());

    }

    @Test
    public void leftTest(){

        car.left(wheel1, wheel2, wheel3, wheel4);

        Assert.assertEquals("Pin 1 is not being set to low on left", "low", wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to low on left", "low", wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to high on left", "high", wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to high on left", "high", wheel4.getState());

    }

    @Test
    public void rightTest(){

        car.right(wheel1, wheel2, wheel3, wheel4);

        Assert.assertEquals("Pin 1 is not being set to high on right", "high", wheel1.getState());
        Assert.assertEquals("Pin 2 is not being set to high on right", "high", wheel2.getState());
        Assert.assertEquals("Pin 3 is not being set to low on right", "low", wheel3.getState());
        Assert.assertEquals("Pin 4 is not being set to low on right", "low", wheel4.getState());
    }

}