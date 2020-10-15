package objects;

import graphics.Color;

public class Brick extends GameObject {

    public static final char objectSymbol = '#';

    public Brick(int rowPos, int colPos) {
      super(rowPos, colPos, 2, 2, Color.ANSI_WHITE);
      drawingSymbol = objectSymbol;  
    }

    public char[][] draw()
    {
      //allocate a bitmap for the stone
      return super.draw();
    }
}
