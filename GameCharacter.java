import java.util.*;

public abstract class GameCharacter
{
    public abstract void setName(String name);
    public abstract void getName();
    public abstract void setWeapon();
    public abstract Weapons getWeapon();
    public abstract int getMaxHealth();
    public abstract int getCurrHealth();
    public abstract void setArmour();
    public abstract Armour getArmour();
    public abstract int getGold();

}