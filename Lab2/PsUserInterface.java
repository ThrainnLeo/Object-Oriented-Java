
import Ps.PsLogic;
import cardutils.Card;

import java.util.Scanner;

public class PsUserInterface {
    private PsLogic Pslogic;
    private Scanner scan;

    public PsUserInterface() {
        Pslogic = new PsLogic();
        scan = new Scanner(System.in);
    }

    public void run(){
        char choise = ' ';
        String answer;

        do{
            PrintMenu();
            answer = scan.nextLine();
            answer = answer.toUpperCase();
            choise = answer.charAt(0);

            switch (choise) {
                case 'N':
                    NewGame();
                    break;
                case 'X':
                    System.out.println("Bye Bye!");
                    break;
                default:
                    System.out.println("Unknown command!");
            }
        }while(choise != 'X');
    }
    public void NewGame(){
        System.out.println(" Initializing new game!");
        Pslogic.initNewGame();
        System.out.println("Ready!");

        while(!Pslogic.isGameOver()){
            PickACard();
        }

        System.out.println("Game over!");
        System.out.println("You got: " + Pslogic.getPoints() + " points");

    }

    public void PickACard(){
        Card nextCard = Pslogic.pickNextCard();
        System.out.println(Pslogic.toString());
        System.out.println("Next card: " + nextCard.toShortString());
        System.out.println("Select a pile [0...4]: ");
        String answer = scan.nextLine();

        int index = Integer.parseInt(answer.trim());
        Pslogic.addCardToPile(index);
    }

    public void PrintMenu(){
        System.out.println("--------Menu--------");
        System.out.println("N Start a new game");
        System.out.println("X Exit");
        System.out.println("--------------------");

    }

}
