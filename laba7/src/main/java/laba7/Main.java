package laba7;

import java.util.ArrayList;
import java.util.List;

/** data printer
 * gets data out of WordAnalytics solver
 * prints it on screen
 */
public class Main {
    public static void main(String[] args) throws Exception {
        long time = System.nanoTime();

        ArrayList<Person> personList = createPersonList();

        System.out.println((System.nanoTime() - time) * Math.pow(10, -6) + " millisec");
        getMemoryConsumption();
    }

    public static ArrayList<Person> createPersonList()
    {
        ArrayList<Person> personList = new ArrayList<>();
        Person person = new Person(0001,
                "loshka",
                "123457",
                "lol54321@gmail.com",
                "Klavdiy Oleh",
                25,
                "+38 034 917 65 65",
                997114,
                3,
                new String[]{"Playing piano", "Cooking", "Drawing"});

        Person person2 = new Person(0002,
                "andrew robinson",
                "123466",
                "andrew.bergna@yahoo.com",
                "Johnny A Robinson",
                51,
                "+413-536-6189",
                4100,
                75,
                new String[]{"Coding", "Playing with cat", "Bowling"});

        Person person3 = new Person(0003,
                "luisa511",
                "McPherson",
                "luisa1984@gmail.com",
                "Jeremy J Payne",
                47,
                "+805-426-4917",
                4100,
                63,
                new String[]{"Drawing", "Music listening"});
        return personList;
    }


    private static void getMemoryConsumption() {
        Runtime runtime = Runtime.getRuntime();
        runtime.gc();
        long memory = runtime.totalMemory() - runtime.freeMemory();
        System.out.printf("Memory used: %d B \n", memory);
    }
}