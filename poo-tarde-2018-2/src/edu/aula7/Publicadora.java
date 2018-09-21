package edu.aula7;

public interface Publicadora {
	void cadastrarAssinante(Assinante a);
	void removerAssinante(Assinante a);
	void divulgarNoticia(String noticia);
}
