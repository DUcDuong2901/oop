// TabooTest.java
// Taboo class tests -- nothing provided.
import org.junit.Test;

import java.util.*;

import static junit.framework.TestCase.assertEquals;

public class TabooTest {
    @Test
    public void testnoFollow() {
        List<String> input = Arrays.asList("a", "c", "a", "b");
        Taboo<String> taboo = new Taboo<>(input);
        Set<String> noFollowSet = taboo.noFollow("a");
        Set<String> expectedSet = new HashSet<>(Arrays.asList("c", "b"));
        assertEquals(expectedSet, noFollowSet);
    }



    @Test
    public void testReduce() {
        List<String> input = new ArrayList<>(Arrays.asList("a", "c", "a", "b"));
        Taboo<String> taboo = new Taboo<>(input);
        List<String> toReduce = new ArrayList<>(Arrays.asList("a", "c", "b", "x", "c", "a"));
        taboo.reduce(toReduce);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("a", "x", "c"));
        assertEquals(expectedOutput, toReduce);
    }
    @Test
    public void testReduce2()
        {

        List<String> input = new ArrayList<>(Arrays.asList("a", "c", "a", "b"));
        Taboo<String> taboo = new Taboo<>(input);
        List<String> toReduce = new ArrayList<>(Arrays.asList("a", "b", "c", "c", "d"));
        taboo.reduce(toReduce);
        List<String> expectedOutput = new ArrayList<>(Arrays.asList("a", "d"));
        assertEquals(expectedOutput, toReduce);




    }
}
