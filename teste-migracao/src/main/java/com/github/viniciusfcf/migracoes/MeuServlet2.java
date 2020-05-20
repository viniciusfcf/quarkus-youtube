package com.github.viniciusfcf.migracoes;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.microprofile.config.inject.ConfigProperty;

@WebServlet("servlet2")
public class MeuServlet2 extends HttpServlet{

	private static final long serialVersionUID = 1L;
    
    @ConfigProperty(name="meu.nome")
    String i;

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.getOutputStream().print("Olá, Servlet com anotação do Quarkus "+i);
    }
}