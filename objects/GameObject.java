package objects;

public class GameObject {
    private int rowPos, colPos;
    private int width, height;
    private String color;

    public GameObject(int rowIndex, int colIndex, int width, int height, String color) {
        rowPos = rowIndex;
        colPos = colIndex;
        this.width = width;
        this.height = height;
        this.color = color;
    }

    public int getRowPos() {
    return rowPos;
    }

    public void setRowPos(int rowPos) {
        this.rowPos = rowPos;
    }

    public int getColPos() {
      return colPos;
    }

    public void setColPos(int colPos) {
        this.colPos = colPos;
    }

    public int getWidth() {
      return width;
    }

    public int getHeight() {
      return height;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public char[][] draw() {
        char objectSymbol = '*';
        if(this instanceof Tank)
            objectSymbol = '*';
        else if(this instanceof Stone)
            objectSymbol = '$';
        else if(this instanceof Brick)
            objectSymbol = '#';

        char[][] bitmap = new char[getHeight()][getWidth()];
        for (int i = 0; i < getHeight(); i++)
            for (int j = 0; j < getWidth(); j++)
                bitmap[i][j] = objectSymbol;
        return bitmap;
    }
}
