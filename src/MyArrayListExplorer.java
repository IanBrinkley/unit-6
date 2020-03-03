import java.util.ArrayList;
import java.util.Arrays;

public class MyArrayListExplorer {
    public static void main(String[] args) {
        MyArrayListExplorer exp = new MyArrayListExplorer();

        ArrayList<Integer> integers = new ArrayList<Integer>(Arrays.asList(1, 3, 4, 0, 8, 1, 0));
        exp.removeZeros(integers);
        System.out.println(integers); //expect [1, 3, 4, 8, 1]

        ArrayList<String> strings = new ArrayList<String>(Arrays.asList("hello", "my", "name", "is", "Mr. Smith"));
        System.out.println(exp.countLetters(strings)); //expect 22
        
        System.out.println(exp.findPosition(3, integers)); //expect 1

        ArrayList<String> parseTest = exp.parseIntoArrayList("West Linn");
        System.out.println(parseTest); //expect [W, e, s, t,  , L, i, n, n]

        ArrayList<Person> people = new ArrayList<Person>(Arrays.asList(new Person(25, "Bob"), new Person(16, "Zach"), new Person(20, "Ian"), new Person(21, "Aidan")));
        System.out.println(exp.findMin(people));

        Purse wallet = new Purse();
        wallet.add(new Coin(0.50, "Half Dollar"));
        wallet.add(new Coin(0.25, "Quarter"));
        wallet.add(new Coin(0.01, "Penny"));
        wallet.add(new Coin(0.01, "Penny"));
        wallet.add(new Coin(0.10, "Dime"));
        wallet.add(new Coin(0.05, "Nickel"));
        wallet.add(new Coin(0.10, "Dime"));
        System.out.println(wallet.count(new Coin(0.01, "Penny"))); //expect 2
        System.out.println(wallet.getSmallest()); //expect Penny
        System.out.println(wallet.getTotal()); //expect 1.02
    }
    public void removeZeros(ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == 0) list.remove(i--);
        }
    }
    public int countLetters(ArrayList<String> list) {
        int sum = 0;
        for (String n : list) {
            sum += n.length();
        }
        return sum;
    }
    public int findPosition(int keyValue, ArrayList<Integer> list) {
        for (int i = 0; i < list.size(); i++) {
            if (list.get(i) == keyValue) return i;
        } return -1;
    }
    public ArrayList<String> parseIntoArrayList(String str) {
        ArrayList<String> fin = new ArrayList<String>();
        for (int i = 0; i < str.length(); i++) {
            fin.add(str.substring(i, i + 1));
        }
        return fin;
    }
    public String findMin(ArrayList<Person> list) {
        int minIndex = 0;
        for (int i = 1; i < list.size(); i++) {
            if (list.get(i).getAge() < list.get(minIndex).getAge()) {
                minIndex = i;
            }
        }
        return list.get(minIndex).getName();
    }
}

class Person {
    private int myAge;
    private String myName;
    public Person(int age, String name) {
        myAge = age;
        myName = name;
    }
    public int getAge() {
        return myAge;
    }
    public String getName() {
        return myName;
    }
}

// A Coin represents a real world coin such as a "quarter" which
// has a value of 0.25, a "half dollar" which has value of 0.50, etc.
// A class invariant holds that 0.00 < all coin values <= 1.00
class Coin {
    private double myValue;
    private String myName;
    public Coin(double value, String name) {
        myValue = value;
        myName = name;
    }
    public double getValue() {
        return myValue;
    }
    public String getName() {
        return myName;
    }
    public boolean equals(Coin aCoin) {
        return (myValue == aCoin.getValue() && myName.equals(aCoin.getName()));
    }
}
// A Purse holds a collection of Coins
class Purse {
    private ArrayList<Coin> coins;
    public Purse() {
        coins = new ArrayList<Coin>();
    }
    public void add(Coin aCoin) {
        coins.add(aCoin);
    }
    public double getTotal() {
        double sum = 0;
        for (Coin c : coins) {
            sum += c.getValue();
        }
        return sum;
    }
    public int count(Coin aCoin) {
        int count = 0;
        for (Coin c : coins) {
            if (c.equals(aCoin)) count++;
        }
        return count;
    }
    public String getSmallest() {
        int smallestIndex = 0;
        for (int i = 1; i < coins.size(); i++) {
            if (coins.get(i).getValue() < coins.get(smallestIndex).getValue()) {
                smallestIndex = i;
            }
        }
        return coins.get(smallestIndex).getName();
    }
}
