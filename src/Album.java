import java.util.ArrayList;
import java.util.LinkedList;

public class Album {
    String name;
    String artist;
    ArrayList<Song> songs;

    public Album(String name, String artist) {
        this.name = name;
        this.artist = artist;
        this.songs = new ArrayList<>();
    }
    //find song
    public boolean findSong(String title){
        for(Song checkSong: songs){
            if(checkSong.getTitle() == title){
                System.out.println("Song found");
                return true;
            }
        }
//        System.out.println("Song not found");
        return false;
    }
    //add new song
    public boolean addSong(String title,double duration){
        if(findSong(title)==true){
            System.out.println("Song already present");
            return false;
        }

        //if song is not present;
        //Song newSong  = new Song(title,duration);
        this.songs.add(new Song(title,duration)); //add it to the albums songs
        return true;
    };
    public boolean addToPlaylist(String title, LinkedList<Song> playlist){
        for(Song checkedSong:songs){
            if(checkedSong.getTitle().equals(title)){
                playlist.add(checkedSong);
                return true;
            }
        }
        return false;
    }
    public boolean addToPlayList(int trackNumber,LinkedList<Song> playlist){
        int index = trackNumber-1;
        if(index>=0 && index<=this.songs.size()-1){
            playlist.add(this.songs.get((index)));
            return true;

        }
        return false;
    }
}
