public class Program {
    public static void main(String[] args) {
        Clock grandfather = new Clock(11, 17, 42);

        // tick the clock 5 times
        grandfather.tick(5);// time will now be 11:17:47

        // tick the clock 1 time
        grandfather.tick(); // time will now be 11:17:48

        // Prints "Current time is 11:17:48
        System.out.println("Current time is " + grandfather.getCurrentTime());
    }
}
