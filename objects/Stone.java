package objects;

import graphics.Color;

public class Stone extends GameObject {

    public static final char objectSymbol = 0x250C; //0x250C is the Unicode ID of the character 218 in the ASCII table

    public Stone(int rowPos, int colPos) {
        super(rowPos, colPos, 2, 2, Color.ANSI_YELLOW);
        drawingSymbol = objectSymbol;
    }

    public char[][] draw()
    {
      //allocate a bitmap for the stone
      return super.draw();
    }
}
