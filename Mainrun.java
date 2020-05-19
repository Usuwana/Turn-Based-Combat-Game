import java.util.*;

public class Mainrun 
{
    public static void main(String[] args)
    {
        int choice;
        int finished = 0;
        String name;
        GameCharacter character = new PlayerCharacter();
        Shop theShop = new Shop();

        while(finished==0)
        {
            System.out.println("1. Go to Shop\n");
            System.out.println("2. Choose Character Name\n");
            System.out.println("3. Choose Weapon\n");
            System.out.println("4. Choose Armour\n");
            System.out.println("5. Start Battle\n");
            System.out.println("6. Exit\n");

            Scanner sc = new Scanner(System.in);
            System.out.println("Pick an option from the menu\n");
            choice = sc.nextInt();

            switch(choice)
            {
                case 1:
                   /*int item;
                    System.out.println("1. Show all weapons\n");
                    System.out.println("2. Show all armour\n");
                    System.out.println("3. Show all portions\n");
                    System.out.println("4. Back to main menu\n");

                    Scanner sc2 = new Scanner(System.in);
                    System.out.println("Pick an option from the menu\n");
                    item = sc2.nextInt();

                    switch(item)
                    {
                        case 1:
                        break;
                        case 2:
                        break;
                        case 3:
                        break;
                    }*/
                    System.out.println("These are the available items: \n");
                    theShop.showShopContents();
                    
                break;

                case 2:
                    System.out.println("Enter name of character: ");
                    Scanner sc1 = new Scanner(System.in);
                    name = sc1.next();
                    character.setName(name);
                break;

                case 3:
                break;

                case 4:
                break;

                case 5:
                    character.getName();
                break;

                case 6:
                    finished = 1;
                break;
            }
        }

    }    
}