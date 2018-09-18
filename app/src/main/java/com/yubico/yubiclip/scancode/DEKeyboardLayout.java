package com.yubico.yubiclip.scancode;

/**
 * Created by kemiren on 6/18/14.
 */
public class DEKeyboardLayout extends KeyboardLayout {
    private static final String[] usb2key1 = new String[]{
            "",
            "",
            "",
            "",
            "a",
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
            "m",
            "n",
            "o",
            "p",
            "q", /* 0x14 */
            "r",
            "s",
            "t",
            "u",
            "v",
            "w",
            "x",
            "z",
            "y",
            "1", /* 0x1e */
            "2",
            "3",
            "4",
            "5",
            "6",
            "7",
            "8",
            "9",
            "0",
            "\n", /* 0x28 */
            "",
            "",
            "\t",
            " ",
            "ß",
            "´",
            "ü",
            "+",
            "",
            "#",
            "ö",
            "'",
            "^",
            ",",
            ".",
            "-", /* 0x38 */
    };
    private static final String[] usb2key2 = new String[]{
            "",
            "",
            "",
            "",
            "A",
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
            "Q", /* 0x94 */
            "R",
            "S",
            "T",
            "U",
            "V",
            "W",
            "X",
            "Z",
            "Y",
            "!",
            "\"",
            "§",
            "$",
            "%",
            "&",
            "/",
            "(",
            ")",
            "=",
            "",
            "",
            "",
            "",
            "",
            "?",
            "`",
            "Ü",
            "*",
            "",
            ">",
            "Ö",
            "Ä",
            "'",
            ";",
            ":",
            "_",
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
