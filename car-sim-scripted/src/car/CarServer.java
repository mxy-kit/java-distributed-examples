package car;

public interface CarServer {
    enum Direction{
        UP,DOWN,LEFT,RIGHT,LU,LD,RU,RD
    }

    Car createCar();
    void destroyCar(Car car);
    boolean moveCarTo(Car car, Direction direction);

}
