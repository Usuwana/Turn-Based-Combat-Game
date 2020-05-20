import java.util.*;

public abstract class Inventory 
{
    public abstract void setItem(String name);
    public abstract String getName();
    public abstract int getCost();
    public abstract int getMinEffect();
    public abstract int getMaxEffect();

    
}