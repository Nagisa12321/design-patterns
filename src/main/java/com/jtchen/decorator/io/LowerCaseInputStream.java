package com.jtchen.decorator.io;

import java.io.FilterInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * @author jtchen
 * @version 1.0
 * @date 2021/3/10 13:23
 */
public class LowerCaseInputStream extends FilterInputStream {
	/**
	 * Creates a {@code FilterInputStream}
	 * by assigning the  argument {@code in}
	 * to the field {@code this.in} so as
	 * to remember it for later use.
	 *
	 * @param in the underlying input stream, or {@code null} if
	 *           this instance is to be created without an underlying stream.
	 */
	protected LowerCaseInputStream(InputStream in) {
		super(in);
	}

	@Override
	public int read() throws IOException {
		int read = super.read();

		if (Character.isUpperCase(read))
			read = Character.toLowerCase(read);

		return read;
	}

	@Override
	public int read(byte[] b, int off, int len) throws IOException {
		int result = super.read(b, off, len);

		for (int i = off; i < off + result; i++) {
			b[i] = (byte) Character.toLowerCase(b[i]);
		}

		return result;
	}
}
