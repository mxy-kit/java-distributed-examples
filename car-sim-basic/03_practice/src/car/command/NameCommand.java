package car.command;

import car.Car;
import car.FieldMatrix;

public class NameCommand implements Command{
    private final Car car;
    private final String name;

    public NameCommand(Car car, String name){
        this.car = car;
        this.name= name;
    }

    @Override
    public boolean execute(FieldMatrix fm){
        car.setName(name);
        return true;
    }

}
