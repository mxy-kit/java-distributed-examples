// 定义客户端的包
package client;

// 导入必要的类和包
import car.webservice.Direction;
import car.webservice.Server;
import car.webservice.ServerService;

import java.net.MalformedURLException;
import java.net.URL;
import java.util.Random;

// 客户端类
public class Client {
    public static void main(String[] args) throws Exception {
        // 定义一个实现了Runnable接口的内部类ServerCar，用于模拟服务端的汽车
        class ServerCar implements Runnable {
            // 可选颜色数组
            String[] color = {"CYAN", "ORANGE", "BLACK", "MAGENTA"};

            @Override
            public void run() {
                // Web服务的URL
                String url = "http://127.0.0.1:8080/CarServer?wsdl";
                ServerService service = null;

                try {
                    // 创建Web服务的客户端对象
                    service = new ServerService(new URL(url));
                } catch (MalformedURLException e) {
                    // 处理URL异常
                    throw new RuntimeException(e);
                }

                // 获取服务端的端口
                Server serverPort = service.getServerPort();

                // 在服务端创建一辆汽车
                int carIndex = serverPort.createCar();

                // 生成一个随机数用于给汽车命名
                Random random = new Random();
                Integer n = random.nextInt(100);

                // 设置汽车的名称和颜色
                serverPort.setCarName(carIndex, "car" + n.toString());
                serverPort.setCarColor(carIndex, color[random.nextInt(4)]);

                // 随机选择汽车移动的方向，并不断地移动
                Direction direction = null;
                while (true) {
                    int dir = random.nextInt(4);
                    switch (dir) {
                        case 0:
                            direction = Direction.;
                            break;
                        case 1:
                            direction = Direction.DOWN;
                            break;
                        case 2:
                            direction = Direction.LEFT;
                            break;
                        case 3:
                            direction = Direction.RIGHT;
                            break;
                    }

                    // 移动汽车，直到成功为止
                    boolean res;
                    do {
                        res = serverPort.moveCarTo(carIndex, direction); // serverport是服务端，res是服务端执行命令后返回的结果，也就是这条命令有没有撞墙
                    } while (res);
                }
            }
        }

        // 创建并启动三个线程，每个线程模拟一个服务端的汽车
        new Thread(new ServerCar()).start();
        new Thread(new ServerCar()).start();
        new Thread(new ServerCar()).start();
    }
}
