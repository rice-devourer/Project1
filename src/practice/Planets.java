package practice;
import dataStructures.Pair;
import dataStructures.ScientificNumber;

public class Planets {
    /*Create an enum called Planet
    Include Sun, Moon, and Earth
    Each planet has a radius (m), mass (kg), distance from earth (m)
    Assume the planets placed linearly at its closest point to the sun
        Example, Sun -> Mercury -> Venus -> Moon* -> Earth -> Mars
     */


    /*
    Create a method that calculates the gravitational field between any two planets
    g = G * mass * / (distanceBetweenPlanets^2)
    G = 6.67*10^-11

    //Tip compute the mantissa and exponent separately
     */

    public static void main(String[] args){
        for(Planet from : Planet.values()){
            for(Planet on : Planet.values()){
                if (from!=on){
                    System.out.println("The gravity field from the " + from.name() + " on the " + on.name() + " is "
                            + getGravityField(from,on));
                }
            }
        }
        Planet[] planets = Planet.values();
        for(int i = 0; i< planets.length;i++){
            for(int j=i;j!=0;j--){
                Planet from = planets[i];
                Planet on = planets[i-j];
                System.out.println("The gravitational force from the " + from.name() + " on the " + on.name() + " is " + getGravityField(from,on));
            }
        }

    }

    public static ScientificNumber getGravityField(Planet from, Planet on) {
        ScientificNumber g = new ScientificNumber(6.67, -11);
        ScientificNumber fromMass = new ScientificNumber(from.getMass(), from.getMassExponent());
        ScientificNumber distance = new ScientificNumber(from.getDistance(), from.getDistanceExponent());
        ScientificNumber distance2 = new ScientificNumber(on.getDistance(),on.getDistanceExponent());
        distance.subtract(distance2);
        distance.multiply(distance);
        g.multiply(fromMass);
        g.division(distance);
        return g;
    }

    public static ScientificNumber getGravitationalForce(Planet from, Planet on) {
        ScientificNumber F = getGravityField(from,on);
        ScientificNumber onMass = new ScientificNumber(on.getMass(),on.getMassExponent());
        F.multiply(onMass);
        return F;
        //g = G * massFrom * / (distanceBetweenPlanets^2)
        //F = G * massFrom * massOn * / (distanceBetweenPlanets^2)
    }

    public enum Planet {
        SUN(435000, 1.989, 30, 1.5, 11),
        MOON(1079.6,7.34767309,22,3.844,6),
        EARTH(3963.1,5.97219,24,0,0),
        BLACKHOLE(20000000,5,100000,1,1),
        MCDONALDS(1,3,5,6,1);

        private final double radius;
        private final double mass;
        private final int scienticMass;
        private final double distance;
        private final int scienticDistance;
        Planet(double radius, double mass, int scienticMass, double distance, int scienticDistance) {
            this.radius = radius;
            this.mass = mass;
            this.distance = distance;
            this.scienticMass = scienticMass;
            this.scienticDistance = scienticDistance;
        }
        public double getRadius(){
            return radius;
        }
        public double getMass(){
            return mass;
        }
        public double getDistance(){
            return distance;
        }
        public int getDistanceExponent(){
            return scienticDistance;
        }
        public int getMassExponent(){
            return scienticMass;
        }



    }
}
