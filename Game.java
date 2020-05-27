/****************************************************************************
 *  Author: Tatenda Usuwana Mapuranga
 *  Purpose: Brings together all the classes to run the game
 *  Project: Turn Based Combat Game
 *  Date Last modified: 27/05/2020
 ******************************************************************************/

import java.util.*;

public class Game 
{
    public static void main(String[] args)
    {
        int choice; //Used for choosing an option from the main menu
        int warfinished = 0; //Controller used to keep the game open until certain conditions are met
        String name; //Used to hold the name of the player character
        String currentWeapon; //Variable to be used to choose the current weapon being used by the player
        String currentArmour; //Variable to be used to choose the current armour being used by the player
        double slimeProbability = 0.5; //Initializes probability of enemy being Slime
        double ogreProbability = 0.2; //Initializes probability of enemy being Ogre
        double dragonProbability = 0; //Initializes probability of enemy being Dragon
        double goblinProbability = 0.3; //Initializes probability of enemy being Goblin
        int totalBattles = 0; //Counts the number of battles that have taken place. Useful for deciding whether to add 15% or 5% probability to dragon
        double enemyChoice = Math.random() *(0.5); //Random nimber used to decide which enemy the character will fight
        PlayerCharacter character = new PlayerCharacter(); //Initializes new Player character
        Shop theShop = new Shop(); //Initialize shop class which reads from shop iteem file
        Inventory weapon; 
        Inventory armour;
        Inventory potion;
        int initial = 0; //Used to make sure that player recieves cheapest available weapon and armour only at the start of the game


        //Where the game is entered. While this variable is zero, the player is inside the game
        while(warfinished==0)
        {   
            if (initial == 0)
            {
                weapon = new CurrentWeapon();
                weapon.setItem("Short Sword");
                int option1 = weapon.getCost();
                weapon.setItem("Great Axe");
                int option2 = weapon.getCost();
                weapon.setItem("Magic Staff");
                int option3 = weapon.getCost();
                int minimum = 100;
                
                //Find te cheapest available weapon to assign to character
                if (option3<minimum)
                {
                    minimum = option3;
                    character.addWeapon("Magic Staff");
                    character.setWeapon("Magic Staff");
                    if (option2 < minimum)
                    {
                        minimum = option2;
                        character.removeWeapon("Magic Staff");
                        character.addWeapon("Great Axe");
                        character.setWeapon("Great Axe");
                        if (option1 < minimum)
                        {
                            minimum = option1;
                            character.removeWeapon("Great Axe");
                            character.addWeapon("Short Sword");
                            character.setWeapon("Short Sword");
                        }
                    }
                }

                armour = new Armour();
                armour.setItem("Leather Armour");
                option1 = armour.getCost();
                armour.setItem("Chain Mail");
                option2 = armour.getCost();
                armour.setItem("Dragon Skin");
                option3 = armour.getCost();
                minimum = 100;

                //Find the cheapest available armour to assign to character
                if (option3<minimum)
                {
                    minimum = option3;
                    character.addArmour("Dragon Skin");
                    character.setArmour("Dragon Skin");
                    if (option2 < minimum)
                    {
                        minimum = option2;
                        character.removeArmour("Dragon Skin");
                        character.addArmour("Chain Mail");
                        character.setArmour("Chain Mail");
                        if (option1 < minimum)
                        {
                            minimum = option1;
                            character.removeArmour("Chain Mail");
                            character.addArmour("Leather Armour");
                            character.setArmour("Leather Armour");
                        }
                    }
                }
                initial = 1;
            }
            System.out.println("----------------------------------");
            System.out.println("\nCharacter name: " + character.getName());
            character.getCurrHealth();
            System.out.println("\nCurrent gold: " + character.getGold());
            System.out.println("\nCURRENT ARMOURY IN INVENTORY: ");
            character.getCurrentArmoury();
            System.out.println("\nCURRENT POTIONS IN INVENTORY: ");
            character.getCurrentPotions();
            System.out.println("\nCURRENT WEAPONS IN INVENTORY: ");
            character.getCurrentWeapons();
            System.out.println("----------------------------------");
            System.out.println("\nCURRENT WEAPON IN HAND: ");
            System.out.println(character.getcurWeapon());
            System.out.println("\nCURRENT PROTECTIVE ARMOUR IN HAND: ");
            System.out.println(character.getcurArmour());
            System.out.println("\n----------------------------------");
            try
            {
                //Main Menu
                System.out.println("\n1. Go to Shop\n");
                System.out.println("2. Choose Character Name\n");
                System.out.println("3. Choose Weapon\n");
                System.out.println("4. Choose Armour\n");
                System.out.println("5. Start Battle\n");
                System.out.println("6. Exit\n");
                System.out.println("----------------------------------");
                Scanner sc = new Scanner(System.in);
                System.out.println("Pick a numeric option from the menu\n");
                choice = sc.nextInt();
                System.out.println("----------------------------------");
                
                switch(choice)
                {
                    case 1:
                        
                        int shopChoice; //Used to choose actions inside the shop
                        //Shop Menu
                        System.out.println("----------------------------------");
                        System.out.println("\nCurrent gold: " + character.getGold());
                        System.out.println("----------------------------------");
                        System.out.println("1. Buy items");
                        System.out.println("2. Sell items");
                        System.out.println("----------------------------------");
                        Scanner sc2 = new Scanner(System.in);
                        System.out.println("Select a numerical choice\n");
                        shopChoice = sc2.nextInt();
                        System.out.println("----------------------------------");
                        

                        switch(shopChoice)
                        {
                            case 1:
                                String item; //Used to select item to buy
                                System.out.println("These are the available items: \n");
                                System.out.println("----------------------------------");
                                //Display the inventory available for purchase
                                theShop.showShopContents();
                                System.out.println("----------------------------------");
                                System.out.println("\nCurrent gold: " + character.getGold());
                                System.out.println("----------------------------------");
                                Scanner sc3 = new Scanner(System.in);
                                System.out.println("Type name of item you would like to buy\n");
                                
                                item = sc3.nextLine();
                                System.out.println("----------------------------------");
                                
                                //Declare variables for choosing which inventory to buy
                                Inventory weaponChoose = new CurrentWeapon();
                                Inventory armourChoose = new Armour();
                                Inventory potionChoose = new Potions();

                                weaponChoose.setItem(item);
                                armourChoose.setItem(item);
                                potionChoose.setItem(item);

                                try
                                {
                                    //Proceed to payment if item is available
                                    if (!(weaponChoose.getName().equals(null)))
                                    {
                                        
                                        potionChoose = null;
                                        armourChoose = null;
                                        //Buy if player has enough gold
                                        if (character.getGold() >= weaponChoose.getCost())
                                        {
                                            character.addWeapon(item);
                                            character.setGold(character.getGold() - weaponChoose.getCost());
                                            System.out.println("\nCurrent gold: " + character.getGold());
                                        }
                                        else
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println("Not enough funds to buy, pick another option.");
                                            System.out.println("----------------------------------");
                                            weaponChoose = null;
                                        }
                                    }
                                }
                                catch (NullPointerException e)
                                {
                                    System.out.println("----------------------------------");
                                    System.out.println("No such weapon");
                                    System.out.println("----------------------------------");
                                }
                                try
                                {
                                    //Proceed to payment if item is available
                                    if (!(armourChoose.getName().equals(null)))
                                    {
                                        
                                        weaponChoose = null;
                                        potionChoose = null;
                                        //Buy if player has enough gold
                                        if (character.getGold() >= armourChoose.getCost())
                                        {
                                            character.addArmour(item);
                                            character.setGold(character.getGold() - armourChoose.getCost());
                                            System.out.println("\nCurrent gold: " + character.getGold());
                                        }
                                        else
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println("Not enough funds to buy, pick another option.");
                                            System.out.println("----------------------------------");
                                            armourChoose = null;
                                        }
                                    }
                                }catch (NullPointerException e)
                                {
                                    System.out.println("----------------------------------");
                                    System.out.println("No such armour");
                                    System.out.println("----------------------------------");
                                }
                                try
                                {
                                    
                                    if (!(potionChoose.getName().equals(null)))
                                    {
                                        
                                        weaponChoose = null;
                                        armourChoose = null;
                                        ////Buy if player has enough gold
                                        if (character.getGold() >= potionChoose.getCost())
                                        {
                                            character.addPotion(item);
                                            character.setGold(character.getGold() - potionChoose.getCost());
                                            System.out.println("\nCurrent gold: " + character.getGold());
                                        }
                                        else
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println("Not enough funds to buy, pick another option.");
                                            System.out.println("----------------------------------");
                                            potionChoose = null;
                                        }
                                    }
                                }catch (NullPointerException e)
                                {
                                    System.out.println("----------------------------------");
                                    System.out.println("No such potion");
                                    System.out.println("----------------------------------");
                                }
                            break;
                            case 2:
                                String sellItem;
                                weapon = new CurrentWeapon();
                                armour = new Armour();
                                potion = new Potions();
                                System.out.println("----------------------------------");
                                System.out.println("\nCurrent gold: " + character.getGold());
                                System.out.println("----------------------------------");
                                System.out.println("ARMOUR:");
                                character.getCurrentArmoury();
                                System.out.println("POTIONS:");
                                character.getCurrentPotions();
                                System.out.println("WEAPONS:");
                                character.getCurrentWeapons();
                                System.out.println("----------------------------------");
                                
                                Scanner sc6 = new Scanner(System.in);
                                System.out.println("Type name of item you would like to sell");
                                sellItem = sc6.nextLine();
                                try
                                {
                                    try
                                    {
                                        //Sell item if it is owned by the player
                                        if (!(character.getWeapon(sellItem).equals(null)) && (character.getWeapon(sellItem).equals(sellItem)))
                                        {
                                            weapon.setItem(sellItem);
                                            character.setGold(character.getGold() + (int)(weapon.getCost()*0.5));
                                            System.out.println(weapon.getName() + " has been sold");
                                            character.removeWeapon(sellItem);
                                        }
                                    }
                                    catch (NullPointerException e)
                                    {
                                        System.out.println("----------------------------------");
                                        System.out.println("No such weapon");
                                        System.out.println("----------------------------------");
                                    }
                                    try
                                    {
                                        //Sell item if it is owned by the player
                                        if (!(character.getArmour(sellItem).equals(null)) && (character.getArmour(sellItem).equals(sellItem)))
                                        {
                                            armour.setItem(sellItem);
                                            character.setGold(character.getGold() + (int)(armour.getCost()*0.5));
                                            character.removeArmour(sellItem);
                                        }
                                    }
                                    catch (NullPointerException e)
                                    {
                                        System.out.println("No such armour");
                                    }
                                    try
                                    {
                                        //Sell item if it is owned by the player
                                        if (!(character.getPotion(sellItem).equals(null)) && (character.getPotion(sellItem).equals(sellItem)))
                                        {
                                            potion.setItem(sellItem);
                                            character.setGold(character.getGold() + (int)(potion.getCost()*0.5));
                                            character.removePotions(sellItem);
                                        }
                                    }
                                    catch (NullPointerException e)
                                    {
                                        System.out.println("----------------------------------");
                                        System.out.println("No such potion");
                                        System.out.println("----------------------------------");
                                    }
                                    
                                }
                                catch (IllegalArgumentException e)
                                {
                                    System.out.println("----------------------------------");
                                    System.out.println("No such inventory");
                                    System.out.println("----------------------------------");
                                }
                                catch (NullPointerException e)
                                {
                                    System.out.println("----------------------------------");
                                    System.out.println("No such inventory");
                                    System.out.println("----------------------------------");
                                }
                            break;
                        }

                        
                        
                    break;

                    case 2:
                        //Setting the name to be used by the player during the game
                        System.out.println("Enter name of character: ");
                        Scanner sc1 = new Scanner(System.in);
                        name = sc1.next();
                        character.setName(name + "\n");
                    break;

                    case 3:
                        
                        System.out.println("CURRENT WEAPONS IN INVENTORY: ");
                        character.getCurrentWeapons(); //Display owned weapons
                        System.out.println("----------------------------------");
                        Scanner sc4 = new Scanner(System.in);
                        System.out.println("Type the name of a weapon to use from the current available weapons\n");
                        currentWeapon = sc4.nextLine();
                        System.out.println("----------------------------------");
                        System.out.println(currentWeapon + " has been selected.");
                        try
                        {
                            //Choose weapon for use if is is owned
                            if (character.getWeapon(currentWeapon).equals(currentWeapon))
                            {
                                character.setWeapon(currentWeapon);
                            }
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println("----------------------------------");
                            System.out.println("No such weapon in your possession");
                            System.out.println("----------------------------------");
                        }
                        catch (NullPointerException e)
                        {
                            System.out.println("----------------------------------");
                            System.out.println("No such weapon in your possession");
                            System.out.println("----------------------------------");
                        }
                        
                        

                    break;

                    case 4:

                        System.out.println("CURRENT ARMOUR IN INVENTORY: ");
                        character.getCurrentArmoury(); //Display armour owned by character
                        System.out.println("----------------------------------");
                        Scanner sc5 = new Scanner(System.in);
                        System.out.println("Type the name of a weapon to use from the current available weapons\n");
                        currentArmour = sc5.nextLine();
                        System.out.println("----------------------------------");
                        
                        System.out.println(currentArmour + " has been selected.");
                        try
                        {
                            //Choose armour for use if is is owned
                            if (character.getArmour(currentArmour).equals(currentArmour))
                            {
                                character.setArmour(currentArmour);
                            }
                        }
                        catch (IllegalArgumentException e)
                        {
                            System.out.println("----------------------------------");
                            System.out.println("No such armour in your possession");
                            System.out.println("----------------------------------");
                        }
                        catch (NullPointerException e)
                        {
                            System.out.println("----------------------------------");
                            System.out.println("No such armour in your possession");
                            System.out.println("----------------------------------");
                        }

                    break;

                    case 5:
                    
                    int charHealth = character.getCurrHealth();
                    int enemyHealth;
                    int battleFinished = 0;
                    double maximumProbability = 0;
                    try
                    {
                        if (!(character.getName().equals(null)))
                        {
                        //Calculates the maximum possible probability
                        if ((slimeProbability > ogreProbability) && (slimeProbability > dragonProbability) && (slimeProbability > goblinProbability))
                        {
                            maximumProbability = slimeProbability;
                        }
                        else if ((ogreProbability > slimeProbability) && (ogreProbability > dragonProbability) && (ogreProbability > goblinProbability))
                        {
                            maximumProbability = ogreProbability;
                        }
                        else if ((dragonProbability > ogreProbability) && (dragonProbability > slimeProbability) && (dragonProbability > goblinProbability))
                        {
                            maximumProbability = dragonProbability;
                        }
                        else if ((goblinProbability > ogreProbability) && (goblinProbability > dragonProbability) && (goblinProbability > slimeProbability))
                        {
                            maximumProbability = goblinProbability;
                        }
                        enemyChoice = Math.random() *(maximumProbability);
                    
                        int attackChoice = 0;//To choose method of attack
                        System.out.println("Slime P: " + slimeProbability);
                        System.out.println("Goblin P: " + goblinProbability);
                        System.out.println("Ogre P: " + ogreProbability);
                        System.out.println("Dragon P: " + dragonProbability);
                        System.out.println("Enemy Choice: " + enemyChoice);
                        System.out.println("Max probability: " + maximumProbability);
                        while(battleFinished ==0)
                        {
                                
                                System.out.print("Character name: " + character.getName()); 
                    
                                //Enemy is Ogre if the enemyChoice is less than the Ogre probability
                                if(enemyChoice < ogreProbability)
                                {
                                    Enemies ogre = new Ogre();
                                    int done = 0;
                                    int attack;
                                    int defence;
                                    
                                    enemyHealth = ogre.getCurrHealth();
                                    System.out.println("\nYour enemy for the battle will be: " + ogre.getName());
                                    
                                    while (done ==0)
                                        {
                                        System.out.println("Choose method of attack");
                                        Scanner sc7 = new Scanner(System.in);
                                        //Attacking options
                                        System.out.println("1. Attack with weapon");
                                        System.out.println("2.Use potion");
                                        System.out.println("3. Attack using weapon with enchantments");
                                        attackChoice = sc7.nextInt();
                                    
                                        switch(attackChoice)
                                        {
                                            //Attack with weapon
                                            case 1:
                                                    if (done == 0)
                                                    {
                                                        weapon = new CurrentWeapon();
                                                        weapon.setItem(character.getcurWeapon());
                                                        attack = weapon.getOverallEffect();
                                                        defence = ogre.getDefence();
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                        System.out.println(ogre.getName() + " health: " + ogre.getCurrHealth());
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                        System.out.println(ogre.getName() + " defends with " + defence + " defensive strength");
                                                        System.out.println("----------------------------------");
                                                        enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                        ogre.setHealth(enemyHealth);
                                                        System.out.println(ogre.getName() + " now has a health of " + ogre.getCurrHealth());
                                                        System.out.println("----------------------------------");
                                                        
                                                    }
                                            break;
                                            //Use potion
                                            case 2:
                                            
                                                    String potionItem;
                                                    potion = new Potions();
                                                    character.getCurrentPotions();
                                                    Scanner potionSelect = new Scanner(System.in);
                                                    System.out.println("Type potion name from list");
                                                    potionItem = potionSelect.nextLine();
                                                
                                                    potion.setItem(potionItem);
                                                    try
                                                    {
                                                        //Use potion if it is available to the character
                                                        if (character.getPotion(potionItem).equals(potionItem))
                                                        {
                                                            character.removePotions(potionItem);
                                                            if (potion.getSymbol() =='H')
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a healing potion");
                                                                character.setHealth(character.getCurrHealth() + potion.getOverallEffect());
                                                                System.out.println(character.getName() + " now has new health of " + character.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }
                                                            else if (potion.getSymbol() == 'D')
                                                            {
                                                                attack = potion.getOverallEffect();
                                                                defence = ogre.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a damaging potion");
                                                                System.out.println(character.getName() + " attacks using " + potion.getName() + " with " + attack);
                                                                System.out.println(ogre.getName() + " defends with " + defence + " defensive strength");
                                                                System.out.println("----------------------------------");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                ogre.setHealth(enemyHealth);
                                                                System.out.println(ogre.getName() + " now has a health of " + ogre.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }
                                                        }
                                                    }
                                                    catch (NullPointerException e)
                                                    {
                                                        System.out.println("----------------------------------");
                                                        System.out.println("No such potion owned");
                                                        System.out.println("----------------------------------");
                                                        done = 1;
                                                    }
                                            break;

                                            //Add enchantments to weapon
                                            case 3:
                                                if (done == 0)
                                                {
                                                    String enchantmentChoice;//Selection of enchantment to use
                                                    System.out.println("--------------------------------");
                                                    System.out.println("Enchantments: ");
                                                    //Declaration and initialization of enchantments
                                                    AddEnchantments twoDamage = new TwoDamage(new CurrentWeapon());
                                                    AddEnchantments fiveDamage = new FiveDamage(new CurrentWeapon());
                                                    AddEnchantments fireDamage = new FireDamage(new CurrentWeapon());
                                                    AddEnchantments powerUp = new PowerUp(new CurrentWeapon());

                                                    System.out.println(twoDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                                                    System.out.println(fiveDamage.getEnchantment() + " costing " + fiveDamage.enchantmentCost());
                                                    System.out.println(fireDamage.getEnchantment() + " costing " + fireDamage.enchantmentCost());
                                                    System.out.println(powerUp.getEnchantment() + " costing " + powerUp.enchantmentCost());
                                                    System.out.println("--------------------------------");
                                                    System.out.println("Current gold: " + character.getGold());
                                                    Scanner enchantmentSelect = new Scanner(System.in);
                                                    System.out.println("Choose enchantments to add to " + character.getcurWeapon());
                                                    enchantmentChoice = enchantmentSelect.nextLine();
                                
                                                       //Proceed to payment if enchantment is available
                                                        if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                                        {
                                                            //Buy enchantment and use it if character has enough gold
                                                            if (character.getGold() >= twoDamage.enchantmentCost())
                                                            {
                                                                character.setGold(character.getGold() - twoDamage.enchantmentCost());
                                                                weapon = new TwoDamage(new CurrentWeapon());
                                                                weapon.setItem(character.getcurWeapon());
                                                                attack = weapon.getOverallEffect();
                                                                defence = ogre.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                                System.out.println(ogre.getName() + " health: " + ogre.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                                System.out.println(ogre.getName() + " defends with " + defence + " defensive strength");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                ogre.setHealth(enemyHealth);
                                                                System.out.println("----------------------------------");
                                                                System.out.println(ogre.getName() + " now has a health of " + ogre.getCurrHealth());
                                                            
                                                            }
                                                            else
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println("Not enough funds to add enchantment");
                                                                System.out.println("----------------------------------");
                                                                done =1;
                                                            }
                                                            
                                                        }
                                                        //Proceed to payment if enchantment is available
                                                        else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                                        {
                                                            //Buy enchantment and use it if character has enough gold
                                                            if (character.getGold() >= fiveDamage.enchantmentCost())
                                                            {
                                                                character.setGold(character.getGold() - fiveDamage.enchantmentCost());
                                                                weapon = new FiveDamage(new CurrentWeapon());
                                                                weapon.setItem(character.getcurWeapon());
                                                                attack = weapon.getOverallEffect();
                                                                defence = ogre.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                                System.out.println(ogre.getName() + " health: " + ogre.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                                System.out.println(ogre.getName() + " defends with " + defence + " defensive strength");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                ogre.setHealth(enemyHealth);
                                                                System.out.println("----------------------------------");
                                                                System.out.println(ogre.getName() + " now has a health of " + ogre.getCurrHealth());
                                                            
                                                            }
                                                            else
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println("Not enough funds to add enchantment");
                                                                System.out.println("----------------------------------");
                                                                done =1;
                                                            }
                                                            
                                                        }
                                                        //Proceed to payment if enchantment is available
                                                        else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                                        {
                                                            //Buy enchantment and use it if character has enough gold
                                                            if (character.getGold() >= fireDamage.enchantmentCost())
                                                            {
                                                                character.setGold(character.getGold() - fireDamage.enchantmentCost());
                                                                weapon = new FireDamage(new CurrentWeapon());
                                                                weapon.setItem(character.getcurWeapon());
                                                                attack = weapon.getOverallEffect();
                                                                defence = ogre.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                                System.out.println(ogre.getName() + " health: " + ogre.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                                System.out.println(ogre.getName() + " defends with " + defence + " defensive strength");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                ogre.setHealth(enemyHealth);
                                                                System.out.println("----------------------------------");
                                                                System.out.println(ogre.getName() + " now has a health of " + ogre.getCurrHealth());
                                                            
                                                            }
                                                            else
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println("Not enough funds to add enchantment");
                                                                System.out.println("----------------------------------");
                                                                done =1;
                                                            }
                                                            
                                                        }
                                                        //Proceed to payment if enchantment is available
                                                        else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                                        {
                                                            //Buy enchantment and use it if character has enough gold
                                                            if (character.getGold() >= powerUp.enchantmentCost())
                                                            {
                                                                character.setGold(character.getGold() - powerUp.enchantmentCost());
                                                                weapon = new PowerUp(new CurrentWeapon());
                                                                weapon.setItem(character.getcurWeapon());
                                                                attack = weapon.getOverallEffect();
                                                                defence = ogre.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                                System.out.println(ogre.getName() + " health: " + ogre.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                                System.out.println(ogre.getName() + " defends with " + defence + " defensive strength");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                ogre.setHealth(enemyHealth);
                                                                System.out.println("----------------------------------");
                                                                System.out.println(ogre.getName() + " now has a health of " + ogre.getCurrHealth());
                                                            
                                                            }
                                                            else
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println("Not enough funds to add enchantment");
                                                                System.out.println("----------------------------------");
                                                                done =1;
                                                            }
                                                            
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Please enter valid enchantment");
                                                            System.out.println("----------------------------------");
                                                            done = 1;
                                                        }
                                            
                                                }
                                            break;
                                            
                                        }

                                        //End battle and award character their prize if health of enemy is 0 or less
                                        if (enemyHealth <=0)
                                        {
                                            System.out.println("Battle over!" + character.getName() + " has won the battle!");
                                            System.out.println(character.getName() + " will receive " + ogre.goldAward());
                                            System.out.println("----------------------------------");
                                            character.setGold(character.getGold() + ogre.goldAward());
                                            charHealth = (int)Math.min(character.getMaxHealth(), character.getCurrHealth()*1.5);
                                            character.setHealth(character.getCurrHealth()+ charHealth);
                                            if (slimeProbability - 0.05 > 0.05)
                                            {
                                                slimeProbability = slimeProbability - 0.05;
                                            }
                                            if (goblinProbability - 0.05 > 0.05)
                                            {
                                                goblinProbability = goblinProbability - 0.05;
                                            }
                                            if (ogreProbability - 0.05 > 0.05)
                                            {
                                                ogreProbability = ogreProbability - 0.05;
                                            }
                                            if (totalBattles == 0)
                                            {
                                                dragonProbability = dragonProbability + 0.15; 
                                            }
                                            else
                                            {
                                                dragonProbability = dragonProbability + 0.05; 
                                            }
                                            done = 1;
                                            battleFinished = 1;
                                        }
                                        if (done ==0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                            System.out.println(ogre.getName() + " health: " + ogre.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            System.out.println(ogre.getName() + " attack turn");
                                            attack = ogre.getDamage();
                                            armour = new Armour();
                                            armour.setItem(character.getcurArmour());
                                            defence = armour.getOverallEffect();
                                            int special = ogre.getSpecialAbilities();
                                            if (special != 0)
                                            {
                                                System.out.println(ogre.getName() + " attacks twice in a row with special ability.");
                                                attack = special;
                                            }
                                            System.out.println(ogre.getName() + " attacks with " + attack + " attacking power");
                                            System.out.println(character.getName() + " defends with " + defence + " defensive strength with " + armour.getName() + " armour");
                                            charHealth = character.getCurrHealth() -(Math.max(0,attack - defence));
                                            character.setHealth(charHealth);
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " now has a health of " + character.getCurrHealth());
                                            System.out.println("----------------------------------");

                                            //End the entire game if health of character is 0 or less
                                            if (charHealth <=0)
                                            {
                                                System.out.println("----------------------------------");
                                                System.out.println("Battle over!" + ogre.getName() + " has won the battle!");
                                                System.out.println("==================================");
                                                System.out.println("GAME OVER!!!");
                                                System.out.println("==================================");
                            
                                                done = 1;
                                                battleFinished = 1;
                                                warfinished = 1;
                                            }
                                        }
                                    }
                                }
                                //Enemy is Goblin if value enemyChoice is within required range
                                else if(enemyChoice < goblinProbability)
                                {
                                    Enemies goblin = new Goblin();
                                    System.out.println("\nYour enemy for the battle will be: " + goblin.getName());
                    
                                    int done = 0;
                                    int attack;
                                    int defence;
                                    
                                    enemyHealth = goblin.getCurrHealth();
                                    
                                    while (done ==0)
                                    {
                                        //Choose method of attack
                                        System.out.println("Choose method of attack");
                                        Scanner sc7 = new Scanner(System.in);
                                        System.out.println("1. Attack with weapon");
                                        System.out.println("2.Use potion");
                                        System.out.println("3. Attack using weapon with enchantments");
                                        attackChoice = sc7.nextInt();

                                        switch(attackChoice)
                                        {
                                            //Attack with weapon
                                            case 1:
                                                    if (done == 0)
                                                    {
                                                        weapon = new CurrentWeapon();
                                                        weapon.setItem(character.getcurWeapon());
                                                        attack = weapon.getOverallEffect();
                                                        defence = goblin.getDefence();
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                        System.out.println(goblin.getName() + " health: " + goblin.getCurrHealth());
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                        System.out.println(goblin.getName() + " defends with " + defence + " defensive strength");
                                                        enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                        goblin.setHealth(enemyHealth);
                                                        System.out.println("----------------------------------");
                                                        System.out.println(goblin.getName() + " now has a health of " + goblin.getCurrHealth());
                                                    
                                                    }
                                            break;
                                            case 2:
                                            //Use potion for attack or healing
                                                String potionItem;
                                                potion = new Potions();
                                                character.getCurrentPotions();
                                                Scanner potionSelect = new Scanner(System.in);
                                                System.out.println("Type potion name from list");
                                                potionItem = potionSelect.nextLine();

                                                potion.setItem(potionItem);
                                                try
                                                    {
                                                        //If player owns selected potion, use it
                                                        if (character.getPotion(potionItem).equals(potionItem))
                                                        {
                                                            character.removePotions(potionItem);

                                                            //If potion is a healing potion, use it to recover health
                                                            if (potion.getSymbol() =='H')
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a healing potion");
                                                                character.setHealth(character.getCurrHealth() + potion.getOverallEffect());
                                                                System.out.println(character.getName() + " now has new health of " + character.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }

                                                            //If potion is damaging potion, use it to attack enemy
                                                            else if (potion.getSymbol() == 'D')
                                                            {
                                                                attack = potion.getOverallEffect();
                                                                defence = goblin.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a damaging potion");
                                                                System.out.println(character.getName() + " attacks using " + potion.getName() + " with " + attack);
                                                                System.out.println(goblin.getName() + " defends with " + defence + " defensive strength");
                                                                System.out.println("----------------------------------");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                goblin.setHealth(enemyHealth);
                                                                System.out.println(goblin.getName() + " now has a health of " + goblin.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }
                                                        }
                                                    } 
                                                    catch (NullPointerException e)
                                                    {
                                                        System.out.println("----------------------------------");
                                                        System.out.println("You do not own such potion");
                                                        System.out.println("----------------------------------");
                                                    }
                                            break;

                                            case 3:
                                            //Use enchantments
                                                    if (done == 0)
                                                    {
                                                        String enchantmentChoice;
                                                        System.out.println("--------------------------------");
                                                        System.out.println("Enchantments: ");

                                                        //Declaration and initialization of enchantments
                                                        AddEnchantments twoDamage = new TwoDamage(new CurrentWeapon());
                                                        AddEnchantments fiveDamage = new FiveDamage(new CurrentWeapon());
                                                        AddEnchantments fireDamage = new FireDamage(new CurrentWeapon());
                                                        AddEnchantments powerUp = new PowerUp(new CurrentWeapon());

                                                        System.out.println(twoDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                                                        System.out.println(fiveDamage.getEnchantment() + " costing " + fiveDamage.enchantmentCost());
                                                        System.out.println(fireDamage.getEnchantment() + " costing " + fireDamage.enchantmentCost());
                                                        System.out.println(powerUp.getEnchantment() + " costing " + powerUp.enchantmentCost());
                                                        System.out.println("--------------------------------");
                                                        System.out.println("Current gold: " + character.getGold());
                                                        Scanner enchantmentSelect = new Scanner(System.in);
                                                        System.out.println("Choose enchantments to add to " + character.getcurWeapon());
                                                        enchantmentChoice = enchantmentSelect.nextLine();
                                    
                                                        //Proceed to payment if enchantment is available
                                                        if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                                        {
                                                            //If player has enough gold, use enchantment
                                                            if (character.getGold() >= twoDamage.enchantmentCost())
                                                            {
                                                                character.setGold(character.getGold() - twoDamage.enchantmentCost());
                                                                weapon = new TwoDamage(new CurrentWeapon());
                                                                weapon.setItem(character.getcurWeapon());
                                                                attack = weapon.getOverallEffect();
                                                                defence = goblin.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                                System.out.println(goblin.getName() + " health: " + goblin.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                                System.out.println(goblin.getName() + " defends with " + defence + " defensive strength");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                goblin.setHealth(enemyHealth);
                                                                System.out.println("----------------------------------");
                                                                System.out.println(goblin.getName() + " now has a health of " + goblin.getCurrHealth());
                                                            
                                                            }
                                                            else
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println("Not enough funds to add enchantment");
                                                                System.out.println("----------------------------------");
                                                                done =1;
                                                            }
                                                            
                                                        }
                                                        //Proceed to payment if enchantment is available
                                                        else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                                        {
                                                            //If player has enough gold, use enchantment
                                                            if (character.getGold() >= fiveDamage.enchantmentCost())
                                                            {
                                                                character.setGold(character.getGold() - fiveDamage.enchantmentCost());
                                                                weapon = new FiveDamage(new CurrentWeapon());
                                                                weapon.setItem(character.getcurWeapon());
                                                                attack = weapon.getOverallEffect();
                                                                defence = goblin.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                                System.out.println(goblin.getName() + " health: " + goblin.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                                System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                                System.out.println(goblin.getName() + " defends with " + defence + " defensive strength");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                goblin.setHealth(enemyHealth);
                                                                System.out.println("----------------------------------");
                                                                System.out.println(goblin.getName() + " now has a health of " + goblin.getCurrHealth());
                                                            
                                                            }
                                                            else
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println("Not enough funds to add enchantment");
                                                                System.out.println("----------------------------------");
                                                                done =1;
                                                            }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= fireDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - fireDamage.enchantmentCost());
                                                            weapon = new FireDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = goblin.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(goblin.getName() + " health: " + goblin.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(goblin.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            goblin.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(goblin.getName() + " now has a health of " + goblin.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            done =1;
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= powerUp.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - powerUp.enchantmentCost());
                                                            weapon = new PowerUp(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = goblin.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(goblin.getName() + " health: " + goblin.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(goblin.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            goblin.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(goblin.getName() + " now has a health of " + goblin.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            done =1;
                                                        }
                                                        
                                                    }
                                                    
                                                    else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Please enter valid enchantment");
                                                            System.out.println("----------------------------------");
                                                            done = 1;
                                                        }
                                                    
                                                }
                                            break;
                                            
                                        }
                                        //Battle ends and character is awarded if enemy health is less than or equal to 0
                                        if (enemyHealth <=0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println("Battle over!" + character.getName() + " has won the battle!");
                                            System.out.println(character.getName() + " will receive " + goblin.goldAward());
                                            System.out.println("----------------------------------");
                                            character.setGold(character.getGold() + goblin.goldAward());
                                            charHealth = (int)Math.min(character.getMaxHealth(), character.getCurrHealth()*1.5);
                                            character.setHealth(character.getCurrHealth() + charHealth);
                                            if (slimeProbability - 0.05 > 0.05)
                                            {
                                                slimeProbability = slimeProbability - 0.05;
                                            }
                                            if (goblinProbability - 0.05 > 0.05)
                                            {
                                                goblinProbability = goblinProbability - 0.05;
                                            }
                                            if (ogreProbability - 0.05 > 0.05)
                                            {
                                                ogreProbability = ogreProbability - 0.05;
                                            }
                                            if (totalBattles == 0)
                                            {
                                                dragonProbability = dragonProbability + 0.15; 
                                            }
                                            else
                                            {
                                                dragonProbability = dragonProbability + 0.05; 
                                            }
                                            done = 1;
                                            battleFinished = 1;
                                        }
                                        if (done ==0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                            System.out.println(goblin.getName() + " health: " + goblin.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            System.out.println(goblin.getName() + " attack turn");
                                            attack = goblin.getDamage();
                                            armour = new Armour();
                                            armour.setItem(character.getcurArmour());
                                            defence = armour.getOverallEffect();
                                        
                                            int special = goblin.getSpecialAbilities();
                                            if (special != 0 )
                                            {
                                                attack = special;
                                                System.out.println("Special ability of 3 extra damage used");
                                            }
                                            System.out.println(goblin.getName() + " attacks with " + attack + " attacking power");
                                            System.out.println(character.getName() + " defends with " + defence + " defensive strength with " + armour.getName() + " armour");
                                            charHealth = character.getCurrHealth() -(Math.max(0,attack - defence));
                                            character.setHealth(charHealth);
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " now has a health of " + character.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            if (charHealth <=0)
                                            {
                                                System.out.println("==================================");
                                                System.out.println("Battle over!" + goblin.getName() + " has won the battle!");
                                                System.out.println("GAME OVER!!!");
                                                System.out.println("==================================");
                                            
                                                done = 1;
                                                battleFinished = 1;
                                                warfinished = 1;
                                            }
                                        }
                                    }
                                }
                                //Enemy is Slime if enemyChoice meets the required range
                                else if (enemyChoice < slimeProbability)
                                {
                                    Enemies slime = new Slime();
                                    System.out.println("\nYour enemy for the battle will be: " + slime.getName());
                                    
                                    int done = 0;
                                    int attack;
                                    int defence;
                                    
                                    enemyHealth = slime.getCurrHealth();
                                    
                                    while (done ==0)
                                        {
                                        System.out.println("Choose method of attack");
                                        Scanner sc7 = new Scanner(System.in);
                                        System.out.println("1. Attack with weapon");
                                        System.out.println("2.Use potion");
                                        System.out.println("3. Attack using weapon with enchantments");
                                        attackChoice = sc7.nextInt();

                                        switch(attackChoice)
                                        {
                                            case 1:
                                            //Attack with weapon
                                                    if (done == 0)
                                                    {
                                                        weapon = new CurrentWeapon();
                                                        weapon.setItem(character.getcurWeapon());
                                                        attack = weapon.getOverallEffect();
                                                        defence = slime.getDefence();
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                        System.out.println(slime.getName() + " health: " + slime.getCurrHealth());
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                        System.out.println(slime.getName() + " defends with " + defence + " defensive strength");
                                                        enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                        slime.setHealth(enemyHealth);
                                                        System.out.println("----------------------------------");
                                                        System.out.println(slime.getName() + " now has a health of " + slime.getCurrHealth());
                                                        
                                                    }
                                            break;
                                            case 2:
                                            //Use potion
                                                String potionItem;
                                                potion = new Potions();
                                                character.getCurrentPotions();
                                                Scanner potionSelect = new Scanner(System.in);
                                                System.out.println("Type potion name from list");
                                                potionItem = potionSelect.nextLine();

                                                potion.setItem(potionItem);
                                                try
                                                    {
                                                        //Use potion if it is available
                                                        if (character.getPotion(potionItem).equals(potionItem))
                                                        {
                                                            character.removePotions(potionItem);

                                                            //If it is healing, use it to restore character's health
                                                            if (potion.getSymbol() =='H')
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a healing potion");
                                                                character.setHealth(character.getCurrHealth() + potion.getOverallEffect());
                                                                System.out.println(character.getName() + " now has new health of " + character.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }

                                                            //If it is damaging, use it to attack enemy
                                                            else if (potion.getSymbol() == 'D')
                                                            {
                                                                attack = potion.getOverallEffect();
                                                                defence = slime.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a damaging potion");
                                                                System.out.println(character.getName() + " attacks using " + potion.getName() + " with " + attack);
                                                                System.out.println(slime.getName() + " defends with " + defence + " defensive strength");
                                                                System.out.println("----------------------------------");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                slime.setHealth(enemyHealth);
                                                                System.out.println(slime.getName() + " now has a health of " + slime.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }
                                                        }
                                                    }
                                                    catch (NullPointerException e)
                                                    {
                                                        System.out.println("----------------------------------");
                                                        System.out.println("No such weapon in inventory");
                                                        System.out.println("----------------------------------");
                                                    }
                                            break;

                                            case 3:
                                               //Add enchantments to weapon attack
                                                if (done == 0)
                                                {
                                                    String enchantmentChoice;
                                                    System.out.println("--------------------------------");
                                                    System.out.println("Enchantments: ");
                                                    AddEnchantments twoDamage = new TwoDamage(new CurrentWeapon());
                                                    AddEnchantments fiveDamage = new FiveDamage(new CurrentWeapon());
                                                    AddEnchantments fireDamage = new FireDamage(new CurrentWeapon());
                                                    AddEnchantments powerUp = new PowerUp(new CurrentWeapon());
                                                    System.out.println(twoDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                                                    System.out.println(fiveDamage.getEnchantment() + " costing " + fiveDamage.enchantmentCost());
                                                    System.out.println(fireDamage.getEnchantment() + " costing " + fireDamage.enchantmentCost());
                                                    System.out.println(powerUp.getEnchantment() + " costing " + powerUp.enchantmentCost());
                                                    System.out.println("--------------------------------");
                                                    System.out.println("Current gold: " + character.getGold());
                                                    Scanner enchantmentSelect = new Scanner(System.in);
                                                    System.out.println("Choose enchantments to add to " + character.getcurWeapon());
                                                    enchantmentChoice = enchantmentSelect.nextLine();
                                
                                                    //Proceed to payment if enchantment is available
                                                    if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= twoDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - twoDamage.enchantmentCost());
                                                            weapon = new TwoDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = slime.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(slime.getName() + " health: " + slime.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(slime.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            slime.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(slime.getName() + " now has a health of " + slime.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            done =1;
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= fiveDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - fiveDamage.enchantmentCost());
                                                            weapon = new FiveDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = slime.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(slime.getName() + " health: " + slime.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(slime.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            slime.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(slime.getName() + " now has a health of " + slime.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            done  =1;
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= fireDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - fireDamage.enchantmentCost());
                                                            weapon = new FireDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = slime.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(slime.getName() + " health: " + slime.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(slime.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            slime.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(slime.getName() + " now has a health of " + slime.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            done=1;
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= powerUp.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - powerUp.enchantmentCost());
                                                            weapon = new PowerUp(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = slime.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(slime.getName() + " health: " + slime.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(slime.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            slime.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(slime.getName() + " now has a health of " + slime.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            done =1;
                                                        }
                                                        
                                                    }
                                                    else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Please enter valid enchantment");
                                                            System.out.println("----------------------------------");
                                                            done = 1;
                                                        }

                                                
                                                }
                                            break;
                                            
                                        }
                                        //Battle ends if enemy health is less than or equal to 0 and character is awarded
                                        if (enemyHealth <=0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println("Battle over!" + character.getName() + " has won the battle!");
                                            System.out.println(character.getName() + " will receive " + slime.goldAward());
                                            System.out.println("----------------------------------");
                                            character.setGold(character.getGold() + slime.goldAward());
                                            charHealth = (int)Math.min(character.getMaxHealth(), character.getCurrHealth()*1.5);
                                            character.setHealth(character.getCurrHealth() + charHealth);
                                            if (slimeProbability - 0.05 > 0.05)
                                            {
                                                slimeProbability = slimeProbability - 0.05;
                                            }
                                            if (goblinProbability - 0.05 > 0.05)
                                            {
                                                goblinProbability = goblinProbability - 0.05;
                                            }
                                            if (ogreProbability - 0.05 > 0.05)
                                            {
                                                ogreProbability = ogreProbability - 0.05;
                                            }
                                            if (totalBattles == 0)
                                            {
                                                dragonProbability = dragonProbability + 0.15; 
                                            }
                                            else
                                            {
                                                dragonProbability = dragonProbability + 0.05; 
                                            }
                                            done = 1;
                                            battleFinished = 1;
                                        }
                                        if (done ==0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                            System.out.println(slime.getName() + " health: " + slime.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            System.out.println(slime.getName() + " attack turn");
                                            attack = slime.getDamage();
                                            armour = new Armour();
                                            armour.setItem(character.getcurArmour());
                                            defence = armour.getOverallEffect();
                                            if (slime.getSpecialAbilities() == 0)
                                            {
                                                System.out.println(slime.getName() + " attack causes no damage special ability.");
                                                attack = 0;
                                            }
                                            System.out.println(slime.getName() + " attacks with " + attack + " attacking power");
                                            System.out.println(character.getName() + " defends with " + defence + " defensive strength with " + armour.getName() + " armour");
                                            charHealth = character.getCurrHealth() -(Math.max(0,attack - defence));
                                            character.setHealth(charHealth);
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " now has a health of " + character.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            if (charHealth <=0)
                                            {
                                                System.out.println("==================================");
                                                System.out.println("Battle over!" + slime.getName() + " has won the battle!");
                                                System.out.println("GAME OVER!!!");
                                                System.out.println("==================================");
                                                done = 1;
                                                battleFinished = 1;
                                                warfinished = 1;
                                            }
                                        }
                                    }
                                }
                                //Enemy is dragon if rewuired range is met by enemyChoice
                                else if (enemyChoice < dragonProbability)
                                {
                                    Enemies dragon = new Dragon();
                                    System.out.println("\nYour enemy for the battle will be: " + dragon.getName());
                                    int done = 0;
                                    int attack;
                                    int defence;
                                    
                                    enemyHealth = dragon.getCurrHealth();
                                    
                                    while (done ==0)
                                        {
                                        System.out.println("Choose method of attack");
                                        Scanner sc7 = new Scanner(System.in);
                                        System.out.println("1. Attack with weapon");
                                        System.out.println("2.Use potion");
                                        System.out.println("3. Attack using weapon with enchantments");
                                        attackChoice = sc7.nextInt();

                                        switch(attackChoice)
                                        {
                                            case 1:
                                            //Attack with weapon
                                                    if (done == 0)
                                                    {
                                                        weapon = new CurrentWeapon();
                                                        weapon.setItem(character.getcurWeapon());
                                                        attack = weapon.getOverallEffect();
                                                        defence = dragon.getDefence();
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                        System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                                        System.out.println("----------------------------------");
                                                        System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                        System.out.println(dragon.getName() + " defends with " + defence + " defensive strength");
                                                        enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                        dragon.setHealth(enemyHealth);
                                                        System.out.println("----------------------------------");
                                                        System.out.println(dragon.getName() + " now has a health of " + dragon.getCurrHealth());
                                                    }
                                            break;
                                            case 2:
                                            //Use potion
                                                String potionItem;
                                                potion = new Potions();
                                                character.getCurrentPotions();
                                                Scanner potionSelect = new Scanner(System.in);
                                                System.out.println("Type potion name from list");
                                                potionItem = potionSelect.nextLine();

                                                potion.setItem(potionItem);
                                                try
                                                    {
                                                        if (character.getPotion(potionItem).equals(potionItem))
                                                        {
                                                            character.removePotions(potionItem);
                                                            if (potion.getSymbol() =='H')
                                                            {
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a healing potion");
                                                                character.setHealth(character.getCurrHealth() + potion.getOverallEffect());
                                                                System.out.println(character.getName() + " now has new health of " + character.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }
                                                            else if (potion.getSymbol() == 'D')
                                                            {
                                                                attack = potion.getOverallEffect();
                                                                defence = dragon.getDefence();
                                                                System.out.println("----------------------------------");
                                                                System.out.println(potion.getName() + " is a damaging potion");
                                                                System.out.println(character.getName() + " attacks using " + potion.getName() + " with " + attack);
                                                                System.out.println(dragon.getName() + " defends with " + defence + " defensive strength");
                                                                System.out.println("----------------------------------");
                                                                enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                                dragon.setHealth(enemyHealth);
                                                                System.out.println(dragon.getName() + " now has a health of " + dragon.getCurrHealth());
                                                                System.out.println("----------------------------------");
                                                            }
                                                            character.removePotions(potionItem);
                                                        }
                                                    }
                                                    catch (NullPointerException e)
                                                    {
                                                        System.out.println("----------------------------------");
                                                        System.out.println("No such potion in inventory");
                                                        System.out.println("----------------------------------");
                                                    }
                                            break;
                                            
                                            case 3:
                                            //Add enchantments to weapon for attack
                                                if (done == 0)
                                                {
                                                    String enchantmentChoice;
                                                    System.out.println("--------------------------------");
                                                    System.out.println("Enchantments: ");
                                                    AddEnchantments twoDamage = new TwoDamage(new CurrentWeapon());
                                                    AddEnchantments fiveDamage = new FiveDamage(new CurrentWeapon());
                                                    AddEnchantments fireDamage = new FireDamage(new CurrentWeapon());
                                                    AddEnchantments powerUp = new PowerUp(new CurrentWeapon());
                                                    System.out.println(twoDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                                                    System.out.println(fiveDamage.getEnchantment() + " costing " + fiveDamage.enchantmentCost());
                                                    System.out.println(fireDamage.getEnchantment() + " costing " + fireDamage.enchantmentCost());
                                                    System.out.println(powerUp.getEnchantment() + " costing " + powerUp.enchantmentCost());
                                                    System.out.println("--------------------------------");
                                                    System.out.println("Current gold: " + character.getGold());
                                                    Scanner enchantmentSelect = new Scanner(System.in);
                                                    System.out.println("Choose enchantments to add to " + character.getcurWeapon());
                                                    enchantmentChoice = enchantmentSelect.nextLine();
                                
                                                    //Proceed to payment if enchantment is available
                                                    if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= twoDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - twoDamage.enchantmentCost());
                                                            weapon = new TwoDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = dragon.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(dragon.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            dragon.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(dragon.getName() + " now has a health of " + dragon.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= fiveDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - fiveDamage.enchantmentCost());
                                                            weapon = new FiveDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = dragon.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(dragon.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            dragon.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(dragon.getName() + " now has a health of " + dragon.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= fireDamage.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - fireDamage.enchantmentCost());
                                                            weapon = new FireDamage(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = dragon.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(dragon.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            dragon.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(dragon.getName() + " now has a health of " + dragon.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            
                                                        }
                                                        
                                                    }
                                                    //Proceed to payment if enchantment is available
                                                    else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                                    {
                                                        //If player has enough gold, use enchantment
                                                        if (character.getGold() >= powerUp.enchantmentCost())
                                                        {
                                                            character.setGold(character.getGold() - powerUp.enchantmentCost());
                                                            weapon = new PowerUp(new CurrentWeapon());
                                                            weapon.setItem(character.getcurWeapon());
                                                            attack = weapon.getOverallEffect();
                                                            defence = dragon.getDefence();
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                                            System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                                            System.out.println("----------------------------------");
                                                            System.out.println(character.getName() + " attacks with " + attack + " attacking power " + "using " + character.getcurWeapon());
                                                            System.out.println(dragon.getName() + " defends with " + defence + " defensive strength");
                                                            enemyHealth = enemyHealth -(Math.max(0,attack - defence));
                                                            dragon.setHealth(enemyHealth);
                                                            System.out.println("----------------------------------");
                                                            System.out.println(dragon.getName() + " now has a health of " + dragon.getCurrHealth());
                                                        
                                                        }
                                                        else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Not enough funds to add enchantment");
                                                            System.out.println("----------------------------------");
                                                            
                                                        }
                                                        
                                                    }
                                                    else
                                                        {
                                                            System.out.println("----------------------------------");
                                                            System.out.println("Please enter valid enchantment");
                                                            System.out.println("----------------------------------");
                                                            done = 1;
                                                        }

                                                
                                                }
                                            break;
                                        
                                        }
                                        //Battle ends if dragon health is less than or equal to 0. The game also ends with the player completing all levels
                                        if (enemyHealth <=0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println("Battle over!" + character.getName() + " has won the battle!");
                                            System.out.println("===================================");
                                            System.out.println("Congratulations! You have finished the game!");
                                            System.out.println("===================================");
                                            System.out.println("----------------------------------");
                                            done = 1;
                                            battleFinished = 1;
                                            warfinished =1;
                                        }
                                        if (done ==0)
                                        {
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " health: " + character.getCurrHealth());
                                            System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            System.out.println(dragon.getName() + " attack turn");
                                            attack = dragon.getDamage();
                                            armour = new Armour();
                                            armour.setItem(character.getcurArmour());
                                            defence = armour.getOverallEffect();
                                            int special = dragon.getSpecialAbilities();
                                            
                                            if (special == 1)
                                            {
                                                System.out.println(dragon.getName() + " inflicts twice the damage with special ability.");
                                                attack = dragon.getDamage()*2;    
                                            }
                                            else if (special == 2)
                                            {
                                                System.out.println("Increase health by 10 with special ability");
                                                dragon.setHealth(dragon.getCurrHealth()+10);
                                                System.out.println(dragon.getName() + " health: " + dragon.getCurrHealth());
                                            }
                                            System.out.println(dragon.getName() + " attacks with " + attack + " attacking power");
                                            System.out.println(character.getName() + " defends with " + defence + " defensive strength with " + armour.getName() + " armour");
                                            charHealth = character.getCurrHealth() -(Math.max(0,attack - defence));
                                            character.setHealth(charHealth);
                                            System.out.println("----------------------------------");
                                            System.out.println(character.getName() + " now has a health of " + character.getCurrHealth());
                                            System.out.println("----------------------------------");
                                            if (charHealth <=0)
                                            {
                                                System.out.println("==================================");
                                                System.out.println("Battle over!" + dragon.getName() + " has won the battle!");
                                                System.out.println("GAME OVER!!!");
                                                System.out.println("==================================");
                                                
                                                done = 1;
                                                battleFinished = 1;
                                                warfinished = 1;
                                            }
                                        }
                                    }
                                }
                                totalBattles = totalBattles+1;
                            }
                        }
                    }
                    catch( NullPointerException e)
                    {
                        System.out.println("----------------------------------");
                        System.out.println("Please give character a name!");
                        System.out.println("----------------------------------");
                        battleFinished = 1;
                    }
                    break;

                    case 6:
                    System.out.println("Goodbye!");
                    System.out.println("----------------------------------");
                    warfinished = 1;
                    break;
                }
                
            }
        
        catch (InputMismatchException e)
        {
            System.out.println("Make sure option is numeric and is within the given numerical range");
        }
    }
}    
}
