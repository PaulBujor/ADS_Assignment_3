import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {

    private Map<Integer, Integer> values = new HashMap();

    public int findMin(List<Integer> coins, int n) {

        //base case
        if (n == 0)
            return 0;

        //Assigning max to result
        int result = n;

        //Go through every coins
        for (int c : coins ) {

            //Check if the amount is greater than the coin
            if (c <= n) {
                int aux;

                //Check if the value exists in the HashMap, if not - add it.
                if (values.containsKey(n-c)) {
                    aux = values.get(n-c);
                } else {
                    aux = findMin(coins, n-c);
                    values.put(n-c, aux);
                }

                //Save the best result
                if (aux < result)
                    result = aux + 1;
            }
        }

        return result;
    }
}
