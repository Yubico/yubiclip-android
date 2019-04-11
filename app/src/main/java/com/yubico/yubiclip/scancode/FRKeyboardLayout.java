package com.yubico.yubiclip.scancode;

/**
 * Created by samshay on 11/04/2019.
 */
public class FRKeyboardLayout extends KeyboardLayout {
    private static final String[] usb2key1 = new String[]{
            "",
            "",
            "",
            "",
            "q",
            "b",
            "c",
            "d",
            "e",
            "f",
            "g", /* 0xa */
            "h",
            "i",
            "j",
            "k",
            "l",
            ",",
            "n",
            "o",
            "p",
            "a", /* 0x14 */
            "r",
            "s",
            "t",
            "u",
            "v",
            "z",
            "x",
            "y",
            "w",
            "&", /* 0x1e */
            "é",
            "\"",
            "'",
            "(",
            "-",
            "è",
            "_",
            "ç",
            "à",
            "\n", /* 0x28 */
            "",
            "",
            "\t",
            " ",
            "-",
            "=",
            "^",
            "$",
            "",
            "*",
            ",",
            "ù",
            "`",
            ";",
            ".",
            "/", /* 0x38 */
    };
    private static final String[] usb2key2 = new String[]{
            "",
            "",
            "",
            "",
            "Q",
            "B",
            "C",
            "D",
            "E",
            "F",
            "G", /* 0x8a */
            "H",
            "I",
            "J",
            "K",
            "L",
            "M",
            "N",
            "O",
            "P",
            "A", /* 0x94 */
            "R",
            "S",
            "T",
            "U",
            "V",
            "Z",
            "X",
            "Y",
            "W",
            "1",
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "0",
            "",
            "",
            "",
            "",
            "",
            "°",
            "+",
            "¨",
            "£",
            "",
            "µ",
            "?",
            "%",
            "~",
            ":",
            "!",
            "§",
    };

    @Override
    protected String fromScanCode(int code) {
        if (code < SHIFT) {
            if (code < usb2key1.length) {
                return usb2key1[code];
            }
        } else {
            code = code ^ SHIFT;
            if (code < usb2key2.length) {
                return usb2key2[code];
            }
        }

        return "";
    }
}
