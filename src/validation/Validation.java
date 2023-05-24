package validation;

import java.awt.event.KeyEvent;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import javax.swing.JTextField;

/**
 *

 */
public class Validation {

    final static String number_digit = "0125678";

    public static boolean validateNic(String nic) {
        boolean nic_state = true;
        if (nic.length() == 10) {
            if (nic.contains("v") || nic.contains("x") || nic.contains("V") || nic.contains("X")) {
                try {
                    String number = nic.substring(0, 9);
                    Integer.parseInt(number);
                    int days = Integer.parseInt(nic.substring(2, 5));
                    if (366 < days) {
                        nic_state = days > 500;
                    }
                    if (days > 866) {
                        nic_state = false;
                    }
                } catch (Exception e) {
                    nic_state = false;
                }

            } else {
                nic_state = false;
            }
        } else {
            if (nic.length() == 12) {
                try {
                    Long.parseLong(nic);
                    int days = Integer.parseInt(nic.substring(4, 7));
                    if (366 < days) {
                        nic_state = days > 500;
                    }
                    if (days > 866) {
                        nic_state = false;
                    }
                } catch (Exception e) {
                    nic_state = false;
                }

            } else {
                nic_state = false;
            }
        }

        return nic_state;

    }

    public static boolean validateMobile(String mobile) {
        boolean mobile_state = true;
        if (mobile.length() == 10) {
            try {
                Integer.parseInt(mobile);
                char[] chara = number_digit.toCharArray();
                mobile_state = false;
                for (int i = 0; i < chara.length; i++) {
                    if (mobile.charAt(2) == chara[i]) {
                        mobile_state = true;
                    }

                }

            } catch (Exception e) {
                mobile_state = false;
            }

        } else {
            mobile_state = false;
        }
        return mobile_state;
    }

    public static boolean validateEmail(String email) {

        Pattern ptn = Pattern.compile("^[_A-Za-z0-9-\\+]+(\\.[_A-Za-z0-9-]+)*@[A-Za-z0-9-]+(\\.[A-Za-z0-9]+)*(\\.[A-Za-z]{2,})$");
        Matcher matcher = ptn.matcher(email);

        return matcher.find();
    }

    public static boolean validateSalary(String salary) {
        boolean val_sal = true;
        try {
            Double.parseDouble(salary);

        } catch (Exception e) {
            val_sal = false;
        }
        return val_sal;
    }

    public static boolean dob_state = false;

    public static boolean validateDobFromNic(String nic, Date date) {
        String year_nic;
        int days;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        if (nic.length() == 10) {
            //year
            year_nic = "19" + nic.substring(0, 2);
            days = Integer.parseInt(nic.substring(2, 5));
        } else {

            year_nic = nic.substring(0, 4);
            days = Integer.parseInt(nic.substring(4, 7));

        }
        String year_dob = sdf.format(date);

        //month
        if (!(Integer.parseInt(year_nic) % 4 == 0) && days > 59) {

            days = days - 1;
        }
        if (days >= 500) {
            days = days - 500;
        }
        LocalDate ldate = LocalDate.ofYearDay(Integer.parseInt(year_nic), days);
        SimpleDateFormat dob = new SimpleDateFormat("yyyy-MM-dd");

        String dob_from_input = dob.format(date);
        String dob_from_nic = ldate.toString();

        if (dob_from_input.equals(dob_from_nic)) {
            dob_state = true;
        }

        return dob_state;
    }

    public static boolean validateGenderFromNic(String nic, String gender) {
        boolean gender_state = false;
        String gender_nic;

        int days;

        if (nic.length() == 10) {
            //year

            days = Integer.parseInt(nic.substring(2, 5));
        } else {

            days = Integer.parseInt(nic.substring(4, 7));

        }

        if (days > 500) {
            gender_nic = "female";
        } else {
            gender_nic = "male";
        }

        if (gender.equalsIgnoreCase(gender_nic)) {
            gender_state = true;
        }

        return gender_state;
    }

    public static String getDOBFromNIC(String nic) {
        String year_nic;
        int days;
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
        if (nic.length() == 10) {
            //year
            year_nic = "19" + nic.substring(0, 2);
            days = Integer.parseInt(nic.substring(2, 5));
        } else {

            year_nic = nic.substring(0, 4);
            days = Integer.parseInt(nic.substring(4, 7));

        }

        //month
        if (!(Integer.parseInt(year_nic) % 4 == 0) && days > 59) {

            days = days - 1;
        }
        if (days >= 500) {
            days = days - 500;
        }
        LocalDate ldate = LocalDate.ofYearDay(Integer.parseInt(year_nic), days);
        return ldate.toString();

    }

    public static String convertNIC(String nic) {
        String convertedNIC;
        if (nic.length() == 10) {
            nic = nic.subSequence(0, 9).toString();
            String backPt = nic.substring(5);
            String frountPt = nic.subSequence(0, 5).toString();

            convertedNIC = "19" + frountPt + "0" + backPt;

        } else {
            if (nic.substring(0).equals("2")) {
                convertedNIC = "THIS VIC CANNOT BE CONVERTED TO OLD NIC";
            } else {
                nic = nic.substring(2);
                String frountPt = nic.substring(0, 5);
                String backPt = nic.substring(6);
                convertedNIC = frountPt + backPt + "v";
            }
        }
        return convertedNIC;

    }

