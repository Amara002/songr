package com.example.demo;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class DemoApplicationTests {

	@Test
	void contextLoads() {
	}
	@Test
	void testConstructor() {
		Album kolthom = new Album("kolthoom","om kolthoom",20,1000,"https://music.metason.net/image?fn=A-249512.jpeg&sc=_63");
		kolthom.setTitle("Title");
		assertEquals("Title",kolthom.getTitle());
		kolthom.setArtist("Artist");
		assertEquals("Artist",kolthom.getArtist());
		kolthom.setSongCount(2);
		assertEquals(2,kolthom.getSongCount());
		kolthom.setLength(5000);
		assertEquals(5000 , kolthom.getLength());
	}

}
