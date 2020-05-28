/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Open the file conatining the shop contents
* Project: Turn Based Combat Game
* Date Last Modified: 28/05/2020
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
            fileStrm = new FileInputStream("Shop.txt");
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

    //Print lines in the file
    public void printItem(String item)
    {
        String thisToken = null;
        StringTokenizer strTok;

        strTok = new StringTokenizer(item, ",");

        while (strTok.hasMoreTokens())
        {
            thisToken = strTok.nextToken();
            System.out.print(thisToken + ", ");
        }
        
        System.out.println("\n");
    }
    
}