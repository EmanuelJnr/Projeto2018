package Logica;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeFormatterBuilder;
import java.util.Scanner;

public class Main {
	public static void main(String[] args) {
		Persistencia pe = new Persistencia();
		CentralDeInformacoes central = pe.recuperarCentral("Central.xml");
		Scanner input = new Scanner(System.in);
		Usuario usuarioLogado=null;

		boolean nlogado = true;
		while(nlogado) {
			System.out.println("1-Fazer login\n2-Cadastrar-se\n3-Listar todos os leilões ativos: ");
			String op = input.nextLine();
			
			if(op.equals("1")) {
				System.out.print("Informe um email para login: ");
				String login = input.nextLine();

				Usuario u = central.recuperarUsuario(login);
				if(u==null)
					System.out.println("Login não encontrado!");
				else {
					System.out.print("Informe sua senha: ");
					String senha = input.nextLine();
					if(u.getSenha().equals(senha)) {
						usuarioLogado = u;
						System.out.println("Logado com sucesso!");
						nlogado=false;
					}
					else
						System.out.println("Senha errada!");
				}
			}
			else if (op.equals("2")){
				System.out.print("Informe um email para login: ");
				String login = input.nextLine();
				System.out.print("Informe sua senha: ");
				String senha = input.nextLine();
				System.out.print("Informe um email secundário: ");
				String emailSeguranca = input.nextLine();
				System.out.print("Qual seu nome: ");
				String nome = input.nextLine();
				System.out.print("Qual seu endereço: ");
				String endereco = input.nextLine();
				System.out.print("Em qual cidade você mora: ");
				String cidade = input.nextLine();
				System.out.print("Em qual estado você mora: ");
				String estado = input.nextLine();
				if(central.adicionarUsuario(new Usuario(login, senha, emailSeguranca, nome, endereco, cidade, estado))) {
					usuarioLogado = central.recuperarUsuario(login);
					pe.salvarCentral(central, "Central.xml");
					System.out.println("Adicionado com sucesso!");
					nlogado=false;
				}
				else
					System.out.println("Já existe um cliente com o mesmo login!");
			}
			else {
				for (Leilao leiloes : central.getLeiloesCadastrados()) {
					if(leiloes.getDataTermino().isBefore(LocalDateTime.now()))
						System.out.println(leiloes.getInformacoesL());
				}
			}
		}

		boolean rodar = true;
		do {
			System.out.println("Opções:\n" +
					"1 - Listar Usuários\n" +
					"2 - Cadastrar Leilão\n"+
					"3 - Listar Leilões de um usuário\n"+
					"4 - Sair");
			String entrada = input.nextLine();


			if(entrada.equals("1")) {
				if(central.getUsuariosCadastrados().size()!=0) {
					for (Usuario usu : central.getUsuariosCadastrados())
						System.out.println(usu.getNome());
				}
				else
					System.out.println("Não há clientes cadastrados!");
			}
			else if(entrada.equals("2")) {
				if(usuarioLogado!=null) {
					System.out.print("Digite o nome do Leilão: ");
					String nomeL = input.nextLine();
					System.out.print("Informe uma descrição para o leilão: ");
					String desc = input.nextLine();
					System.out.println("Informe o valor para o leilão");
					float valor = input.nextInt();
					System.out.print("Digite a data de início:(dd/MM/yyyy HH:mm) ");
					String dataInicio = input.nextLine();
					System.out.print("Digite a data do fim:(dd/MM/yyyy HH:mm) ");
					String dataFim = input.nextLine();
					DateTimeFormatter parser = new DateTimeFormatterBuilder().appendPattern("dd/MM/yyyy HH:mm").toFormatter();
					LocalDateTime dataI = LocalDateTime.parse(dataInicio, parser);
					LocalDateTime dataF = LocalDateTime.parse(dataFim, parser);

					if(central.adicionarLeilao(new Leilao(nomeL, desc, valor, dataI, dataF, usuarioLogado))) {
						pe.salvarCentral(central, "central.xml");
						System.out.println("Leilão adicionado!");
					}
					else
						System.out.println("Leilão não cadastrado!");
				}
				else
					System.out.println("Você não está logado!");
			}
			else if(entrada.equals("3")) {
				System.out.print("Digite o nome do usuário: ");
				String nome = input.nextLine();

				if(central.recuperarLeiloesDeUmUsuario(nome)==null)
					System.out.println("Usuario não encontrado!");
				else if(central.recuperarLeiloesDeUmUsuario(nome).size()==0) {
					System.out.println("Este usuário não tem nenhum Leilão!");
				}
				else {
					for(Leilao leiloes : central.recuperarLeiloesDeUmUsuario(nome)) {
						System.out.println(leiloes.getInformacoesL());
					}
				}
			}
			else {
				System.out.println("Fim de programa");
				rodar = false;
			}
		} while(rodar);
		GeradorDeRelatorios.gerarRelatorioCompleto(central);

		input.close();
	}
}