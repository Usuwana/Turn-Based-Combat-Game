import java.util.*;
import java.io.*;

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