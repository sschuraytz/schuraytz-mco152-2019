package schuraytz.fire;

public class Projectile {

    private final double velocity;
    private final double degrees;
    private double time;

    public Projectile(double velocity, double degrees) {
        this.velocity = velocity;
        this.degrees = degrees;
    }

    public void addTime(double deltaTime) {
        time += deltaTime;
    }

    public double getX() {
        return Math.cos(Math.toRadians(degrees)) * velocity * time;
    }

    public double getY() {
        return Math.sin(Math.toRadians(degrees)) * velocity * time - 9.8 * 0.5 * (time * time);
    }

    @Override
    public String toString() {
        return "seconds since launch: " + time + " \t\tx:  " + getX() + "\t\t\t\ty:  " + getY();
        //return "Launched " + time + " seconds ago:    x: " + getX() + "   y: " + getY();
    }
}
