import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        int userInput;
        Scanner scanner = new Scanner(System.in);
        StepTracker stepTracker = new StepTracker();

        System.out.println("Счетчик шагов приветствует тебя, Идущий в носках!");

        printMenu();
        userInput = scanner.nextInt();

        while (userInput != 0) {
            if ( userInput == 1 ) {
                storeDaySteps (scanner, stepTracker);
            } else if ( userInput == 2 ) {
                getStepStat(scanner, stepTracker);
            } else if ( userInput == 3 ){
                storeNewStepGoal(scanner, stepTracker);
            } else if ( userInput == 4 ){
                System.out.println("До встречи, досточтимый!");
                return;
            } else {
                System.out.println("Я так еще не умею, досточтимый. Попробуй еще раз");
            }

            printMenu();
            userInput = scanner.nextInt();
        }

    }

    /* Метод печатает основное меню */
    private static void printMenu() {
        System.out.println("Что ты хочешь, досточтимый? Мы можем:");
        System.out.println("1 - Ввести количество шагов за определённый день месяца");
        System.out.println("2 - Напечатать статистику за определённый месяц");
        System.out.println("3 - Изменить цель по количеству шагов в день");
        System.out.println("4 - Выйти из приложения");
        System.out.println("Какова твоя воля?");
    }


    /* Метод запрашивает новую цель по шагам и сохраняет ее */
    private static void storeNewStepGoal (Scanner scanner, StepTracker stepTracker){
        System.out.println("Введи новую цель по шагам, досточтимый. Допускаются только целые положительные значения");
        int userInput = scanner.nextInt();
        if (userInput > 0) {
            stepTracker.storeNewDayStepGoal(userInput);
            System.out.println("Ок, новая цель по шагам за день - " + stepTracker.getDayStepGoal() );
        } else {
            System.out.println("Введено недопустимое значение");
        }
    }


    /* Метод запрашивает и сохраняет количество шагов за определенный день месяца */
    private static void storeDaySteps (Scanner scanner, StepTracker stepTracker) {
        int month;
        int day;
        int steps;

        System.out.println("Досточтимый, для сохранения пройденных шагов укажи месяц (0-12), день (0-29) и количество шагов (>=0)");

        System.out.print("   Месяц: ");
        month = scanner.nextInt();
        if (month < 0 || month > 11 ) {
            System.out.println("Введено недопустимое значение. Месяц должен быть о 0 до 11");
            return;
        }

        System.out.print("   День: ");
        day = scanner.nextInt();
        if (day < 0 || day > 29 ) {
            System.out.println("Введено недопустимое значение. День должен быть о 0 до 29");
            return;
        }

        System.out.print("   Пройдено шагов: ");
        steps = scanner.nextInt();
        if (steps < 0 ) {
            System.out.println("Введено недопустимое значение. День должен быть о 0 до 29");
            return;
        }

        stepTracker.storeDaySteps(month, day, steps);
        System.out.println("Ок. Месяц " + month + ", день " + day + ", сохранено "
                + stepTracker.getDaySteps(month, day) + " шагов");
    }


    /* Метод выводит статистику по шагам за указанный месяц */
    private static void getStepStat(Scanner scanner, StepTracker stepTracker) {
        System.out.println("Досточтимый, статистика за какой месяц тебя интересует? Укажи от 0 до 11");

        System.out.print("   Месяц: ");
        int month = scanner.nextInt();
        if (month < 0 || month > 11 ) {
            System.out.println("Введено недопустимое значение. Месяц должен быть о 0 до 11");
            return;
        }

        System.out.println("Количество пройденных шагов по дням: ");
        for (int i=0; i<30; i++) {
            System.out.print(i+1 + " день: " + stepTracker.getDaySteps(month, i) + ", ");
        }
        //System.out.println("\n");

        System.out.println("Общее количество шагов: "
                + stepTracker.getMonthTotalSteps(month));
        System.out.println("Максимальное пройденное количество шагов: "
                + stepTracker.getMonthMaxSteps(month));
        System.out.println("Среднее количество шагов (округлено вниз): "
                + stepTracker.getMonthAvgSteps(month));
        System.out.println("Пройденная дистанция (в км): "
                + stepTracker.convertStepsToKm(month) );
        System.out.println("Количество сожжённых килокалорий: "
                + stepTracker.countCalories(month));
        System.out.println("Лучшая серия: "
                + stepTracker.getBestStepSeries(month) + " день(дней)");
    }
}

