package app;

import java.util.Scanner;

import dao.UsuarioDAO;
import model.Usuario;

public class Principal {
    public static void main(String[] args) {
        UsuarioDAO usuarioDAO = new UsuarioDAO();
        Scanner sc = new Scanner(System.in);
        int opcao = 0;

        do {
            System.out.println("\n1) Listar\n2) Inserir\n3) Excluir\n4) Atualizar\n5) Sair");
            opcao = sc.nextInt();

            if (opcao == 1) {
                System.out.println(usuarioDAO.get());
            } else if (opcao == 2) {
                System.out.print("Codigo: ");
                int c = sc.nextInt();
                System.out.print("Login: ");
                String l = sc.next();
                System.out.print("Senha: ");
                String s = sc.next();
                System.out.print("Sexo (M/F): ");
                char sx = sc.next().charAt(0);
                usuarioDAO.insert(new Usuario(c, l, s, sx));
            } else if (opcao == 3) {
                System.out.print("Codigo para excluir: ");
                usuarioDAO.delete(sc.nextInt());
            } else if (opcao == 4) {
                System.out.print("Codigo do usuario a atualizar: ");
                int c = sc.nextInt();
                System.out.print("Novo Login: ");
                String l = sc.next();
                System.out.print("Nova Senha: ");
                String s = sc.next();
                System.out.print("Novo Sexo (M/F): ");
                char sx = sc.next().charAt(0);
                usuarioDAO.update(new Usuario(c, l, s, sx));
            }
        } while (opcao != 5);
        sc.close();
    }
}