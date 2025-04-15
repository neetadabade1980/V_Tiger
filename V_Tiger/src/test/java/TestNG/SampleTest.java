package TestNG;

import org.testng.annotations.Test;

import Generic_Utilities.BaseClass;


@Test
public class SampleTest  extends BaseClass{
	
	
	@Test
		public void createContact() {
			
			System.out.println("Contact Created");
			
		}
		
	
		public void modifyContact() {
			
			System.out.println("Contact modify");
			
		}
		
	
		public void deleteContact() {
	
			System.out.println("Contact deleted");
	
		}
		
		
		
		
		
		
	}
