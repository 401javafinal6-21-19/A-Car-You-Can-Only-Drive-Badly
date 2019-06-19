package BadDriving;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;


public class Car {
    final private GpioController gpio;
    final private GpioPinDigitalOutput thrustPin26;
    final private GpioPinDigitalOutput thrustPin27;
    final private GpioPinDigitalOutput thrustPin28;
    final private GpioPinDigitalOutput thrustPin29;

//    Example has a COMMAND_TIMEOUT = 300; here.

//    Button left = //add the id into here for the left button
//    Button right = //add the id for the right button here.
//    Button down = //add the id for the right button here.
//    Button up = //add the id for the up button here.


    public Car() {
        try {
            System.out.println("initializing Car object");

            gpio = GpioFactory.getInstance();

            thrustPin26 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "thrustPin26", PinState.LOW);
            thrustPin27 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "thrustPin27", PinState.LOW);
            thrustPin28 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "thrustPin28", PinState.LOW);
            thrustPin29 = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "thrustPin29", PinState.LOW);
        } catch (Exception e) {
            e.printStackTrace();
            throw new RuntimeException("Car was not initialized");
        }
    }


    public void steeringButtonDepressed() throws InterruptedException {
        Reciever r = new Reciever();
        switch (r.direction){
            case "forward":
                forward();
                break;

            case "stop":
                stop();
                break;

            case "left":
                left();
                break;

            case "right":
                right();
                break;

            default: stop();
                break;
        }
        //while (//whatever button is pushed or true or whatever) {
            //do the logic for that movement.
    }

    public void steeringButtonReleased() throws InterruptedException {
        Reciever r = new Reciever();
        switch (r.direction){
            case "forward release":
                forwardRelease();
                break;

            case "left release":
                leftRelease();
                break;

            case "right release":
                rightRelease();
                break;

            default: stop();
                break;
        }
    }

//  Everything below this line is within steeringButtonDepressed

    public void forward() throws InterruptedException {

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

        wheelOne.high();
        wheelTwo.high();
        wheelThree.high();
        wheelFour.high();
    }

    public void stop() throws InterruptedException {

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

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

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

        wheelOne.high();
        wheelOne.toggle();
        wheelTwo.high();
        wheelTwo.toggle();
        wheelThree.high();
        wheelFour.high();
    }

    public void right() throws InterruptedException {

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

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

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

        wheelOne.low();
        wheelTwo.low();
        wheelThree.low();
        wheelFour.low();
    }

    public void rightRelease() throws InterruptedException {

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

        wheelOne.low();
        wheelTwo.low();
        wheelThree.low();
        wheelFour.low();
    }

    public void leftRelease() throws InterruptedException {

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29);

        wheelOne.high();
        wheelOne.toggle();
        wheelTwo.high();
        wheelTwo.toggle();
        wheelThree.high();
        wheelFour.high();
    }

}
