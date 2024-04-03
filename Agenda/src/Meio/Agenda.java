package Meio;

import javax.swing.JOptionPane;

import Nomes.Contato;

public class Agenda {
	private Contato[] contatos;
	private int tamanhoMaximo;
	private int tamanhoAtual;

	public Agenda(int tamanhoMaximo) {
		this.tamanhoMaximo = tamanhoMaximo;
		this.contatos = new Contato[tamanhoMaximo];
		this.tamanhoAtual = 0;
	}

	public void adicionarContato(Contato contato) {
		if (tamanhoAtual < tamanhoMaximo) {
			contatos[tamanhoAtual++] = contato;
			JOptionPane.showMessageDialog(null, "Contato adicionado com sucesso!");
		} else {
			JOptionPane.showMessageDialog(null, "A agenda está cheia, não é possível adicionar mais contatos.");
		}
	}

	public void listarContatos() {
		if (tamanhoAtual == 0) {
			JOptionPane.showMessageDialog(null, "A agenda está vazia.");
			return;
		}

		StringBuilder lista = new StringBuilder();
		for (int i = 0; i < tamanhoAtual; i++) {
			lista.append("Nome: ").append(contatos[i].getNome()).append("\nTelefone: ")
					.append(contatos[i].getTelefone()).append("\nEmail: ").append(contatos[i].getEmail())
					.append("\n\n");
		}

		JOptionPane.showMessageDialog(null, lista.toString());
	}

	public void removerContato(String nome) {
		boolean encontrado = false;
		for (int i = 0; i < tamanhoAtual; i++) {
			if (contatos[i].getNome().equalsIgnoreCase(nome)) {
				contatos[i] = null;
				for (int j = i; j < tamanhoAtual - 1; j++) {
					contatos[j] = contatos[j + 1];
				}
				contatos[tamanhoAtual - 1] = null;
				tamanhoAtual--;
				encontrado = true;
				JOptionPane.showMessageDialog(null, "Contato removido com sucesso!");
				break;
			}
		}
		if (!encontrado) {
			JOptionPane.showMessageDialog(null, "Contato não encontrado na agenda.");
		}
	}
}
