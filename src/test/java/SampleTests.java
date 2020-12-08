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
        aMap.put(0, "Jeronimo");
        aMap.put(2147483647, "Bombina");
        aMap.put(-2147483647, "Silvio");
        aMap.put(null, "100500");
        aMap.put(1, "");
        aMap.put(-1, null);
        aMap.put(null, "100501");
        aMap.put("", "");
        aMap.put("100600", "");
        aMap.put("xxx", "6");
        aMap.put(21474836475l, "Felicita");
        aMap.put(true, 3);

        Assert.assertEquals(aMap.get(0), "Jeronimo");
        Assert.assertEquals(aMap.get(2147483647), "Bombina");
        Assert.assertEquals(aMap.get(-2147483647), "Silvio");
        Assert.assertEquals(aMap.get(null), "100501");
        Assert.assertEquals(aMap.get(1), "");
        Assert.assertTrue(aMap.get(-1)==null);
        Assert.assertTrue(aMap.get("").equals(""));
        Assert.assertTrue(aMap.get("100600").equals(""));
        Assert.assertTrue(aMap.get("xxx").equals("6"));
        Assert.assertTrue(aMap.get(21474836475l).equals("Felicita"));
        Assert.assertTrue(aMap.get(true).equals(3));
        Assert.assertNull(aMap.get(false));
        Assert.assertNull(aMap.get(54321));
    }

    @Test
    public void checkSortedMap() throws NullPointerException{
        SortedMap sMap = new TreeMap<Integer, String>();;
        sMap.put(0, "Jeronimo");
        sMap.put(2147483647, "Bombina");
        sMap.put(-2147483647, "Silvio");
        sMap.put(1, "");
        sMap.put(-1, null);
        Assert.assertThrows(NullPointerException.class, ()->{sMap.put(null, "100500");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put("", "");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put("gg", "rf");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put(21474836475l, "rf");});
        Assert.assertThrows(ClassCastException.class, ()->{sMap.put(true, "rf");});

        Assert.assertEquals(sMap.get(0), "Jeronimo");
        Assert.assertEquals(sMap.get(2147483647), "Bombina");
        Assert.assertEquals(sMap.get(-2147483647), "Silvio");
        Assert.assertEquals(sMap.get(1), "");
        Assert.assertNull(sMap.get(-1));
    }

}

