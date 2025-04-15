package DataProvider;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class DataProvider2 {

	
	
	@Test(dataProvider = "getData")
	public void bookTickets( String src , String dest , int noOfPass) {
		
		System.out.println("Book Tickets from "+src+"  to "+dest+" ---> NoOfPassengers= "+noOfPass);
	}

	
	@DataProvider
	public Object[][] getData() {
		
		
		Object [][] objArr = new Object[3][3];
		
		objArr[0][0] = "Banglore";
		
		objArr[0][1]= "Goa";
		
		objArr[0][2]= 10;
		
		objArr[1][0] = "Banglore";
		
		objArr[1][1]= "Pune";
		
		objArr[1][2]= 15;
		
		objArr[2][0] = "Banglore";
		
		objArr[2][1]= "Hyderabad";
		
		objArr[2][2]= 30 ;
		
		
		return objArr;
		
		
		
		
	}
}
