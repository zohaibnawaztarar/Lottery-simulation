import java.util.Random;
import java.util.HashSet;
import java.util.*;
/**
 * This class includes the main menu, user input and lottery game to compare and draw lottery results.
 * 
 * @author Zohaib Tarar
 * @version 1.0
 */
public class Lottery
{    
    private MySet temp;
    private MySet userInput;
    private MySet lotto;

    // Defines the maximum lottery number
    int LOTTERY_MAX = 49; 

    /**
     * Constructor for objects of class Lottery
     */
    public Lottery()
    {
        userInput = new MySet();
        lotto = new MySet();   
    }

    /**
     * Main method which is Entry point for the program.
     *     
     * @param String[] Args
     * return none
     */
    public static void main(String args[])
    {         
        Lottery lottery = new Lottery();        
        lottery.process();
    }

    /**
     * Process the user choice for menu.
     *
     */
    private void process()
    {
        char choice; // To hold value of choice entered by user
        do
        {
            choice=menu();
            processchoice(choice);
        } while (choice != 'q' && choice != 'Q');
    }

    /**
     * Display a menu, validate the user's input and return the choice they made
     * 
     * @param   none
     * @return  char x, the validated choice made by the user
     */
    private char menu()
    {
        char choice=' ';
        boolean valid=false;

        while (!valid)
        {
            System.out.println('\u000C'); // Clears screen
            System.out.println("Please make a choice, and press ENTER");
            System.out.println("P - Play Lottery");
            System.out.println("L - List Of Prizes");
            System.out.println("Q - Quit");        

            // Asks for user input
            choice=Genio.getCharacter(); 

            switch (choice)
            {
                case 'P':
                case 'p':
                case 'L':
                case 'l':
                case 'Q':
                case 'q': 
                valid=true;
                break;
                default: System.out.println("That is not a valid choice, please try again"); // Incase user enters wrong value
                pressKey();
                break;         
            }
        }

        return choice;
    }

    /**
     * Process the choice made by the user
     * 
     * @param   choice
     * @return  none
     */
    private void processchoice(char choice)
    {
        switch (choice)
        {
            case 'P': 
            case 'p':  randomNums(); //calls for the method to generate random numbers
            break;

            case 'L':
            case 'l':  getPrizeDetails(); // Call for getPrizeDetails method to show prizes
            break;            

            case 'Q':
            case 'q': System.out.println("\nGoodbye!\n\nYou may now close the program!");
            default:    
            break;
        }
    }

    /**
     * Displays prize values 
     * 
     * @param  none
     * @return none 
     */
    public void getPrizeDetails()
    {
        System.out.println("\tList Of Prizes");
        System.out.println("--------------------------------------------------------------------------------------");   
        System.out.println("3 matched numbers =  £25");
        System.out.println("4 matched numbers =  £100");
        System.out.println("5 matched numbers =  £1000");
        System.out.println("6 matched numbers =  £100,000");
        System.out.println("--------------------------------------------------------------------------------------");   
        pressKey(); // Calls the press key method to allow details to remain on screen
    }

    /**
     * Creates a 'pause' effect to allow details to remain on screen
     * 
     * @param  none
     * @return none 
     */
    public static void pressKey()
    {
        String s;
        System.out.println("\t\nPress return to continue: ");
        s = Genio.getString();
    }    

    /**
     * This method creates the random numbers and put them in set
     *
     */
    public void randomNums()
    {
        Random randGenerator = new Random();
        for(int i=0; i<6; i++)
        {
            int num; //Variable to hold the random number
            // generates a random number between 1 and 49
            num = (randGenerator.nextInt(49)) + 1;
            lotto.addToSet(num);     //Adds the generated number to set          
        } 
        userInput(); //Calls the userinput method
    }

    /**
     * This Method ask the user for input and then performs the split string method.
     *
     */
    public void userInput()
    {
        // ask the user for input
        System.out.println("Please enter 6 numbers between one and " + LOTTERY_MAX + " in the format 1,2,3,4,5,6");
        String input = Genio.getString();
        int number = 0;
        // Split string to integer
        String[] splitString = input.split(",");

        for(int i = 0; i <= 5; i++)
        {
            number = Integer.parseInt(splitString[i]);
            if(number > LOTTERY_MAX || number < 1)
            {
                System.out.println("Numbers must be between 1 and " + LOTTERY_MAX); //incase user enters the numbers which are out of range
                userInput(); // Sends user back to start of method and tells them to make thier input valid
            }
            userInput.addToSet(number); // Add number to set
        }        
        compareSets(); // calls for compare set method
    }

    /**
     * This method adds the all numbers to set to compare it against random generated number
     *
     * @param number A parameter
     * @return result
     */
    public boolean addToSet(int num)
    {
        Integer nextNumber = new Integer(num);
        boolean result = lotto.addToSet(nextNumber);
        return result;
    }

    /**
     * Method to compare sets 
     *
     */
    public void compareSets()
    {
        temp = userInput;
        temp = temp.intersection(lotto, userInput);
        calcuateWinnings();
    }

    /**
     * Method to calculate winning and display it to the user
     *
     */
    public void calcuateWinnings()
    {
        int match = temp.getCardinality();

        switch(match)
        {
            case 0: 
            case 1: 
            case 2: System.out.println("Sorry! You have no matched numbers, Please Try Again!");
            break;            

            case 3: System.out.println("Congratulations! You have 3 matched numbers, you have won £25!");
            break;

            case 4: System.out.println("Congratulations! You have 4 matched numbers, you have won £100!");
            break;

            case 5: System.out.println("Congratulations! You have 5 matched numbers, you have won £1000!");
            break;

            case 6: System.out.println("Congratulations! You have 6 matched numbers, you have won £100,000!");
            break;
        }
        pressKey(); // Calls the press key method to allow details to remain on screen         
    }
}
