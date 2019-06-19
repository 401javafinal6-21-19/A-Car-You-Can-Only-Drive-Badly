/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package BadDriving;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.RaspiPin;
import static com.pi4j.io.gpio.PinState.LOW;
import java.lang.Thread;



public class App{

    public static void main(String[] args) throws InterruptedException {
        final GpioController gpio = GpioFactory.getInstance();


         new Thread(new Runnable() {
             @Override
             public void run() {
                 Reciever r = new Reciever();
                 r.getDB();
             }
         }).start();

         Car hotRod = new Car();

         hotRod.steeringButtonDepressed();


//
//            Thread.sleep(30000);
//
//            turnLeftButtonDown();
//
//            Thread.sleep(5000);
//
//            forwardButtonUp();
//
//            Thread.sleep(5000);
//
//            turnRightButtonDown();
//
//            Thread.sleep(5000);
//
//            forwardButtonUp();
//
//            Thread.sleep(5000);
//
//            forwardButtonDown();
//
//            Thread.sleep(5000);
//
//            forwardButtonUp();
//
//
//            Thread.sleep(600);
//
//            stop();
//
//          gpio.shutdown();
//
//            Thread.sleep(5000);
//
//            stop();
//
//            Thread.sleep(10000);
//
//            WheelOne.firstWheel.setState(false);
//            WheelTwo.seccondWheel.setState(false);
//            WheelThree.thirdWheel.setState(false);
//
//           WheelFour.fourthWheel.setState(false);
//
//           WheelFour.fourthWheel.setState(false);
//    }
//
//
//    public static class WheelOne{
//        final static GpioController gpio = GpioFactory.getInstance();
//        final static GpioPinDigitalOutput firstWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "PinWheel1", LOW);
//
//        public static void onButtonPress() throws InterruptedException{
//            firstWheel.toggle();
//
//        }
//
//
//    }

//    public static class WheelTwo{
//
//        final static GpioController gpio = GpioFactory.getInstance();
//        final static GpioPinDigitalOutput seccondWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "PinWheel2", LOW);
//
//        public static void onButtonPress(){
//
//            seccondWheel.toggle();
//        }
//
//    }
//
//    public static class WheelThree{
//        final static GpioController gpio = GpioFactory.getInstance();
//        final static GpioPinDigitalOutput thirdWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "PinWheel3", LOW);
//
//        public static void onButtonPress() throws InterruptedException{
//
//            thirdWheel.toggle();
//
//        }
//
//    }
//
//    public static class WheelFour{
//        final static GpioController gpio = GpioFactory.getInstance();
//        final static GpioPinDigitalOutput fourthWheel = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "PinWheel4", LOW);
//
//
//        public static void onButtonPress() throws InterruptedException{
//            fourthWheel.toggle();
//        }
//
//    }
//
//    public static void turnLeftButtonDown() throws InterruptedException{
//        WheelFour.fourthWheel.high();
//        WheelThree.thirdWheel.high();
//
//        WheelOne.firstWheel.low();
//        WheelTwo.seccondWheel.low();
//    }

    /*public static void turnLeftButtonUp() throws InterruptedException{
        WheelFour.fourthWheel.low();
        WheelThree.thirdWheel.low();
    }*/

//    public static void turnRightButtonDown() throws InterruptedException{
//        WheelOne.firstWheel.high();
//        WheelTwo.seccondWheel.high();
//
//        WheelFour.fourthWheel.low();
//        WheelThree.thirdWheel.low();
//    }

  /*  public static void turnRightButtonUp() throws InterruptedException{
        WheelOne.firstWheel.low();
        WheelTwo.seccondWheel.low();
    }*/

//    public static void forwardButtonDown() throws InterruptedException{
//        WheelOne.firstWheel.high();
//        WheelTwo.seccondWheel.high();
//        WheelFour.fourthWheel.high();
//        WheelThree.thirdWheel.high();
//
//    }
//
//    public static void forwardButtonUp() throws InterruptedException{
//        WheelOne.firstWheel.low();
//        WheelTwo.seccondWheel.low();
//        WheelThree.thirdWheel.low();
//        WheelFour.fourthWheel.low();
//    }


//    public static void stop() throws InterruptedException{

//        WheelOne.firstWheel.high();
//        WheelOne.firstWheel.toggle();
//
//        WheelTwo.seccondWheel.high();
//        WheelTwo.seccondWheel.toggle();
//
//        WheelThree.thirdWheel.high();
//        WheelThree.thirdWheel.toggle();
//
//        WheelFour.fourthWheel.high();
//        WheelFour.fourthWheel.toggle();
        /*System.out.println("just hit the stop method");
        WheelOne.firstWheel.low();
        WheelTwo.seccondWheel.low();
        WheelThree.thirdWheel.low();
        WheelFour.fourthWheel.low();*/
//
//        WheelOne.firstWheel.setState(false);
//        WheelTwo.seccondWheel.setState(false);
//        WheelThree.thirdWheel.setState(false);
//        WheelFour.fourthWheel.setState(false);
//
//    }


}

