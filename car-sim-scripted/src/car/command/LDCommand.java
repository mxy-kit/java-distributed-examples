package car.command;

import car.Car;
import car.CarServer;

public class LDCommand extends MoveCommand{
    public LDCommand(Car car, int count){
        super(car, count, CarServer.Direction.LD);
    }
}
