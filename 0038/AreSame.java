public class AreSame {
	public static boolean comp(int[] a, int[] b) {

		boolean aresame = false;

		for (int x = 0; x < a.length; x++) {
			if (Math.sqrt(a[x]) != b[x]) {

				System.out.println(Math.sqrt(a[x]) + " and " + b[x]);

				aresame = false;
			}
		}

		return aresame;
	}

	public static void main(String[] args) {

		int[] a = new int[] { 121, 144, 19, 161, 19, 144, 19, 11 };
		int[] b = new int[] { 121, 14641, 20736, 361, 25921, 361, 20736, 361 };

		System.out.println(comp(a, b));
	}
}