import java.util.*;

public class Weapons extends Inventory 
{

    public Weapons(GameCharacter next) 
    {
        super(next);
    }

    @Override
    public void setName(String name) 
    {
    
    }

    @Override
    public int getCost() 
    {
        return 0;
    }

    @Override
    public int getMinEffect() 
    {
        return 0;
    }

    @Override
    public int getMaxEffect() 
    {
        return 0;
    }
    
}