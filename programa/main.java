package main;

import java.util.Scanner;

import fachada.Fachada;
import usuarios.admins.RepositorioUsuarioAdminLista;
import fornecedores.RepositorioFornecedorLista;

public class Main {
    public static void main (String[] args) {//inserir aqui as exceptions apropriadas.
		Fachada fachada = new Fachada();
		RepositorioUsuarioAdminLista = new RepositorioUsuarioAdminLista();
		RepositorioFornecedorLista = new RepositorioFornecedorLista();
		Admin Matheus = new admin("Matheus");
		Fornecedor Glock = new fornecedor("Glock");
		fachada.cadastrarAdmin(Matheus);
		fachada.inserirFornecedor(Glock);

    }   // Fim da main.
}   // Fim da Classe Main.