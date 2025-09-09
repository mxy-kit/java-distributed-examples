package car.command;

import car.Car;
import car.CarServer;

public class LUCommand extends MoveCommand{
    public LUCommand(Car car, int count){
        super(car, count, CarServer.Direction.LU);
    }
}
