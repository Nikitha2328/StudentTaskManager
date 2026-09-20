import java.util.ArrayList;

public class ArrayListDemo {

    public static void main(String[] args) {

        ArrayList<String> names = new ArrayList<>();

        names.add("Nikitha");
        names.add("Rahul");
        names.add("Priya");

        System.out.println(names);

        System.out.println("First name: " + names.get(0));

        System.out.println("Total names: " + names.size());

        names.remove("Rahul");

        System.out.println(names);
    }
}