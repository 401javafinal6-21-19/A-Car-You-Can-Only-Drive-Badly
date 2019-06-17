/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package BadDriving;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import static com.pi4j.io.gpio.PinState.*;

public class App {


    public static void main(String[] args) throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();

       turnLeft();

       Thread.sleep(600);

       turnRight();

       Thread.sleep(600);

       forward();

       Thread.sleep(600);

       stop();

       gpio.shutdown();

    }


    public static class WheelOne{
        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput firstWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "PinWheel1", HIGH);

        public static void onButtonPress() throws InterruptedException{
            firstWheel.toggle();

        }


    }

    public static class WheelTwo{

        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput seccondWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "PinWheel2", HIGH);

        public static void onButtonPress(){

            seccondWheel.toggle();
        }

    }

    public static class WheelThree{
        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput thirdWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "PinWheel3", HIGH);

        public static void onButtonPress() throws InterruptedException{

            thirdWheel.toggle();

        }


    }

    public static class WheelFour{
        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput fourthWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "PinWheel4", HIGH);


        public static void onButtonPress() throws InterruptedException{
            fourthWheel.toggle();
        }


    }

    public static void turnLeft() throws InterruptedException{
        WheelFour.fourthWheel.high();
        WheelThree.thirdWheel.high();

        WheelOne.firstWheel.low();
        WheelTwo.seccondWheel.low();
    }

    public static void turnRight() throws InterruptedException{
        WheelOne.firstWheel.high();
        WheelTwo.seccondWheel.high();

        WheelFour.fourthWheel.low();
        WheelThree.thirdWheel.low();
    }

    public static void forward() throws InterruptedException{
        /*if(WheelOne.gpio.isLow()){
            WheelOne.onButtonPress();
        }

        if(WheelTwo.gpio.isLow()){
            WheelTwo.onButtonPress();
        }

        if(WheelThree.gpio.isLow()){
            WheelThree.onButtonPress();
        }

        if(WheelFour.gpio.isLow()){
            WheelFour.onButtonPress();
        }*/

        WheelOne.firstWheel.high();
        WheelTwo.seccondWheel.high();
        WheelThree.thirdWheel.high();
        WheelFour.fourthWheel.high();
    }

    public static void stop() throws InterruptedException{

        if(WheelOne.firstWheel.isHigh()){
            WheelOne.firstWheel.toggle();
        }

        if(WheelTwo.seccondWheel.isHigh()){
            WheelTwo.seccondWheel.toggle();
        }

        if(WheelThree.thirdWheel.isHigh()){
            WheelThree.thirdWheel.toggle();
        }

        if(WheelFour.fourthWheel.isHigh()){
            WheelFour.fourthWheel.toggle();
        }

       /* WheelOne.firstWheel.low();
        WheelTwo.seccondWheel.low();
        WheelThree.thirdWheel.low();
        WheelFour.fourthWheel.low();*/
    }


}

