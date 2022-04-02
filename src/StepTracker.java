public class StepTracker {
    int dayStepGoal = 10000;
    MonthData[] monthToData;
    Converter converter;

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
        monthToData[month].storeDaySteps(day, steps);
    }

    /* Получить пройденные шаги  за день месяца */
    public int getDaySteps(int month, int day)
    {
        return monthToData[month].getDaySteps(day);
    }


    public int getMonthTotalSteps (int month){
        return monthToData[month].getTotalSteps();
    }


    public int getMonthMaxSteps(int month) {
        return monthToData[month].getMaxSteps();
    }


    public int getMonthAvgSteps (int month) {
        return monthToData[month].getAvgSteps();
    }


    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
        converter = new Converter();
    }


    private static class MonthData {
        int[] stepStore;

        void storeDaySteps(int day, int steps) {
            stepStore[day] = steps;
        }

        int getDaySteps(int day) {
            return stepStore[day];
        }


        int getTotalSteps() {
            int totalSteps = 0;
            for (int i = 0; i < 30; i++) {
                totalSteps = totalSteps + stepStore[i];
            }
            return totalSteps;
        }

        int getAvgSteps (){
            return getTotalSteps()/30;
        }

        int getMaxSteps() {
            int maxSteps = stepStore[0];

            for(int i = 1; i < 30; i++) {
                if ( stepStore[i] > maxSteps ) maxSteps = stepStore[i];
            }

            return maxSteps;
        }

        public MonthData() {
            stepStore = new int[30];
            for (int i = 0; i < stepStore.length; i++) {
                stepStore[i] = 0;
            }
        }
    }
}
