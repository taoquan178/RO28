package org.example.vti.util;

import org.example.vti.entity.Department;
import org.example.vti.entity.Position;
import org.example.vti.repository.DepartmentRepository;
import org.example.vti.repository.PositionRepository;
import org.example.vti.service.impl.AccountServiceImpl;

import java.sql.SQLException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import java.util.List;
import java.util.Scanner;

/**
 * Class chưa các hàm hỗ trợ liên quan đến nhập dữ liệu từ bàn phím
 */
public class ScannerUtils {

	private static Scanner sc = new Scanner(System.in);

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

	public static int checkDepartmentID() throws SQLException {
		DepartmentRepository departmentRepository = new DepartmentRepository();
		List<Department> departmentList = departmentRepository.getListDepartments();
		while (true){
			int  a = Integer.parseInt(sc.nextLine());
			try {
				for (Department department1 : departmentList){
					if (department1.getId() == a){
						return a;
					}
				}
			} catch (Exception e){
				System.err.println("Nhập lại:");
			}
		}
	}

	public static int checkPositionID() throws SQLException{
		PositionRepository positionRepository = new PositionRepository();
		List<Position> positionList1 = positionRepository.getListPosition();
		while (true){
			int  a = Integer.parseInt(sc.nextLine());
			try {
				for (Position position1 : positionList1){
					if (position1.getId() == a) {
						return a;
					}
				}
			} catch (Exception e){
				System.err.println("Nhập lại:");
			}
		}
	}
}
