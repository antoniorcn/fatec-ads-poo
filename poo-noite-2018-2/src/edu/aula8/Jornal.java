package edu.aula8;

import java.util.ArrayList;
import java.util.List;

public class Jornal implements Publicadora {
	private List<Assinante> assinantes = new ArrayList<>();
	@Override
	public void adicionar(Assinante a) {
		assinantes.add(a);
	}
	@Override
	public void remover(Assinante a) {
		assinantes.remove(a);
	}
	@Override
	public void publicar(String noticia) {
		for (Assinante a : assinantes) { 
			a.receberNoticia(noticia);
		}
	}
}
