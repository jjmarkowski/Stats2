public class Stats {

	public static void main(String[] args) {
		//max
		//min
		//mean
		//median
		//quartile 1
		//quartile 2
		//mode
		//standard deviation
		
		int[] a = {1,2,3,4,5,6,7,8,9,10};

		System.out.println("Max = " + max(a));

		System.out.println("Min = " + min(a));

		System.out.println("Mean = " + mean(a));

		System.out.println("Mode = " + mode(a));

		System.out.println("Standard Deviation = " + standardDeviation(a));

		//array is allready in order from smallest to largest
		int[] b = {7, 15, 36, 39, 40, 41};
		System.out.println("Median = " + median(b));

		System.out.println("Quartile 1 = " + quartile1(b));

		System.out.println("Quartile 3 = " + quartile3(b));
	}

	public static int max(int[] a) {
		int max = a[0];
		for (int i=1; i<a.length; i++) {
			if (max < a[i]) {
				max = a[i];	
			}
		}
		return max;
	}

	public static int min(int[] a) {
		int min = a[0];
		for (int i=1; i<a.length; i++) {
			if (min > a[i]) {
				min = a[i];
			}	
		}
		return min;
	}

	public static double mean(int[] a) {
		double total = 0;
		for (int i=0; i<a.length; i++) {
			total += a[i];
		}
		total = total/a.length;
		return total;
	}

	public static double median(int[] a) {
		double median = 0.0;
		if (0 == a.length % 2) {
			median = (a[(a.length/2)-1] + a[a.length/2])/2.0;
		} else {
			median = a[a.length/2];
		}
		return median;
	}

	public static double quartile1(int[] a) {
		double quartile1 = 0.0;
		int count = (a.length/2)-1;
		int[] b = new int[count+1];
		for (int i=0; i<=count; i++) {
			b[i] = a[i];
		}
		quartile1 = median(b);
		return quartile1;
	}

	public static double quartile3(int[] a) {
		double quartile3 = 0.0;
		int count = 0;
		int[] c = new int[a.length/2];

		if (a.length % 2 == 0) {
			count = (a.length/2);
		} else {
			count = (a.length/2)+1;
		}

		int j = 0;
		for (int i=count; i<a.length; i++) {
			c[j] = a[i];
			j++;
		}
		quartile3 = median(c);
		return quartile3;
	}

	public static int mode(int[] a) {
		int currentModeCount = 0;
		int currentCount = 0;
		int mode = 0;

		for (int i=0; i<a.length; i++) {

			for (int j=0; j<a.length; j++) {
				if (a[i] == a[j]) {
					currentCount++;					
				}				
			}
			if (currentCount > currentModeCount) {
				mode = a[i];
				currentModeCount = currentCount;
			}
			currentCount = 0;
		}
		return mode;
	}

	public static double standardDeviation(int[] a) {
		double deviation = 0;
		double avg = mean(a);

		for (int i=0; i < a.length; i++) {
			deviation += (a[i] - avg)*(a[i]-avg);
		}

		deviation = deviation/ (a.length-1);
		deviation = Math.sqrt(deviation);

		return deviation;
	}
	
}