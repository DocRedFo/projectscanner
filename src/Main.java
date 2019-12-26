import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/*
* Программа сравнения для двух файлов.
* Файлы для примера:
* fileOne: C:\Users\DELL\IdeaProjects\project scanner\1.txt
* fileTwo: C:\Users\DELL\IdeaProjects\project scanner\2.txt
* */
public class Main {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Введите путь к файлу один: ");
        String file1 = scanner.nextLine();
        System.out.print("Введите путь ко второму файлу: ");
        String file2 = scanner.nextLine();

        File fileOne = new File(file1);
        File fileTwo = new File(file2);

        try {
            Scanner OFile = new Scanner(fileOne);
            Scanner TFile = new Scanner(fileTwo);

            //Делим на символы
            OFile.useDelimiter("");
            TFile.useDelimiter("");

            //Счётчик отличий
            int i = 0;

            //Чтение и сравнение
            while (OFile.hasNext() && TFile.hasNext()){
                if (i < 10) {
                    if (!OFile.next().equals(TFile.next())) {
                        System.out.println(OFile.next() + " - " + TFile.next());
                        i++;
                    }
                }
                else {
                    
                }
            }

        } catch (FileNotFoundException e) {
            e.printStackTrace();
            System.out.println("Файлы не найдены");
        } catch (Exception e) {
            e.printStackTrace();
            System.out.println("Какая-то ошибка");
        }
    }
}
