package org.example.utils;


import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.Scanner;
import java.util.regex.Pattern;

/**
 * Class chưa các hàm hỗ trợ liên quan đến nhập dữ liệu từ bàn phím
 */
public class ScannerUtils {

	private static Scanner sc = new Scanner(System.in);

	public static final Pattern REGEX_EMAIL = Pattern.compile("^[A-Z0-9._%+-]+@[A-Z0-9.-]+\\.[A-Z]{2,6}$", Pattern.CASE_INSENSITIVE);
	public static Integer inputInt() {
		while (true) {
			try {
				return Integer.parseInt(sc.nextLine());
			} catch (Exception e) {
				System.err.print("Dữ liệu bạn nhập vào không phải là số mời nhập lại: ");
			}
		}
	}

	public static String inputString() {
		while (true) {
			String string = sc.nextLine().trim();
			if (!string.isEmpty()) {
				return string;
			} else {
				System.err.print("Dữ liệu ban nhập vào không phải là chuỗi mời nhập lại: ");
			}
		}
	}

	public static LocalDate inputLocalDate() {
		System.out.println("Nhập theo định dạng yyyy-MM-dd");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		while (true) {
			String localdate = sc.next().trim();
			try {
				if (format.parse(localdate) != null) {
					return LocalDate.parse(localdate);
				}
			} catch (Exception e) {
				System.err.println("Nhập lại:");
			}
		}
	}

	public LocalDate parseLocalDate(String localdate) throws ParseException {
		SimpleDateFormat format = new SimpleDateFormat("yyyy,MM,dd");
		Date date = format.parse(localdate);
		return LocalDate.parse(localdate);
	}

	public static String inputStringPassword() {
		while (true) {
			String string = sc.nextLine().trim();
			if (Pattern.matches("[a-zA-Z0-9_-]{6,12}$", string)) {
				return string;
			} else {
				System.err.println("Dữ liệu ban nhập vào phải từ ( 6-12 kí tự và có chữ thường, chữ hoa và số ): ");
			}
		}
	}

	public static String inputStringEmail() {
		while (true) {
			String string = sc.nextLine().trim();
			String regexPattern = "^(.+)@(\\S+)$";
			if (Pattern.compile(regexPattern).matcher(string).matches()) {
				return string;
			} else {
				System.err.println("Dữ liệu ban nhập vào phải là email");
			}
		}
	}

	public static String inputStringFullName() {
		while (true) {
			String string = sc.nextLine().trim();
			if (Pattern.matches("^[A-Z a-zÀÁÂÃÈÉÊÌÍÒÓÔÕÙÚÝàáâãèéêìíòóôõùúýĂăĐđĨĩŨũƠơƯưẠ-ỹ]+$", string)) {
				return string;
			} else {
				System.err.println("Họ tên không được nhập số và kí tự đặc biệt");
			}
		}
	}


}
