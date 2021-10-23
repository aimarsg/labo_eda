package eda;

public class Reloj {
    private final long start;

    //Create a stopwatch object./
    public Reloj() {
        start = System.currentTimeMillis();
    }

    // Return elapsed time (in seconds) since this object was created.*/
    public double elapsedTime() {
        long now = System.currentTimeMillis();
        return (now - start) / 1000.0;
    }
}


