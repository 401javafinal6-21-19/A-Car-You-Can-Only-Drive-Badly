package BadDriving;

import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.*;

public class CarTest {


      /*  GpioTest gpio = GpioTest.getInstance();
        public GpioPinDigitalOutput testPin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "thrustPin26", PinState.LOW);
       public  GpioPinDigitalOutput testPin27 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "wheelTwo", PinState.LOW);
       public GpioPinDigitalOutput testPin28 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "wheelThree", PinState.LOW);
       public GpioPinDigitalOutput testPin29 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "wheelFour", PinState.LOW);


     Steering steering = new Steering();


    @Test
    public void forwardTest() throws Exception {

        steering.forward();

        assertEquals("Pin 26 is not on high", "high", testPin26.getState().toString());
        assertEquals("Pin 27 is not on high", "high", testPin27.getState().toString());
        assertEquals("Pin 28 is not on high", "high", testPin28.getState().toString());
        assertEquals("Pin 29 is not on high", "high", testPin29.getState().toString());
    }

    @Test
    public void stopTest() throws Exception{

        steering.stop();

        assertEquals("Pin 26 is not on low", "low", testPin26.getState().toString());
        assertEquals("Pin 27 is not on low", "low", testPin27.getState().toString());
        assertEquals("Pin 28 is not on low", "low", testPin28.getState().toString());
        assertEquals("Pin 29 is not on low", "low", testPin29.getState().toString());


    }

    @Test
    public void leftTest()throws Exception{

        steering.left();

        assertEquals("Pin 26 is not on low", "low", testPin26.getState().toString());
        assertEquals("Pin 27 is not on low", "low", testPin27.getState().toString());
        assertEquals("Pin 28 is not on high", "high", testPin28.getState().toString());
        assertEquals("Pin 29 is not on high", "high", testPin29.getState().toString());

    }

    @Test
    public void rightTest() throws Exception{

        steering.right();

        assertEquals("Pin 26 is not on high", "high", testPin26.getState().toString());
        assertEquals("Pin 27 is not on high", "high", testPin27.getState().toString());
        assertEquals("Pin 28 is not on low", "low", testPin28.getState().toString());
        assertEquals("Pin 29 is not on low", "low", testPin29.getState().toString());

    }

    public void forwardReleaseTest(){

    }

    public void rightReleaseTest(){

    }

    public void leftReleaseTest(){

    }*/

}