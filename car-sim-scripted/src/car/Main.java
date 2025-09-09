package car;

import car.command.*;

import java.awt.*;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.util.Random;
import java.util.StringTokenizer;


/**
 * @author : Alex
 **/
public class Main {
    public static void main(String[] args) throws Exception{
        InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("field.txt"); // 读文件内容
        FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is)); // 将文件中的内容加载为地图
        //FieldMatrix fm = new FieldMatrix(10,10);
        CarPainter p = new CarPainter(fm);
        BasicCarServer carServer = new BasicCarServer(fm, p);
        Car car = carServer.createCar();



        is = CarPainter.class.getClassLoader().getResourceAsStream("script.txt");
        Script script = Script.load(new InputStreamReader(is), car);
        //script.add(new DownCommand(car, 6));
        script.execute();
    }
}
