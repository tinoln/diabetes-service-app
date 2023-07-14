package com.tinoln.serviceapp.web.reports;

import java.io.IOException;

import javax.servlet.http.HttpServletResponse;

import net.sf.jasperreports.engine.JRException;
import net.sf.jasperreports.engine.JasperPrint;

public interface JasperReportsExporter {

	void export(JasperPrint jp, String fileName, HttpServletResponse response) throws JRException, IOException;

}