package demo;

import junit.framework.TestCase;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

import demo.entity.AppUser;

/**
 * Unit test for simple App.
 */
public class AppTest extends TestCase {

	public void testApp() {
		SessionFactory sessionFactory = new Configuration().configure().buildSessionFactory();
		Session session = sessionFactory.openSession();
		session.beginTransaction();

		AppUser user = new AppUser("firstuser");
		session.save(user);

		session.getTransaction().commit();
		session.close();
	}
}







//import junit.framework.Test;
//import junit.framework.TestCase;
//import junit.framework.TestSuite;

/**
 * Unit test for simple App.
 */
//public class AppTest extends TestCase
//{
    /**
     * Create the test case
     *
     * @param testName name of the test case
     */
    //public AppTest( String testName )
    //{
        //super( testName );
    //}

    /**
     * @return the suite of tests being tested
     */
    //public static Test suite()
    //{
        //return new TestSuite( AppTest.class );
    //}

    /**
     * Rigourous Test :-)
     */
    //public void testApp()
    //{
        //assertTrue( true );
    //}
//}
