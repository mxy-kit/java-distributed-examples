package net.rmi;


import car.BasicCarServer;
import car.Car;
import car.CarPainter;
import car.FieldMatrix;
import car.command.Command;
import net.command.SerializableCommand;

import java.lang.reflect.Array;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.Vector;

public class CarServer implements RemoteCarServer {
    public static final int port = 8080;
    public static final String name = "RMICarServer";

    public static FieldMatrix fm;
    public static CarPainter p;
    public static BasicCarServer carServer;
    public static ArrayList<Car> cars;


    public CarServer() {
    }


    public static void main(String[] args) throws Exception {
        fm = new FieldMatrix(10,10);
        CarPainter p = new CarPainter(fm);
        carServer = new BasicCarServer(fm, p);
        cars = new ArrayList<Car>();
        CarServer server = new CarServer();
        // 以上是初始化Car相关的东西，下面注册RMI服务
        Registry registry = LocateRegistry.createRegistry(8080); // 绑定端口
        RemoteCarServer obj = (RemoteCarServer) UnicastRemoteObject.exportObject(server, 0); // 绑定地址
        registry.bind("RMICarServer", obj);
        System.out.println("Server started on port: 8080");
    }

    @Override
    public <T> T executeCommand(SerializableCommand command) throws RemoteException {
        // 判断命令是创建车辆还是让车移动
        if (command.commandName.equals("CREATECAR")) {
            // 创建车辆并返回车的idx
            cars.add(carServer.createCar());
            return (T)(Integer)(cars.size() - 1);
        } else {
            // 移动对应的idx的车辆，并返回移动结果。
            Car car = cars.get(command.carIndex);
            Command command1 = Command.createCommand(car,command.commandName + " " +command.commandparameter);
            Boolean res = (Boolean) command1.execute();
            return (T)res;
        }
    }
}
