import java.util.*;

public interface Inventory 
{
    
    //public void setName(String name);
    public String getName(String line);
    public int getCost();
    public int getMinEffect();
    public int getMaxEffect();
}