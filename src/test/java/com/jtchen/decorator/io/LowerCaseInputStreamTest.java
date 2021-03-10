package com.jtchen.decorator.io;

import org.junit.Before;
import org.junit.Test;

import java.io.ByteArrayOutputStream;
import java.io.FileInputStream;
import java.io.IOException;

import static org.junit.Assert.*;

public class LowerCaseInputStreamTest {

	private LowerCaseInputStream lowerCaseInputStream;

	@Before
	public void setUp() throws Exception {
		FileInputStream fis = new FileInputStream("src/main/resources/test.txt");
		lowerCaseInputStream = new LowerCaseInputStream(fis);
	}

	@Test
	public void testRead1() throws IOException {
		StringBuilder builder = new StringBuilder();
		int data;

		while ((data = lowerCaseInputStream.read()) != -1) {
			builder.append((char) data);
		}
		lowerCaseInputStream.close();

		System.out.println(builder);
	}

	@Test
	public void testRead2() throws IOException {
		ByteArrayOutputStream byteArrayOutputStream = new ByteArrayOutputStream();
		int len;
		byte[] bytes = new byte[1024];

		while ((len = lowerCaseInputStream.read(bytes)) != -1) {
			byteArrayOutputStream.write(bytes, 0, len);
		}

		byteArrayOutputStream.flush();

		String string = byteArrayOutputStream.toString();

		byteArrayOutputStream.close();
		lowerCaseInputStream.close();
		System.out.println(string);

	}
}