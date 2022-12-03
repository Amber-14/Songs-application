import java.util.Iterator;
import java.util.LinkedList;
import java.util.ListIterator;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Album album1 = new Album("album1","Alan Walker");
        album1.addSong("Song1",4.5);
        album1.addSong("Song2",3.2);
        album1.addSong("Song3",3.4);
        album1.addSong("Song4",4);

        LinkedList<Song> playlist = new LinkedList<>();
        album1.addToPlaylist("Song1",playlist);
        album1.addToPlaylist("Song2",playlist);
//        System.out.println(album1.addToPlaylist("abc",playlist));if song is not present
        album1.addToPlayList(3,playlist);

        //printList(playlist);
        play(playlist);
    }
    public static void play(LinkedList<Song> playlist){
        Scanner sc = new Scanner(System.in);
        ListIterator<Song> itr = playlist.listIterator();
        if(!itr.hasNext()){
            System.out.println("");
            return;
        }
        System.out.println("You are now listening: "+ itr.next().getTitle());
        showMenu();

        boolean forward = true; // to check the case of next-prev or prev-next;
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
                    if(playlist.size()>0){
                        printList(playlist);
                    }else{
                        System.out.println("Your playlist is empty !");
                    }
                    break;
                case 3:
                    if(!forward){
                        if(itr.hasNext()){
                            itr.next();
                        }
                    }
                    if(!itr.hasNext()){
                        System.out.println("You reached at end of playlist");
                    }else{
                        System.out.println("You are listening "+ itr.next());
                    }
                    forward=true;
                    break;
                case 4:
                    if(forward){
                        if(itr.hasPrevious()){
                            itr.previous();
                        }
                    }
                    if(!itr.hasPrevious()){
                        System.out.println("You reached at start of playlist");
                    }else{
                        System.out.println("You are listening "+ itr.previous());
                    }
                    forward=false;
                    break;
                case 5: //repeat the song
                    if(forward){
                        if(itr.hasPrevious()){
                            System.out.println("Now playing "+itr.previous().toString());
                            forward = false;
                        }else {
                            System.out.println("we are at the start of the list");
                        }
                    }else {
                        if(itr.hasNext()){
                            System.out.println("now playing "+itr.next().toString());
                            forward = true;
                        }else {
                            System.out.println("we have reached to the end of list");
                        }
                    }
                    break;
                case 6://remove the song from the list
                    if(forward){
                        if(itr.hasNext()){
                            itr.remove();
                            System.out.println("you are listening "+itr.next());
                            forward=true;
                        }else{ //if list contains only one element
                            if(itr.hasPrevious()){
                                itr.remove();
                                System.out.println("You are listening "+itr.previous());
                                forward=false;
                            }
                        }
                    }else{
                        if(itr.hasPrevious()){
                            itr.remove();
                            System.out.println("you are listening "+itr.previous());
                            forward = false;
                        }else{
                            itr.remove();
                            System.out.println("Your playlist is empty");
                        }
                    }
                    break;
//                    if (playlist.size() >0){
//                        itr.remove();
//                        if(itr.hasNext()){
//                            System.out.println("now playing "+itr.next().toString());
//                        }
//                        else {
//                            if(itr.hasPrevious())
//                                System.out.println("now playing "+itr.previous().toString());
//                        }
//                    }else{
//                        System.out.println("Can't delete,playlist is empty!");
//                    }
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
