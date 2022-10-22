package bitmanipulation;

public class BaseSixteen {

    public BaseSixteen() {}

    public String convertToHex(Integer num) {
        if (num == null || num == 0) return "0";

        char[] map = new char[] {'0','1','2','3','4','5','6','7','8','9','a','b','c','d','e','f'};
        StringBuilder sb = new StringBuilder();

        while (num != 0) {
            int index = num & 15;
            sb.append(map[index]);
            num = num >>> 4;
        }

        return sb.reverse().toString();
    }
}
