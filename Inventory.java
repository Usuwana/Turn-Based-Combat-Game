import java.util.*;

public interface Inventory 
{
    
    public abstract void setName(String name);
    public abstract String getName();
    public abstract int getCost();
    public abstract int getMinEffect();
    public abstract int getMaxEffect();
}