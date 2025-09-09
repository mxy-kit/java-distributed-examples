package car.command;

import car.Car;
import car.CarServer;
import car.FieldMatrix;

public class DRCommand extends MoveCommand{

    public DRCommand(Car car, int count){
        super(car, count, CarServer.Direction.DR);
    }
}
