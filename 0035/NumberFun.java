public class NumberFun {
	public static double findNextSquare(long sq) {

		long num = sq;
		double newNum = 0;
		boolean found = false;

		while (!found) {

			if (num > 500) {
				found = true;
			}
			double sqrtNum = Math.sqrt(num);

			if (sqrtNum * sqrtNum == num) {
				found = true;

				newNum = (int) sqrtNum * sqrtNum;
			}

			num++;
		}

		return newNum;
	}

	public static void main(String[] args) {

		System.out.println(findNextSquare(121));
	}
}