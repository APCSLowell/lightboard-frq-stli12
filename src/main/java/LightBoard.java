public class LightBoard
{
  /** The lights on the board, where true represents on and false represents off.
   */
  private boolean[][] lights;

  /** Constructs a LightBoard object having numRows rows and numCols columns.
   * Precondition: numRows > 0, numCols > 0
   * Postcondition: each light has a 40% probability of being set to on.
   */
  public LightBoard(int numRows, int numCols)
  {
    lights = new boolean[numRows][numCols];
    for(int i =0; i < numRows; i++){
      for(int j = 0; j < numCols; j++){
        if((double)Math.random() <= 0.4)
          lights[i][j] = true;
        else
          lights[i][j] = false;
      }
    }

  }

  /** Evaluates a light in row index row and column index col and returns a status
   *  as described in part (b).
   *  Precondition: row and col are valid indexes in lights.
   */
  public boolean evaluateLight(int row, int col)
  {
     int count = 0;
    for(int i =0; i < lights.length; i ++){
      if(lights[i][col] == true)
        count++;
    }

    if(lights[row][col] == true && count % 2==0)
      return false;
    else if(lights[row][col] == false && count % 3 == 0)
      return true;
    else
      return lights[row][col];
  }
  //used for testing
  public String toString()
  {
    String s = "";
    for (int r = 0; r < lights.length; r++)
    {
      for (int c = 0; c < lights[0].length; c++)
        if (lights[r][c])
          s += "*";
        else
          s += ".";
      s += "\n";
    }
    return s;
  }
  
}
