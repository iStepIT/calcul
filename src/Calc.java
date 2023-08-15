import java.util.Scanner;

class Calc {

    public static void main(String[] args) throws Exception {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Введите 2 числа и математическую операцию в одну строку! Цифры только арабские или римские");
        String expression = scanner.nextLine();
        System.out.println(parse(expression));
    }


    public static String parse(String expression) throws Exception {
        int num1;
        int num2;
        String oper;
        String result;
        boolean isRom;
        String[] operands = expression.split(" ");
        if (operands.length !=3) throw new Exception("Должно быть 2 операнда!");
        oper = detectOperation(expression);
        if (oper == null) throw new Exception("Не верная математическая операция");
        if (Roman.isRom(operands[0]) && Roman.isRom(operands[2])) {

            num1 = Roman.covertToArab(operands[0]);
            num2 = Roman.covertToArab(operands[2]);
            isRom = true;
    }

    else if (!Roman.isRom(operands[0]) && !Roman.isRom(operands[2])) {

            num1 = Integer.parseInt(operands[0]);
            num2 = Integer.parseInt(operands[2]);
            isRom = false;

        }
        else {
            throw new Exception("Числа должны быть в одном формате");
        }
        if (num1 > 10 || num2 > 10) {
            throw new Exception("Числа должны быть от 1 до 10");
        }
        int arab = calc(num1, num2, oper);
        if (isRom) {

            if (arab <= 0) {
                throw new Exception("Римское число должно быть больше нуля");
            }

            result = Roman.convertToRoman(arab);
        } else {

            result = String.valueOf(arab);
        }

        return result;
}

    static String detectOperation(String expression){
        if (expression.contains("+")) return "+";
        else if (expression.contains("-")) return "-";
        else if (expression.contains("*")) return "*";
        else if (expression.contains("/")) return "/";
        else return null;
    }

    static int calc (int a, int b, String oper) {

        if (oper.equals("+")) return a + b;
        else if (oper.equals("-")) return a - b;
        else if (oper.equals("*")) return a * b;
        else return a / b;
    }

}

class Roman {
    static String[] romanArray = new String[]{"0", "I", "II", "III", "IV", "V", "VI", "VII", "VIII", "IX", "X", "XI", "XII", "XIII", "XIV", "XV", "XVI", "XVII", "XVIII", "XIX", "XX", "XXI", "XXII", "XXIII", "XXIV", "XXV", "XXVI", "XXVII", "XXVIII", "XXIX", "XXX", "XXXI", "XXXII", "XXXIII", "XXXIV", "XXXV", "XXXVI", "XXXVII", "XXXVIII", "XXXIX", "XL", "XLI", "XLII", "XLIII", "XLIV", "XLV", "XLVI", "XLVII", "XLVIII", "XLIX", "L", "LI", "LII", "LIII", "LIV", "LV", "LVI", "LVII", "LVIII", "LIX", "LX", "LXI", "LXII", "LXIII", "LXIV", "LXV", "LXVI", "LXVII", "LXVIII", "LXIX", "LXX", "LXXI", "LXXII", "LXXIII", "LXXIV", "LXXV", "LXXVI", "LXXVII", "LXXVIII", "LXXIX", "LXXX", "LXXXI", "LXXXII", "LXXXIII", "LXXXIV", "LXXXV", "LXXXVI", "LXXXVII", "LXXXVIII", "LXXXIX", "XC", "XCI", "XCII", "XCIII", "XCIV", "XCV", "XCVI", "XCVII", "XCVIII", "XCIX", "C"};


    public static boolean isRom(String val) {
        for (int i = 0; i < romanArray.length; i++) {
            if (val.equals(romanArray[i])) {
                return true;
            }
        }
        return false;
    }

    public static int covertToArab(String roman) {
        for (int i = 0; i < romanArray.length; i++) {
            if (roman.equals(romanArray[i])) {
                return i;
            }
        }
        return -1;
    }

    public static String convertToRoman(int arab) {
        return romanArray[arab];
    }
    
}