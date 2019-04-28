import java.util.Arrays;

public class Testing {

	public static void main(String[] args) {
		double d[] = {1.0,2.0,3.0,99.0,5.0,6.0,7.0,8.0};
		System.out.println( median(d));
	}

	public static double median(double[] d) {
		double median = Double.NaN;
		if (d != null & d.length > 0) {
			if (d.length == 1) {
				median = d[0];
			} else {
				Arrays.sort(d);
				int mid = d.length / 2;
				if (d.length % 2 != 0) {
					median = d[mid];
				} else {
					median = (d[mid - 1] + d[mid]) / 2;
				}
			}
		}
		return median;
	}
}


