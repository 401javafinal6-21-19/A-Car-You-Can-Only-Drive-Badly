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

        WheelOne.onButtonPress();
        Thread.sleep(400);


       /* WheelTwo.onButtonPress();
        Thread.sleep(400);
        WheelTwo.Stop();

        WheelThree.onButtonPress();
        Thread.sleep(400);
        WheelThree.Stop();

        WheelFour.onButtonPress();
        Thread.sleep(400);
        WheelFour.Stop();

        gpio.shutdown();
*/

    }


    public static class WheelOne{
        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput firstWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "PinWheel1", HIGH);

        public static void onButtonPress() throws InterruptedException{
            firstWheel.high();
            Thread.sleep(400);
            firstWheel.low();
            gpio.shutdown();

        }

        public static void Stop() throws InterruptedException{



        }

    }

    public static class WheelTwo{

        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput seccondWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "PinWheel2", HIGH);

        public static void onButtonPress(){

            seccondWheel.high();
        }


        public static void Stop() throws InterruptedException{

            seccondWheel.low();

        }
    }

    public static class WheelThree{
        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput thirdWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "PinWheel3", HIGH);

        public static void onButtonPress() throws InterruptedException{

            thirdWheel.high();

        }

        public static void Stop() throws InterruptedException{

            thirdWheel.low();

        }

    }

    public static class WheelFour{
        final static GpioController gpio = GpioFactory.getInstance();
        final static GpioPinDigitalOutput fourthWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "PinWheel4", HIGH);


        public static void onButtonPress() throws InterruptedException{

            fourthWheel.high();
        }

        public static void Stop() throws InterruptedException{

            fourthWheel.low();

        }

    }
}

