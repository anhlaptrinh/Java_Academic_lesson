package example;

import java.util.Scanner;

import javax.sound.midi.Soundbank;

public class Function {
	  public static void main(String[] args) {
	        Scanner scanner = new Scanner(System.in);
	        System.out.println("1.Phép cộng");
        	System.out.println("2.Phép trừ");
        	System.out.println("3.Phép nhân");
        	System.out.println("4.Phép chia");
        	System.out.print("Chọn chức năng... ");
        	int chucNang=scanner.nextInt();
        	

	        System.out.print("Nhập số thứ nhất: ");
	        int a = scanner.nextInt();

	        System.out.print("Nhập số thứ hai: ");
	        int b = scanner.nextInt();

	        switch(chucNang) {
	        case 1 ->System.out.println(a+"+"+b+"="+tinhAB(a, b, '+'));
	        case 2 ->System.out.println(a+"-"+b+"="+tinhAB(a, b, '-'));
	        case 3 -> System.out.println(a+"x"+b+"="+tinhAB(a, b, 'x'));
	        case 4 ->System.out.println(a+"/"+b+"="+tinhAB(a, b, '/'));
	        }

	        scanner.close();
	    }
	/*
	 * Có 2 loại hàm
	 */
	  public static float tinhAB(int a,int b,char c) {
	    	float kq=0;
	    	if(c=='+') return  kq=a+b;
	    	if(c=='-') return kq=a-b;
	    	if(c=='x') return kq=a*b;
	    	if(c=='/') return kq=a/b;
			return kq;
	    	
	    }
//	public static void tinhTongHaiSo() {
//		int a=4;
//		int b=5;
//		int kq=a+b;
//		System.out.println("Kiemtra "+kq);
//	}
//	  public static int timSoLonNhat(int a, int b, int c) {
//	        return timSoLonNhat(a, timSoLonNhat(b, c));
//	    }
//
//	    public static int timSoLonNhat(int a, int b) {
//	        if (a > b) {
//	            return a;
//	        } else {
//	            return b;
//	        }
//	    }
	    
}
