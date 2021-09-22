public class RegularExpressionMatching {
    private static final char WILDCARD = '.';

    public static boolean isMatch(String s, String p) {
        int sPosition = 0;
        int pPosition = 0;

        while(sPosition < s.length()) {
            if(pPosition >= p.length()) {
                return false;
            }

            char sCurrent = s.charAt(sPosition);
            char pCurrent = p.charAt(pPosition);

            if(pCurrent == '*') {
                pPosition --;
                pCurrent = p.charAt(pPosition);

                if(pCurrent == '.') {
                    pPosition += 2;
                    if(pPosition >= p.length()) { return true; }

                    pCurrent = p.charAt(pPosition);
                    while(sPosition < s.length()) {
                        int sPositionIncrease = getNextPositionOfNextPCharInS(s.substring(sPosition, s.length()), pCurrent);
                        if (sPositionIncrease == -1) { return false; }

                        sPosition += sPositionIncrease;
                        boolean isSubStringMatch = isMatch(
                                    s.substring(sPosition, s.length()),
                                    p.substring(pPosition, p.length()));

                        if(isSubStringMatch) { return true; }
                        sPosition++;
                    }
                }
            }

            if(sCurrent == pCurrent || pCurrent == '.') {
                sPosition++;
                pPosition++;
            } else {
                if(p.charAt(pPosition + 1) != '*') { return false; }
                pPosition += 2;
            }
        }

        return true;
    }

    private static int getNextPositionOfNextPCharInS(String s, char pCurrent) {
        int sPosition = 0;
        while (sPosition < s.length()) {
            if(s.charAt(sPosition) == pCurrent) {
                return sPosition;
            }
            sPosition++;
        }
        return -1;
    }
}
