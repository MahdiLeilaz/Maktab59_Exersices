
public class TripMethod {
	private final double economic = 5000.0;
	private final double vip = 10000.0;
	private final double motorcycle = 4000.0;
	private double startPrice;

	private int column;
	private int row;

	private final double[][] situationCoefficientArray = { { 1.4, 1.2, 1.2 }, { 3.0, 2.0, 2.0 }, { 1, 5, 2.0, 0, 8 } };

	private boolean isItRainy;
	private boolean isItHeavyTraffic;

	public void setRainyWeather() {
		this.isItRainy = true;
	}

	public void rainyWeatherOff() {
		this.isItRainy = false;
	}

	public void setHeavyTraffic() {
		this.isItHeavyTraffic = true;
	}

	public void heavyTrafficOff() {
		this.isItHeavyTraffic = false;
	}

	public void setVehicleMode(int input) {
		switch (input) {
		case 1: {
			this.startPrice = this.economic;
			this.row = 0;
		}
			break;
		case 2: {
			this.startPrice = this.vip;
			this.row = 1;
		}
			break;
		case 3: {
			this.startPrice = this.motorcycle;
			this.row = 2;
		}
			break;
		default:
			System.out.println("Not Valid");
			break;
		}
	}

	private void coefficientColumn() {
		if (this.isItRainy && this.isItHeavyTraffic)
			this.column = 0;
		else if (this.isItHeavyTraffic)
			this.column = 1;
		else if (this.isItRainy)
			this.column = 2;
		else
			this.column = 4;
	}

	public double getPrice() {
		coefficientColumn();
		double coefficient = this.situationCoefficientArray[row][column];
		double output = this.startPrice * coefficient;
		return output;
	}

}
