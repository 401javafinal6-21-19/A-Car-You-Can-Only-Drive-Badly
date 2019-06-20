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

                   forward(wheelOne, wheelTwo, wheelThree, wheelFour);

                System.out.println("direction in case forward " + r.direction);
                break;

            case "stop":

                    stop(wheelOne, wheelTwo, wheelThree, wheelFour);

                System.out.println("direction in case stop " + r.direction);
                break;

            case "left":

                    left(wheelOne, wheelTwo, wheelThree, wheelFour);

                System.out.println("direction in case left " + r.direction);
                break;

            case "right":

                  right(wheelOne, wheelTwo, wheelThree, wheelFour);

                System.out.println("direction in case right " + r.direction);
                break;

            default:

                   stop(wheelOne, wheelTwo, wheelThree, wheelFour);

                System.out.println("direction in case stop " + r.direction);
                break;

        }

    }


    public void forward(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)  {
        highWrap(wheel1);
        toggleWrap(wheel1);
        highWrap(wheel2);
        toggleWrap(wheel2);
        highWrap(wheel3);
        toggleWrap(wheel3);
        highWrap(wheel4);
        toggleWrap(wheel4);

    }

    public void forward(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4)  {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }

    public void stop(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)  {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }

    public void stop(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4)  {

        highWrap(wheel1);
        toggleWrap(wheel1);
        highWrap(wheel2);
        toggleWrap(wheel2);
        highWrap(wheel3);
        toggleWrap(wheel3);
        highWrap(wheel4);
        toggleWrap(wheel4);
    }

    public void left(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4) {

        highWrap(wheel1);
        toggleWrap(wheel1);
        highWrap(wheel2);
        toggleWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }
    public void left(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4) {

        highWrap(wheel1);
        toggleWrap(wheel1);
        highWrap(wheel2);
        toggleWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }
    public void right(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4) {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        toggleWrap(wheel3);
        highWrap(wheel4);
        toggleWrap(wheel4);
    }

    public void right(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4) {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        toggleWrap(wheel3);
        highWrap(wheel4);
        toggleWrap(wheel4);
    }
//Wrappers to abstract the j4pi library for testing and modularity

    public void highWrap(GpioPinDigitalOutput wheel){
        wheel.high();
    }

    public void lowWrap(GpioPinDigitalOutput wheel) {
        wheel.low();
    }

    public void toggleWrap(GpioPinDigitalOutput wheel){


            wheel.toggle();

    }

//overloaded wrappers for testing

    public void highWrap(GpioTest wheel){
        wheel.high();
    }

    public void lowWrap(GpioTest wheel){
        wheel.low();
    }

    public void toggleWrap(GpioTest wheel){
        wheel.toggle();
    }
}
