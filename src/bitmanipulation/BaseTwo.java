package bitmanipulation;

import java.util.ArrayList;
import java.util.Collections;

public class BaseTwo {
    private final ArrayList<Integer> store = new ArrayList<>();
    BaseTwo() {}
    public Integer toBaseTwo(Integer num) {
        if (num == null) return num;

        while (num != 0) {
            int temp = num % 2;
            store.add(temp);
            num = num / 2;
        }

        int result = 0;
        Collections.reverse(store);
        for (int val : store) {
            result = result * 10 + val;
        }
        return result;
    }
}
