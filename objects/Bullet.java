package objects;

import graphics.*;
import utilities.*;

public class Bullet extends GameObject implements Movable
{
  private Commands.Direction curDirection;

  public static final char objectSymbol = '*';

  public Bullet(int rowPos, int colPos, Commands.Direction direction)
  {
    super(rowPos, colPos, 1, 1, Color.ANSI_RED);
    curDirection = direction;
    drawingSymbol = objectSymbol;
  }

  public Commands.Direction getCurDirection()
  {
    return curDirection;
  }

  public void move(Commands.Direction direction, Renderer mainRenderer)
  {
     switch (direction)
     {
      case UP:
        setRowPos(getRowPos() - 1);
        break;
      case DOWN:
        setRowPos(getRowPos() + 1);
        break;
      case LEFT:
        setColPos(getColPos() - 1);
        break;
      case RIGHT:
        setColPos(getColPos() + 1);
        break;
      default:
        break;  
      }
      
      //Check if the bullet is moving out of the battle field
      if (getRowPos() + this.getHeight() > mainRenderer.getHeight() || getRowPos() < 0 
          || getColPos() + this.getWidth() > mainRenderer.getWidth() || getColPos() < 0)
      {
        this.setAlive(false);
      }
  }

  // Overriding draw() in Object class to make tank shape
  public char[][] draw()
  {
    //allocate a bitmap for the tank
    char[][] bitmap = super.draw();

    return bitmap;
  }
}
