import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {


        List<Integer> coins = new ArrayList<>();
        coins.add(1);
        coins.add(22);
        coins.add(10);
        coins.add(7);
        int n = 1222;
        Coins coins1 = new Coins();
        System.out.println("The minimum amount of coins is: " + coins1.findMin(coins, n));
    }
}
