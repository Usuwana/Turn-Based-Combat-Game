import java.util.*;
import java.io.*;

public class Weapons implements Inventory 
{
    private void readFile()
    {
        FileInputStream fileStrm = null;
        InputStreamReader rdr;
        BufferedReader bufRdr;
        int lineNum;
        String line;

        try
        {
            fileStrm = new FileInputStream("ShopItems.txt");
            rdr = new InputStreamReader(fileStrm);
            bufRdr = new BufferedReader(rdr);

            lineNum = 0;
            line = bufRdr.readLine();
            while (line != null)
            {
                lineNum++;
                getName(line);
                getCost();
                getMinEffect();
                getMaxEffect();
                line = bufRdr.readLine();
            }
            fileStrm.close();
        }
        catch (IOException e)
        {
            if (fileStrm != null)
            {
                try
                {
                    fileStrm.close();
                }
                catch (IOException ex2)
                {

                }
                System.out.println("Error in file processing: " + e.getMessage());
            }
        }
    
    }
    

    @Override
    public String getName(String line) 
    {
          String thisToken = null;
          StringTokenizer strTok;

          strTok = new StringTokenizer(line, ",");
          while (strTok.hasMoreTokens())
          {
              thisToken = strTok.nextToken();
          }
          return null;
    }

    @Override
    public int getCost() 
    {
        return 0;
    }

    @Override
    public int getMinEffect() 
    {
        return 0;
    }

    @Override
    public int getMaxEffect() 
    {
        return 0;
    }

    
}