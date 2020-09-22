package controller;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

	private int idCarro;
	private String sentido;
	private static int chegada;
	private Semaphore semaforo;
	
	public ThreadCarro(int idCarro, String sentido, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.sentido = sentido;
		this.semaforo = semaforo;
	}
	
	public void run() {
		
		chegadaCruzamento();
		
		try {
			semaforo.acquire();
			cruzar();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
		
		passouCruzamento();
	}

	private void chegadaCruzamento() {
		
		int tempo = (int) (Math.random() * 1000);
		
		try {
			sleep(tempo);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		
		chegada++;
		System.out.println("#" + idCarro + " com sentido " + sentido + " foi o " + chegada + "º a chegar no cruzamento");
		
	}

	private void cruzar() {
		System.out.println("#" + idCarro + " está atravessando o cruzamento");
	}

	private void passouCruzamento() {
		System.out.println("#" + idCarro + " com sentido " + sentido + " passou o cruzamento");
		
	}
	
}
