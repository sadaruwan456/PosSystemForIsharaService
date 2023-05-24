/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor. *
 * @author Dilanka Snadaruwan
 * @Date 08/10/2019
 */
package Cryptography;

/**

 */
public class Cryption implements Crypt {

    public static  String encript(String text) {
        String ENCRIPTED_TEXT = null;

        char[] TO_ENCRIPT = text.toCharArray();

        for (int TEXT_COUNT = 0; TEXT_COUNT < TO_ENCRIPT.length; TEXT_COUNT++) {

            //START ENCRIPT THE SYMBOLS       
            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '`') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = BACK_QUTE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + BACK_QUTE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '~') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CONSOLE_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CONSOLE_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '!') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = EXCLAMATION_MARK;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + EXCLAMATION_MARK;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '@') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = AT_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + AT_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '#') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = HASH_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + HASH_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '$') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = DOLLAR_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + DOLLAR_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '%') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = PERCENT_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + PERCENT_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '^') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CARET_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CARET_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '&') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = AND_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + AND_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '*') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = STAR_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + STAR_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '(') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = OPEN_BRACKET;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + OPEN_BRACKET;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == ')') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CLOSE_BRACKET;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CLOSE_BRACKET;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '-') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = HYPHEN;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + HYPHEN;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '_') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = UNDERSCORE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + UNDERSCORE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '=') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = EQUAL_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + EQUAL_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '+') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = PLUS_KEY;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + PLUS_KEY;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '/') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = FOWERD_SLASH;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + FOWERD_SLASH;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '{') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = OPEN_C_BRACKET;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + OPEN_C_BRACKET;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '}') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CLOSE_C_BRACKET;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CLOSE_C_BRACKET;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '[') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = OPEN_S_BRACKET;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + OPEN_S_BRACKET;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == ']') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CLOSE_S_BRACKET;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CLOSE_S_BRACKET;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '\\') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = BACK_SLASH;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + BACK_SLASH;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '|') {

                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = VERTICAL_BAR;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + VERTICAL_BAR;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == ';') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = SEMI_COLON;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + SEMI_COLON;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == ':') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = COLON;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + COLON;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '\"') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = INVERTED_COMMAS;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + INVERTED_COMMAS;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '\'') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = APOSTROPHE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + APOSTROPHE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '<') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LESS_THAN;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LESS_THAN;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == ',') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = COMMA;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + COMMA;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '>') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = GRATER_THAN;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + GRATER_THAN;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '.') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = FULL_STOP;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + FULL_STOP;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '?') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = QUECTION_MARK;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + QUECTION_MARK;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == ' ') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = SPACE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + SPACE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            Character TAB_KEY = 9;
            if (TO_ENCRIPT[TEXT_COUNT] == TAB_KEY) {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = TAB;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + TAB;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            Character ENTER_KEY = 13;
            if (TO_ENCRIPT[TEXT_COUNT] == ENTER_KEY) {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = ENTER;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + ENTER;

                }
            }
            //------------------------------------------------------------

            // END OF SYMBOLS
            // START OF NUMBER ENCRIPTION
            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '0') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_ZERO;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_ZERO;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '1') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_ONE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_ONE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '2') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_TWO;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_TWO;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '3') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_THREE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_THREE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '4') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_FOUR;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_FOUR;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '5') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_FIVE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_FIVE;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '6') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_SIX;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_SIX;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '7') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_SEVEN;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_SEVEN;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '8') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_EIGHT;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_EIGHT;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == '9') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = NUMBER_NINE;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + NUMBER_NINE;

                }
            }
            //------------------------------------------------------------

            // END OF NUMBER ENCRIPTION
            // START OF CAPITAL LETTER ENCRIPTION
            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'A') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_A;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_A;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'B') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_B;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_B;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'C') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_C;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_C;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'D') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_D;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_D;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'E') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_E;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_E;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'F') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_F;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_F;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'G') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_G;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_G;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'H') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_H;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_H;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'I') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_I;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_I;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'J') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_J;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_J;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'K') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_K;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_K;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'L') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_L;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_L;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'M') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_M;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_M;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'N') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_N;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_N;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'O') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_O;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_O;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'P') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_P;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_P;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'Q') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_Q;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_Q;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'R') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_R;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_R;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'S') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_S;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_S;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'T') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_T;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_T;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'U') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_U;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_U;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'V') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_V;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_V;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'W') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_W;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_W;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'X') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_X;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_X;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'Y') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_Y;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_Y;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'Z') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = CAP_LETTER_Z;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + CAP_LETTER_Z;

                }
            }
            //------------------------------------------------------------

