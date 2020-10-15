package objects;

import graphics.*;
import utilities.*;

public interface Movable
{
  public Commands.Direction getCurDirection();
  public void move(Commands.Direction cmd, Renderer mainRenderer);
}
