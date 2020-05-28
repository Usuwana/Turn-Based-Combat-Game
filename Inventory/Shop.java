/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Open the file conatining the shop contents
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
package Inventory;
import java.util.*;
import java.io.*;

public class Shop 
{

    //Opens file, reads and prints shop items in it, then closes
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
        //int i=1;

        strTok = new StringTokenizer(item, ",");
        //System.out.println(i + ". ");
        //i++;
        while (strTok.hasMoreTokens())
        {
            thisToken = strTok.nextToken();
            System.out.print(thisToken + " ");
        }
        
        System.out.println("\n");
    }
    
}