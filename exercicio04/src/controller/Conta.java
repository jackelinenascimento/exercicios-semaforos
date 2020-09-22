package controller;

import java.util.concurrent.Semaphore;

public class Conta extends Thread{

	private int idConta;
	private int operacao;
	private int valor;
	private int saldo;
	private static Semaphore semaforo;
	
	public Conta(int idConta, int operacao, int valor, int saldo, Semaphore semaforo) {
		this.idConta = idConta;
		this.operacao = operacao;
		this.valor = valor;
		this.saldo = saldo;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		
		try {
			semaforo.acquire();
			if(operacao == 1) {
				deposito();
			} else if(operacao == 2){
				saque();			
			} else {
				System.out.println("Operação inválida.");
			}
			saldo();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void deposito() {
		System.out.println("Conta: #" + idConta + " - Depositado: " + valor);
		saldo+= valor;
		
	}

	private void saque() {
		System.out.println("Conta: #" + idConta + " - Saque: " + valor);
		saldo-= valor;
		
	}

	private void saldo() {
		System.out.println("Conta: #" + idConta + " - O saldo é: " + saldo);
		
	}
	
	
	
}
