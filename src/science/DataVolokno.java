package science;

import javax.swing.*;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Created by User on 21.03.2016.
 */
public class DataVolokno {

    private static ArrayList<Volokno> arrayList;
    private static int lastId = 0;
    private static Scanner scanner;

    private static void openFile() {
        try {
            scanner = new Scanner(new File("src//data//volokno.txt"));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Файл не найден" );
        }
    }
    public static void readFile() {
        openFile();
        String[][] m = new String[100][5];
        while (scanner.hasNext()) {
            for (int row = 0; row < m.length; row++) {
                for (int col = 0; col < m[row].length; col++) {
                    if(!scanner.hasNext())
                        break;
                    m[row][col] = scanner.next();
                    if (col == 0) {
                        lastId = Integer.parseInt(m[row][col]);
                    }
                }
                if(!scanner.hasNext())
                    break;
            }
        }

        arrayList = new ArrayList<Volokno>(lastId + 5);
        for (int i = 0; i < lastId + 1; i++) {
            arrayList.add( new Volokno(i, m[i][1], Double.parseDouble(m[i][2]), Double.parseDouble(m[i][3]), Double.parseDouble(m[i][4])));
        }
        for (int i = 0; i < lastId + 1; i++) {
            System.out.println(arrayList.get(i).getId());
            System.out.println(arrayList.get(i).getName());
            System.out.println(arrayList.get(i).getEf());
            System.out.println(arrayList.get(i).getL());
            System.out.println(arrayList.get(i).getD());
        }
    }

    public static Volokno getArrayList( int index) {
        return arrayList.get(index);
    }

    public static int getLastId() {
        return lastId;
    }

    public static void addNewItems(String name, double ef, double l, double d){
        try(FileWriter writer = new FileWriter("src//data//volokno.txt", false)) {
            for (int i = 0; i < lastId + 1; i++) {
                writer.write(arrayList.get(i).getId()+ " ");
                writer.write(arrayList.get(i).getName()+ " ");
                writer.write(Double.toString(arrayList.get(i).getEf())+ " ");
                writer.write(Double.toString(arrayList.get(i).getL())+ " ");
                writer.write(Double.toString(arrayList.get(i).getD()));
                writer.write('\n');
                writer.flush();
            }
            writer.write(lastId+1+ " ");
            writer.write(name+ " ");
            writer.write(Double.toString(ef)+ " ");
            writer.write(Double.toString(l)+ " ");
            writer.write(Double.toString(d));
            lastId++;
        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }
    }
    public static Volokno findElement(String as){
        readFile();
        Volokno tmp = null;
        for (int i = 0; i < lastId + 1; i++){
            if(arrayList.get(i).getName().equals(as)) {
                System.out.println("11111");
                tmp = arrayList.get(i);
            }

        }
        if(tmp == null)
            return null;
        return tmp;
    }
}
