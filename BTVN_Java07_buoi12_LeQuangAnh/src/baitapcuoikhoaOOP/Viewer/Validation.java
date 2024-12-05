package baitapcuoikhoaOOP.Viewer;

import java.util.Scanner;
import java.util.regex.Pattern;

public class Validation {
	public static Scanner scanner = new Scanner(System.in);
	 public enum DataType {
	        STRING,
	        DOUBLE,
	        INTEGER,
	        PHONE
	    }

	    @SuppressWarnings("unchecked")
		public static <T> T getValue(String message, DataType type) {
	        System.out.println(message);

	        switch (type) {
	            case DOUBLE:
	                return (T) Double.valueOf(getValidDoubleInput());
	            case INTEGER:
	                return (T) Integer.valueOf(getValidIntegerInput());
	            case STRING:
	            	return (T) getValidStringInput();
	            case PHONE:
	            	return (T) getValidPhoneNumber();
	            	
	                
	        }
			return null;
	    }
	public static int getValidIntegerInput() {
        while (true) {
            String input = scanner.nextLine();
            if (input.matches("\\d+")) {
               int values= Integer.parseInt(input);
                if (values > 0) {
	                return values;
	            } else {
	                System.out.println("Invalid input. Please enter a value greater than 0.");
	            }
            } else {
                System.out.println("Invalid input. Please enter a valid positive integer.");
            }
        }
    }
	 public static String getValidStringInput() {
	        String input;
	        while (true) {
	            input = scanner.nextLine();
	            if (!input.isEmpty() && Pattern.matches("[a-zA-Z0-9 ]+", input)) {
	                return input;
	            } else {
	                System.out.println(
	                        "Vui lòng nhập đúng định dạng và không dấu hay kí hiệu đặc biệt.");
	            }
	        }
	    }
	 public static String getValidPhoneNumber() {
	        String input;
	        while (true) {
	            input = scanner.nextLine();
	            if (!input.isEmpty() && Pattern.matches("\\d{10}", input)) {
	                return input;
	            } else {
	            	 System.out.println("Vui lòng nhập đúng định dạng số với 10 chữ số.");
	            }
	        }
	    }
	 public static double getValidDoubleInput() {
		    while (true) {
		        String input = scanner.nextLine();
		        
		        // Kiểm tra xem đầu vào có phải là số thực không
		        if (input.matches("\\d+(\\.\\d+)?")) { 
		            double value = Double.parseDouble(input);
		            
		            // Kiểm tra xem giá trị có lớn hơn 0 không
		            if (value > 0) {
		                return value;
		            } else {
		                System.out.println("Invalid input. Please enter a value greater than 0.");
		            }
		        } else {
		            System.out.println("Invalid input. Please enter a valid positive double.");
		        }
		    }
		}
}
