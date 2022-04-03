public class Converter {

   public double stepsToKm(int steps) {
       return steps * 0.75 / 1000;
   }

    public int countCalories(int steps) {
       return steps * 50 / 1000;
    }

    Converter(){
    }
}
