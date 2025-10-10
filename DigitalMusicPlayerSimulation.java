import java.util.Scanner;
// Track class (Encapsulation)
class Track {
    private String title;
    private String artist;
    private double duration; // in minutes
    private boolean isPlaying;

    Track(String title, String artist, double duration) {
        this.title = title;
        this.artist = artist;
        this.duration = duration;
        this.isPlaying = false;
    }

    // Getters
    public String getTitle() { return title; }
    public String getArtist() { return artist; }
    public double getDuration() { return duration; }
    public boolean isPlaying() { return isPlaying; }

    // Play track
    public void play() {
        isPlaying = true;
        System.out.println("Playing: " + title + " by " + artist);
    }

    // Pause track
    public void pause() {
        isPlaying = false;
        System.out.println("Paused: " + title);
    }
}

// Audio interface (Abstraction & Polymorphism)
interface Audio {
    void play();
    void pause();
}

// MP3Player class (Composition)
class MP3Player {
    private Track track1;
    private Track track2;
    private Track track3;

    private Track currentTrack;

    MP3Player(Track t1, Track t2, Track t3) {
        this.track1 = t1;
        this.track2 = t2;
        this.track3 = t3;
        this.currentTrack = t1; // default first track
    }

    // Play current track
    public void play() {
        currentTrack.play();
    }

    // Pause current track
    public void pause() {
        currentTrack.pause();
    }

    // Skip to next track
    public void skip() {
        if (currentTrack == track1) currentTrack = track2;
        else if (currentTrack == track2) currentTrack = track3;
        else currentTrack = track1;

        System.out.println("Skipped to: " + currentTrack.getTitle());
        currentTrack.play();
    }

    // Repeat current track
    public void repeat() {
        System.out.println("Repeating: " + currentTrack.getTitle());
        currentTrack.play();
    }

    // Show current track info
    public void showTrackInfo() {
        System.out.println("Now Playing: " + currentTrack.getTitle() +
                           " by " + currentTrack.getArtist() +
                           " (" + currentTrack.getDuration() + " min)");
    }
}

// Main class


public class DigitalMusicPlayerSimulation {
    public static void main(String[] args) {
        // Create individual tracks
        Track t1 = new Track("Shape of You", "Ed Sheeran", 4.2);
        Track t2 = new Track("Blinding Lights", "The Weeknd", 3.5);
        Track t3 = new Track("Believer", "Imagine Dragons", 3.8);

        // Create MP3 player with 3 tracks
        MP3Player player = new MP3Player(t1, t2, t3);

        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n--- MP3 Player Menu ---");
            System.out.println("1. Play");
            System.out.println("2. Pause");
            System.out.println("3. Skip");
            System.out.println("4. Repeat");
            System.out.println("5. Show Current Track");
            System.out.println("6. Exit");
            System.out.print("Enter choice: ");

            int choice = sc.nextInt();

            if (choice == 1) player.play();
            else if (choice == 2) player.pause();
            else if (choice == 3) player.skip();
            else if (choice == 4) player.repeat();
            else if (choice == 5) player.showTrackInfo();
            else if (choice == 6) {
                System.out.println("Exiting...");
                break;
            } else System.out.println("Invalid choice!");
        }

        sc.close();
    }
}
