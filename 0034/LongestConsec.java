class LongestConsec {

	public static String longestConsec(String[] strarr, int k) {

		for (int x = 0; x < strarr.length; x++) {
			System.out.println(strarr[x]);
		}
		return "";
	}

	public static void main(String[] args) {

		String[] arr = { "zone", "abigail", "theta", "form", "libe", "zas", "theta", "abigail" };

		longestConsec(arr, 2);
	}
}