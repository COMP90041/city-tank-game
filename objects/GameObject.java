package objects;

public abstract class GameObject implements Drawable {
    private int rowPos, colPos;
    private int width, height;
    private String color;
    private boolean alive;
    protected char drawingSymbol = '*';

    //constructor
    public GameObject(int rowPos, int colPos, int width, int height, String color) {
        this.rowPos = rowPos;
        this.colPos = colPos;
        this.width = width;
        this.height = height;
        this.color = color;
        this.alive = true;
    }

    //setters and getters
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

    public boolean isAlive() {
      return alive;
    }

    public void setAlive(boolean status) {
      this.alive = status;
    }

    public char[][] draw() {
      char[][] bitmap = new char[getHeight()][getWidth()];
      for (int i = 0; i < getHeight(); i++)
        for (int j = 0; j < getWidth(); j++)
          bitmap[i][j] = drawingSymbol;
      return bitmap;
    }
}
