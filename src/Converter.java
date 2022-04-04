public class Converter {
    double stepLength = 0.75;
    int caloriesPerStep = 50;

    public double stepsToKm(int steps) {
       return steps * stepLength / 1000;
   }

    public int stepsToCalories(int steps) {
       return steps * caloriesPerStep / 1000;
    }
}
