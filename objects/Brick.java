package objects;

import graphics.Color;

public class Brick extends GameObject {

    public Brick(int rowIndex, int colIndex) {
        super(rowIndex, colIndex, 2, 2, Color.ANSI_WHITE);
    }

    public char[][] draw()
    {
      //allocate a bitmap for the stone
      return super.draw();
    }
}
