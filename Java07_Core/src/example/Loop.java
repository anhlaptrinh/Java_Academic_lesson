package example;

import java.util.Scanner;

public class Loop {
	public static void main(String[] args) {
		Scanner sc=new Scanner(System.in);
//		System.out.println("Vui lòng nhập điểm thi: ");
//		double diemThi=sc.nextDouble();
//		while(diemThi<5) {
//			//thêm điều kiện thì hạy code ở đây
//			System.out.println("Vui lòng nhập điểm thi: ");
//			diemThi=sc.nextDouble();
//			
//		}
//		//Xuất giá trị của biến điểm thi ra màn hình
//		System.out.println("Điểm thi là: "+diemThi);
		int n,sum=0;
		do {
			n=sc.nextInt();
			if(n>0) sum+=n;
		}while(n>0);
		System.out.println("tổng: "+sum);
	}
}
