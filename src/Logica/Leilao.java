package Logica;

import java.text.SimpleDateFormat;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

public class Leilao {
	private long id;
	private String nome;
	private String descricao;
	private float valor;
	private LocalDateTime dataInicio;
	private LocalDateTime dataTermino;
	private Usuario usuario;
	
	public Leilao(String nome, String descricao, float valor, LocalDateTime dataInicio, LocalDateTime dataTermino, Usuario usuario) {
		id = System.currentTimeMillis();
		setNome(nome);
		setDescricao(descricao);
		setValor(valor);
		setDataInicio(dataInicio);
		setDataTermino(dataTermino);
		setUsuario(usuario);
	}
	public Leilao() {
		id = System.currentTimeMillis();
	}
	public  String calcularTempoFinal(LocalDateTime tempoFinal) {
		GregorianCalendar gc = new GregorianCalendar();
        gc.setTime(new Date(System.currentTimeMillis()));
        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm:ss");
        gc.add(Calendar.HOUR, tempoFinal.getHour());
        gc.add(Calendar.MINUTE, tempoFinal.getMinute());
        gc.add(Calendar.SECOND, tempoFinal.getSecond());
		return sdf.format(gc.getTime());
	}
	public String getInformacoesL() {
		DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();	
		return "Nome: "+nome+", descrição: "+descricao+", início: "+dataInicio.format(parser)+"h, fim: "+dataTermino.format(parser)+"h\n"+usuario.getInformacoesU();
	}
	public boolean equals(Leilao l) {
		if(l.getId() == this.id)
			return true;
		return false;
	}
	public long getId() {
		return id;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getDescricao() {
		return descricao;
	}
	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}
	public float getValor() {
		return valor;
	}
	public void setValor(float valor) {
		this.valor = valor;
	}
	public LocalDateTime getDataInicio() {
		return dataInicio;
	}
	public void setDataInicio(LocalDateTime dataInicio) {
		this.dataInicio = dataInicio;
	}
	public LocalDateTime getDataTermino() {
		return dataTermino;
	}
	public void setDataTermino(LocalDateTime dataTermino) {
		this.dataTermino = dataTermino;
	}
	public Usuario getUsuario() {
		return usuario;
	}
	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}
}