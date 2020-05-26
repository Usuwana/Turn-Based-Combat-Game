/***************************************************************************************************************************************************
* Author: Tatenda Usuwana Mapuranga
* Purpose: Used to define characteristics of a weapon item. Acts as a super class for a normal weapon and it's modifications
* Project: Turn Based Combat Game
* Date Last Modified: 26/05/2020
********************************************************************************************************************************************************/
//package Model;
//Inherits from super class Inventory
public abstract class Weapons extends Inventory 
{
    @Override
    public abstract void setItem(String name); //Set the values of a weapon's attributes
    @Override
    public abstract char getSymbol(); //Retrieves the symbol of a weapon item
    @Override
    public abstract String getName(); //Retrieves the set name of a weapon item
    @Override
    public abstract int getCost(); //Retrieves the set cost of a weapon item
    @Override
    public abstract int getMinEffect();  //Retrieves the set minimum effect of a weapon item
    @Override
    public abstract int getMaxEffect(); //Retrieves the set maximum effect of a weapon item
    @Override
    public abstract int getOverallEffect(); //Retrieves the overall effect of a weapon 
    
}