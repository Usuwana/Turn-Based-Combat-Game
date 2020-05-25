import java.util.*;
import java.math.*;

public class Mainrun 
{
    public static void main(String[] args)
    {
        int choice;
        int warfinished = 0;
        String name;
        int gold = 0;
        String currentWeapon;
        String currentArmour;
        double slimeProbability = 0.5;
        double ogreProbability = 0.2;
        double dragonProbability = 0;
        double goblinProbability = 0.3;
        int dragonUse = 0;
        double enemyChoice = Math.random() *(0.5);
        GameCharacter character = new PlayerCharacter();
        Shop theShop = new Shop();
        Inventory weapon;


        while(warfinished==0)
        {   
            
            System.out.println("----------------------------------");
            System.out.println("\nCharacter name: " + character.getName());
            character.getCurrHealth();
            System.out.println("\nCurrent gold: " + character.getGold());
            gold = character.getGold();
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

            System.out.println("\n1. Go to Shop\n");
            System.out.println("2. Choose Character Name\n");
            System.out.println("3. Choose Weapon\n");
            System.out.println("4. Choose Armour\n");
            System.out.println("5. Start Battle\n");
            System.out.println("6. Exit\n");
            System.out.println("----------------------------------");
            Scanner sc = new Scanner(System.in);
            System.out.println("Pick an option from the menu\n");
            choice = sc.nextInt();
            System.out.println("----------------------------------");

            switch(choice)
            {
                case 1:
                    
                    int shopChoice;
                    System.out.println("1. Buy items");
                    System.out.println("2. Sell items");
                    System.out.println("----------------------------------");
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Select a numerical choice\n");
                    shopChoice = sc2.nextInt();
                    

                    switch(shopChoice)
                    {
                        case 1:
                            String item;
                            System.out.println("These are the available items: \n");
                            System.out.println("----------------------------------");
                            theShop.showShopContents();
                            System.out.println("----------------------------------");
                            /*System.out.println("Enchantments: ");
                            AddEnchantments twoDamage = new TwoDamage(new CurrentWeapon());
                            AddEnchantments fiveDamage = new FiveDamage(new CurrentWeapon());
                            AddEnchantments fireDamage = new FireDamage(new CurrentWeapon());
                            AddEnchantments powerUp = new PowerUp(new CurrentWeapon());
                            System.out.println(twoDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                            System.out.println(fiveDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                            System.out.println(fireDamage.getEnchantment() + " costing " + twoDamage.enchantmentCost());
                            System.out.println(powerUp.getEnchantment() + " costing " + twoDamage.enchantmentCost());*/
                            System.out.println("----------------------------------");
                            Scanner sc3 = new Scanner(System.in);
                            System.out.println("Type name of item you would like to buy\n");
                            
                            item = sc3.nextLine();
                            System.out.println("----------------------------------");

                            Inventory weaponChoose = new CurrentWeapon();
                            Inventory armourChoose = new Armour();
                            Inventory potionChoose = new Potions();

                            weaponChoose.setItem(item);
                            armourChoose.setItem(item);
                            potionChoose.setItem(item);

                            try
                            {
                                if (!(weaponChoose.getName().equals(null)))
                                {
                                    
                                    potionChoose = null;
                                    armourChoose = null;
                                    if (gold >= weaponChoose.getCost())
                                    {
                                        character.addWeapon(item);
                                        character.setGold(character.getGold() - weaponChoose.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        weaponChoose = null;
                                    }
                                }
                            }
                            catch (NullPointerException e)
                            {
                                System.out.println("No such weapon");
                            }
                            try
                            {
                                if (!(armourChoose.getName().equals(null)))
                                {
                                    
                                    weaponChoose = null;
                                    potionChoose = null;
                                    if (gold >= armourChoose.getCost())
                                    {
                                        character.addArmour(item);
                                        character.setGold(character.getGold() - armourChoose.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        armourChoose = null;
                                    }
                                }
                            }catch (NullPointerException e)
                            {
                                System.out.println("No such armour");
                            }
                            try
                            {
                                if (!(potionChoose.getName().equals(null)))
                                {
                                    
                                    weaponChoose = null;
                                    armourChoose = null;
                                    if (gold >= potionChoose.getCost())
                                    {
                                        character.addPotion(item);
                                        character.setGold(character.getGold() - potionChoose.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        potionChoose = null;
                                    }
                                }
                            }catch (NullPointerException e)
                            {
                                System.out.println("No such potion");
                            }
                        break;
                        case 2:
                            String sellItem;
                            weapon = new CurrentWeapon();
                            Inventory armour = new Armour();
                            Inventory potion = new Potions();
                            character.getCurrentArmoury();
                            character.getCurrentPotions();
                            character.getCurrentWeapons();
                            System.out.println("----------------------------------");
                            Scanner sc6 = new Scanner(System.in);
                            System.out.println("Select item you would like to sell");
                            sellItem = sc6.nextLine();

                            try
                            {
                                try
                                {
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
                                    System.out.println("No such weapon");
                                }
                                try
                                {
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
                                    if (!(character.getPotion(sellItem).equals(null)) && (character.getPotion(sellItem).equals(sellItem)))
                                    {
                                        potion.setItem(sellItem);
                                        character.setGold(character.getGold() + (int)(potion.getCost()*0.5));
                                        character.removePotions(sellItem);
                                    }
                                }
                                catch (NullPointerException e)
                                {
                                    System.out.println("No such potion");
                                }
                                
                            }
                            catch (IllegalArgumentException e)
                            {
                                System.out.println("No such inventory");
                            }
                            catch (NullPointerException e)
                            {
                                System.out.println("No such inventory");
                            }
                        break;
                    }

                    
                    
                break;

                case 2:
                    System.out.println("Enter name of character: ");
                    Scanner sc1 = new Scanner(System.in);
                    name = sc1.next();
                    character.setName(name + "\n");
                break;

                case 3:
                    
                    System.out.println("CURRENT WEAPONS IN INVENTORY: ");
                    character.getCurrentWeapons();
                    System.out.println("----------------------------------");
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("Type the name of a weapon to use from the current available weapons\n");
                    currentWeapon = sc4.nextLine();
                    System.out.println("----------------------------------");
                    System.out.println(currentWeapon + " has been selected.");
                    try
                    {
                        if (character.getWeapon(currentWeapon).equals(currentWeapon))
                        {
                            character.setWeapon(currentWeapon);
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("No such weapon in your possession");
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("No such weapon in your possession");
                    }
                    
                    

                break;

                case 4:

                    System.out.println("CURRENT ARMOUR IN INVENTORY: ");
                    character.getCurrentArmoury();
                    System.out.println("----------------------------------");
                    Scanner sc5 = new Scanner(System.in);
                    System.out.println("Type the name of a weapon to use from the current available weapons\n");
                    currentArmour = sc5.nextLine();
                    System.out.println("----------------------------------");
                    
                    System.out.println(currentArmour + " has been selected.");
                    try
                    {
                        if (character.getArmour(currentArmour).equals(currentArmour))
                        {
                            character.setArmour(currentArmour);
                        }
                    }
                    catch (IllegalArgumentException e)
                    {
                        System.out.println("No such armour in your possession");
                    }
                    catch (NullPointerException e)
                    {
                        System.out.println("No such armour in your possession");
                    }

                break;

                case 5:
                
                int charHealth = character.getCurrHealth();
                int enemyHealth;
                int battleFinished = 0;
                double maximumProbability = 0;
                
                slimeProbability = slimeProbability;
                ogreProbability = ogreProbability;
                dragonProbability = dragonProbability;
                goblinProbability = goblinProbability;
                
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
               
                int attackChoice = 0;
                System.out.println("Slime P: " + slimeProbability);
                System.out.println("Goblin P: " + goblinProbability);
                System.out.println("Ogre P: " + ogreProbability);
                System.out.println("Dragon P: " + dragonProbability);
                System.out.println("Enemy Choice: " + enemyChoice);
                System.out.println("Max probability: " + maximumProbability);
                  while(battleFinished ==0)
                  {
                        
                        System.out.print("Character name: " + character.getName()); 
            
                        if(enemyChoice < ogreProbability)
                        {
                            Enemies ogre = new Ogre();
                            int done = 0;
                            int attack;
                            int defence;
                            int goldAward;
                            enemyHealth = ogre.getCurrHealth();
                            System.out.println("\nYour enemy for the battle will be: " + ogre.getName());
                            
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
                                    case 2:
                                    //try
                                            String potionItem;
                                            Inventory potion = new Potions();
                                            character.getCurrentPotions();
                                            Scanner potionSelect = new Scanner(System.in);
                                            System.out.println("Type potion name from list");
                                            potionItem = potionSelect.nextLine();

                                            potion.setItem(potionItem);
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
                                    break;

                                    case 3:
                                        if (done == 0)
                                        {
                                            String enchantmentChoice;
                                            System.out.println("--------------------------------");
                                            System.out.println("Enchantments: ");
                                            //Inventory enchantedWeapon = new CurrentWeapon();
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
                        
                                            if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > twoDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fiveDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fireDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                            {
                                                if (character.getGold() > powerUp.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                        }
                                    break;
                                    
                                }

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
                                    if (dragonUse == 0)
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
                                    Inventory armour = new Armour();
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
                                    charHealth = charHealth -(Math.max(0,attack - defence));
                                    character.setHealth(charHealth);
                                    System.out.println("----------------------------------");
                                    System.out.println(character.getName() + " now has a health of " + character.getCurrHealth());
                                    System.out.println("----------------------------------");
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
                        else if(enemyChoice < goblinProbability)
                        {
                            Enemies goblin = new Goblin();
                            System.out.println("\nYour enemy for the battle will be: " + goblin.getName());
            
                            int done = 0;
                            int attack;
                            int defence;
                            int goldAward;
                            enemyHealth = goblin.getCurrHealth();
                            
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
                                        String potionItem;
                                        Inventory potion = new Potions();
                                        character.getCurrentPotions();
                                        Scanner potionSelect = new Scanner(System.in);
                                        System.out.println("Type potion name from list");
                                        potionItem = potionSelect.nextLine();

                                        potion.setItem(potionItem);
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
                                    break;

                                    case 3:
                                            if (done == 0)
                                            {
                                                String enchantmentChoice;
                                                System.out.println("--------------------------------");
                                                System.out.println("Enchantments: ");
                                                //Inventory enchantedWeapon = new CurrentWeapon();
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
                            
                                                if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                                {
                                                    if (character.getGold() > twoDamage.enchantmentCost())
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
                                                        System.out.println("Not enough funds to add enchantment");
                                                        done =1;
                                                    }
                                                    
                                                }
                                                else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                                {
                                                    if (character.getGold() > fiveDamage.enchantmentCost())
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
                                                        System.out.println("Not enough funds to add enchantment");
                                                        done =1;
                                                    }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fireDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                            {
                                                if (character.getGold() > powerUp.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                               
                                        }
                                    break;
                                    
                                }
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
                                    if (dragonUse == 0)
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
                                    Inventory armour = new Armour();
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
                                    charHealth = charHealth -(Math.max(0,attack - defence));
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
                        else if (enemyChoice < slimeProbability)
                        {
                            Enemies slime = new Slime();
                            System.out.println("\nYour enemy for the battle will be: " + slime.getName());
                            
                            int done = 0;
                            int attack;
                            int defence;
                            int goldAward;
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
                                        String potionItem;
                                        Inventory potion = new Potions();
                                        character.getCurrentPotions();
                                        Scanner potionSelect = new Scanner(System.in);
                                        System.out.println("Type potion name from list");
                                        potionItem = potionSelect.nextLine();

                                        potion.setItem(potionItem);
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
                                    break;

                                    case 3:
                                        if (done == 0)
                                        {
                                            String enchantmentChoice;
                                            System.out.println("--------------------------------");
                                            System.out.println("Enchantments: ");
                                            //Inventory enchantedWeapon = new CurrentWeapon();
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
                        
                                            if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > twoDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fiveDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done  =1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fireDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done=1;
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                            {
                                                if (character.getGold() > powerUp.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    done =1;
                                                }
                                                
                                            }

                                        
                                        }
                                    break;
                                    
                                }
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
                                    if (dragonUse == 0)
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
                                    Inventory armour = new Armour();
                                    armour.setItem(character.getcurArmour());
                                    defence = armour.getOverallEffect();
                                    if (slime.getSpecialAbilities() == 0)
                                    {
                                        System.out.println(slime.getName() + " attack causes no damage special ability.");
                                        attack = 0;
                                    }
                                    System.out.println(slime.getName() + " attacks with " + attack + " attacking power");
                                    System.out.println(character.getName() + " defends with " + defence + " defensive strength with " + armour.getName() + " armour");
                                    charHealth = charHealth -(Math.max(0,attack - defence));
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
                        else if (enemyChoice < dragonProbability)
                        {
                            Enemies dragon = new Dragon();
                            System.out.println("\nYour enemy for the battle will be: " + dragon.getName());
                            int done = 0;
                            int attack;
                            int defence;
                            int goldAward;
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
                                        String potionItem;
                                        Inventory potion = new Potions();
                                        character.getCurrentPotions();
                                        Scanner potionSelect = new Scanner(System.in);
                                        System.out.println("Type potion name from list");
                                        potionItem = potionSelect.nextLine();

                                        potion.setItem(potionItem);
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
                                    break;
                                    
                                    case 3:
                                        if (done == 0)
                                        {
                                            String enchantmentChoice;
                                            System.out.println("--------------------------------");
                                            System.out.println("Enchantments: ");
                                            //Inventory enchantedWeapon = new CurrentWeapon();
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
                        
                                            if (enchantmentChoice.equals(twoDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > twoDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fiveDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fiveDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(fireDamage.getEnchantment()))
                                            {
                                                if (character.getGold() > fireDamage.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    
                                                }
                                                
                                            }
                                            else if (enchantmentChoice.equals(powerUp.getEnchantment()))
                                            {
                                                if (character.getGold() > powerUp.enchantmentCost())
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
                                                    System.out.println("Not enough funds to add enchantment");
                                                    
                                                }
                                                
                                            }

                                        
                                        }
                                    break;
                                   
                                }
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
                                    Inventory armour = new Armour();
                                    armour.setItem(character.getcurArmour());
                                    defence = armour.getOverallEffect();
                                    int special = dragon.getSpecialAbilities();
                                    //System.out.println(dragon.getName() + " attacks with " + attack + " attacking power");
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
                                    charHealth = charHealth -(Math.max(0,attack - defence));
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
                        dragonUse = dragonUse+1;
                  }
                break;

                case 6:
                   System.out.println("Goodbye!");
                   System.out.println("----------------------------------");
                    warfinished = 1;
                break;
            }
        }

    }    
}