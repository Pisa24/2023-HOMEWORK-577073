package it.uniroma3.diadia.Partite;

import java.util.List;
import it.uniroma3.diadia.DiaDia;
import it.uniroma3.diadia.IOSimulator;
import it.uniroma3.diadia.ambienti.Labirinto;

class IOSimulatorTest {
	
	public static IOSimulator PartitaSemplice(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto labirinto = Labirinto.newBuilder()
				.addStanzaIniziale("Bagno")
				.addStanzaFinale("Camera")
				.addStanza("Corridoio")
				.addAdiacenza("Bagno", "Corridoio", "sud")
				.addAdiacenza("Corridoio", "Bagno", "nord")
				.addAdiacenza("Corridoio", "Camera", "sud")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io,labirinto);
		gioco.gioca();
		return io;
	}
	
	public static IOSimulator PartitaMonolocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto monolocale = Labirinto.newBuilder()
				.addStanzaIniziale("Bagno")
				.addStanzaFinale("Bagno")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io,monolocale);
		gioco.gioca();
		return io;
	}
	

	public static IOSimulator PartitaBilocale(List<String> comandiDaLeggere) {
		IOSimulator io = new IOSimulator(comandiDaLeggere);
		Labirinto bilocale = Labirinto.newBuilder()
				.addStanzaIniziale("Bagno")
				.addAdiacenza("Bagno","Camera", "sud")
				.addStanzaFinale("Camera")
				.getLabirinto();
		DiaDia gioco = new DiaDia(io,bilocale);
		gioco.gioca();
		return io;
	}
}
