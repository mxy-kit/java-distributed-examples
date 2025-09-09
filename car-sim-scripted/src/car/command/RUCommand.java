package car.command;

import car.Car;
import car.CarServer;

public class RUCommand extends MoveCommand{
    public RUCommand(Car car, int count){
        super(car, count, CarServer.Direction.RU);
    }
}
