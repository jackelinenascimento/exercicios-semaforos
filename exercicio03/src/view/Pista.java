package view;

import java.util.concurrent.Semaphore;

import controler.ThreadCarro;

public class Pista {

	public static void main(String[] args) {
	
		Semaphore semaforo = new Semaphore(5);
		
		ThreadCarro res = new ThreadCarro();
		
		int[] equipes = {1,1,2,2,3,3,4,4,5,5,6,6,7,7};
		
		for(int i=0; i<14; i++) {
			
			Thread carro = new ThreadCarro(i, equipes[i], semaforo);
			carro.start();
		}
		
		res.resultado();
		
	}

}
