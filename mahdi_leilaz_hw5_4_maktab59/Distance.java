
public class Distance {
	private int currentPosition;
	private int destination;
	private final int[][] distanceCoefficientArray = { { 1, 2, 2, 4, 3 }, { 2, 1, 4, 2, 3 }, { 3, 5, 1, 3, 2 },
			{ 4, 3, 3, 1, 2 }, { 3, 3, 2, 2, 1 } };

	public void setCurrentPosition(int currentPosition) {
		this.currentPosition = currentPosition;
	}

	public void setDestination(int destination) {
		this.destination = destination;
	}

	public int getDistanceCoefficient() {
		int output = this.distanceCoefficientArray[this.currentPosition][this.destination];
		return output;
	}

}
