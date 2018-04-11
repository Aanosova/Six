import java.io.File;
        import java.io.FileNotFoundException;
        import java.util.ArrayList;
        import java.util.List;
        import java.util.*;
/**
 * ���� ������� ���� � ������� ����, ���������� ����� ������
 ����������:
 ��������� ����� �� �����.
 ������������� � ���������� �������.
 ��������� ������� ��� ������ ����� ����������� � �����.       ������� ���������� �� �������
 ����� ����� � ������������ ����������� ����������. ������� �� ������� ��� ����� � ������� ��� ��� ����������� � �����
 */
public class SashaSix {
    public static void main(String[] args) throws FileNotFoundException {

        /**��������! ������ � ����� ������ ���� �� ����������!!!
         � ������ ������� ��������� �� windows-1251 �� �����������*/

        File f = new File("C:/Users/�����/Desktop/Words.txt");
        Scanner scanner = new Scanner(f);
        List<String> slova =  new ArrayList();
        while (scanner.hasNext()) {
            slova.add(scanner.next());
        }
        System.out.println();
        System.out.println("�������� ������ �� �����: " + slova);
        System.out.println("-----------------------------------------");

        //����������
        java.util.Collections.sort(slova);
        System.out.println("���������� �� ��������: " + slova);
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
            System.out.println("����� " + entry.getKey() + " ����������� " + entry.getValue() + " ��� ");
            System.out.println("-----------------------------------------");
        }
        //������� ������������ ���������� ��������
        Map.Entry<String, Integer> maxEntry = null;
        for (Map.Entry<String, Integer> entry : wordsMap.entrySet()) {
            if (maxEntry == null || entry.getValue().compareTo(maxEntry.getValue()) > 0) {
                maxEntry = entry;
            }
        }
        System.out.println("� ����� " + maxEntry.getKey() + " ������������ ���������� ���������� = " +  maxEntry.getValue() );
    }
}