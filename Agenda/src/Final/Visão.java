package Final;

import javax.swing.JOptionPane;

import Meio.Agenda;
import Nomes.Contato;

public class Visão {
	public static void main(String[] args) {
		Agenda agenda = new Agenda(10);

		int opcao;
		do {
			String escolha = JOptionPane.showInputDialog("Escolha uma opção:\n" + "1 - Adicionar contato\n"
					+ "2 - Listar contatos\n" + "3 - Remover contato\n" + "0 - Sair");

			opcao = Integer.parseInt(escolha);

			switch (opcao) {
			case 1:
				String nome = JOptionPane.showInputDialog("Nome do contato:");
				String telefone = JOptionPane.showInputDialog("Telefone do contato:");
				String email = JOptionPane.showInputDialog("Email do contato:");
				Contato novoContato = new Contato();
				novoContato.setNome(nome);
				novoContato.setTelefone(telefone);
				novoContato.setEmail(email);
				agenda.adicionarContato(novoContato);
				break;
			case 2:
				agenda.listarContatos();
				break;
			case 3:
				String nomeRemover = JOptionPane.showInputDialog("Nome do contato a ser removido:");
				agenda.removerContato(nomeRemover);
				break;
			case 0:
				JOptionPane.showMessageDialog(null, "Saindo...");
				break;
			default:
				JOptionPane.showMessageDialog(null, "Opção inválida!");
			}
		} while (opcao != 0);
	}
}
