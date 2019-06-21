package BadDriving;

import com.pi4j.io.gpio.*;

public class Steering {

    final  GpioController gpio;
    final  GpioPinDigitalOutput wheelOne;
    final  GpioPinDigitalOutput wheelTwo;
    final  GpioPinDigitalOutput wheelThree;
    final  GpioPinDigitalOutput wheelFour;

    /**
     * Steering()
     * This class governs the basic steering operations of the car.
     *
     * public void steeringButtonDepressed(String direction)
     *
     * public void forward(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)
     *
     * public void stop(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)
     *
     * public void left(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)
     *
     * public void right(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)
     *
     * public void highWrap(GpioPinDigitalOutput wheel)
     *
     * public void lowWrap(GpioPinDigitalOutput wheel)
     *
     * public void toggleWrap(GpioPinDigitalOutput wheel)
     */
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

    /**
     *
     * @param direction - a String, when it is called later this comes from firebase and represents the strinigified JSON object
     *                  that came back from firebase.
     *
     *  This switch case takes in the direction string and when the case matches, it calls one of the direction functions, enumerated below.
     *
     *  The default case is stop, as the car needed a safe failure sate.
     */

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


    /**
     *
     * @param wheel1 - GpioPinDigitalOutput 26
     * @param wheel2 - GpioPinDigitalOutput 27
     * @param wheel3 - GpioPinDigitalOutput 28
     * @param wheel4 - GpioPinDigitalOutput 29
     *
     * Forward sets the state of the GPIO pins to open using the wrapper functions highWrap and toggleWrap below so that the pins are in the correct state for going forward.
     */

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

    /**
     *
     * @param wheel1 - GpioPinDigitalOutput 26
     * @param wheel2 - GpioPinDigitalOutput 27
     * @param wheel3 - GpioPinDigitalOutput 28
     * @param wheel4 - GpioPinDigitalOutput 29
     *
     * Stop sets the state of the GPIO pins to off using the wrapper functions highWrap below so that the pins are in the correct state for stopping.
     */

    public void stop(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4)  {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }

    /**
     *
     * @param wheel1 - GpioPinDigitalOutput 26
     * @param wheel2 - GpioPinDigitalOutput 27
     * @param wheel3 - GpioPinDigitalOutput 28
     * @param wheel4 - GpioPinDigitalOutput 29
     *
     * Left sets the state of the GPIO pins to open using the wrapper functions highWrap and toggleWrap below so that the pins are in the correct state for going left.
     *
     */

    public void left(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4) {

        highWrap(wheel1);
        toggleWrap(wheel1);
        highWrap(wheel2);
        toggleWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }

    /**
     *
     * @param wheel1 - GpioPinDigitalOutput 26
     * @param wheel2 - GpioPinDigitalOutput 27
     * @param wheel3 - GpioPinDigitalOutput 28
     * @param wheel4 - GpioPinDigitalOutput 29
     *
     * Right sets the state of the GPIO pins to open using the wrapper functions highWrap and toggleWrap below so that the pins are in the correct state for going right.
     *
     */

    public void right(GpioPinDigitalOutput wheel1, GpioPinDigitalOutput wheel2, GpioPinDigitalOutput wheel3, GpioPinDigitalOutput wheel4) {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        toggleWrap(wheel3);
        highWrap(wheel4);
        toggleWrap(wheel4);
    }


//Wrappers to abstract the j4pi library for testing and modularity

    /**
     *
     * @param wheel - GpioPinDigitalOutput wheel
     *
     * this accesses the J4Pi method .high() and sets the given GPIO pin to high.
     *
     */

    public void highWrap(GpioPinDigitalOutput wheel){
        wheel.high();
    }

    /**
     *
     * @param wheel - GpioPinDigitalOutput wheel
     *
     * this accesses the J4Pi method .low() and sets the given GPIO pin to low.
     *
     */
    public void lowWrap(GpioPinDigitalOutput wheel) {
        wheel.low();
    }

    /**
     *
     * @param wheel - GpioPinDigitalOutput wheel
     *
     *  this accesses the J4Pi method .toggle() and sets the given GPIO pin to the opposite of what it had previously been.             
     */

    public void toggleWrap(GpioPinDigitalOutput wheel){


            wheel.toggle();

    }


}
