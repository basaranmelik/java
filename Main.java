import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("\nOluşturmak istediğiniz dosyanın ismini giriniz: ");
        String fileName = scanner.nextLine();
        createNewFile(fileName);

        System.out.println(fileName + ".txt isimli dosyanıza veri girmek için 1'e basınız.");
        int cho = scanner.nextInt();
        if (cho == 1) {
            writeFile(fileName);
            System.out.println("\nDosya bilgileri gösteriliyor.");
        } else {
            System.out.println("\nDosya bilgileri gösteriliyor.");
        }
        readFile(fileName);
        getFileInfo(fileName);
    }

    public static void createNewFile(String name) {
        File file = new File("C:\\Users\\basar\\IdeaProjects\\files\\" + name);
        try {
            if (file.createNewFile()) {
                System.out.println("\n" + name + ".txt dosyası oluşturuldu.\n");
            } else {
                System.out.println("\n" + name + ".txt dosyası zaten mevcut.\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void getFileInfo(String isim) {
        String write, read;
        File file = new File("C:\\Users\\basar\\IdeaProjects\\files\\" + isim);

        if (file.canWrite()) {
            write = "Evet";
        } else {
            write = "Hayır";
        }

        if (file.canRead()) {
            read = "Evet";
        } else {
            read = "Hayır";
        }

        if (file.exists()) {
            System.out.println("\nDosya adı: " + file.getName() + ".txt");
            System.out.println("Dosya yolu: " + file.getAbsoluteFile() + ".txt");
            System.out.println("Dosya yazılabilir mi: " + write);
            System.out.println("Dosya yazılabilir mi: " + read);
            System.out.println("Dosya boyutu (byte): " + file.length());
        }
    }

    public static void readFile(String isim) {
        File file = new File("C:\\Users\\basar\\IdeaProjects\\files\\" + isim);
        try {
            Scanner scanner = new Scanner(System.in);
            Scanner reader = new Scanner(file);
            int sayac = 0;

            System.out.println("\nHangi kelimenin geçtiğini kontrol etmek istersiniz: ");
            String control = scanner.nextLine();

            while (reader.hasNextLine()) {
                String line = reader.nextLine();
                if (line.equals(control)) {
                    sayac++;
                }
            }
            System.out.println("\n" + control + " kelimesi " + sayac + " kez geçmektedir.");

            reader.close();

        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }


    }

    public static void writeFile(String isim) {
        try {
            BufferedWriter writer = new BufferedWriter(new FileWriter("C:\\Users\\basar\\IdeaProjects\\files\\" + isim, true));
            Scanner scanner = new Scanner(System.in);

            System.out.println(isim + ".txt dosyasına yazmak istediğiniz kelimeyi giriniz: ");
            String s = scanner.nextLine();

            writer.newLine();
            writer.write(s);

            writer.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}




