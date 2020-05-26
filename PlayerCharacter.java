/****************************************************************************
 * Author: Tatenda Usuwana Mapuranga
 *  Purpose: Used to set characteristics of a player, modify their characteristics during the game and carry character's attributes and inventory
 *  Project: Turn Based Combat Game
 *  Date Last modified: 26/05/2020
******************************************************************************/

import java.util.*;

public class PlayerCharacter implements GameCharacter
{
    private String name;
    private int gold = 100;
    private int health = 30;
    private String currentWeapon;
    private String currentArmour;
    private String currentPotion;
    //private List<Inventory> items;
    //private List<Weapons> weapons;
    //private List<Armour> armoury;
    //private List<Potions> potions;
    private List<Inventory> weapons;
    private List<Inventory> armoury;
    private List<Inventory> potions;
    //private List<Inventory> enchantments;
    private Inventory weapon;
    private Inventory armour;
    private Inventory potion;
    //private Inventory enchantment;


    public PlayerCharacter()
    {
        //items = new ArrayList<>();
        /*weapons = new ArrayList<Weapons>();
        armoury = new ArrayList<Armour>();
        potions = new ArrayList<Potions>();*/
        weapons = new ArrayList<>();
        armoury = new ArrayList<>();
        potions = new ArrayList<>();
        //enchantments = new ArrayList<>();
        //weapon = new Weapons();
        //armour = new Armour();
        //potion = new Potions();
    }

    @Override
    public void setName(String name) 
    {
        this.name = name;

    }

    @Override
    public String getName() 
    {
        return name;
    }

    @Override
    public void addWeapon(String name) 
    {
        weapon = new CurrentWeapon();
        weapon.setItem(name);
        weapons.add((Weapons)weapon);        
    }

    @Override
    public void addArmour(String name) 
    {
        armour = new Armour();
        armour.setItem(name);
        armoury.add((Armour)armour);
    }

    @Override
    public void addPotion(String name) 
    {
        potion = new Potions();
        potion.setItem(name);
        potions.add((Potions)potion);
    }

    @Override
    public void setWeapon(String current) 
    {
        currentWeapon = current;
    }

    @Override
    public void setArmour(String current) 
    {
        currentArmour = current;
    }

    @Override
    public void setPotion(String current) 
    {
        currentPotion = current;
    }

    @Override
    public void setGold(int gold)
    {
        this.gold = gold;
    }

    @Override
    public void setHealth(int health)
    {
            this.health=health;
    }

    @Override
    public int getMaxHealth() 
    {
        return 30;
    }

    @Override
    public int getCurrHealth() 
    {
        return health;
    }

    @Override
    public String getArmour(String name) 
    {
        String item = null;
        //int cost = 0;
        for (int i=0; i<armoury.size();i++)
        {
            try
            {
                if (name.equals(armoury.get(i).getName()))
                {
                //System.out.println(armoury.get(i).getName() +  "with cost " + armoury.get(i).getCost());
                //System.out.println("The potions minimum effect is " + armoury.get(i).getMinEffect());
                //System.out.println("The potions maximum effect is " + armoury.get(i).getMaxEffect());
                item = armoury.get(i).getName();
                //cost = armoury.get(i).getCost();
                } 
            }
            catch (NullPointerException e)
            {
                System.out.println("Armour not in inventory");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Armour not in inventory");
            }
            
        }
        return item;
    }

