package com.example.tp.tp6;

import com.example.tp.verification.tp6.exceptions.ElementIsNull;
import com.example.tp.verification.tp6.exceptions.QueueIsEmpty;
import com.example.tp.verification.tp6.exceptions.TailIsNull;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import com.example.tp.verification.tp6.model.Queue;
import static org.junit.jupiter.api.Assertions.*;

public class QueueTest {
	Queue<String> fa0, fa1, fa2;

	@BeforeEach
	public void setUp() throws Exception {
		fa0 = new Queue<String>();

		fa1 = new Queue<String>();
		fa1.push("plop");

		fa2 = new Queue<String>();
		fa2.push("a");
		fa2.push("b");
	}

	@Test
	public void testIsEmpty() {
		assertTrue(fa0.isEmpty());
		assertFalse(fa1.isEmpty());
	}

	@Test
	public void testPush() {
		assertTrue(fa0.isEmpty()); 
		fa0.push("toto");
		assertFalse(fa0.isEmpty());
	}

	@Test
	public void testPop() {
		//exception
		try{
			fa0.pop();
			fail();
		}catch(QueueIsEmpty e){
			//ok
		}
		assertEquals(fa1.pop(),"plop");
		assertTrue(fa1.isEmpty());
		assertEquals(fa2.pop(), "b");
		assertEquals(fa2.pop(),"a");
		assertTrue(fa2.isEmpty());
	}

	@Test
	public void testPushTail() {
		//exception
		try{
			fa0.front();
			fail();
		}catch(TailIsNull e){
			//ok
		}
		fa0.push("toto");
		assertEquals(fa0.front(),"toto");
		fa1.push("titi");
		assertEquals(fa1.front(),"plop");
	}

	@Test
	public  void testPopTail() {
		fa1.pop();
		try{
			fa1.front();
			fail();
		}catch(TailIsNull e){
			//ok
		}
		fa2.pop();
		assertEquals(fa2.front(),"a");
	}

	@Test
	public void testSize() {
		try{
			fa0.size();
			fail();
		} catch(QueueIsEmpty e){
			//ok
		}
		assertEquals(fa1.size(),1);
		assertEquals(fa2.size(),2);
	}

	@Test
	public void testFront() {
		//exception
		try{
			fa0.front();
			fail();
		}catch(TailIsNull e){
			//ok
		}
		assertEquals(fa1.front(),"plop");
		assertEquals(fa2.front(),"a");
	}

	@Test
	public void pushNull() {
		//exception
		try{
			fa0.push(null);
			fail();
		}catch(ElementIsNull e){
			//ok
		}

	}
}
