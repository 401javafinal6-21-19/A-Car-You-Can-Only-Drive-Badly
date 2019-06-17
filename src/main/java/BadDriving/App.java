/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package BadDriving;


import com.pi4j.io.gpio.*;
import com.pi4j.io.*;

public class App {


    public static void main(String[] args) throws InterruptedException {

        App.wheelThree();

        App.wheelFour();

        System.out.println("Done");
    }


    public static void wheelOne()throws InterruptedException{
        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput firstWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "PinWheel1", PinState.HIGH);

        System.out.println("First Switch");


    }

    public static void wheelTwo() throws InterruptedException{

        final GpioController gpio = GpioFactory.getInstance();
        final GpioPinDigitalOutput seccondWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "PinWheel2", PinState.HIGH);

        System.out.println("Seccond Switch");

        seccondWheel.pulse(60000, true);


    }

    public static void wheelThree() throws InterruptedException{
        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput thirdWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "PinWheel3", PinState.HIGH);

        System.out.println("Third Switch");

        thirdWheel.pulse(60000, true);


    }

    public static void wheelFour() throws InterruptedException{
        final GpioController gpio = GpioFactory.getInstance();

        final GpioPinDigitalOutput fourthWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "PinWheel4", PinState.HIGH);

        System.out.println("Fourth Switch");

        fourthWheel.pulse(60000, true);


    }
}


