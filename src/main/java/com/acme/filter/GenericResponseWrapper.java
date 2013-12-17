package com.acme.filter;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.PrintWriter;

import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpServletResponseWrapper;

public class GenericResponseWrapper extends HttpServletResponseWrapper {
	private PrintWriter pw;
	public FilterServletOutputStream filterOutputStream;
	private int contentLength;
	private String contentType;

	public GenericResponseWrapper(HttpServletResponse response) {
		super(response);
	}


	public ServletOutputStream getOutputStream() throws IOException {
		if (filterOutputStream == null) {
			filterOutputStream = new FilterServletOutputStream();
		}
		return filterOutputStream;
	}

	public PrintWriter getWriter() throws IOException {
		if (pw == null) {
			if (filterOutputStream == null) {
				filterOutputStream = new FilterServletOutputStream();
			}
			pw = new PrintWriter(new OutputStreamWriter(getOutputStream(),
					getResponse().getCharacterEncoding()));
		}
		return pw;
	}

	public void setContentLength(int length) {
		this.contentLength = length;
		super.setContentLength(length);
	}

	public int getContentLength() {
		return contentLength;
	}

	public void setContentType(String type) {
		this.contentType = type;
		super.setContentType(type);
	}

	public String getContentType() {
		return contentType;
	}
}
