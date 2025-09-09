package car;

public class Position {
    public final int row;
    public final int col;
    public Position(int row, int col){
        this.row = row; this.col = col;
    };

    public Position move(CarServer.Direction direction) {
        switch(direction){
            case UP: return new Position(row - 1,col);
            case DOWN: return new Position(row + 1,col);
            case LEFT: return new Position(row ,col - 1);
            case RIGHT: return new Position(row ,col + 1);
            case LU:return new Position(row - 1,col - 1);
            case LD:return new Position(row + 1,col - 1);
            case RU:return new Position(row - 1,col + 1);
            case RD:return new Position(row + 1,col + 1);
            default:throw new RuntimeException("Position move error");
        }
    }
    @Override
    public String toString(){
        return "[Position: col="+col+" row="+row+"]";
    }
}
