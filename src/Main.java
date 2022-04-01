import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);

        System.out.println("Счетчик шагов приветствует тебя, Идущий в носках!");

        printMenu();
        userInput = scanner.nextInt();

        while (userInput != 0) {
            if ( userInput == 1 ) {
                System.out.println("Ты ввел 1");
            } else if ( userInput == 2 ) {
                System.out.println("Ты ввел 2");
            } else if ( userInput == 3 ){
                System.out.println("Ты ввел 3");
            } else if ( userInput == 4 ){
                System.out.println("Ты ввел 4");
            } else {
                System.out.println("Я так еще не умею, досточтимый. Поробуй еще раз");
            }

            printMenu();
            userInput = scanner.nextInt();
        }
        System.out.println("До встречи, досточтимый!");
    }

    private static void printMenu() {
        System.out.println("Мы можем:");
        System.out.println("1 - Ввести количество шагов за определённый день");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
        System.out.println("Что ты хочешь, досточтимый?");
    }
}

