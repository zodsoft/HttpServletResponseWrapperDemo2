package com.acme.filter;

import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;

import javax.servlet.ServletOutputStream;

public class FilterServletOutputStream extends ServletOutputStream {

	public ByteArrayOutputStream output = null;
	public DataOutputStream stream;

	public FilterServletOutputStream() {
		output = new ByteArrayOutputStream();
		stream = new DataOutputStream(output);
	}

	@Override
	public void write(int b) throws IOException {
		stream.write(b);
	}

	@Override
	public void write(byte b[]) throws IOException {
		stream.write(b);
	}

	@Override
	public void write(byte buf[], int offset, int len) throws IOException {
		stream.write(buf, offset, len);
	}

	@Override
	public void flush() throws IOException {
		stream.flush();
	}

	@Override
	public void close() throws IOException {
		stream.close();
	}

	public ByteArrayOutputStream getBuffer() {
		return output;
	}

}
