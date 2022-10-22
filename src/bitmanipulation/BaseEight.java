package bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;

public class BaseEight {
    private final ArrayList<Integer> store = new ArrayList<>();

    public BaseEight() {}

    public Integer toBaseEight(Integer num) {
        if (num == null) return num;

        while (num != 0) {
            int temp = num % 8;
            store.add(temp);
            num = num / 8;
        }

        int result = 0;
        Collections.reverse(store);
        for (int val : store) {
            result = result * 10 + val;
        }

        return result;
    }
}
