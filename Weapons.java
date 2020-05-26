/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to define characteristics of a weapon item. Acts as a super class for a normal weapon and it's modifications
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/


//import java.util.*;
//import java.io.*;

public abstract class Weapons extends Inventory 
{
    @Override
    public abstract void setItem(String name); 

    @Override
    public abstract char getSymbol(); 
    
    @Override
    public abstract String getName();
    
    @Override
    public abstract int getCost();

    @Override
    public abstract int getMinEffect(); 

    @Override
    public abstract int getMaxEffect();

    @Override
    public abstract int getOverallEffect();
    
}