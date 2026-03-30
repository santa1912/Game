import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        Blackjack game = new Blackjack();

        game.showYouCard();
        game.showComputerCard();

        while(!game.isEnd()){

            System.out.print("Want another card? (y/n): ");
            String ans = sc.next();

            if(ans.equalsIgnoreCase("n")){
                break;
            }

            game.addMoreCard();
            game.showYouCard();
            game.showComputerCard();
        }

        game.showSumCard();
        game.checkWinner();

        System.out.println("The winner is " + game.getWinner());

        sc.close();
    }
}