    @Override
    public String getWeapon(String name) 
    {
        String item = null;
        //int cost;
        for (int i=0; i<weapons.size();i++)
        {
            try
            {
                if (name.equals(weapons.get(i).getName()))
                {
                    //System.out.println(weapons.get(i).getName() + " with cost " + weapons.get(i).getCost());
                    //System.out.println("The weapons minimum effect is " + weapons.get(i).getMinEffect());
                    //System.out.println("The weapons maximum effect is " + weapons.get(i).getMaxEffect());
                    item = weapons.get(i).getName();
                    //cost = weapons.get(i).getCost();
                    //System.out.println(weapons.size());
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("Weapon not in inventory");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Weapon not in inventory");
            }
            
        }

        return item;
    }

    @Override
    public String getPotion(String name) 
    {
        String item = null;
        //int cost;
        for (int i=0; i<potions.size();i++)
        {
            try
            {
                if (name.equals(potions.get(i).getName()))
                {
                    //System.out.println(potions.get(i).getName() + "with cost " + potions.get(i).getCost());
                    //System.out.println("The potions minimum effect is " + potions.get(i).getMinEffect());
                    //System.out.println("The potions maximum effect is " + potions.get(i).getMaxEffect());
                    item = potions.get(i).getName();
                    //cost = potions.get(i).getCost();
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("Potion not in inventory");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Potion not in inventory");
            }
        }
        
        return item;
    }


    @Override
    public int getGold() 
    {
        return gold;
    }

    @Override
    public void getCurrentWeapons()
    {
        for (int i = 0; i < weapons.size(); i++)
        {
            //System.out.println("Weapons currently in character's inventory: \n");
            System.out.println(weapons.get(i).getName() + " costing " + weapons.get(i).getCost() + " with minimum damage of " + weapons.get(i).getMinEffect() + " and maximum damage of " + weapons.get(i).getMaxEffect() + ". ");
            
        }
    }

    @Override
    public void getCurrentArmoury()
    {
        for (int i = 0; i < armoury.size(); i++)
        {
            //System.out.println("Armour currently in character's inventory: \n");
            System.out.println(armoury.get(i).getName() + " costing " + armoury.get(i).getCost() + " with minimum defence of " + armoury.get(i).getMinEffect() + " and maximum defence of " + armoury.get(i).getMaxEffect() + ". ");
            
        }
    }

    @Override
    public void getCurrentPotions()
    {
        for (int i = 0; i < potions.size(); i++)
        {
            ///System.out.println("Potions currently in character's inventory: \n");
            System.out.println(potions.get(i).getName() + " costing " + potions.get(i).getCost() + " with minimum effect of " + potions.get(i).getMinEffect() + " and maximum effect of " + potions.get(i).getMaxEffect() + ". ");
            
        }
    }

    @Override
    public String getcurWeapon()
    {
        return currentWeapon;
    }

    @Override
    public String getcurArmour()
    {
        return currentArmour;
    }

    @Override
    public String getcurPotion()
    {
        return currentPotion;
    }

    @Override
    public void removeWeapon(String name)
    {
        //String item = null;
        //int cost;
        for (int i=0; i<weapons.size();i++)
        {
            try
            {
                if (name.equals(weapons.get(i).getName()))
                {
                    //System.out.println(weapons.get(i).getName() + " with cost " + weapons.get(i).getCost());
                    //System.out.println("The weapons minimum effect is " + weapons.get(i).getMinEffect());
                    //System.out.println("The weapons maximum effect is " + weapons.get(i).getMaxEffect());
                    //item = weapons.get(i).getName();
                    weapons.remove(i);
                    //cost = weapons.get(i).getCost();
                    //System.out.println(weapons.size());
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("Weapon not in inventory");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Weapon not in inventory");
            }
            
        }
    }

    @Override
    public void removeArmour(String name)
    {
        for (int i=0; i<armoury.size();i++)
        {
            try
            {
                if (name.equals(armoury.get(i).getName()))
                {
                    //System.out.println(weapons.get(i).getName() + " with cost " + weapons.get(i).getCost());
                    //System.out.println("The weapons minimum effect is " + weapons.get(i).getMinEffect());
                    //System.out.println("The weapons maximum effect is " + weapons.get(i).getMaxEffect());
                    //item = weapons.get(i).getName();
                    armoury.remove(i);
                    //cost = weapons.get(i).getCost();
                    //System.out.println(weapons.size());
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("Armour not in inventory");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Armour not in inventory");
            }
        }
    }

    @Override
    public void removePotions(String name)
    {
        for (int i=0; i<potions.size();i++)
        {
            try
            {
                if (name.equals(potions.get(i).getName()))
                {
                    //System.out.println(weapons.get(i).getName() + " with cost " + weapons.get(i).getCost());
                    //System.out.println("The weapons minimum effect is " + weapons.get(i).getMinEffect());
                    //System.out.println("The weapons maximum effect is " + weapons.get(i).getMaxEffect());
                    //item = weapons.get(i).getName();
                    potions.remove(i);
                    //cost = weapons.get(i).getCost();
                    //System.out.println(weapons.size());
                }
            }
            catch (NullPointerException e)
            {
                System.out.println("Potion not in inventory");
            }
            catch (IllegalArgumentException e)
            {
                System.out.println("Potion not in inventory");
            }
        }

    }

}