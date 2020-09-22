package view;

import java.util.concurrent.Semaphore;

public class Porta {

	public static void main(String[] args) {
	
		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		
		for(int idPessoa = 1; idPessoa<5; idPessoa++) {
			Thread tPessoa = new PessoaThread(idPessoa, semaforo);
			tPessoa.start();
		}

	}

}
