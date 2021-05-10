import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Coins {

    private Map<Integer, Integer> values = new HashMap();

    public int findMin(List<Integer> coins, int n) {

        if (n == 0)
            return 0;

        int result = n;

        for (int c : coins ) {
            if (c <= n) {
                int aux;
                if (values.containsKey(n-c)) {
                    aux = values.get(n-c);
                } else {
                    aux = findMin(coins, n-c);
                    values.put(n-c, aux);
                }

                if (aux < result)
                    result = aux + 1;
            }
        }

        return result;
    }

    public String showMap() {
        return values.toString();
    }


}
