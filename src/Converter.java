public class Converter {

   public static double stepsToKm(int steps) {
       return steps * 0.75 / 1000;
   }

    public static int countCalories(int steps) {
       return steps * 50 / 1000;
    }
}
