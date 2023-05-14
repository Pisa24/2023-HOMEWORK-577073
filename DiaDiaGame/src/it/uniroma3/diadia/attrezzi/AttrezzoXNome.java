package it.uniroma3.diadia.attrezzi;

import java.util.Comparator;

public class AttrezzoXNome implements Comparator<Attrezzo>{

	@Override
	public int compare(Attrezzo o1, Attrezzo o2) {
		if(o1.getNome().compareTo(o2.getNome())==0)
			return o1.getPeso()-o2.getPeso();
		return o1.getNome().compareTo(o2.getNome());
	}

}