    public static void validateAmount(KeyEvent evt, JTextField tf) {
        char c = evt.getKeyChar();
        String s = tf.getText();
        if (Character.isDigit(c)) {
            if (c == '0') {
                if (s.equals("0")) {
                    evt.consume();
                }
            }
        } else {
            switch (c) {
                case '.':
                    if (s.isEmpty()) {
                        tf.setText("0");
                    } else {
                        if (s.contains(".")) {
                            evt.consume();
                        }
                    }
                    break;
                default:
                    evt.consume();
                    break;
            }
        }
    }

    public static void validateNumbersOnly(KeyEvent evt, JTextField tf) {
        if (!Character.isDigit(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void validateMobileNumber(KeyEvent evt, JTextField tf) {
        char c = evt.getKeyChar();
        if (tf.getText().isEmpty()) {
            if (!(Character.isDigit(c) || c == '+')) {
                evt.consume();
            }
        } else {
            validateNumbersOnly(evt, tf);
        }
    }

    public static void validateItemName(KeyEvent evt, JTextField tf) {
        char c = evt.getKeyChar();
        if (!(Character.isDigit(c) || Character.isAlphabetic(c) || c == ' ' || c == '(' || c == ')' || c == '[' || c == ']')) {
            evt.consume();
        }
    }

    public static void validateName(KeyEvent evt, JTextField tf) {
        if (!Character.isAlphabetic(evt.getKeyChar())) {
            evt.consume();
        }
    }

    public static void validateText(KeyEvent evt, JTextField tf) {
        if (evt.getKeyChar() == '\\') {
            evt.consume();
        }
    }

    public static void validateDate(KeyEvent evt, JTextField tf) {
        validateNumbersOnly(evt, tf);
        char c = evt.getKeyChar();
        if (!evt.isConsumed()) {
            if (tf.getText().length() == 0) {
                if (c == '0' || c == '1') {
                    evt.consume();
                }
            } else if (tf.getText().length() == 3) {
                tf.setText(tf.getText() + c + "/");
                evt.consume();
            } else if (tf.getText().length() == 4) {
                tf.setText(tf.getText() + "/");
                if (!(c == '0' || c == '1')) {
                    evt.consume();
                }
            } else if (tf.getText().length() == 5) {
                if (!(c == '0' || c == '1')) {
                    evt.consume();
                }
            } else if (tf.getText().length() == 6) {
                if (tf.getText().substring(5, 6).equals("0")) {
                    if (c == '0') {
                        evt.consume();
                    } else {
                        tf.setText(tf.getText() + c + "/");
                        evt.consume();
                    }
                } else if (tf.getText().substring(5, 6).equals("1")) {
                    if (c == '0' || c == '1' || c == '2') {
                        tf.setText(tf.getText() + c + "/");
                        evt.consume();
                    } else {
                        evt.consume();
                    }
                } else {
                    tf.setText(tf.getText() + c + "/");
                    evt.consume();
                }
            } else if (tf.getText().length() == 7) {
                tf.setText(tf.getText() + "/");
                if (tf.getText().substring(5, 7).equals("02")) {
                    if (!(c == '0' || c == '1' || c == '2')) {
                        evt.consume();
                    }
                } else {
                    if (!(c == '0' || c == '1' || c == '2' || c == '3')) {
                        evt.consume();
                    }
                }
            } else if (tf.getText().length() == 8) {
                if (tf.getText().substring(5, 7).equals("02")) {
                    if (!(c == '0' || c == '1' || c == '2')) {
                        evt.consume();
                    }
                } else {
                    if (!(c == '0' || c == '1' || c == '2' || c == '3')) {
                        evt.consume();
                    }
                }
            } else if (tf.getText().length() == 9) {
                if (tf.getText().substring(8, 9).equals("3")) {
                    switch (tf.getText().substring(5, 7)) {
                        case "01":
                        case "03":
                        case "05":
                        case "07":
                        case "08":
                        case "10":
                        case "12":
                            if (!(c == '0' || c == '1')) {
                                evt.consume();
                            }
                            break;
                        case "04":
                        case "06":
                        case "09":
                        case "11":
                            if (c != '0') {
                                evt.consume();
                            }
                            break;
                    }
                } else if (tf.getText().substring(8, 9).equals("2")) {
                    if (Integer.parseInt(tf.getText().substring(0, 4)) % 4 != 0) {
                        if (c == '9') {
                            evt.consume();
                        }
                    }
                } else if (tf.getText().substring(8, 9).equals("0")) {
                    if (c == '0') {
                        evt.consume();
                    }
                }
            } else if (tf.getText().length() > 9) {
                evt.consume();
            }
        }
    }

}
