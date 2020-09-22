package controler;

import java.util.concurrent.Semaphore;

public class ThreadCarro extends Thread{

	private int idCarro;
	private int equipe;
	private Semaphore semaforo;
	private static int tempos[] = new int[14];
	private static int competidores[] = new int[14];
	private static int equipes[] = new int[14];
	private static int posCarro;
	
	public ThreadCarro() {};
	
	public ThreadCarro(int idCarro, int equipe, Semaphore semaforo) {
		this.idCarro = idCarro;
		this.equipe = equipe;
		this.semaforo = semaforo;
	}
	
	@Override
	public void run() {
		try{
			semaforo.acquire();
			largada();
		} catch (InterruptedException e) {
			e.printStackTrace();
		} finally {
			semaforo.release();
		}
	}

	private void largada() {
		
		int melhorTempo = 0;
		
		System.out.println("Carro " + idCarro + " da Equipe " + equipe + "na pista");
		
		for(int voltas=1; voltas<4; voltas++) {
			
			int tempoVolta = (int)((Math.random()*10)+5);
			
			try {
				sleep(tempoVolta);
				if(voltas == 1) {
					melhorTempo = tempoVolta;
				} else {
					if(tempoVolta<melhorTempo) {
						melhorTempo = tempoVolta;
					}
				}
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		
		tempos[posCarro] = melhorTempo;
		competidores[posCarro] = idCarro;
		equipes[posCarro] = equipe;
		posCarro++;
	}
	
	public static void resultado() {
		
		int auxiliar;
		
		for(int i=0; i<14; i++) {
			for(int j=0; j<14; j++) {
				if(tempos[i] < tempos[j]) {
					auxiliar = tempos[i];
					tempos[i] = tempos[j];
					tempos[j] = auxiliar;
					
					auxiliar = competidores[i];
					competidores[i] = competidores[j];
					competidores[j] = auxiliar;
					
					auxiliar = equipes[i];
					equipes[i] = equipes[j];
					equipes[j] = auxiliar;
				}
			}
		}
		System.out.println("************* RESULTADO ****************");
		for(int i=0; i<14; i++) {			
			System.out.println((i+1) + "º lugar: Carro: " + competidores[i] + " - Equipe: " + equipes[i]);
		}
		
	}
}





