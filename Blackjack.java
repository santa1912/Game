import java.util.Random;

public class Blackjack {

    // Attributes
    private int[] cardYou = new int[5];
    private int[] cardComputer = new int[5];
    private int numYourCard = 2;
    private int numComputerCard = 2;
    private int sumYou = 0;
    private int sumComputer = 0;
    private String winner = "";

    private Random rand = new Random();

    // Constructor
    public Blackjack() {

        // initial cards
        cardYou[0] = rand.nextInt(11) + 1;
        cardYou[1] = rand.nextInt(11) + 1;

        cardComputer[0] = rand.nextInt(11) + 1;
        cardComputer[1] = rand.nextInt(11) + 1;

        // fix 11 + 11
        if(cardYou[0]==11 && cardYou[1]==11){
            cardYou[1] = 1;
        }

        if(cardComputer[0]==11 && cardComputer[1]==11){
            cardComputer[1] = 1;
        }

        sumYou = cardYou[0] + cardYou[1];
        sumComputer = cardComputer[0] + cardComputer[1];

        // check initial 21
        if(sumYou == 21 && sumComputer == 21){
            winner = "Computer";
        }
        else if(sumYou == 21){
            winner = "You";
        }
        else if(sumComputer == 21){
            winner = "Computer";
        }
    }

    public void showYouCard(){
        System.out.print("You : ");
        for(int i=0;i<numYourCard;i++){
            System.out.print(cardYou[i] + " ");
        }
        System.out.println();
    }

    public void showComputerCard(){
        System.out.print("Computer : ");
        for(int i=0;i<numComputerCard;i++){
            System.out.print(cardComputer[i] + " ");
        }
        System.out.println();
    }

    public void addMoreCard(){

        // player
        if(numYourCard < 5){
            cardYou[numYourCard] = rand.nextInt(11) + 1;
            sumYou += cardYou[numYourCard];
            numYourCard++;
        }

        // computer auto draw
        if(sumComputer < 17 && numComputerCard < 5){
            cardComputer[numComputerCard] = rand.nextInt(11) + 1;
            sumComputer += cardComputer[numComputerCard];
            numComputerCard++;
        }
    }

    public void showSumCard(){
        System.out.println("\nSum of your cards = " + sumYou);
        System.out.println("Sum of computer cards = " + sumComputer);
    }

    public boolean isEnd(){

        if(sumYou > 21){
            winner = "Computer";
            return true;
        }

        if(sumYou == 21){
            winner = "You";
            return true;
        }

        if(sumComputer == 21){
            winner = "Computer";
            return true;
        }

        return false;
    }

    public void checkWinner(){

        if(winner.equals("")){
            if(sumYou > 21){
                winner = "Computer";
            }
            else if(sumComputer > 21){
                winner = "You";
            }
            else if(sumYou > sumComputer){
                winner = "You";
            }
            else{
                winner = "Computer";
            }
        }
    }

    public String getWinner(){
        return winner;
    }
}