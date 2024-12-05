package baitapcuoikhoaOOP.Viewer;

import java.io.IOException;
import java.text.ParseException;
import java.util.Scanner;

import javax.sound.midi.Soundbank;

import baitapcuoikhoaOOP.Controller.CompanyControl;
import baitapcuoikhoaOOP.Viewer.Validation.DataType;
import baitapcuoikhoaOOP.dto.Company;
import baitapcuoikhoaOOP.dto.DepartmentHead;
import baitapcuoikhoaOOP.dto.Director;
import baitapcuoikhoaOOP.dto.Staff;

public class HumanResourceManagement<T> {
	static Scanner scanner = new Scanner(System.in);
	private CompanyControl comcon = new CompanyControl();

	public HumanResourceManagement() {

	}

	public void Menu() throws IOException, ParseException {
		String[] menu = { "Nhập thông tin công ty", "Phân bổ nhân viên vào trưởng phòng", "Thêm, xóa 1 nhân sự",
				"Xuất ra thông tin toàn bộ người trong công ty", "Tính và xuất tổng lương cho toàn công ty",
				"Tìm nhân viên thường có lương cao nhất",
				"Tìm trưởng phòng có số lượng nhân viên dưới quyền nhiều nhất",
				"Sắp xếp nhân viên toàn công ty theo thứ tự abc", "Sắp xếp nhân viên toàn công ty theo lương giảm dần",
				"Tìm giám đốc có số lượng cổ phần nhiều nhất", "Tính và Xuất tổng thu nhập của từng giám đốc" };
		Menu<?> m = new Menu<Object>("=====================Company Management Menu=====================", menu) {
			@Override
			public void execute(int n) throws ParseException {

				// TODO Auto-generated method stub
				switch (n) {
				case 1: {
					if(comcon.com==null) {
						String companyName = Validation.getValue("Nhập tên công ty: ", DataType.STRING);
						String taxCode = Validation.getValue("Nhập mã số thuế: ", DataType.STRING);
						Double monthlyRevenue = Validation.getValue("Nhập doanh thu tháng: ", DataType.DOUBLE);
						Company com = new Company(companyName, taxCode, monthlyRevenue);
						comcon.addCompany(com);
						System.out.println("Tạo công ty thành công!");
					}
					else System.out.println(comcon.com);
					break;
				}
				case 2: {
					comcon.assignEmployeeToDepartmentHead();
					break;
				}
				case 3: {
					printOrRemoveEmployee();
					break;
				}
				case 4: {
					comcon.printAllEmployee();
					break;
				}
				case 5: {
					System.out.println("Tổng lương cho công ty: " + comcon.calculateTotalCompanySalary());
					break;
				}
				case 6: {
					System.out.println("Nhân viên có lương cao nhất: " );
					for(Staff st : comcon.findHighestSalaryEmployee()) {
						System.out.println(st);
						System.out.println(">>Lương nhận được: "+st.calculateSalary());
						System.out.println("------------------------------");
					}
					break;
				}
				case 7: {
					System.out.println("Trưởng Phòng có nhiều nhân viên dưới quyền nhiều nhất là:");
					for(DepartmentHead headers: comcon.findDepartmentHeadsWithMostEmployees())
						System.out.println(headers);
					break;
				}
				case 8: {
					comcon.sortEmployeesByName();
					System.out.println("Sắp xếp thành công. Vui lòng sử dụng chức năng 4 để in ra");
					break;
				}
				case 9: {
					comcon.sortEmployeesBySalary();
					System.out.println("Sắp xếp thành công. Vui lòng sử dụng chức năng 4 để in ra");
					break;
				}
				case 10: {
					System.out.print("Giám đốc có cổ phần nhiều nhất là: ");
					for(Director dir: comcon.findDirectorWithHighestProfitShare()) {
						System.out.println(dir.getName());
						System.out.println("Cổ Phần: "+dir.getProfitShare()+"%");
					}
					break;
				}
				case 11: {
					comcon.calculateDirectorIncome();
					break;
				}
				case 12: {
					break;
				}

				default:
					System.out.println("Out of function!");
				}

			}
		};
		m.run();
	}

	private void printOrRemoveEmployee() throws ParseException {
		String[] submenu = { "Thêm Nhân sự", "Xóa Nhân sự" };
		Menu<?> m = new Menu<Object>("=====================Company Management Menu=====================", submenu) {

			@Override
			public void execute(int n) throws ParseException {
				// TODO Auto-generated method stub
				switch (n) {
				case 1: {
					String empName = Validation.getValue("Nhập tên: ", DataType.STRING);
					empName = capitalizeWords(empName);
					String empPhone = Validation.getValue("Nhập số điện thoại: ", DataType.PHONE);
					System.out.println("1.Nhân viên");
					System.out.println("2.Trưởng Phòng");
					System.out.println("3.Giám Đốc");
					int role = 0;
					do {
					    role = Validation.getValue("Chọn Chức Vụ: ", DataType.INTEGER);
					    
					    if (role == 1 || role == 2) {
					        comcon.addEmployee(role, empName, empPhone, 0);
					    } else if (role == 3) {
					        // Tính tổng số cổ phần của các giám đốc hiện có
					        double totalProfitShare = comcon.employees.stream()
					                .filter(e -> e instanceof Director)
					                .mapToDouble(e -> ((Director) e).getProfitShare())
					                .sum();

					        double remainingProfitShare = 100 - totalProfitShare;

					        double profitshare = Validation.getValue("Nhập Cổ Phần Sở Hữu: ", DataType.DOUBLE);

					        // Kiểm tra nếu cổ phần nhỏ hơn hoặc bằng giới hạn còn lại
					        if (profitshare <= remainingProfitShare) {
					            comcon.addEmployee(role, empName, empPhone, profitshare);
					        } else {
					            System.out.println("Cổ phần phải ít hơn hoặc bằng " + remainingProfitShare + "%!");
					        }
					    } else {
					        System.out.println("Không hợp lệ!");
					    }
					} while (role < 1 || role > 3);

					break;
				}
				case 2: {
					String empId=Validation.getValue("Nhập id nhân sự muốn xóa: ", DataType.STRING);
					comcon.removeEmployee(empId);
					break;
				}
				case 3:{
					break;
				}
				default:
					System.out.println("Out of function");
				}
			}

		};
		m.run();
	}
	public static String capitalizeWords(String str) {
        if (str == null || str.isEmpty()) {
            return str;
        }

        String[] words = str.trim().split("\\s+");
        StringBuilder capitalized = new StringBuilder();

        for (String word : words) {
            if (word.length() > 0) {
                capitalized.append(Character.toUpperCase(word.charAt(0)))
                           .append(word.substring(1).toLowerCase())
                           .append(" ");
            }
        }

        return capitalized.toString().trim(); // Loại bỏ dấu cách thừa ở cuối chuỗi
    }

}
