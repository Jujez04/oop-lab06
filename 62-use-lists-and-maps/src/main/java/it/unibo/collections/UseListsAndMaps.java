package it.unibo.collections;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * Example class using {@link List} and {@link Map}.
 *
 */
public final class UseListsAndMaps {

    private final static int SIZE = 1000;
    private final static int NEWSIZE = 100000;

    private UseListsAndMaps() {
    }

    /**
     * @param s
     *            unused
     */
    public static void main(final String... s) {
        /*
         * 1) Create a new ArrayList<Integer>, and populate it with the numbers
         * from 1000 (included) to 2000 (excluded).
         */
        ArrayList<Integer> arrayInt = new ArrayList<>();
        for(int i = 0; i < SIZE; i++){
            arrayInt.add((i + SIZE));
        }
        System.out.println(arrayInt);
        /*
         * 2) Create a new LinkedList<Integer> and, in a single line of code
         * without using any looping construct (for, while), populate it with
         * the same contents of the list of point 1.
         */
        LinkedList<Integer> linkedListInt = new LinkedList<>(arrayInt);
        /*
         * 3) Using "set" and "get" and "size" methods, swap the first and last
         * element of the first list. You can not use any "magic number".
         * (Suggestion: use a temporary variable)
         */
        int temp = arrayInt.get(SIZE - 1);
        arrayInt.set(SIZE - 1, arrayInt.get(0));
        arrayInt.set(0, temp);
        /*
         * 4) Using a single for-each, print the contents of the arraylist.
         */
        for (Integer i : arrayInt) {
            System.out.println(i);
        }
        /*
         * 5) Measure the performance of inserting new elements in the head of
         * the collection: measure the time required to add 100.000 elements as
         * first element of the collection for both ArrayList and LinkedList,
         * using the previous lists. In order to measure times, use as example
         * TestPerformance.java.
         */
        long time = System.nanoTime();
        for (int i = 0; i < NEWSIZE; i++) {
            arrayInt.add(i);
        }
        time = System.nanoTime() - time;
        var millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + arrayInt.size()
                + " ints to Intger and inserting them in a ArrayList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        for (int i = 0; i < NEWSIZE; i++) {
            linkedListInt.add(i);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Converting "
                + linkedListInt.size()
                + " ints to Integer and inserting them in a LinkedList took "
                + time
                + "ns ("
                + millis
                + "ms)"
        );
        /*
         * 6) Measure the performance of reading 1000 times an element whose
         * position is in the middle of the collection for both ArrayList and
         * LinkedList, using the collections of point 5. In order to measure
         * times, use as example TestPerformance.java.
         */
        time = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            arrayInt.get(NEWSIZE/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading the middle element 1000 times in " 
                + "ArrayList" 
                + "("
                + millis
                + "ms)"
        );
        time = System.nanoTime();
        for (int i = 0; i < SIZE; i++) {
            linkedListInt.get(NEWSIZE/2);
        }
        time = System.nanoTime() - time;
        millis = TimeUnit.NANOSECONDS.toMillis(time);
        System.out.println(// NOPMD
            "Reading the middle element 1000 times in " 
                + "LinkedList" 
                + "("
                + millis
                + "ms)"
        );
        /*
         * 7) Build a new Map that associates to each continent's name its
         * population:
         *
         * Africa -> 1,110,635,000
         *
         * Americas -> 972,005,000
         *
         * Antarctica -> 0
         *
         * Asia -> 4,298,723,000
         *
         * Europe -> 742,452,000
         *
         * Oceania -> 38,304,000
         */
        Map<String,Long> earth = new HashMap<>();
        earth.put("Africa", 1110635000L);
        earth.put("Americas", 972005000L);
        earth.put("Antartica", 0L);
        earth.put("Asia", 4298723000L);
        earth.put("Europe", 742452000L);
        earth.put("Oceania", 38304000L);
        /*
         * 8) Compute the population of the world
         */
        for (String i : earth.keySet()) {
            System.out.println(i + " " + earth.get(i));
        }
    }
}
