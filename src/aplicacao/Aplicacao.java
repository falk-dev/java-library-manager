package aplicacao;
import java.util.Scanner;

// import java.util.HashMap;

// import modelo.Livro;
// import modelo.Usuario;
// import modelo.Emprestimo;

public class Aplicacao{
	public static void main(String[] args) {
		menu();
	}
	// so para acelerar um pouquinho
	public static void menu() {
		Scanner tcl = new Scanner(System.in);
		int op;
		
		do {
			
			String menu;
			menu  = "\n=== BIBLIOTECA ===\n";
			menu += "Escolha uma opção:\n";
			//aqui nao sei oque mais vc mychelle vai colocar entao vou deixa sem nada
			menu += "0 - Sair\n";
			
			System.out.println("Digite aqui a opção:");
			op = tcl.nextInt();
			
			switch (op) {
				case 1:
					System.out.println("op01");
					break;
				case 0:
					System.out.println("Saindo do sistema!");
					break;
				default:
					System.out.println("Opção inválida. Tente novamente.");
			}
		}while(op == 0);

        tcl.close();
	}
}
