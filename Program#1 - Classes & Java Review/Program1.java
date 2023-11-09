import java.util.Scanner;

public class Program1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        //create instances of albums to be changed by user
       Album album1=new Album();
       Album album2=new Album();
       Album album3=new Album();

        System.out.println("Tell me about three of your favorite albums.");

        // First album
        System.out.println("What is the name of your first album?");
        album1.setTitle(scanner.next());
        System.out.println("Who is the artist?");
        album1.setPerformer(scanner.next());
        System.out.println("What genre is this album?");
        album1.setGenre(scanner.next());
        System.out.println("How many songs are on the album? Please enter an integer");
        // Need a try/catch in case the user doesn't enter an integer
        try{
            album1.setNumSongs(scanner.nextInt());
        } catch(Exception e){
            System.out.println("Sorry! That isn't an integer. I'm going to guess you meant 10");
        }
        System.out.println(album1.toString());
        System.out.println("Thank you :) Now tell me about a second album");

        // Second album
        System.out.println("What is the name of your second album?");
        album2.setTitle(scanner.next());
        System.out.println("Who is the artist?");
        album2.setPerformer(scanner.next());
        System.out.println("What genre is this album?");
        album2.setGenre(scanner.next());
        System.out.println("How many songs are on the album?");
        // Need a try/catch in case the user doesn't enter an integer
        try{
            album2.setNumSongs(scanner.nextInt());
        } catch(Exception e){
            System.out.println("Sorry! That isn't an integer. I'm going to guess you meant 10");
        }
        System.out.println(album2.toString());
        System.out.println("Thank you :) Now tell me about a third album");

        //Third album
        System.out.println("What is the name of your third album?");
        album3.setTitle(scanner.next());
        System.out.println("Who is the artist?");
        album3.setPerformer(scanner.next());
        System.out.println("What genre is this album?");
        album3.setGenre(scanner.next());
        System.out.println("How many songs are on the album?");
        // Need a try/catch in case the user doesn't enter an integer
        try{
            album1.setNumSongs(scanner.nextInt());
        } catch(Exception e){
            System.out.println("Sorry! That isn't an integer. I'm going to guess you meant 10");
        }
        System.out.println(album3.toString());
        System.out.println("Thank you :)");
        scanner.close();
    }
}
