import java.util.Random;
import java.util.Scanner;

public class World {
    public static void main(String[] args) throws InterruptedException {
        int menu = 0;

        System.out.print("Enter hero's name:  ");
        Scanner scanner = new Scanner(System.in);
        String name = scanner.nextLine();
        Random random = new Random();
        Hero hero = new Hero(200, random.nextInt(5, 15),
                random.nextInt(5,10 ), name, 0, 0);

        while (menu!=3){
            System.out.println("Where do you want to go?");
            System.out.println("1. To the trader");
            System.out.println("2. To the dark forest");
            System.out.println("3. Exit");
            menu = scanner.nextInt();

            switch (menu)
            {
                case 1:
                    System.out.println("Trader has day off today");
                    break;
                case 2:
                    Entity monster = null;
                    if(random.nextInt(2) == 1)
                        monster = new Goblin(100, random.nextInt(1, 10),
                                random.nextInt(5,10 ), name, 0, random.nextInt(10,20));
                    else
                        monster = new Skeleton(100, random.nextInt(5, 10),
                            random.nextInt(1,10 ), name, 0, random.nextInt(20,30));
                    BattleScene battleScene = new BattleScene(hero, monster);
                    Thread battle = new Thread(battleScene);
                    battle.start();
                    battle.join();
                    break;
                case 3:
                    System.out.println("Thank you and bye");
            }
        }

    }
}
