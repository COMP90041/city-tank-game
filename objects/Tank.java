package objects;

import graphics.*;
import utilities.*;

public class Tank
{
  private int rowPos, colPos;
  private Commands.Direction curDirection;
  private int width, height;

  public Tank(int rowIndex, int colIndex)
  {
    rowPos = rowIndex;
    colPos = colIndex;
    curDirection = Commands.Direction.UP;
    width = 5;
    height = 5;
  }

  public Tank(int rowIndex, int colIndex, Commands.Direction direction)
  {
    this(rowIndex, colIndex);
    curDirection = direction;
  }

  public int getRowPos()
  {
    return rowPos;
  }

  public int getColPos()
  {
    return colPos;
  }

  public int getWidth()
  {
    return width;
  }

  public int getHeight()
  {
    return height;
  }

  public void move(Commands.Direction cmd)
  {
    //Update the location or the current direction
    //based on the command received from the player
    switch (curDirection)
    {
      case UP:
        switch (cmd)
        {
          case UP:
            rowPos--;
            break;
          case DOWN:
            rowPos++;
            break;
          case LEFT:
            curDirection = Commands.Direction.LEFT;
            break;
          case RIGHT:
            curDirection = Commands.Direction.RIGHT;
            break;
          default:
            break;
        }
        break;
      case DOWN:
        switch (cmd)
        {
          case UP:
            rowPos--;
            break;
          case DOWN:
            rowPos++;
            break;
          case LEFT:
            curDirection = Commands.Direction.LEFT;
            break;
          case RIGHT:
            curDirection = Commands.Direction.RIGHT;
            break;
          default:
            break;
        }
        break;
      case LEFT:
        switch (cmd)
        {
          case UP:
            curDirection = Commands.Direction.UP;
            break;
          case DOWN:
            curDirection = Commands.Direction.DOWN;
            break;
          case LEFT:
            colPos--;
            break;
          case RIGHT:
            colPos++;
            break;
          default:
            break;
        }
        break;
      case RIGHT:
        switch (cmd)
        {
          case UP:
            curDirection = Commands.Direction.UP;
            break;
          case DOWN:
            curDirection = Commands.Direction.DOWN;
            break;
          case LEFT:
            colPos--;
            break;
          case RIGHT:
            colPos++;
            break;
          default:
            break;
        }
        break;
      default:
        break;
    }
  }

  public char[][] draw()
  {
    //allocate a bitmap for the tank
    char[][] bitmap = new char[getHeight()][getWidth()];
    for (int i = 0; i < getHeight(); i++)
      for (int j = 0; j < getWidth(); j++)
      {
        bitmap[i][j] = '*';
      }

    //update the bitmap accordingly
    //based on the current direction
    switch (curDirection)
    {
      case UP:
        bitmap[0][0] = bitmap[0][4] = ' ';
        bitmap[1][0] = bitmap[1][1] = bitmap[1][3] = bitmap[1][4] = ' ';
        break;
      case DOWN:
        bitmap[3][0] = bitmap[3][1] = bitmap[3][3] = bitmap[3][4] = ' ';
        bitmap[4][0] = bitmap[4][4] = ' ';
        break;
      case LEFT:
        bitmap[0][0] = bitmap[0][1] = ' ';
        bitmap[1][1] = bitmap[3][1] = ' ';
        bitmap[4][0] = bitmap[4][1] = ' ';
        break;
      case RIGHT:
        bitmap[0][3] = bitmap[0][4] = ' ';
        bitmap[1][3] = bitmap[3][3] = ' ';
        bitmap[4][3] = bitmap[4][4] = ' ';
        break;
      default:
        break;
    }
    return bitmap;
  }
}
