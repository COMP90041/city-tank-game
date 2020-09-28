package objects;

import graphics.Color;

public class Stone extends GameObject {

    public Stone(int rowIndex, int colIndex) {
        super(rowIndex, colIndex, 2, 2, Color.ANSI_YELLOW);
    }

    public char[][] draw()
    {
      //allocate a bitmap for the stone
      return super.draw();
    }
}
