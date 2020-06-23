package com.github.viniciusfcf.picocli;

import picocli.CommandLine.Command;
import picocli.CommandLine.Option;

@Command(name="hello", mixinStandardHelpOptions=true)
public class HelloCommand implements Runnable{

    @Option(names = { "-n", "--nome"}, description = "Nome do usuário", defaultValue = "Vinicius")
    String nome;

	@Override
	public void run() {
		System.out.println("Olá "+nome);
	}
    
}