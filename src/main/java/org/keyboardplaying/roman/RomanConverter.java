package org.keyboardplaying.roman;

import org.keyboardplaying.util.BiHashMap;
import org.keyboardplaying.util.BiMap;

/**
 * Converts an integer from and to roman numerals.
 *
 * @author Cyrille Chopelet (http://keyboardplaying.org)
 */
public class RomanConverter {

    private static final int MAX_VALUE = 3777;
    private static final int MAX_10_POWER = 3;
    private static final int TEN = 10;
    private static final int FIVE = 5;

    private static final BiMap<Character, Integer> CORRESPONDANCE;

    static {
        CORRESPONDANCE = new BiHashMap<>();
        CORRESPONDANCE.put(Character.valueOf('I'), Integer.valueOf(1));
        CORRESPONDANCE.put(Character.valueOf('V'), Integer.valueOf(5));
        CORRESPONDANCE.put(Character.valueOf('X'), Integer.valueOf(10));
        CORRESPONDANCE.put(Character.valueOf('L'), Integer.valueOf(50));
        CORRESPONDANCE.put(Character.valueOf('C'), Integer.valueOf(100));
        CORRESPONDANCE.put(Character.valueOf('D'), Integer.valueOf(500));
        CORRESPONDANCE.put(Character.valueOf('M'), Integer.valueOf(1000));
    }

    /**
     * Parses a Roman numeral to an integer.
     * <p/>
     * Due to the numerous variants of Roman numerals writing, no constraint is checked. At the current time, this
     * algorithm is a dumb application of conversion rules.
     *
     * @param roman
     *            the Roman numeral
     * @return the integer version of the number
     */
    public int from(String roman) {
        int result = 0;

        if (roman != null) {
            String roman2 = roman.trim().toUpperCase();
            int length = roman2.length();
            int i = 0;
            while (i < length) {
                char current = roman2.charAt(i);
                int value = getIntValue(current);
                int group = 0;
                do {
                    group += value;
                    i++;
                } while (i < length && roman2.charAt(i) == current);

                if (i == length || getIntValue(roman2.charAt(i)) < value) {
                    result += group;
                } else {
                    result -= group;
                }
            }
        }

        return result;
    }

    private int getIntValue(char roman) {
        return CORRESPONDANCE.get(Character.valueOf(roman)).intValue();
    }

    /**
     * Parses an integer as a Roman numeral.
     *
     * @param value
     *            the integer
     * @return the Roman numeral
     */
    public String to(int value) {
        if (value < 0) {
            throw new IllegalArgumentException("Only positive values can be written as Roman numerals.");
        } else if (value > MAX_VALUE) {
            throw new IllegalArgumentException("This number is too large to be written as a Roman numeral.");
        }

        return appendRoman(new StringBuilder(), MAX_10_POWER, value).toString();
    }

    private StringBuilder appendRoman(StringBuilder sb, int power, int value) {
        if (power >= 0) {
            int rank = (int) Math.pow(TEN, power);
            int unit = value / rank;
            int remainder = value - unit * rank;

            Character unitChar = getChar(rank);
            if (unit == FIVE - 1 || unit == TEN - 1) {
                // One rank below: substract one unit to upper char
                sb.append(unitChar).append(getChar(++unit * rank));

            } else {

                // Greater than five, use the mid-dozen char
                if (unit >= FIVE) {
                    sb.append(getChar(FIVE * rank));
                    unit -= FIVE;
                }

                // Add single units
                while (unit > 0) {
                    sb.append(unitChar);
                    unit--;
                }
            }

            appendRoman(sb, power - 1, remainder);
        }
        return sb;
    }

    private Character getChar(int value) {
        return CORRESPONDANCE.getKey(Integer.valueOf(value));
    }
}
