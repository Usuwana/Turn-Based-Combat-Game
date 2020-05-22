import java.util.*;

public class Mainrun 
{
    public static void main(String[] args)
    {
        int choice;
        int finished = 0;
        String name;
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
                    int item;

                    System.out.println("These are the available items: \n");
                    System.out.println("----------------------------------");
                    theShop.showShopContents();
                    System.out.println("----------------------------------");
                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Pick an item you would like to buy\n");
                    System.out.println("Type 10 to go back to main menu\n");
                    item = sc2.nextInt();
                    System.out.println("----------------------------------");

                    switch(item)
                    {
                        case 1:
                            character.addWeapon("Short Sword");
                        break;
                        case 2:
                            character.addWeapon("Great Axe");
                        break;
                        case 3:
                            character.addWeapon("Magic Staff");
                        break;
                        case 4:
                            character.addArmour("Leather Armour");
                        break;
                        case 5:
                            character.addArmour("Chain Mail");
                        break;
                        case 6:
                            character.addArmour("Dragon Skin");
                        break;
                        case 7:
                            character.addPotion("Potion of Healing");
                        break;
                        case 8:
                            character.addPotion("Potion of Greater Healing");
                        break;
                        case 9:
                            character.addPotion("Explosive Potion");
                        break;
                        case 10:
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
                    Scanner sc3 = new Scanner(System.in);
                    System.out.println("Type the name of a weapon to use from the current available weapons\n");
                    currentWeapon = sc3.nextLine();
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
                    Scanner sc4 = new Scanner(System.in);
                    System.out.println("Type the name of a weapon to use from the current available weapons\n");
                    currentArmour = sc4.nextLine();
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