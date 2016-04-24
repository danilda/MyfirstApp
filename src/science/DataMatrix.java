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
public class DataMatrix {
    private static ArrayList<Matrix> arrayList;
    private static int lastId = 0;
    private static Scanner scanner;

    private static void openFile() {
        try {
            scanner = new Scanner(new File("src//data//matrix.txt"));
        }
        catch (Exception e){
            JOptionPane.showMessageDialog(null, "Файл не найден" );
        }

    }
    public static void readFile() {
        openFile();
        String[][] m = new String[100][3];
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

            arrayList = new ArrayList<Matrix>(lastId + 5);
            for (int i = 0; i < lastId + 1; i++) {
                arrayList.add( new Matrix(i, m[i][1], Double.parseDouble(m[i][2])));
            }
            for (int i = 0; i < lastId + 1; i++) {
                System.out.println(arrayList.get(i).getId());
                System.out.println(arrayList.get(i).getName());
                System.out.println(arrayList.get(i).getEm());
            }

            scanner.close();

    }

    public static Matrix getArrayList( int index) {
        return arrayList.get(index);
    }

    public static int getLastId() {
        return lastId;
    }

    public static void addNewItems(String name, double em) throws IOException {
        FileWriter writer = new FileWriter("src//data//matrix.txt", false);
        try {
            for (int i = 0; i < lastId + 1; i++) {
                writer.write(arrayList.get(i).getId()+ " ");
                writer.write(arrayList.get(i).getName()+ " ");
                writer.write(Double.toString(arrayList.get(i).getEm()));
                writer.write('\n');
                writer.flush();
            }
            writer.write(lastId+1+ " ");
            writer.write(name+ " ");
            writer.write(Double.toString(em));
            lastId++;
        }catch(IOException ex){

            System.out.println(ex.getMessage());
        }
        finally {
            writer.close();
        }

    }
    public static Matrix findElement(String as){
        readFile();
        Matrix tmp = null;
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
