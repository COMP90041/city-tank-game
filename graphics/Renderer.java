package graphics;

import objects.*;
import java.util.ArrayList;

public class Renderer
{
  private ArrayList<GameObject> objects;

  private int width, height;
  private char[][] bitmap;
  private String[][] colourBitmap;

  private static final char borderChar = '.';

  public Renderer(int aWidth, int aHeight)
  {
    width = aWidth;
    height = aHeight;
    objects = new ArrayList<GameObject>();
  }

  //setters and getters
  public int getHeight() {
    return height;
  }

  public int getWidth() {
    return width;
  }

  public char[][] getBitMap() {
    return bitmap;
  }

  public void addObject(GameObject newObject) {
    objects.add(newObject);
  }

  public void render()
  {
    int i, j;
    bitmap = new char[height][width];
    colourBitmap = new String[height][width];

    //clear the screen
    for (i = 0; i < height; i++)
    {
      for (j = 0; j < width; j++)
      {
        bitmap[i][j] = ' ';
        colourBitmap[i][j] = "";
      }
    }
    
    //render objects
    for (GameObject obj : objects)
    {
      //Bullet-specific handling code
      if (obj instanceof Bullet) {
        Bullet aBullet = (Bullet) obj;
        aBullet.move(aBullet.getCurDirection(), this);
        if (!aBullet.isAlive()) continue;
      }

      String objColor = obj.getColor();
      char[][] objBitmap = obj.draw();
      for (i = 0; i < obj.getHeight(); i++)
      {
        for (j = 0; j < obj.getWidth(); j++)
        {
          bitmap[obj.getRowPos() + i][obj.getColPos() + j] = objBitmap[i][j];
          colourBitmap[obj.getRowPos() + i][obj.getColPos() + j] = objColor;
        }
      }
    }

    //output to the screen
    //including the border
    for (i = 0; i < width + 2; i++)
    {
      System.out.print(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
    }
    System.out.println();

    //main playing screen
    for (i = 0; i < height; i++)
    {
      System.out.print(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
      for (j = 0; j < width; j++)
      {
          System.out.print(colourBitmap[i][j] + bitmap[i][j] + Color.ANSI_RESET);
      }
      System.out.println(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
    }

    for (i = 0; i < width + 2; i++)
    {
      System.out.print(Color.ANSI_RED + borderChar + Color.ANSI_RESET);
    }

    System.out.println();
  }
}
