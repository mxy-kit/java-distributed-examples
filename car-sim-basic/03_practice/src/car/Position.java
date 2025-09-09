package car;

public class Position {
    public final int row;
    public final int col;
    public Position(int row, int col){
        this.row = row; this.col = col;
    };

    public Position move(CarServer.Direction direction, FieldMatrix fm) {
        switch(direction){
            case UP:
                if(row - 1 < 0)
                    return this; // 禁止移动，返回原来的位置
                else
                    return new Position(row - 1,col); // 可以移动，向上移动一格
            case DOWN:
                if(row + 1 > fm.rows - 1)
                    return this;
                else
                    return new Position(row + 1,col);
            case LEFT:
                if (col-1<0)
                    return this;
                else
                    return new Position(row ,col - 1);
            case RIGHT:
                if(col + 1 > fm.cols - 1)
                    return this;
                else
                    return new Position(row ,col + 1);
            case UL:
                if (col - 1 < 0 || row - 1 < 0)
                    return this;
                else
                    return  new Position(row - 1,col - 1);
            case DL:
                if (col - 1 < 0 || row + 1 > fm.rows - 1)
                    return this;
                else
                    return  new Position(row + 1,col - 1);
            case UR:
                if (col + 1 > fm.cols - 1 || row - 1 < 0)
                    return this;
                else
                    return  new Position(row - 1,col + 1);
            case DR:
                if (col + 1 > fm.cols - 1 || row + 1 > fm.rows - 1)
                    return this;
                else
                    return  new Position(row + 1,col + 1);
            default:throw new RuntimeException("Position move error");
        }
    }

    @Override
    public String toString(){
        return "[Position: col="+col+" row="+row+"]";
    }
}
