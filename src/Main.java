import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Программа сравнения для двух файлов.
* Файлы для примера:
* fileOne: 1.txt
* fileTwo: 2.txt
* */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
//        Scanner scanner = new Scanner(System.in);
//        System.out.print("Введите путь к файлу один: ");
//        String file1 = scanner.nextLine();
//        System.out.print("Введите путь ко второму файлу: ");
//        String file2 = scanner.nextLine();

        File fileOne = new File("1.txt"/*file1*/);
        File fileTwo = new File("2.txt"/*file2*/);

        try {
            Scanner OFile = new Scanner(fileOne);
            Scanner TFile = new Scanner(fileTwo);

            //Счётчик отличий
            int i = 0;

            while (OFile.hasNext() && TFile.hasNext()) {


                String s1 = OFile.next();
                String s2 = TFile.next();

                //Массивы из символов документа
                char[] c1 = s1.toCharArray();
                char[] c2 = s2.toCharArray();


                //Сравнение посимвольно
                if (c1.length > c2.length) {
                    for (int j = 0; j < c2.length; j++) {
                        if (c1[j] != c2[j]) {
                            i++;
                            if (i <= 10) {
                                System.out.println(c1[j] + " " + c2[j]);
                            }
                        }
                    }
                } else {
                    for (int j = 0; j < c1.length; j++) {
                        if (c1[j] != c2[j]) {
                            i++;
                            if (i <= 10) {
                                System.out.println(c1[j] + " " + c2[j]);
                            }
                        }
                    }
                }
            }

            if (i > 10) System.out.println("А так же ещё " + (i - 10) + " отличий(ия)");

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файлы не найдены");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Какая-то ошибка");
        }
    }
}
