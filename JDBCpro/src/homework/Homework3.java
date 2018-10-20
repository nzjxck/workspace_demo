package homework;

public class Homework3 {
	public static void main(String[] args) {
		float sum = 0;
		float temp = 1;
		int flag = -1;

		for (float i = 1; Math.abs(temp) > 10e-5; i++) {
			temp = 1 / i;
			flag *= -1;
			temp = flag * temp;
			sum += temp;
		}
		System.out.println(sum);
	}
}
