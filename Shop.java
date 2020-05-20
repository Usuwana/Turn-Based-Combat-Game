import java.util.*;
import java.io.*;

public class Shop 
{

    public void showShopContents()
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
            while(line != null)
            {
                lineNum++;
                printItem(line);
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
            }
            System.out.println("Error in file processing: " + e.getMessage());
        }
    }

    public void printItem(String item)
    {
        String thisToken = null;
        StringTokenizer strTok;
        //int i=0;

        strTok = new StringTokenizer(item, ",");
        while (strTok.hasMoreTokens())
        {
            thisToken = strTok.nextToken();
            //i=i+1;
            System.out.print(thisToken + " ");
        }
        System.out.println("\n");
    }
    
}