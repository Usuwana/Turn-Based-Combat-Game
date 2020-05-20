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
        System.out.println(this.name);
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
    public String getArmour(String name) 
    {
        String item = null;
        for (int i=0; i<armoury.size();i++)
        {
            if (name.equals(armoury.get(i).getName()))
            {
                System.out.println(armoury.get(i).getName() + "with cost " + armoury.get(i).getCost());
                System.out.println("The potions minimum effect is " + armoury.get(i).getMinEffect());
                System.out.println("The potions maximum effect is " + armoury.get(i).getMaxEffect());
                item = armoury.get(i).getName();
            }
            else
            {
                throw new IllegalArgumentException("Player does not own such armour");
            }
        }
        return item;
    }

    @Override
    public String getWeapon(String name) 
    {
        String item = null;
        for (int i=0; i<weapons.size();i++)
        {
            if (name.equals(weapons.get(i).getName()))
            {
                System.out.println(weapons.get(i).getName() + "with cost " + weapons.get(i).getCost());
                System.out.println("The weapons minimum effect is " + weapons.get(i).getMinEffect());
                System.out.println("The weapons maximum effect is " + weapons.get(i).getMaxEffect());
                item = weapons.get(i).getName();
            
            }
            else
            {
                throw new IllegalArgumentException("Player does not own such weapon");
            }
        }
        return item;
    }

    @Override
    public String getPotion(String name) 
    {
        String item = null;
        for (int i=0; i<potions.size();i++)
        {
            if (name.equals(potions.get(i).getName()))
            {
                System.out.println(potions.get(i).getName() + "with cost " + potions.get(i).getCost());
                System.out.println("The potions minimum effect is " + potions.get(i).getMinEffect());
                System.out.println("The potions maximum effect is " + potions.get(i).getMaxEffect());
                item = potions.get(i).getName();
            }
            else
            {
                throw new IllegalArgumentException("Player does not own such potion");
            }
        }
        
        return item;
    }


    @Override
    public int getGold() 
    {
        return 100;
    }

    @Override
    public void getCurrentWeapons()
    {
        for (int i = 0; i < weapons.size(); i++)
        {
            System.out.println("Weapons currently in character's inventory: \n");
            System.out.println(weapons.get(i).getName() + "costing " + weapons.get(i).getCost() + " with minimum damage of " + weapons.get(i).getMinEffect() + " and maximum damage of " + weapons.get(i).getMaxEffect() + ". ");
            
        }
    }

    @Override
    public void getCurrentArmoury()
    {
        for (int i = 0; i < armoury.size(); i++)
        {
            System.out.println("Armour currently in character's inventory: \n");
            System.out.println(armoury.get(i).getName() + "costing " + armoury.get(i).getCost() + " with minimum defence of " + armoury.get(i).getMinEffect() + " and maximum defence of " + armoury.get(i).getMaxEffect() + ". ");
            
        }
    }

    @Override
    public void getCurrentPotions()
    {
        for (int i = 0; i < potions.size(); i++)
        {
            System.out.println("Potions currently in character's inventory: \n");
            System.out.println(potions.get(i).getName() + "costing " + potions.get(i).getCost() + " with minimum effect of " + potions.get(i).getMinEffect() + " and maximum effect of " + potions.get(i).getMaxEffect() + ". ");
            
        }
    }


}