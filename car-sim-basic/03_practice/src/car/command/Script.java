package car.command;

import car.FieldMatrix;

import java.util.ArrayList;
import java.util.List;

public class Script {
    List<Command> commands;

    public Script(){
        commands = new ArrayList<>();
    }

    public void add(Command command){
        commands.add(command);
    }

    
    public void execute(FieldMatrix fm){
        for(Command command : commands){
            command.execute(fm);
        }
    }
}
