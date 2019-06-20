package BadDriving;

public class SteeringMock {

    GpioTest wheel1 = new GpioTest();
    GpioTest wheel2 = new GpioTest();
    GpioTest wheel3 = new GpioTest();
    GpioTest wheel4 = new GpioTest();


    public void steeringButtonDepressed(String direction){

        switch (direction) {
            case "forward":

                forward(wheel1, wheel2, wheel3, wheel4);

                break;

            case "stop":

                stop(wheel1, wheel2, wheel3, wheel4);

                break;

            case "left":

                left(wheel1, wheel2, wheel3, wheel4);

                break;

            case "right":

                right(wheel1, wheel2, wheel3, wheel4);

                break;

            default:

                stop(wheel1, wheel2, wheel3, wheel4);

                break;

        }

    }


    public void left(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4) {

        highWrap(wheel1);
        toggleWrap(wheel1);
        highWrap(wheel2);
        toggleWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
    }

    public void right(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4) {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        toggleWrap(wheel3);
        highWrap(wheel4);
        toggleWrap(wheel4);
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

    public void forward(GpioTest wheel1, GpioTest wheel2, GpioTest wheel3, GpioTest wheel4)  {

        highWrap(wheel1);
        highWrap(wheel2);
        highWrap(wheel3);
        highWrap(wheel4);
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
