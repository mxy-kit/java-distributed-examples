package net.rmi;


import net.command.SerializableCommand;

import java.io.Serializable;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Random;

public class RemoteCarClient {
    public static final int port = 8080;
    public static final String host = "127.0.0.1";

    public static String[] directions = {"UP","DOWN","LEFT","RIGHT"};
    public RemoteCarClient() {
    }

    public static void main(String[] args) throws Exception {
        Registry registry = LocateRegistry.getRegistry("127.0.0.1", 8080); // 去127.0.0.1这个ip的8080端口
        System.out.println(String.format("Client connected to registry on host %s and port %d", "127.0.0.1", 8080));
        RemoteCarServer server = (RemoteCarServer)registry.lookup("RMICarServer");
        System.out.println("server = " + String.valueOf(server));
        // 以上代码是寻找RMI服务端
        SerializableCommand command = new SerializableCommand(-1,"CREATECAR",""); //调用服务端的CREATECAR命令
        int carIdx = server.executeCommand(command); // 这个命令返回的是CAR pannel中新建的这个car的idx
        Random random = new Random();
        // 循环让车随机移动，直到碰到墙。随机另一个方向
            while (true) {
                int dir = random.nextInt(4);
                command = new SerializableCommand(carIdx,directions[dir],"1");
            if (!((Boolean) server.executeCommand(command))){
                int newDir;
                do {
                    newDir = random.nextInt(4);
                } while (newDir == dir);
                dir = newDir;
            }
        }
    }
}
