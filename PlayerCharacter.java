import java.util.*;

public class PlayerCharacter implements GameCharacter
{
    private String name;
    //private List<Inventory> items;
    private List<Weapons> weapons;
    private List<Armour> armoury;
    private List<Potions> potions;
    private Inventory weapon;
    private Inventory armour;
    private Inventory potion;


    public PlayerCharacter()
    {
        //items = new ArrayList<>();
        weapons = new ArrayList<Weapons>();
        armoury = new ArrayList<Armour>();
        potions = new ArrayList<Potions>();
        weapon = new Weapons();
        armour = new Armour();
        potion = new Potions();
    }

    @Override
    public void setName(String name) 
    {
        this.name = name;

    }

    @Override
    public void getName() 
    {
        System.out.println(this.name +"\n");
    }

    @Override
    public void setWeapon(String name) 
    {
        weapon.setItem(name);
        weapons.add((Weapons)weapon);
    }

    @Override
    public void setArmour(String name) 
    {
        armour.setItem(name);
        armoury.add((Armour)armour);
    }

    @Override
    public void setPotion(String name) 
    {
        potion.setItem(name);
        potions.add((Potions)potion);
    }

    @Override
    public int getMaxHealth() 
    {
        return 30;
    }

    @Override
    public int getCurrHealth() 
    {
        return 30;
    }

    @Override
    public Inventory getArmour(String name) 
    {
        return null;
    }

    @Override
    public Inventory getWeapon(String name) 
    {
        Inventory weapon = new Weapons();
        //weapon.setItem
        return null;
    }

    @Override
    public Inventory getPotion(String name) 
    {
        for (int i=0; i<potions.size();i++)
        {
            if (name.equals(potions.get(i)))
            {
                System.out.println(potion.getName() + "with cost " + potion.getCost());
                System.out.println("The potions minimum effect is " + potion.getMinEffect());
                System.out.println("The potions maximum effect is " + potion.getMaxEffect());
                /*if (potion.getHealing() == true)
                {
                    System.out.println("It is a healing potion");
                }
                else
                {
                    System.out.println("It is a damaging potion");
                }*/
            }
            else
            {
                throw new IllegalArgumentException("Player does not own such potion");
            }
        }
        
        return null;
    }


    @Override
    public int getGold() 
    {
        return 100;
    }

}