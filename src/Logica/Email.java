package Logica;

import org.apache.commons.mail.DefaultAuthenticator;
import org.apache.commons.mail.EmailException;
import org.apache.commons.mail.SimpleEmail;

public class Email extends SimpleEmail{
	public Email() {
		setHostName("smtp.gmail.com");
		setSmtpPort(587);
		setAuthenticator(new DefaultAuthenticator("gerenciador.festas54325@gmail.com", "wsmjbljpfbenawys"));
		setSSLOnConnect(true);
		try {
			setFrom("gerenciador.festas54325@gmail.com");
		} catch (EmailException e) {
			e.printStackTrace();
		}
	}
	public boolean enviarEmail(String destinatario, String titulo, String mensagem) {
		setSubject(titulo);
		try {
			setMsg(mensagem);
			addTo(destinatario);
			send();
			return true;
		} catch (EmailException e) {
			return false;
		}
	}
}