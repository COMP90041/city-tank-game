package objects;

import graphics.*;
import utilities.*;

public class Tank extends GameObject
{
  //private int rowPos, colPos;
  private Commands.Direction curDirection;
  //private int width, height;

  public Tank(int rowIndex, int colIndex)
  {
    super(rowIndex, colIndex, 5, 5);
    curDirection = Commands.Direction.UP;
  }

  public Tank(int rowIndex, int colIndex, Commands.Direction direction)
  {
    this(rowIndex, colIndex);
    curDirection = direction;
  }

  public void move(Commands.Direction cmd, Renderer mainRenderer)
  {
    //Update the location or the current direction
    //based on the command received from the player
    switch (curDirection)
    {
      case UP:
        switch (cmd)
        {
          case UP:
            if(! isCollision(mainRenderer, getRowPos() - 1, getColPos()))
              setRowPos(getRowPos() - 1);
            break;
          case DOWN:
            if(! isCollision(mainRenderer, getRowPos() + 1, getColPos()))
              setRowPos(getRowPos() + 1);
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
            if(! isCollision(mainRenderer, getRowPos() - 1, getColPos()))
              setRowPos(getRowPos() - 1);
            break;
          case DOWN:
            if(! isCollision(mainRenderer, getRowPos() + 1, getColPos()))
              setRowPos(getRowPos() + 1);
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
            if(! isCollision(mainRenderer, getRowPos(), getColPos() - 1))
              setColPos(getColPos() - 1);
            break;
          case RIGHT:
            if(! isCollision(mainRenderer, getRowPos(), getColPos() + 1))
              setColPos(getColPos() + 1);
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
            if(! isCollision(mainRenderer, getRowPos(), getColPos() - 1))
              setColPos(getColPos() - 1);
            break;
          case RIGHT:
            if(! isCollision(mainRenderer, getRowPos(), getColPos() + 1))
              setColPos(getColPos() + 1);
            break;
          default:
            break;
        }
        break;
      default:
        break;
    }
  }

  // Overriding draw() in Object class to make tank shape
  public char[][] draw()
  {
    //allocate a bitmap for the tank
    char[][] bitmap = super.draw();

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

  private boolean isCollision(Renderer mainRenderer, int rowPos, int colPos) {
    // Collision check with the borders
    if((rowPos + this.getHeight() > mainRenderer.getHeight()) || (colPos + this.getWidth() > mainRenderer.getWidth()) || rowPos < 0 || colPos < 0)
      return true;
    // Collision check with obstacles in the map
    else {
      char[][] bitmap = mainRenderer.getBitMap();

      // Removes the player tank from the bitmap before checking for collision with enemy tanks
      for (int i = 0; i < this.getHeight(); i++)
        for (int j = 0; j < this.getWidth(); j++)
          bitmap[this.getRowPos() + i][this.getColPos() + j] = ' ';

      for (int i = 0; i < this.getHeight(); i++)
        for (int j = 0; j < this.getWidth(); j++)
         if(bitmap[rowPos + i][colPos + j] != ' ') return true;
    }
    return false;
  }

}