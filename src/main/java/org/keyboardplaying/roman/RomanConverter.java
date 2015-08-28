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

    private BiMap<Character, Integer> correspondance;

    {
        correspondance = new BiHashMap<>();
        correspondance.put(Character.valueOf('I'), Integer.valueOf(1));
        correspondance.put(Character.valueOf('V'), Integer.valueOf(5));
        correspondance.put(Character.valueOf('X'), Integer.valueOf(10));
        correspondance.put(Character.valueOf('L'), Integer.valueOf(50));
        correspondance.put(Character.valueOf('C'), Integer.valueOf(100));
        correspondance.put(Character.valueOf('D'), Integer.valueOf(500));
        correspondance.put(Character.valueOf('M'), Integer.valueOf(1000));
    }

    /**
     * Parses a Roman numeral to an integer.
     * <p/>
     * Due to the numerous variants of Roman numerals writing, no constraint is checked. At the
     * current time, this algorithm is a dumb application of conversion rules.
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
        return correspondance.get(Character.valueOf(roman)).intValue();
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
            throw new IllegalArgumentException(
                    "Only positive values can be written as Roman numerals.");
        } else if (value > MAX_VALUE) {
            throw new IllegalArgumentException(
                    "This number is too large to be written as a Roman numeral.");
        }

        int five = TEN / 2;

        StringBuilder roman = new StringBuilder();

        int toConvert = value;
        for (int i = MAX_10_POWER; i >= 0; i--) {
            int tenthPower = (int) Math.pow(TEN, i);
            int tenth = toConvert / tenthPower;
            toConvert -= tenth * tenthPower;

            Character tenthChar = getChar(tenthPower);
            if (tenth == five - 1 || tenth == TEN - 1) {
                roman.append(tenthChar);
                tenth++;
            }
            if (tenth == TEN) {
                roman.append(getChar(TEN * tenthPower));
                tenth = 0;
            } else if (tenth >= five) {
                roman.append(getChar(five * tenthPower));
                tenth -= five;
            }
            while (tenth > 0) {
                roman.append(tenthChar);
                tenth--;
            }
        }

        return roman.toString();
    }

    private Character getChar(int value) {
        return correspondance.getKey(Integer.valueOf(value));
    }
}
