import java.util.Arrays;

public class StepTracker {
    int dayStepGoal = 10000;
    MonthData[] monthToData;
    Converter converter = new Converter();

    /* Получить текущую цель по шагам */
    public int getDayStepGoal() {
        return dayStepGoal;
    }


    /* Сохранить новую цель по шагам */
    public void storeNewDayStepGoal(int newGoal) {
        dayStepGoal = newGoal;
    }


    /* Сохранить пройденные шаги  за день месяца */
    public void storeDaySteps(int month, int day, int steps)
    {
        monthToData[month].stepStore[day] = steps;
    }


    /* Получить пройденные шаги за день месяца */
    public int getDaySteps(int month, int day)
    {
        return monthToData[month].stepStore[day];
    }


    /* Получить общее количество шагов за месяц */
    public int getMonthTotalSteps (int month){
        int totalSteps = 0;
        for (int i = 0; i < 30; i++) {
            totalSteps = totalSteps + monthToData[month].stepStore[i];
        }
        return totalSteps;
    }


    /* Получить максимальное количество шагов за месяц */
    public int getMonthMaxSteps(int month)
    {
        int maxSteps = monthToData[month].stepStore[0];

        for(int i = 1; i < 30; i++) {
            if ( monthToData[month].stepStore[i] > maxSteps ) maxSteps = monthToData[month].stepStore[i];
        }

        return maxSteps;
    }


    /* Получить среднее количество шагов за месяц */
    public int getMonthAvgSteps (int month)
    {
        return getMonthTotalSteps(month)/30;
    }


    /* Сконвертировать шаги в километры */
    public double convertStepsToKm (int month) {
        return converter.stepsToKm(getMonthTotalSteps(month));
    }


    /* Подсчитать количество калорий */
    public int countCalories (int month) {
        return converter.countCalories(getMonthTotalSteps(month));
    }


    /* Найти лучшую серию шагов */
    public int getBestStepSeries (int month){
        int bestSeries=0;
        int currentS=0;

        //int[] tempSteps = {0, 12000, 13000, 0, 10000, 956, 11000, 12000, 13000};

        for (int i = 0; i < monthToData[month].stepStore.length; i++){
            if (monthToData[month].stepStore[i] >= dayStepGoal) {
                currentS++;
            } else {
                if ( bestSeries < currentS ) bestSeries = currentS;
                currentS = 0;
            }
        }
        //условие необходимо для случая, когда лучшая серия - в конце месяца
        if ( bestSeries < currentS ) bestSeries = currentS;

        return bestSeries;
    }

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }


    private static class MonthData {
        int[] stepStore;

        public MonthData() {
            stepStore = new int[30];
            Arrays.fill(stepStore, 0);
        }
    }
}
