package br.com.challenge;

import org.junit.Test;

import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import br.com.challenge.entity.Task;
import static org.junit.Assert.*;
@RunWith(SpringRunner.class)
@SpringBootTest
public class ChallengeApplicationTests {

	@Test
	public void testTask() {
		String s1 = "Fist task of the day";
		Task t1 = new Task();
		t1.setTitulo(s1);
		
		assertEquals(t1.getTitulo(), s1);
	}

}
