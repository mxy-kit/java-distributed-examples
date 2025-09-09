package car;

import car.command.*;

import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * @author : Alex
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        FieldMatrix fm = new FieldMatrix(10,12);
        CarPainter p = new CarPainter(fm);
        BasicCarServer carServer = new BasicCarServer(fm, p);
        Car car = carServer.createCar();

        car.setColor(Color.YELLOW);
        car.setName("Simp");
        /*car.moveTo(CarServer.Direction.DR, fm);*/
        /*car.moveTo(CarServer.Direction.UR, fm);*/
        /*new SpeedCommand(car,1000).execute(fm);*/
        /*car.moveTo(CarServer.Direction.DL, fm);*/
        /*car.moveTo(CarServer.Direction.UL, fm);*/

        ColorCommand ccommand = new ColorCommand(car, Color.GREEN);
        ccommand.execute(fm);
        new NameCommand(car, "Class").execute(fm);
        MoveCommand command;
        command = new DownCommand(car, 2);
        command.execute(fm);
        command = new URCommand(car, 6);
        command.execute(fm);

        Script script = new Script();
        script.add(new ColorCommand(car, Color.BLUE));
        script.add(new NameCommand(car,"Queue"));
        script.add(new DownCommand(car, 300));
        script.add(new SpeedCommand(car, 1000));
        script.add(new RightCommand(car, 9));
        script.add(new SpeedCommand(car, 100));
        script.add(new UpCommand(car, 4));
        script.add(new LeftCommand(car, 6));
        script.add(new ColorCommand(car, Color.YELLOW));
        script.add(new ULCommand(car, 4));
        script.add(new ColorCommand(car, Color.PINK));
        script.add(new DLCommand(car, 4));
        script.add(new ColorCommand(car, Color.BLACK));
        script.add(new DRCommand(car, 4));
        script.execute(fm);

    }
}
