import java.util.*;

public class Mainrun 
{
    public static void main(String[] args)
    {
        int choice;
        int finished = 0;
        String name;
        int gold = 0;
        String currentWeapon;
        String currentArmour;
        GameCharacter character = new PlayerCharacter();
        Shop theShop = new Shop();


        while(finished==0)
        {   
            
            System.out.println("----------------------------------");
            System.out.print("Character name: ");
            character.getName();
            character.getCurrHealth();
            System.out.println("\nCurrent gold: " + character.getGold());
            gold = character.getGold();
            System.out.println("");
            System.out.println("CURRENT ARMOURY IN INVENTORY: ");
            character.getCurrentArmoury();
            System.out.println("");
            System.out.println("CURRENT POTIONS IN INVENTORY: ");
            character.getCurrentPotions();
            System.out.println("");
            System.out.println("CURRENT WEAPONS IN INVENTORY: ");
            character.getCurrentWeapons();
            System.out.println("----------------------------------");
            System.out.println("\nCURRENT WEAPON IN HAND: ");
            System.out.println(character.getcurWeapon());
            System.out.println("\nCURRENT PROTECTIVE ARMOUR IN HAND: ");
            System.out.println(character.getcurArmour());
            System.out.println("\nCURRENT PORTION IN HAND: ");
            System.out.println(character.getcurPotion());
            System.out.println("");
            System.out.println("----------------------------------");

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
                            int item;
                            System.out.println("These are the available items: \n");
                            System.out.println("----------------------------------");
                            theShop.showShopContents();
                            System.out.println("----------------------------------");
                            Scanner sc3 = new Scanner(System.in);
                            System.out.println("Pick an item you would like to buy\n");
                            System.out.println("Type 10 to go back to main menu\n");
                            item = sc3.nextInt();
                            System.out.println("----------------------------------");

                            switch(item)
                            {
                                case 1:
                                    Inventory sword = new Weapons();
                                    sword.setItem("Short Sword");
                                    if (gold >= sword.getCost())
                                    {
                                        character.addWeapon("Short Sword");
                                        //Inventory sword = new Weapons();
                                        //sword.setItem("Short Sword");
                                        character.setGold(character.getGold() - sword.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        sword = null;
                                    }
                                    

                                break;
                                case 2:
                                    Inventory axe = new Weapons();
                                    axe.setItem("Great Axe");
                                    if (gold >= axe.getCost())
                                    {
                                        character.addWeapon("Great Axe");
                                        //Inventory axe = new Weapons();
                                        //axe.setItem("Great Axe");
                                        character.setGold(character.getGold()-axe.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        axe = null;
                                    }

                                break;
                                case 3:
                                    Inventory staff = new Weapons();
                                    staff.setItem("Magic Staff");
                                    if (gold >= staff.getCost())
                                    {
                                        character.addWeapon("Magic Staff");
                                        //Inventory staff = new Weapons();
                                        //staff.setItem("Magic Staff");
                                        character.setGold(character.getGold()-staff.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        staff = null;
                                    }
                                    
                                break;

                                case 4:
                                    Inventory leather = new Armour();
                                    leather.setItem("Leather Armour");
                                    if (gold >= leather.getCost())
                                    {
                                        character.addArmour("Leather Armour");
                                        //Inventory leather = new Armour();
                                        //leather.setItem("Leather Armour");
                                        character.setGold(character.getGold()-leather.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        leather = null;
                                    }

                                break;

                                case 5:
                                    Inventory mail = new Armour();
                                    mail.setItem("Chain Mail");
                                    if (gold >= mail.getCost())
                                    {
                                        character.addArmour("Chain Mail");
                                        //Inventory mail = new Armour();
                                        //mail.setItem("Chain Mail");
                                        character.setGold(character.getGold()-mail.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        mail = null;
                                    }

                                break;

                                case 6:
                                    Inventory skin = new Armour();
                                    skin.setItem("Dragon Skin");
                                    if (gold >= skin.getCost())
                                    {
                                        character.addArmour("Dragon Skin");
                                        //Inventory skin = new Armour();
                                        //skin.setItem("Dragon Skin");
                                        character.setGold(character.getGold()-skin.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        skin = null;
                                    }


                                break;

                                case 7:
                                    Inventory healing = new Potions();
                                    healing.setItem("Potion of Healing");
                                    if (gold >= healing.getCost())
                                    {
                                        character.addPotion("Potion of Healing");
                                        //Inventory healing = new Potions();
                                        //healing.setItem("Potion of Healing");
                                        character.setGold(character.getGold()-healing.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        healing = null;
                                    }


                                break;

                                case 8:
                                    Inventory greaterHealing = new Potions();
                                    greaterHealing.setItem("Potion of Greater Healing");
                                    if (gold >= greaterHealing.getCost())
                                    {
                                        character.addPotion("Potion of Greater Healing");
                                        //Inventory greaterHealing = new Potions();
                                        //greaterHealing.setItem("Potion of Greater Healing");
                                        character.setGold(character.getGold()-greaterHealing.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        greaterHealing = null;
                                    }


                                break;

                                case 9:
                                    Inventory explosive = new Potions();
                                    explosive.setItem("Explosive Potion");
                                    if (gold >= explosive.getCost())
                                    {
                                        character.addPotion("Explosive Potion");
                                        //Inventory explosive = new Potions();
                                        //explosive.setItem("Explosive Potion");
                                        character.setGold(character.getGold()-explosive.getCost());
                                    }
                                    else
                                    {
                                        System.out.println("Not enough funds to buy, pick another option.");
                                        explosive = null;
                                    }
                                break;

                                case 10:
                                break;
                            }
                            break;
                        case 2:
                            String sellItem;
                            Inventory weapon = new Weapons();
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
                                if (character.getWeapon(sellItem).equals(sellItem))
                                {
                                    weapon.setItem(sellItem);
                                    character.setGold(character.getGold() + weapon.getCost());
                                    character.removeWeapon(sellItem);
                                }
                                else if (character.getArmour(sellItem).equals(sellItem))
                                {
                                    armour.setItem(sellItem);
                                    character.setGold(character.getGold() + armour.getCost());
                                    character.removeArmour(sellItem);
                                }
                                else if (character.getPotion(sellItem).equals(sellItem))
                                {
                                    potion.setItem(sellItem);
                                    character.setGold(character.getGold() + potion.getCost());
                                    character.removePotions(sellItem);
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
                            //System.out.println(character.getArmour(sellItem));
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
                    //String weapon = character.getWeapon(currentWeapon);
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
                   System.out.print("Character name: "); 
                   character.getName();
                   double enemyChoice = Math.random();
                   if (enemyChoice < 0.5)
                   {
                       Enemies enemy = new Slime();
                       System.out.println("Your enemy for the battle will be: " + enemy.getName());
                   }
                   else if(enemyChoice < 0.3)
                   {
                       Enemies enemy = new Goblin();
                       System.out.println("Your enemy for the battle will be: " + enemy.getName());
                   }
                   else if(enemyChoice < 0.2)
                   {
                       Enemies enemy = new Ogre();
                       System.out.println("Your enemy for the battle will be: " + enemy.getName());
                   }
                break;

                case 6:
                   System.out.println("Goodbye!");
                   System.out.println("----------------------------------");
                    finished = 1;
                break;
            }
        }

    }    
}