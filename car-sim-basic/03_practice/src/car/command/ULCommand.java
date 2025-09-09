package car.command;

import car.Car;
import car.CarServer;

public class ULCommand extends MoveCommand{

    public ULCommand(Car car, int count){
        super(car, count, CarServer.Direction.UL);
    }

}
