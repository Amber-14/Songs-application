import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("album1","Alan Walker");
        album1.addSong("Faded",4.5);
        album1.addSong("Darkside",3.2);
        album1.addSong("Unstoppable",3.4);
        album1.addSong("Beliver",4);

        LinkedList<Song> playlist = new LinkedList<>();
        album1.addToPlaylist("Faded",playlist);
        album1.addToPlaylist("Beliver",playlist);
//        System.out.println(album1.addToPlaylist("abc",playlist));if song is not present
        album1.addToPlayList(2,playlist);

        //printList(playlist);
        play(playlist);
    }
    public static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> it = playlist.listIterator();
        if(!it.hasNext()){
            System.out.println("");
            return;
        }
        System.out.println("You are now listening: "+ it.next().getTitle());
        showMenu();

        while (true){
            int option = sc.nextInt();
            switch (option){
                case 0:
                    System.out.println("Thank you for listening ");
                    return;
                case 1:
                    showMenu();
                    break;
                case 2:
                    printList(playlist);
                    break;
            }
        }
    }
    public static void printList(LinkedList<Song> playlist){
        ListIterator<Song> it = playlist.listIterator(); // advantage of iterator can move forward and backword
        while (it.hasNext()){
            System.out.println(it.next());
        }
        return;
    }
    public static void showMenu(){

        System.out.println("0. Exit");
        System.out.println("1. Print Menu");
        System.out.println("2. Print the list of all song in the playlist");
        System.out.println("3. Play next Song");
        System.out.println("4. Play previous song");
        System.out.println("5. Repeat the Song");
        System.out.println("6. Delete the song");
    }
}
