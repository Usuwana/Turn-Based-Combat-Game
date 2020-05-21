import java.util.*;

public abstract class Inventory 
{
    public abstract void setItem(String name);
    public abstract char getSymbol();
    public abstract String getName();
    //public abstract void getItem();
    public abstract int getCost();
    public abstract int getMinEffect();
    public abstract int getMaxEffect();

    
}