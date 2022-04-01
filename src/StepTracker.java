public class StepTracker {
    int dayStepGoal = 10000;
    MonthData[] monthToData;

    int getDayStepGoal() {
        return dayStepGoal;
    }


    void storeNewDayStepGoal(int newGoal) {
        dayStepGoal = newGoal;
    }

    void storeDaySteps(int month, int day, int steps) {
        monthToData[month].storeDaySteps(day, steps);
    }

    void getMonthStatistics(int month) {

    }

    public StepTracker() {
        monthToData = new MonthData[12];
        for (int i = 0; i < monthToData.length; i++) {
            monthToData[i] = new MonthData();
        }
    }


    private static class MonthData {
        int[] stepStore;

        void storeDaySteps(int day, int steps){
            stepStore[day] = steps;
        }

        public MonthData() {
            stepStore = new int[30];
            for (int i = 0; i < stepStore.length; i++) {
                stepStore[i] = 0;
            }
        }
    }
}
