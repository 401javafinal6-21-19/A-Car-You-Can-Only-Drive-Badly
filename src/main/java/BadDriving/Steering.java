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

        wheelOne.high();
        wheelTwo.high();
        wheelThree.high();
        wheelFour.high();
    }

    public void stop() throws InterruptedException {

        wheelOne.high();
        wheelOne.toggle();
        wheelTwo.high();
        wheelTwo.toggle();
        wheelThree.high();
        wheelThree.toggle();
        wheelFour.high();
        wheelFour.toggle();
    }

    public void left() throws InterruptedException {

        wheelOne.high();
        wheelOne.toggle();
        wheelTwo.high();
        wheelTwo.toggle();
        wheelThree.high();
        wheelFour.high();
    }

    public void right() throws InterruptedException {

        wheelOne.high();
        wheelTwo.high();
        wheelThree.high();
        wheelThree.toggle();
        wheelFour.high();
        wheelFour.toggle();
    }
//  Everything above this line is within steeringButtonDepressed

//  Everything below this line is within steeringButtonReleased

    public void forwardRelease() throws InterruptedException {

        wheelOne.low();
        wheelTwo.low();
        wheelThree.low();
        wheelFour.low();
    }

    public void rightRelease() throws InterruptedException {

        wheelOne.low();
        wheelTwo.low();
        wheelThree.low();
        wheelFour.low();
    }

    public void leftRelease() throws InterruptedException {

        wheelOne.high();
        wheelOne.toggle();
        wheelTwo.high();
        wheelTwo.toggle();
        wheelThree.high();
        wheelFour.high();
    }
}
