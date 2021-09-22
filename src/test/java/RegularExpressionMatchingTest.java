import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class RegularExpressionMatchingTest {
    @Test
    void testSimpleCaseReturningFalse() {
        String s = "aa";
        String p = "a";
        assertFalse(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testRecurringElementReturnsTrue() {
        String s = "aa";
        String p = "a*";
        assertTrue(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testRecurringWildcardElementReturnsTrue() {
        String s = "ab";
        String p = ".*";
        assertTrue(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testZeroRepetitionsInString() {
        String s = "aab";
        String p = "c*a*b";
        assertTrue(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testMississippiFalse() {
        String s = "mississippi";
        String p = "mis*is*p*.";
        assertFalse(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testWildCardRepeatingCaseTrue() {
        String s = "edgecaset";
        String p = ".*t";
        assertTrue(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testWildCardRepeatingCaseFalse() {
        String s = "edgecasec";
        String p = ".*t";
        assertFalse(RegularExpressionMatching.isMatch(s, p));
    }

    @Test
    void testWildCardRepeatingCaseComplexTrue() {
        String s = "edgecasetttccca";
        String p = ".*t*b*c*a";
        assertTrue(RegularExpressionMatching.isMatch(s, p));
    }
}
