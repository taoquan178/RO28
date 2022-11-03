package question1;

public class Question1 {
	public static void main(String[] args) {

		/**
		 * Question 1: 1 học viên đã code bài min,max và có 1 vài lỗi sai như hình dưới
		 * (Code trong File DebugExercise.rar, hãy giải nén ra và import vào eclipse). Để
		 * tìm được ra bug, hãy thực hiện từng thao tác dưới đây để tìm ra lỗi và sửa nó
		 * a) Trong function getMaxValue, hãy tìm xem tại vòng lặp i = 4 thì
		 * variable maxValue đang có giá trị bao nhiêu
		 * b) Tại vòng lặp i = 4, hãy thử set lại maxValue = 5
		 * c) Hãy tìm bug và sửa lại cho bài trên để tìm Max Value và Min
		 * Value cho đúng
		 */
		// a, tại vòng lặp i = 4 thì variable maxValue đang có giá trị là -1
		// b, tại vòng lặp i = 4 có maxValue = 5 thì maxValue =-8 , numbers[5] = -8, numbers[i] = -5
		// c, sửa lại điều kiện if (numbers[i] < maxValue) thành if (numbers[i] > maxValue) trong method getMaxValue
		//    sửa lại điều kiện for (int i = 1; i < numbers.length - 1; i++)
		//    thành for (int i = 1; i <= numbers.length - 1; i++) sửa dấu so sánh < thành <= để nó có thể lặp lại hết giá trị

		int[] numbers = { -1, 1, 3, 5, -5, -8 };
		int maxValue = getMaxValue(numbers);
		int minValue = getMinValue(numbers);

		System.out.println("Max Value: " + maxValue);
		System.out.println("Min Value: " + minValue);
	}

	public static int getMaxValue(int[] numbers) {
		int maxValue = numbers[0];
		for (int i = 1; i < numbers.length; i++) {
			if (numbers[i] > maxValue) {
				maxValue = numbers[i];
			}
		}
		return maxValue;
	}

	public static int getMinValue(int[] numbers) {
		int minValue = numbers[0];
		for (int i = 1; i <= numbers.length - 1; i++) {
			if (numbers[i] < minValue) {
				minValue = numbers[i];
			}
		}
		return minValue;
	}
}
