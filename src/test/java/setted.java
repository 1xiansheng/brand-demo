
import com.alibaba.fastjson.JSON;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class setted {
    public static void main(String[] args) {

        Map<String, String> map = new HashMap<>();

        map.put("1", "zhangsan");
        map.put("2", "lisi");
        map.put("3", "wangwu");
        map.put("4", "zhaoli");

        String s2 = JSON.toJSONString(map);
        System.out.println(s2);
        HashMap hashMap = JSON.parseObject("{\"1\":\"zhangsan\",\"2\":\"lisi\",\"3\":\"wangwu\",\"4\":\"zhaoli\"}", HashMap.class);
        System.out.println(hashMap);
        System.out.println("1-----------------------");

        //遍历
        Set<String> keySet = map.keySet();
        for (String s : keySet) {
            //System.out.println(s);
            String s1 = map.get(s);
            System.out.println(s + "=" + s1);
        }

        System.out.println("---------------");
        Iterator<String> iterator = map.keySet().iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            String s = map.get(next);
            System.out.println(next + "=" + s);
        }

        System.out.println("-----------------");
        Iterator<String> iterator1 = map.values().iterator();
        while (iterator1.hasNext()) {
            String next = iterator1.next();
            System.out.println(next);
        }

        System.out.println("-----------");
        Iterator<Map.Entry<String, String>> iterator2 = map.entrySet().iterator();
        while (iterator2.hasNext()) {
            Map.Entry<String, String> next = iterator2.next();
            String key = next.getKey();
            String value = next.getValue();
            System.out.println(key + "=" + value);
        }


        System.out.println("----------");
        map.forEach((k, y) -> System.out.println(k + "=" + y));

    }

}
