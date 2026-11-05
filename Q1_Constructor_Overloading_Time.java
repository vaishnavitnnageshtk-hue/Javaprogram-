/*
 * Constructors | Q1
 * WAP to explain constructor overloading by displaying time in
 * seconds, minutes and hours.
 *
 * Constructor overloading = same constructor name, different parameter lists.
 * The compiler picks the constructor by the NUMBER of arguments passed.
 */
class Time {
    private final int totalSeconds;

    // 1 argument: total seconds
    Time(int seconds) {
        totalSeconds = seconds;
    }

    // 2 arguments: minutes and seconds
    Time(int minutes, int seconds) {
        totalSeconds = minutes * 60 + seconds;
    }

    // 3 arguments: hours, minutes and seconds
    Time(int hours, int minutes, int seconds) {
        totalSeconds = hours * 3600 + minutes * 60 + seconds;
    }

    void display() {
        int h = totalSeconds / 3600;
        int m = (totalSeconds % 3600) / 60;
        int s = totalSeconds % 60;
        System.out.println("Time        : " + h + " hours, " + m + " minutes, " + s + " seconds");
        System.out.println("In seconds  : " + totalSeconds);
        System.out.printf("In minutes  : %.2f%n", totalSeconds / 60.0);
        System.out.printf("In hours    : %.4f%n", totalSeconds / 3600.0);
    }
}

public class Main {
    public static void main(String[] args) {
        System.out.println("--- Time(int seconds) -> Time(3725) ---");
        new Time(3725).display();

        System.out.println("\n--- Time(int minutes, int seconds) -> Time(125, 30) ---");
        new Time(125, 30).display();

        System.out.println("\n--- Time(int hours, int minutes, int seconds) -> Time(2, 45, 30) ---");
        new Time(2, 45, 30).display();
    }
}
