package Labb3;

public class TheGame extends Methods{

    // Här körs spelet
    public static void main(String[] args) {

        Methods x = new Methods();

        System.out.println("");
        System.out.println("************************");
        System.out.println("* Welcome to The Game! *");
        System.out.println("************************");
        System.out.print("Enter your name:");

        //Anropar självaste spelet
        x.init();
    }
}




