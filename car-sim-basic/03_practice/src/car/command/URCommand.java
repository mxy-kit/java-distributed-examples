package car.command;

import car.Car;
import car.CarServer;
import car.FieldMatrix;

public class URCommand extends MoveCommand{

    public URCommand(Car car, int count){
        super(car, count, CarServer.Direction.UR);
    }
}
