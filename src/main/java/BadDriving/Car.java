package BadDriving;

import com.pi4j.io.gpio.GpioController;
import com.pi4j.io.gpio.GpioFactory;
import com.pi4j.io.gpio.GpioPin;
import com.pi4j.io.gpio.GpioPinDigital;
import com.pi4j.io.gpio.GpioPinDigitalInput;
import com.pi4j.io.gpio.GpioPinDigitalOutput;
import com.pi4j.io.gpio.PinState;
import com.pi4j.io.gpio.RaspiPin;
import static com.sun.nio.file.SensitivityWatchEventModifier.HIGH;


public class Car {
    static final private GpioController gpio;
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
//  Commands when buttons are pressed down
    public enum SteeringCommandsButtonDown {
        STOP, TurnLeftButtonDown, TurnRightButtonDown, ForwardButtonDown
    }
//  Commands when buttons are released
    public enum SteeringCommandsButtonReleased {
        TurnLeftButtonReleased, TurnRightButtonReleased, ForwardButtonReleased
    }

    public void steering(SteeringCommandsButtonDown cmd) {
//        need to figure out onClick of button or button held down do the things above.
        Reciever r = new Reciever();
        switch (r.direction){
            case "forward":
                forward();

                break;
            case "stop":

                break;
            case "left":

                break;
            case "right":

                break;
           default:

                break;
        }
        //while (//whatever button is pushed or true or whatever) {
            //do the logic for that movement.
    }
//    Might need to to this for each  movement direction

    public void forward() throws InterruptedException {

        GpioPinDigitalOutput wheelOne = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_26, "PinWheel1", HIGH);
        GpioPinDigitalOutput wheelTwo = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_27, "PinWheel2", HIGH);
        GpioPinDigitalOutput wheelThree = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_28, "PinWheel3", HIGH);
        GpioPinDigitalOutput wheelFour = gpio.provisionDigitalOutputPin(RaspiPin.GPIO_29, "PinWheel4", HIGH);


    }

}
