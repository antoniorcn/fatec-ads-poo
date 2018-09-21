package edu.aula7;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicadora {
	private List<Assinante> assinantes = new ArrayList<>();
	@Override
	public void cadastrarAssinante(Assinante a) {
		assinantes.add(a);
	}

	@Override
	public void removerAssinante(Assinante a) {
		assinantes.remove(a);
	}

	@Override
	public void divulgarNoticia(String noticia) {
		for (Assinante a : assinantes) { 
			a.recebeNoticia(noticia);
		}
	}

}
