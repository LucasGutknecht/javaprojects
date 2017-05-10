import java.util.Scanner; // 1. importando a classe Scanner
import java.nio.file.*;// 1.2 importando os metodos da superclasse nio.file.*
import java.nio.file.attribute.*;// 1.3 importando da superclasse nio.file.attribute.*
import java.io.*;// 1.4 importando da superclasse io.*
import java.util.*;


class salvador {// 1.5 classe principal do programa, pois contém o método main
	public static void main(String[] args) throws IOException{
	  Scanner ler = new Scanner(System.in);
	  String entrada;
          System.out.printf("Backup Manual= 1\nBackup Automatico= 2\nBackup Agendado= 3\nRestaurar Backup= 4\nSelecione o tipo do Backup: ");
	  entrada = ler.nextLine();
	  	switch(entrada){
			 case menu.bkpManual: 
				    manual manual = new manual();
				    manual.backup();
				    break;
			 case menu.bkpAutomatico: 
                    automatico auto = new automatico();
                    auto.backup();
                    break;
			 case menu.bkpAgendado: 
                    agendado agenda = new agendado();
                    agenda.backup();
                    break;
			 case menu.bkpRestaurar: 
                    restaurar restaurar = new restaurar();
                    restaurar.backup();
                    break;
			 default: 
				System.out.printf("Fora do índice! Escolha outro número entre as opções válidas!\n");
				break;
		}
	}
}
class menu { 
	public static final String bkpManual = "1", 
				   bkpAutomatico = "2", 
			       bkpAgendado   = "3", 
				   bkpRestaurar  = "4"; 
}

class manual {
	public static void backup() throws IOException{
		Scanner scanner = new Scanner(System.in);
		String entrada;
		System.out.print("Nome do diretorio: ");
		entrada = scanner.nextLine();
		Path fileDir = Paths.get(entrada);
		ArvoreDir visitor = new ArvoreDir();
		Files.walkFileTree(fileDir, visitor);
		for (int i = 0; i < listas.lista_arquivos.size(); i++) {
			String listas_de_arquivos = listas.lista_arquivos.get(i);
			System.out.println(listas_de_arquivos);
		}
	}
}

class automatico{
	public static void backup(){
		System.out.print("Você escolheu o Backup Automatico!");
	}
}
class agendado{
	public static void backup(){
		System.out.print("Você escolheu o Backup Agendado!");
	}
	public static void agendador(){
		System.out.print("Este é o agendador de Backups!");
	}
}
class restaurar{
	public static void backup(){
		System.out.print("Você escolheu a Restauração de Backup!");
	}
}

class ArvoreDir extends SimpleFileVisitor<Path> {
	public FileVisitResult postVisitDirectory(Path dir, IOException exc) throws IOException{
//		listas.lista_diretorios.add(dir.toString());
		return FileVisitResult.CONTINUE;
	}
	public FileVisitResult preVisitDirectory(Path dir, BasicFileAttributes attrs) throws IOException{
		return FileVisitResult.CONTINUE;
	}
	public FileVisitResult visitFile(Path file, BasicFileAttributes attrs) throws IOException{
		listas.lista_arquivos.add(file.toString());
		return FileVisitResult.CONTINUE;
	}
	public FileVisitResult visitFileFailed(Path file, IOException exc) throws IOException{
		System.err.println(exc.getMessage());
		return FileVisitResult.CONTINUE;
	}	
}

class listas {
	public static List<String> lista_arquivos = new ArrayList<String>();
//	public static List<String> lista_diretorios = new ArrayList<String>();	
}


