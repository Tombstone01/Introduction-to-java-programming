class MinMax {
	public static int[] minMax(int[] arr) {
		Int[] ints = new Int[2];

		ints[0] = findMin(arr);
		ints[1] = findMax(arr);

		return ints;
	}

	public static int findMin(int[] arr) {

		int min = arr[0];

		for (int x = 1; x < arr.length; x++) {

			if (min > arr[x]) {
				min = arr[x];
			}
		}

		return min;
	}

	public static int findMax(int[] arr) {

		int max = arr[0];

		for (int x = 1; x < arr.length; x++) {

			if (max < arr[x]) {
				min = arr[x];
			}
		}

		return min;
	}

	public static void main(String[] args) {
		
	}
}