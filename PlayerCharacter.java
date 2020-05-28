/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: Used to set characteristics of a player, modify their characteristics during the game and carry character's attributes and inventory
 *  Project: Turn Based Combat Game
 *  Date Last modified: 28/05/2020
 ******************************************************************************/
import Inventory.*;
import java.util.*;

public class PlayerCharacter
{
    private String name;
    private int gold = 100;
    private int health = 30;
    private String currentWeapon;
    private String currentArmour;
    private String currentPotion;
    private List<Inventory> weapons;
    private List<Inventory> armoury;
    private List<Inventory> potions;
    private Inventory weapon;
    private Inventory armour;
    private Inventory potion;


    public PlayerCharacter()
    {
        weapons = new ArrayList<>();
        armoury = new ArrayList<>();
        potions = new ArrayList<>();
    }

    //Sets the name of the player
    public void setName(String name) 
    {
        this.name = name;

    }

    //Retrieves the name of the player
    public String getName() 
    {
        return name;
    }

    //Adds a new weapon to the list of weapons owned by the player
    public void addWeapon(String name) 
    {
        weapon = new CurrentWeapon();
        weapon.setItem(name);
        weapons.add((Weapons)weapon);        
    }

    //Adds new armour to the list of armour owned by the player
    public void addArmour(String name) 
    {
        armour = new Armour();
        armour.setItem(name);
        armoury.add((Armour)armour);
    }

    //Adds a new potion to the list of potions owned by the player
    public void addPotion(String name) 
    {
        potion = new Potions();
        potion.setItem(name);
        potions.add((Potions)potion);
    }

    //Sets the weapon currently in hand for the player
    public void setWeapon(String current) 
    {
        currentWeapon = current;
    }

    //Sets the armour currently in hand for the player
    public void setArmour(String current) 
    {
        currentArmour = current;
    }

    //Sets the potion currently in hand for the player
    public void setPotion(String current) 
    {
        currentPotion = current;
    }

    //Sets the gold the player currently has
    public void setGold(int gold)
    {
        this.gold = gold;
    }

    //Sets the health of the player
    public void setHealth(int health)
    {
        this.health=health;
    }

    //Retrieves the default health of the player
    public int getMaxHealth() 
    {
        return 30;
    }

    //Retrieves the current health of the player
    public int getCurrHealth() 
    {
        return health;
    }

    //Searches the armour list owned by the player and retrieves a specific armour item if it is contained in the list
    public String getArmour(String name) 
    {
        String item = null;
        for (int i=0; i<armoury.size();i++)
        {
            try
            {
                if (name.equals(armoury.get(i).getName()))
                {
                    item = armoury.get(i).getName();
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

    //Searches the weapon list owned by the player and retrieves a specific weapon item if it is contained in the list
    public String getWeapon(String name) 
    {
        String item = null;
        
        for (int i=0; i<weapons.size();i++)
        {
            try
            {
                if (name.equals(weapons.get(i).getName()))
                {
                    item = weapons.get(i).getName();
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

    //Searches the potion list owned by the player and retrieves a specific potion item if it is contained in the list
    public String getPotion(String name) 
    {
        String item = null;
    
        for (int i=0; i<potions.size();i++)
        {
            try
            {
                if (name.equals(potions.get(i).getName()))
                {
                    item = potions.get(i).getName();
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


    //Retrieves the gold at the player's disposal
    public int getGold() 
    {
        return gold;
    }

    //Prints out the weapons currently owned by the player
    public void getCurrentWeapons()
    {
        for (int i = 0; i < weapons.size(); i++)
        {
            System.out.println("----------------------------------");
            System.out.println("Name: " + weapons.get(i).getName());
            System.out.println("Cost: " + weapons.get(i).getCost());
            System.out.println("Minimum Damage: " +  weapons.get(i).getMinEffect());
            System.out.println("Maximum Damage: " + weapons.get(i).getMaxEffect());
            System.out.println("----------------------------------");
        }
    }

    //Prints out the armour currently owned by the player
    public void getCurrentArmoury()
    {
        for (int i = 0; i < armoury.size(); i++)
        {
            
            System.out.println("----------------------------------");
            System.out.println("Name: " + armoury.get(i).getName());
            System.out.println("Cost: " + armoury.get(i).getCost());
            System.out.println("Minimum Defence: " +  armoury.get(i).getMinEffect());
            System.out.println("Maximum Defence: " + armoury.get(i).getMaxEffect());
            System.out.println("----------------------------------");            
        }
    }

    //Prints out the potions currently owned by the player
    public void getCurrentPotions()
    {
        for (int i = 0; i < potions.size(); i++)
        {
             
            System.out.println("----------------------------------");
            System.out.println("Name: " + potions.get(i).getName());
            System.out.println("Cost: " + potions.get(i).getCost());
            System.out.println("Minimum Effect: " +  potions.get(i).getMinEffect());
            System.out.println("Maximum Effect: " + potions.get(i).getMaxEffect());
            System.out.println("----------------------------------");         
        }
    }

    //Retrieves the weapon currently being used by the player
    public String getcurWeapon()
    {
        return currentWeapon;
    }

    //Retrieves the armour currently being used by the player
    public String getcurArmour()
    {
        return currentArmour;
    }

    //Retrieves the potion currently being used by the player
    public String getcurPotion()
    {
        return currentPotion;
    }

    //Removes a weapon from the list of owned weapons
    public void removeWeapon(String name)
    {
        for (int i=0; i<weapons.size();i++)
        {
            try
            {
                if (name.equals(weapons.get(i).getName()))
                {
                    weapons.remove(i);
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

    //Removes a weapon from the list of owned armour
    public void removeArmour(String name)
    {
        for (int i=0; i<armoury.size();i++)
        {
            try
            {
                if (name.equals(armoury.get(i).getName()))
                {
                    armoury.remove(i);
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

    //Removes a weapon from the list of owned potions
    public void removePotions(String name)
    {
        for (int i=0; i<potions.size();i++)
        {
            try
            {
                if (name.equals(potions.get(i).getName()))
                {
                    potions.remove(i);
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