package view;

import java.util.concurrent.Semaphore;

import controller.Conta;

public class CaixaEletronico {

	public static void main(String[] args) {
	
		int permissao = 2;
		Semaphore semaforo = new Semaphore(permissao);
		
		for(int i=0; i<20; i++) {
			
			int operacao = (int)((Math.random()*2)+1);
			int valor = (int)((Math.random()*100)+100);
			int saldo = (int)((Math.random()*1000)+1000);
			
			Conta conta = new Conta(i, operacao, valor, saldo, semaforo);
			conta.start();
		}

	}

}
