package backend;


import java.util.*;
import java.util.concurrent.TimeUnit;


/**
 * Hello world!
 */
public final class App {
    private App() {
    }

    static Date upDate = new Date(	796780800000L);

    /**
     * Says hello to the world.
     * @param args The arguments of the program.
     */
    public static void main(String[] args) {
        System.out.println((int)TimeUnit.MILLISECONDS.toDays(new Date().getTime() - upDate.getTime()) / 365);
    }
}