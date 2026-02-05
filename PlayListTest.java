import java.util.ArrayList;

//interface that defines the ADT
interface MusicPlayer{
    void addSong(String songName); //operations
        void play();
        void stop();

}

//implementatioon of ADT
class PlaylistMusicPlayer implements MusicPlayer{

    // data structure
    ArrayList<String> song = new ArrayList<>(); //store songs in order
    int currentIndex = 0; // data type: int, tracks current song
    boolean isPlaying = false; // data type: boolean, tracks play state

    // operation
    public void addSong(String songName){
        if(songName != null){ //invarint: song cant be null
            song.add(songName);  // updates data structure
            System.out.println(songName + " added to playlist ");
        }
    }

    public void play(){
        if(song.isEmpty()){ // invariant: cannot play if playlist is empty
           System.out.println("Playlist is empty");
        return;
     }
        if(!isPlaying){ //invariant: only start playing if it's not already playing
            isPlaying = true;
        }
        // access data structure
        System.out.println("Playing " + song.get(currentIndex)); // read from ArrayList

        //update ADt state
        currentIndex++; //move to next song
        if(currentIndex >= song.size()){ //invariant: looping back if the song list is at the end
            currentIndex = 0;
        }
    }

    public void stop(){
        if(isPlaying){ //Invariant: only stop if currently playing
            isPlaying = false;   // Updates ADT state
            System.out.println(" Music Stopped ");
        } else {
            System.out.println(" Music is already stopped ");
        }
    }
}


public class PlayListTest{
    public static void main (String [] args){
        //ADT referance type
        MusicPlayer player = new PlaylistMusicPlayer();  // ADT referance

        player.addSong(" Diamond Eyes ");
        player.addSong(" The Red ");
        player.addSong(" New Girl ");
        player.addSong(" About A Girl ");
        System.out.println(" ");
        player.play(); // plays first song
        player.play();  // plays next song
        player.play();
        player.play();
        player.play();  // oops back to first

        player.stop(); // stops the play back
    }
}

/*NOTES
    ADT: MusicPlayer Interface [abstract Operations]
    ADT referance: MusicPlayer player = new PlarlisMusicPlayer
    DATA Structure: Arraylist<String> song [concrete implementation]
    Data Type: int currentIndex, boolen isPLaying [actual values]
    Invariants: songName != null, !song.isEmpty() ensures valid operations [rules that always remain true]
    Operations: addSong(), play(), stop() */