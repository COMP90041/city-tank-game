package utilities;

public class Commands
{
  public enum Direction {UP, DOWN, LEFT, RIGHT}

  public static void clearScreen()
  {
    System.out.print("\033[H\033[2J");
    System.out.flush();
  }
}
