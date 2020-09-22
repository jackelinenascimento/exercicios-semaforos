package view;

import java.util.concurrent.Semaphore;

import controller.ThreadCarro;

public class Cruzamento {

	public static void main(String[] args) {

		int permissoes = 1;
		Semaphore semaforo = new Semaphore(permissoes);
		String[] sentidos = {"norte", "sul", "leste", "oeste"};
		
		for(int idCarro = 1; idCarro<5; idCarro++) {
			
			String sentido = sentidos[(int)(Math.random()*3)];
			Thread tCarro = new ThreadCarro(idCarro, sentido, semaforo);
			tCarro.start();
		}
	}
}
