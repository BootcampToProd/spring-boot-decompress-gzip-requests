package com.bootcamptoprod.filter;

import jakarta.servlet.ServletInputStream;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletRequestWrapper;

import java.io.IOException;
import java.util.zip.GZIPInputStream;

public class GzipHttpServletRequestWrapper extends HttpServletRequestWrapper {

    public GzipHttpServletRequestWrapper(HttpServletRequest request) throws IOException {
        super(request);
    }

    @Override
    public ServletInputStream getInputStream() throws IOException {
        return new GzipServletInputStreamWrapper(new GZIPInputStream(super.getInputStream()));
    }
}