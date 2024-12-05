package baitapcuoikhoaOOP.Viewer;

import java.io.IOException;
import java.text.ParseException;

public class CompanyTest {
	public static void main(String[] args) throws IOException, ParseException {
		HumanResourceManagement<?> human=new HumanResourceManagement<Object>();
		human.Menu();
	}
}
