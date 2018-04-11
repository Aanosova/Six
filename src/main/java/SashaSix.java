import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.*;
/**
 * Есть входной файл с набором слов, написанных через пробел
 Необходимо:
 Прочитать слова из файла.
 Отсортировать в алфавитном порядке.
 Посчитать сколько раз каждое слово встречается в файле.       Вывести статистику на консоль
 Найти слово с максимальным количеством повторений. Вывести на консоль это слово и сколько раз оно встречается в файле
 */
public class SashaSix {
    public static void main(String[] args) throws FileNotFoundException {

        /**ВНИМАНИЕ! Данные в файле должны быть на английском!!!
         В данном примере кодировка на windows-1251 не реализована*/

        File f = new File("C:/Users/Игорь/Desktop/Words.txt");
        Scanner scanner = new Scanner(f);
        List<String> slova =  new ArrayList();
        while (scanner.hasNext()) {
            slova.add(scanner.next());
        }
        System.out.println();
        System.out.println("Исходные данные из файла: " + slova);
        System.out.println("-----------------------------------------");

        //сортировка
        java.util.Collections.sort(slova);
        System.out.println("Сортировка по алфавиту: " + slova);
        System.out.println("-----------------------------------------");

        //
        Map<String, Integer> wordsMap = new TreeMap();//new TreeMap();
        for (String word : slova) {
            if (wordsMap.containsKey(word)) {
                int counter = wordsMap.get(word);
                wordsMap.put(word, counter + 1);
            } else {
                wordsMap.put(word, 1);
            }
        }
        for (Map.Entry entry : wordsMap.entrySet()) {
            System.out.println("Слово " + entry.getKey() + " повторяется " + entry.getValue() + " раз ");
            System.out.println("-----------------------------------------");
        }
        //считаем максимальное количество повторов
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println("У слова " + maxEntry.getKey() + " максимальное количество повторений = " +  maxEntry.getValue() );
    }
}