// END OF ENCRIPTING CPITAL LETTERS 
//START OF ENCRIPTING SIMPLE LETTERS
            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'a') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_A;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_A;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'b') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_B;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_B;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'c') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_C;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_C;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'd') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_D;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_D;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'e') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_E;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_E;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'f') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_F;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_F;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'g') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_G;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_G;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'h') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_H;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_H;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'i') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_I;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_I;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'j') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_J;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_J;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'k') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_K;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_K;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'l') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_L;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_L;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'm') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_M;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_M;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'n') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_N;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_N;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'o') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_O;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_O;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'p') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_P;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_P;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'q') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_Q;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_Q;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'r') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_R;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_R;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 's') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_S;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_S;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 't') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_T;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_T;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'u') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_U;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_U;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'v') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_V;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_V;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'w') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_W;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_W;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'x') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_X;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_X;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'y') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_Y;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_Y;

                }
            }
            //------------------------------------------------------------

            //------------------------------------------------------------
            if (TO_ENCRIPT[TEXT_COUNT] == 'z') {
                if (ENCRIPTED_TEXT == null) {
                    ENCRIPTED_TEXT = LETTER_Z;
                } else {
                    ENCRIPTED_TEXT = ENCRIPTED_TEXT + LETTER_Z;

                }
            }
            //------------------------------------------------------------
            //END OF SIMPLE LETTER ENCRIPTION

        }

        return ENCRIPTED_TEXT;
    }

    public static String decript(String text) {
        String DECRIPTED_TEXT = null;

        char[] TEXT_CHAR = text.toCharArray();
        int COUNT = (TEXT_CHAR.length) / 3;
        int BEGIN_INDEX = 0;
        int END_INDEX = 3;

        for (int CHAR_COUNT = 0; CHAR_COUNT < COUNT; CHAR_COUNT = CHAR_COUNT + 1) {

            String CREATED_TEXT = text.substring(BEGIN_INDEX, END_INDEX);
            BEGIN_INDEX = BEGIN_INDEX + 3;
            END_INDEX = END_INDEX + 3;

            //THIS IS THE DECRIPTION PROCESS
            //SYMBOL DECRIPTION
            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CONSOLE_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "~";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "~";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(BACK_QUTE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "`";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "`";
                }
            }
            //---------------------------------------------------------------------------------------- 

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(EXCLAMATION_MARK)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "!";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "!";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(AT_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "@";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "@";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(HASH_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "#";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "#";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(DOLLAR_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "$";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "$";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(PERCENT_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "%";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "%";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CARET_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "^";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "^";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(AND_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "&";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "&";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(STAR_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "*";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "*";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(OPEN_BRACKET)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "(";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "(";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CLOSE_BRACKET)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ")";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ")";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(HYPHEN)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "-";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "-";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(UNDERSCORE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "_";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "_";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(EQUAL_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "=";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "=";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(PLUS_KEY)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "+";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "+";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(FOWERD_SLASH)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "/";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "/";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(OPEN_S_BRACKET)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "[";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "[";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(OPEN_C_BRACKET)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "{";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "{";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CLOSE_S_BRACKET)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "]";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "]";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CLOSE_C_BRACKET)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "}";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "}";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(BACK_SLASH)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "\\";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "\\";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(VERTICAL_BAR)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "|";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "|";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(SEMI_COLON)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ";";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ";";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(COLON)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ":";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ":";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(APOSTROPHE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "'";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "'";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(INVERTED_COMMAS)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "\"";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "\"";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(COMMA)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ",";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ",";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LESS_THAN)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "<";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "<";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(FULL_STOP)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ".";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ".";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(GRATER_THAN)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ">";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ">";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(QUECTION_MARK)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "?";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "?";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(SPACE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = " ";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + " ";
                }
            }
            //----------------------------------------------------------------------------------------
            Character tab = 9;
            String TAB_KEY = String.valueOf(tab);
            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(TAB)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = TAB_KEY;
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + TAB_KEY;
                }
            }
            //----------------------------------------------------------------------------------------

            Character enter = 13;
            String ENTER_KEY = String.valueOf(enter);

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(ENTER)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = ENTER_KEY;
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + ENTER_KEY;
                }
            }
            //----------------------------------------------------------------------------------------
            //END OF SYMBOL ENCRIPTION
            // START OF NUMBER ENCRIPTION

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_ZERO)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "0";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "0";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_ONE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "1";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "1";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_TWO)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "2";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "2";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_THREE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "3";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "3";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_FOUR)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "4";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "4";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_FIVE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "5";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "5";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_SIX)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "6";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "6";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_SEVEN)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "7";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "7";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_EIGHT)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "8";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "8";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(NUMBER_NINE)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "9";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "9";
                }
            }
            //----------------------------------------------------------------------------------------
            //END OF NUMBER DECRIPTION
            //START OF SIMPLE LETTER DECRIPTION

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_A)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "a";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "a";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_B)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "b";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "b";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_C)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "c";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "c";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_D)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "d";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "d";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_E)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "e";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "e";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_F)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "f";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "f";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_G)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "g";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "g";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_H)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "h";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "h";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_I)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "i";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "i";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_J)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "j";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "j";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_K)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "k";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "k";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_L)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "l";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "l";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_M)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "m";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "m";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_N)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "n";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "n";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_O)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "o";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "o";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_P)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "p";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "p";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_Q)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "q";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "q";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_R)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "r";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "r";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_S)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "s";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "s";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_T)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "t";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "t";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_U)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "u";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "u";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_V)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "v";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "v";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_W)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "w";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "w";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_X)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "x";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "x";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_Y)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "y";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "y";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(LETTER_Z)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "z";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "z";
                }
            }
            //----------------------------------------------------------------------------------------
            //END OF SIMPLE LETTER DECRIPTION
            //START OF CAPTAL LETTER DECRIPTION

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_A)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "A";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "A";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_B)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "B";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "B";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_C)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "C";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "C";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_D)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "D";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "D";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_F)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "F";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "F";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_G)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "G";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "G";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_H)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "H";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "H";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_I)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "I";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "I";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_J)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "J";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "J";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_K)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "K";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "K";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_L)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "L";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "L";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_M)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "M";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "M";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_N)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "N";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "N";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_O)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "O";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "O";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_P)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "P";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "P";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_Q)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "Q";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "Q";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_R)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "R";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "R";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_S)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "S";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "S";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_T)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "T";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "T";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_U)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "U";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "U";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_V)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "V";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "V";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_W)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "W";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "W";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_X)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "X";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "X";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_Y)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "Y";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "Y";
                }
            }
            //----------------------------------------------------------------------------------------

            //--------------------------------------------------------------------------------------
            if (CREATED_TEXT.equals(CAP_LETTER_Z)) {
                if (DECRIPTED_TEXT == null) {
                    DECRIPTED_TEXT = "Z";
                } else {
                    DECRIPTED_TEXT = DECRIPTED_TEXT + "Z";
                }
            }
            //----------------------------------------------------------------------------------------

            //END OF DECRIPTION
        }

        return DECRIPTED_TEXT;
    }

  
}
