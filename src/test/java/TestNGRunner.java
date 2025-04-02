import org.testng.TestNG;
import org.testng.TestRunner;

import Com.naukari.Naukari.com.UpdateProfile;

public class TestNGRunner {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
	        TestNG testng = new TestNG();

	        // Add test classes to run
	        testng.setTestClasses(new Class[]{TestRunner.class, UpdateProfile.class});

	        // Execute TestNG tests
	        testng.run();
	}

}
