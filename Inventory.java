import java.util.*;

public abstract class Inventory extends CharacterModify
{
    public Inventory(GameCharacter next) 
    {
        super(next);
    }

    public abstract void setName(String name);
    public abstract String getName();
    public abstract int getCost();
    public abstract int getMinEffect();
    public abstract int getMaxEffect();
}