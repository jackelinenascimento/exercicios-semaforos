package view;

import java.util.concurrent.Semaphore;

public class PessoaThread extends Thread {

	private int idPessoa;
	private static int posChegada;
	private static int posSaida;
	private Semaphore semaforo;
	
	public PessoaThread(int idPessoa, Semaphore semaforo) {
		this.idPessoa = idPessoa;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		pessoaAndando();
		
		try {
			semaforo.acquire();
			pessoaAtravessando();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		pessoaAtravessou();
	}

	private void pessoaAndando() {
		int distanciaTotal = 200;
		int distanciaPercorrida = 0;
		int deslocamento = (int)((Math.random()*2)+2);
		int tempo = 1000;

		while (distanciaPercorrida < distanciaTotal) {
			distanciaPercorrida += deslocamento;
			try {
				sleep(tempo);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			System.out.println("#" + idPessoa + " já andou " + distanciaPercorrida + "m.");
		}
		posChegada++;
		System.out.println("#" + idPessoa + " foi o " + posChegada + " o. a chegar na porta.");
		
	}

	private void pessoaAtravessando() {
		System.out.println("#" + idPessoa + " atravessando a porta");
		int tempo = (int) ((Math.random() * 1) + 1);
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
	}

	private void pessoaAtravessou() {
		posSaida++;
		System.out.println("#" + idPessoa + " foi o " + posSaida + "o. a atravessar a porta.");
		
	}
}
