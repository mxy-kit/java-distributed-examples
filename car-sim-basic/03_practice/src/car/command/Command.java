package car.command;

import car.FieldMatrix;

public interface Command {
    boolean execute(FieldMatrix fm);
}
