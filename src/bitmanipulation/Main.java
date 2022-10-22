package bitmanipulation;

import java.util.HashMap;
import java.util.Map;

public class Main {
    public static void main(String[] args) {
        BaseTwo baseTwo = new BaseTwo();
        Integer base2 = baseTwo.toBaseTwo(4);
        System.out.println(base2);

        BaseEight baseEight = new BaseEight();
        Integer base8 = baseEight.toBaseEight(255);
        System.out.println(base8);

        BaseSixteen baseSixteen = new BaseSixteen();
        String base16 = baseSixteen.convertToHex(-1);
        System.out.println(base16);
    }
}
