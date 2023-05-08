package Telas;

import Logica.CentralDeInformacoes;
import Logica.Persistencia;

public class TelaListarUsuarios extends TelaPadrao {
	private static final long serialVersionUID = 1L;
	Persistencia pe = new Persistencia();
	CentralDeInformacoes central = pe.recuperarCentral("Central.xml");

	public TelaListarUsuarios() {
		super("Listagem de Usuários");
		setVisible(true);
	}
}