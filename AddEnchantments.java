

public abstract class AddEnchantments extends Weapons
{
    protected Weapons next;

    public AddEnchantments(Weapons newWeapon)
    {
        next = newWeapon;
    }

    public abstract String getEnchantment();
    public abstract int enchantmentCost();

    @Override
    public void setItem(String name) 
    {
       next.setItem(name);
    }

    @Override
    public char getSymbol() 
    {
        return next.getSymbol();
    }
    
    @Override
    public String getName()
    {
        return next.getName();
    }

    @Override
    public int getCost() 
    {
        return next.getCost();
    }

    @Override
    public int getMinEffect() 
    {
        return next.getMinEffect();
    }

    @Override
    public int getMaxEffect() 
    {
        return next.getMaxEffect();
    }

    @Override
    public int getOverallEffect()
    {
        return next.getOverallEffect();
    }
    
}