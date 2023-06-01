package it.uniroma3.diadia.ambienti;

/*
 * stanza buia: non permette di leggere la descrizione della stanza ammeno che
 * non si abbia lo strumento adatto;
 */
public class StanzaBuia extends Stanza{
	private String fonteDiLuce;

	public StanzaBuia(String nome, String fonteDiLuce) {
		super(nome);
		this.fonteDiLuce = fonteDiLuce;
	}
	
	public String getDescrizioneBuia() {
		return "qui c'è un buio pesto... \n"
		+ "Prova a trovare: " + fonteDiLuce;
	}

	@Override
	public String getDescrizione() {
		if(super.hasAttrezzo(this.fonteDiLuce))
			return super.getDescrizione();
		else
			return getDescrizioneBuia();
	}
}
