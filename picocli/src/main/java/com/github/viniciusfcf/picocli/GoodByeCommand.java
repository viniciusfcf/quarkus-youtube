package com.github.viniciusfcf.picocli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name = "goodbye")
public class GoodByeCommand implements Runnable{

    @Option(names = { "-n", "--nome"}, description = "Nome do usuário", required = true)
    String nome;

	@Override
	public void run() {
		System.out.println("Xau!! "+nome);
	}
    
}