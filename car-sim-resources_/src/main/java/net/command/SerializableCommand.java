package net.command;

import java.io.Serializable;

/**
 * @author : Alex
 * @created : 23.03.2021, вторник
 **/
public class SerializableCommand implements Serializable {
    public final int carIndex; // carpannel中某一辆车的Idx
    public final String commandName; // 命令名称
    public final String commandparameter; // 命令参数

    public SerializableCommand(int carIndex, String commandName, String commandparameter){
        this.carIndex = carIndex;
        this.commandName = commandName;
        this.commandparameter = commandparameter;
    }
}
