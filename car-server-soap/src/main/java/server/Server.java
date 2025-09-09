// 定义服务所在的包
package server;

// 导入必要的类和包
import car.*;
import car.util.ColorFactory;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.xml.ws.Endpoint;
import java.awt.*;
import java.io.InputStream;
import java.io.InputStreamReader;

// 将类标记为一个Web服务
@WebService
public class Server {
    // 声明一个对BasicCarServer的引用
    BasicCarServer carServer;

    // 定义Web服务的URL
    public static final String url = "http://0.0.0.0:8080/CarServer";

    // 构造函数，接受FieldMatrix和CarEventsListener作为参数
    protected Server(FieldMatrix fieldMatrix, CarEventsListener carEventsListener) {
        // 使用提供的FieldMatrix和CarEventsListener创建BasicCarServer
        carServer = BasicCarServer.createCarServer(fieldMatrix, carEventsListener);
    }

    // 定义一个Web方法，创建一辆汽车并返回其索引
    @WebMethod
    public int createCar() {
        // 使用carServer创建一辆汽车
        Car car = carServer.createCar();
        // 返回创建的汽车的索引
        return car.getIndex();
    }

    // 定义一个Web方法，销毁给定索引的汽车
    @WebMethod
    public void destroyCar(int carIndex) {
        // 使用索引获取汽车
        Car car = carServer.getCar(carIndex);
        // 使用carServer销毁汽车
        carServer.destroyCar(car);
    }

    // 定义一个Web方法，将汽车移动到指定方向
    @WebMethod
    public boolean moveCarTo(int carIndex, CarServer.Direction direction) {
        // 使用索引获取汽车
        Car car = carServer.getCar(carIndex);
        boolean ret = false; // 一开始定位false
        try {
            // 尝试将汽车移动到指定方向
            ret = car.moveTo(direction); // 如果执行成功了，也就是移动成功了，返回值就是true，这时候ret就是true了
        } catch (Exception e) {
            // 如果发生错误，打印异常堆栈信息
            e.printStackTrace();
            return false;
        }
        // 返回移动操作的结果
        return ret; // 也就是车子有没有撞到墙，撞到了就是false,没有撞到就是true
    }

    // 定义一个Web方法，设置汽车的名称
    @WebMethod
    public void setCarName(int carIndex, String name) {
        // 使用carServer设置汽车的名称
        carServer.getCar(carIndex).setName(name);
    }

    // 定义一个Web方法，设置汽车的颜色
    @WebMethod
    public void setCarColor(int carIndex, String color) {
        // 使用ColorFactory设置汽车的颜色
        carServer.getCar(carIndex).setColor(ColorFactory.getColor(color));
    }

    // 主方法，用于启动服务器
    public static void main(String[] args) {
        // 从文件加载场地矩阵
        InputStream is = CarPainter.class.getClassLoader().getResourceAsStream("Field10x10.txt");
        FieldMatrix fm = FieldMatrix.load(new InputStreamReader(is));

        // 使用加载的场地矩阵创建CarPainter
        CarPainter p = new CarPainter(fm);

        // 创建一个具有FieldMatrix和CarPainter的Server实例
        Server server = new Server(fm, p);

        // 将服务器作为Web服务发布到指定的URL
        Endpoint.publish(url, server);
    }
}
