package objects;

public class Stone extends GameObject {

    public Stone(int rowIndex, int colIndex) {
        super(rowIndex, colIndex, 2, 2);
    }

    public char[][] draw()
    {
      //allocate a bitmap for the stone
      return super.draw();
    }
}
