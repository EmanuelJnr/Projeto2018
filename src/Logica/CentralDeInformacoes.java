package Logica;

import java.util.ArrayList;

public class CentralDeInformacoes {
	private ArrayList<Usuario> usuariosCadastrados = new ArrayList<Usuario>();
	private ArrayList<Leilao> leiloesCadastrados = new ArrayList<Leilao>();

	public boolean adicionarUsuario(Usuario uAdd) {
		for(Usuario u : usuariosCadastrados) {
			if(uAdd.equals(u))
				return false;
		}
		usuariosCadastrados.add(uAdd);
		return true;
	}
	public Usuario recuperarUsuario(String login){
		for(Usuario u : usuariosCadastrados) {
			if(u.getLogin().equals(login))
				return u;
		}
		return null;
	}
	public boolean adicionarLeilao(Leilao lAdd) {
		for(Leilao l : leiloesCadastrados) {
			if(lAdd.equals(l))
				return false;
		}
		leiloesCadastrados.add(lAdd);
		return true;
	}
	public Leilao recuperarLeilaoPeloId(long id) {
		for(Leilao l : leiloesCadastrados) {
			if(id==l.getId())
				return l;
		}
		return null;
	}
	public ArrayList<Leilao> recuperarLeiloesDeUmUsuario(String nome){
		Usuario u = null;
		for (Usuario us : usuariosCadastrados) {
			if(us.getNome().equals(nome))
				u=us;
		}
		if(u==null)
			return null;
		ArrayList<Leilao> leiloesDeUmUsuario = new ArrayList<>();
		for(Leilao l : leiloesCadastrados) {
			if(l.getUsuario().equals(u))
				leiloesDeUmUsuario.add(l);
		}
		return leiloesDeUmUsuario;
	}
	public ArrayList<Usuario> getUsuariosCadastrados() {
		return usuariosCadastrados;
	}
	public ArrayList<Leilao> getLeiloesCadastrados() {
		return leiloesCadastrados;
	}
}