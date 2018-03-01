package com.sefryek.brokerpro.utils;

import com.sefryek.util.MapUtils;
import com.sefryek.util.StringUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

/**
 * Copyright 2016 (C) syspod.co
 *
 * @auther: Ashkan Haghighi Kia
 * @email: kia@syspod.co
 */

public abstract class PersianUtils {

    /**
     * The constant ARABIC_TO_PERSIAN_CHARACTERS_MAP.
     */
    private static final Map<Character, Character> ARABIC_TO_PERSIAN_CHARACTERS_MAP = createArabicToPersianCharactersMap();

    /**
     * Create arabic to persian characters map.<br />
     * <pre>
     *     This map contains:
     *     1603(arabicLetterKaf)         --> 1705(persianLetterKeh)
     *     1609(arabicLetterAlefMaksura) --> 1740(persianLetterYeh)
     *     1610(arabicLetterYeh)         --> 1740(persianLetterYeh)
     * </pre>
     *
     * @return the arabic to persian characters map
     */
    private static Map<Character, Character> createArabicToPersianCharactersMap() {
        Map<Character, Character> characterMap = new HashMap<>();
        characterMap.put((char) 1603, (char) 1705);
        characterMap.put((char) 1610, (char) 1740);
        characterMap.put((char) 1609, (char) 1740);
        return MapUtils.immutableMap(characterMap);
    }

    public static String convertArabicToPersian(String string) {
        if (StringUtils.isNotEmptyOrBlank(string)) {
            String currentString = string;
            Set<Character> characters = ARABIC_TO_PERSIAN_CHARACTERS_MAP.keySet();
            for (Character character : characters) {
                currentString = StringUtils.replace(currentString, String.valueOf(character), String.valueOf(ARABIC_TO_PERSIAN_CHARACTERS_MAP.get(character)));
            }
            return currentString;
        }
        return string;
    }
}
