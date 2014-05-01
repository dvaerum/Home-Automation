package HOME.CodeGene.ByteTest;

import java.util.*;

public class JavaTestFileSmall {
    public void start(Integer test) {
        List<Integer> list = new ArrayList<Integer>();
        List<List<Integer>> list2 = new ArrayList<>();
        Map<String, Integer> map = new TreeMap<>();
        list.add(7);
        list.add(19);
        list.get(2);
        list2.add(list);
        list2.get(2).get(0);
        Double x = 2.0d;
        System.out.println(x);

//        map.put("Test", 65);
//        map.put("Test2",650);
//        map.get("Test");
    }
    int start2(Integer test) {
        int y = 100;
        System.out.println(y);
        return y;
    }
}
