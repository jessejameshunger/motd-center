/*
 * *************************************************************************************************
 *
 *      Urheberrechtshinweis
 *      Copyright © Jesse-James Hunger  / 2021
 *      Klasse:  Utility
 *
 * ************************************************************************************************
 *
 */

package de.james.net.riveax.proxysystem.util;


import com.google.common.collect.Maps;

import java.util.Map;

public class Utility {

    private final static int CENTER_PX = 125;
    public Map<String, Boolean> isLogged = Maps.newHashMap();
    public String prefix = "§8•§7● §eRiveax §8» ";

    public String centerText(String message) {
        int messagePxSize = 0;
        boolean previousCode = false;
        boolean isBold = false;
        for (char c : message.toCharArray()) {
            if (c == '§') {
                previousCode = true;
                continue;
            } else if (previousCode) {
                previousCode = false;
                if (c == 'l' || c == 'L') {
                    isBold = true;
                    continue;
                } else isBold = false;
            } else {
                DefaultFontInfo dFI = DefaultFontInfo.getDefaultFontInfo(c);
                messagePxSize += isBold ? dFI.getBoldLength() : dFI.getLength();
                messagePxSize++;
            }
        }
        int halvedMessageSize = messagePxSize / 2;
        int toCompensate = CENTER_PX - halvedMessageSize;
        int spaceLength = DefaultFontInfo.SPACE.getLength() + 1;
        int compensated = 0;
        StringBuilder sb = new StringBuilder();
        while (compensated < toCompensate){
            sb.append(" ");
            compensated += spaceLength;
        }
        return sb.toString() + message;
    }

}
