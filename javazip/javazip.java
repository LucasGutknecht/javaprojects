import java.util.Scanner; // 1. importando a classe Scanner
import java.io.*;
import java.util.zip.ZipEntry;
import java.util.zip.ZipOutputStream;

class javazip {
 public static void main(String[] args){
    Scanner ler = new Scanner(System.in);

    String n;

    System.out.printf("Digite o path do arquivo: ");
    n = ler.nextLine(); // 3.1 entrada de dados (lendo um valor inteiro)
    zip ziper = new zip();
    ziper.zipar(n);
    System.out.printf("Arquivo zipado com sucesso!\n");
 }
}
class zip {
  public void zipar(String caminhodoarquivo){
	System.out.printf("Zipando...\n");
       try{
	FileInputStream fis = new FileInputStream(caminhodoarquivo);
	FileOutputStream fos = new FileOutputStream(caminhodoarquivo+".zip");
	ZipOutputStream zipOut = new ZipOutputStream(fos);
 	zipOut.putNextEntry(new ZipEntry(caminhodoarquivo));
	int content;
	while((content = fis.read())!= -1){
  	zipOut.write(content);
  }	
	zipOut.closeEntry();
	zipOut.close();
  }catch(IOException e){
  	e.printStackTrace();
  }
 }
}

class constant {
 final static int tbuffer = 4096;
}
