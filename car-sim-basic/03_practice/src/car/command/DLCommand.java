package car.command;

import car.Car;
import car.CarServer;

public class DLCommand extends MoveCommand{

    public DLCommand(Car car, int count){
        super(car, count, CarServer.Direction.DL);
    }

}
