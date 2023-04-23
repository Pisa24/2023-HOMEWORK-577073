package it.uniroma3.diadia.ambienti;

import it.uniroma3.diadia.attrezzi.Attrezzo;


/*
 * Stanza magca: una particolare stanza, una volta chr vengono aggiunti 3 oggetti in essa
 * avverrà un comportamento magico.
 * */

public class StanzaMagica extends Stanza{

	private int contatoreAttrezziPosati;
	private int sogliaMagica;

	/*
	 * Costruttore principale con soglia 3 default
	 */
	
	/*
	 * Costruttore con soglia a piacimento
	 */
	public StanzaMagica(String nome, int soglia) {
		super(nome);
		this.contatoreAttrezziPosati = 0;
		this.sogliaMagica = soglia;
	}

	/*
	 * Add attrezzo in overriding tenendo conto del comportamento magico
	 */
	@Override
	public boolean addAttrezzo(Attrezzo attrezzo) {
		
		this.contatoreAttrezziPosati++;
		if(this.contatoreAttrezziPosati > this.sogliaMagica)   //ho superato la soglia magica
			attrezzo = this.modificaAttrezzo(attrezzo);
		return super.addAttrezzo(attrezzo);
	}

	/*
	 * Comportamento magico: inversione del nome e raddoppiamento del peso
	 */
	private Attrezzo modificaAttrezzo(Attrezzo attrezzo) {
		StringBuilder nomeInvertito;
		int pesoX2 = attrezzo.getPeso() * 2;
		nomeInvertito = new StringBuilder(attrezzo.getNome());
		nomeInvertito = nomeInvertito.reverse();
		attrezzo = new Attrezzo(nomeInvertito.toString(),
				pesoX2);
		return attrezzo;
	}

}
