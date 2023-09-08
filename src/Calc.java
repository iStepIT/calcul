import java.util.Scanner;
// Создай консольное приложение "Строковый калькулятор". Приложение должно
//читать из консоли введённые пользователем строки, числа, арифметические операции
// проводимые между ними и выводить в консоль результат их выполнения.
//
// Требования:
//Калькулятор умеет выполнять операции сложения строк, вычитания строки из строки, умножения строки
// на число и деления строки на число: "a" + "b", "a" - "b", "a" * b, "a" / b.
// Данные передаются в одну строку (смотрите пример)! Решения, в которых каждая строка, число и арифметическая
// операция передаются с новой строки считаются неверными.
//
//Значения строк передаваемых в выражении выделяются двойными кавычками.
//Результатом сложения двух строк, является строка состоящая из переданных.
//Результатом деления строки на число n, является строка в n раз короче исходной (смотрите пример).
//Результатом умножения стaроки на число n, является строка, в которой переданная строка повторяется ровно n раз.
//Результатом вычитания строки из строки, является строка, в которой удалена переданная подстрока или сама
// исходная строка, если в нее нет вхождения вычитаемой строки (смотрите пример).
//
//Калькулятор должен принимать на вход числа от 1 до 10 включительно, не более.
// И строки длинной не более 10 символов. Если строка, полученная в результате работы приложения длиннее 40 символов,
// то в выводе после 40 символа должны стоять три точки (...)
//Калькулятор умеет работать только с целыми числами.
//Первым аргументом выражения, подаваемого на вход, должна быть строка, при вводе пользователем
// выражения вроде 3 + "hello", калькулятор должен выбросить исключение и прекратить свою работу.
//
//При вводе пользователем неподходящих чисел, строк или неподдерживаемых операций
// (например, деление строки на строку) приложение выбрасывает исключение и завершает свою работу.
//При вводе пользователем выражения, не соответствующего одной из вышеописанных арифметических операций,
// приложение выбрасывает исключение и завершает свою работу.
//Input:
//            "100" + "500"
//    Output:
//            "100500"
//    Input:
//            "Hi World!" - "World!"
//    Output:
//            "Hi "
//    Input:
//            "Bye-bye!" - "World!"
//
//    Output:
//            "Bye-bye!"
//    Input:
//            "Java" * 5
//    Output:
//            "JavaJavaJavaJavaJava"
//    Input:
//            "Example!!!" / 3
//    Output:
//            "Exa"
//Input:
//            "100" + "500"
//    Output:
//            "100500"
//    Input:
//            "Hi World!" - "World!"
//    Output:
//            "Hi "
//    Input:
//            "Bye-bye!" - "World!"
//
//    Output:
//            "Bye-bye!"
//    Input:
//            "Java" * 5
//    Output:
//            "JavaJavaJavaJavaJava"
//    Input:
//            "Example!!!" / 3
//    Output:
//            "Exa"

class Calc {


    public static void main(String[] args) throws Exception {
        Scanner sc = new Scanner(System.in);
        System.out.println("Введите строки, числа, арифметические операции");
        String userInput = sc.nextLine();
        int sumSym = userInput.length();
        // if (sumSym > 27) throw new Exception("Вы ввели больше положенных символов");
        char act;
        String[] dataUserInput;
        String result = "";
        if (userInput.contains("*")) {
            dataUserInput = userInput.split(" \\* ");
            act = '*';
        }
        else if (userInput.contains("/")) {
            dataUserInput = userInput.split(" / ");
            act = '/';
        }
        else if (userInput.contains("-")) {
            dataUserInput = userInput.split(" - ");
            act = '-';
        }
        else if (userInput.contains("+")) {
            dataUserInput = userInput.split(" \\+ ");
            act = '+';
        }else throw new Exception("Не верный знак");
        int sumSym1 = dataUserInput[0].length();
        int sumSym2 = dataUserInput[1].length();
        if (sumSym1 > 10 || sumSym2 > 10) throw new Exception("Строка должна быть до 10 символов");

        if ((act == '*') || (act == '/')) {
            if (dataUserInput[1].contains("\"")) throw new Exception("Делить или или умножать можно только на число");}
        dataUserInput[0] = dataUserInput[0].replace("\"", "");

        if ((act == '*')) {
            dataUserInput[0] = dataUserInput[0].replace("\"", "");
            int numtwo;
            numtwo = Integer.parseInt(dataUserInput[1]);
            if (numtwo > 10 || numtwo < 0) throw new Exception("Число должно быть от 0 до 10");
            for (int i = 0; i < numtwo; i++)
                result += dataUserInput[0];
            int resLen = result.length();
            if (resLen<=40){
                System.out.print("\"" + result + "\"");
            }
            if (resLen>40){
                System.out.print("\"" + result.substring(0, 40)+ "..." + "\"");
            }
        }
        if (act == '/') {
            dataUserInput[0] = dataUserInput[0].replace("\"", "");
            int numtwo;
            numtwo = Integer.parseInt(dataUserInput[1]);
            if (numtwo > 10 || numtwo < 0) throw new Exception("Число должно быть от 0 до 10");
            int lenDel = dataUserInput[0].length()/ numtwo;
            result = dataUserInput[0].substring(0, lenDel);
            System.out.print("\"" + result + "\"");
        }
        else
        if ((act == '+') || (act == '-')) {
            if (act == '+') {
                dataUserInput[0] = dataUserInput[0].replace("\"", "");
                dataUserInput[1] = dataUserInput[1].replace("\"", "");
                result = dataUserInput[0] + dataUserInput[1];
                int resLen = result.length();
                if (resLen<=40){
                    resOut(result);
                }
                if (resLen>40){
                    result = result.substring(0, 40)+ "...";
                    resOut(result);
                }
            }
            if (act == '-') {
                dataUserInput[0] = dataUserInput[0].replace("\"", "");
                dataUserInput[1] = dataUserInput[1].replace("\"", "");
                int index = dataUserInput[0].indexOf(dataUserInput[1]);
                if (index == -1)
                {
                    System.out.print("\"" + dataUserInput[0] + "\"");
                } else {
                    result = dataUserInput[0].substring(0, index);
                    result += dataUserInput[0].substring(index + dataUserInput[1].length());
                    resOut(result);
                }
            }
        }
    }
    static void resOut(String result){
        System.out.print("\"" + result + "\"");
    }
}
