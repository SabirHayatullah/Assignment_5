public class HolidayBonus {
	
	public static double[] calculateHolidayBonus(double[][] data, double high, double low, double other) {

		double bonus[] = new double[data.length];

		for (int row = 0; row < data.length; row++) {
			for (int col = 0; col < data[row].length; col++) {
				double highest = TwoDimRaggedArrayUtility.getHighestInColumn(data, col);
				double lowest = TwoDimRaggedArrayUtility.getLowestInColumn(data, col);

				if (data[row][col] > 0) {
					if (data[row][col] == highest) {
						bonus[row] += high;
					} else if (data[row][col] == lowest) {
						bonus[row] += low;
					} else {
						bonus[row] += other;
					}

				}
			}
		}

		return bonus;
	}

	
	public static double calculateTotalHolidayBonus(double[][] data, double high, double low, double other) {

		double[] bonus = calculateHolidayBonus(data, high, low, other);

		double sum = 0;

		for (int i = 0; i < bonus.length; i++) {
			sum += bonus[i];
		}

		return sum;
	}

}