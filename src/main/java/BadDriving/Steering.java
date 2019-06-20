package BadDriving;

import com.pi4j.io.gpio.*;

public class Steering {

    final  GpioController gpio;
    final  GpioPinDigitalOutput wheelOne;
    final  GpioPinDigitalOutput wheelTwo;
    final  GpioPinDigitalOutput wheelThree;
    final  GpioPinDigitalOutput wheelFour;

    public Steering() {

        try {
            System.out.println("initializing Car object");

            gpio = GpioFactory.getInstance();

            wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "thrustPin26", PinState.LOW);
            wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "wheelTwo", PinState.LOW);
            wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "wheelThree", PinState.LOW);
            wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "wheelFour", PinState.LOW);


        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Car was not initialized");
        }
    }

    public void steeringButtonDepressed(String direction){
        Car r = new Car();
        switch (direction) {
            case "forward":
                try {
                   forward();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("direction in case forward " + r.direction);
                break;

            case "stop":
                try {
                    stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("direction in case stop " + r.direction);
                break;

            case "left":
                try {
                    left();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("direction in case left " + r.direction);
                break;

            case "right":
                try {
                  right();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("direction in case right " + r.direction);
                break;

            default:
                try {
                   stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("direction in case stop " + r.direction);
                break;

        }

    }

    public void steeringButtonReleased(String direction){
        Car r = new Car();
        switch (direction){
            case "forward release":
                try {
                  forwardRelease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case "left release":
                try {
                   leftRelease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            case "right release":
                try {
                    rightRelease();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;

            default:
                try {
                    stop();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                break;
        }
    }


    public void forward() throws InterruptedException {

        highWrap(wheelOne);
        highWrap(wheelTwo);
        highWrap(wheelThree);
        highWrap(wheelFour);
    }

    public void stop() throws InterruptedException {

        highWrap(wheelOne);
        toggleWrap(wheelOne);
        highWrap(wheelTwo);
        toggleWrap(wheelTwo);
        highWrap(wheelThree);
        toggleWrap(wheelThree);
        highWrap(wheelFour);
        toggleWrap(wheelFour);
    }

    public void left() throws InterruptedException {

        highWrap(wheelOne);
        toggleWrap(wheelOne);
        highWrap(wheelTwo);
        toggleWrap(wheelTwo);
        highWrap(wheelThree);
        highWrap(wheelFour);
    }

    public void right() throws InterruptedException {

        highWrap(wheelOne);
        highWrap(wheelTwo);
        highWrap(wheelThree);
        toggleWrap(wheelThree);
        highWrap(wheelFour);
        toggleWrap(wheelFour);
    }
//  Everything above this line is within steeringButtonDepressed

//  Everything below this line is within steeringButtonReleased

    public void forwardRelease() throws InterruptedException {

        lowWrap(wheelOne);
        lowWrap(wheelTwo);
        lowWrap(wheelThree);
        lowWrap(wheelFour);
    }

    public void rightRelease() throws InterruptedException {


        lowWrap(wheelOne);
        lowWrap(wheelTwo);
        lowWrap(wheelThree);
        lowWrap(wheelFour);
    }

    public void leftRelease() throws InterruptedException {

        highWrap(wheelOne);
        toggleWrap(wheelOne);
        highWrap(wheelTwo);
        toggleWrap(wheelTwo);
        highWrap(wheelThree);
        highWrap(wheelFour);
    }

//Wrappers to abstract the j4pi library for testing and modularity

    public void highWrap(GpioPinDigitalOutput wheel) throws InterruptedException{
        wheel.high();
    }

    public void lowWrap(GpioPinDigitalOutput wheel) throws InterruptedException{
        wheel.low();
    }

    public void toggleWrap(GpioPinDigitalOutput wheel) throws InterruptedException{
        wheel.toggle();
    }

//overloaded wrappers for testing

    public void highWrap(GpioTest wheel) throws InterruptedException{
        wheel.high();
    }

    public void lowWrap(GpioTest wheel) throws InterruptedException{
        wheel.low();
    }

    public void toggleWrap(GpioTest wheel) throws InterruptedException{
        wheel.toggle();
    }
}
