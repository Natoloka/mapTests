import org.junit.Assert;
import org.junit.Test;

import java.util.HashMap;
import java.util.Map;
import java.util.SortedMap;
import java.util.TreeMap;

public class SampleTests {

    @Test
    public void checkHashMap() {
        Map aMap = new HashMap<Integer, String>();
        aMap.put(-2147483647, "Silvio");
//        expected in HashMap types
        Assert.assertEquals(aMap.get(-2147483647), "Silvio");
//        key is null
        aMap.put(null, "100500");
        Assert.assertEquals(aMap.get(null), "100500");
//        rewrite value where key is null
        aMap.put(null, "100501");
        Assert.assertEquals(aMap.get(null), "100501");
//        value is empty String
        aMap.put(1, "");
        Assert.assertEquals(aMap.get(1), "");
//        value is null
        aMap.put(-1, null);
        Assert.assertTrue(aMap.get(-1)==null);
//        key is empty String
        aMap.put("", "");
        Assert.assertTrue(aMap.get("").equals(""));
//        key is String
        aMap.put("xxx", "6");
//        key is Long
        aMap.put(21474836475l, "Felicita");
        Assert.assertTrue(aMap.get(21474836475l).equals("Felicita"));
//        key is boolean, value int
        aMap.put(true, 3);
        Assert.assertTrue(aMap.get(true).equals(3));
//        try with non-existed boolean key
        Assert.assertNull(aMap.get(false));
    }

    @Test
    public void checkSortedMap() throws NullPointerException{
        SortedMap sMap = new TreeMap<Integer, String>();;
        sMap.put(0, "Jeronimo");
        Assert.assertEquals(sMap.get(0), "Jeronimo");
        sMap.put(2147483647, "Bombina");
        Assert.assertEquals(sMap.get(2147483647), "Bombina");
        sMap.put(-2147483647, "Silvio");
        Assert.assertEquals(sMap.get(-2147483647), "Silvio");
        sMap.put(1, "");
        Assert.assertEquals(sMap.get(1), "");
        sMap.put(-1, null);
        Assert.assertNull(sMap.get(-1));

        Assert.assertThrows(NullPointerException.class, ()->{sMap.put(null, "100500");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put("", "");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put("gg", "rf");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put(21474836475l, "rf");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put(true, "rf");});

    }

}
