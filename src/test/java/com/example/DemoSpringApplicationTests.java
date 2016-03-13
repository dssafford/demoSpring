package com.example;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.boot.test.SpringApplicationConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import static org.junit.Assert.assertEquals;

@RunWith(SpringJUnit4ClassRunner.class)
@SpringApplicationConfiguration(classes = Application.class)
@WebAppConfiguration
public class DemoSpringApplicationTests {

	@Test
	public void contextLoads() {
		MyController mc = new MyController();
		//mc.printAllAsses();
		assertEquals("doug", "doug");
	}

	@Test
	public void calcResultTest() {
		MyController mc = new MyController();
		assertEquals(mc.calcResult(), 6);
	}
}
