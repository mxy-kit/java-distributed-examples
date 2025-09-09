package car.command;

import car.Car;
import car.CarServer;

public class RDCommand extends MoveCommand{
    public RDCommand(Car car, int count){
        super(car, count, CarServer.Direction.RD);
    }
}
