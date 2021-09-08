/**
 * It's a simple program. I just wanted to write the exercise; It could be way
 * better with designing a menu, creating more Objects like Passenger, Taxi
 * Driver, Taxi and so an; but i was tired and has no more time for programming
 * , so...;
 * 
 * @author Mahdi
 *
 */
public class Main {

	public static void main(String[] args) {
		Distance dis = new Distance();
		dis.setCurrentPosition(2);
		dis.setDestination(3);
		System.out.println(dis.getDistanceCoefficient());
		int co1 = dis.getDistanceCoefficient();

		TripMethod tr = new TripMethod();
		tr.setRainyWeather();
		tr.heavyTrafficOff();
		tr.setVehicleMode(1); // 1 for economic; 2 for vip; 3 for motorcycle;
		double price = tr.getPrice();

		double finalPrice = price * co1;
		System.out.println(finalPrice);
	}
}
