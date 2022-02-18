import java.io.*;
import java.nio.file.Files;
import java.util.Arrays;
import java.util.Scanner;
import java.lang.Math;
import java.io.IOException;
public class Main {
    public static void SortDescending(int[] array) {
        while (true){
            int f = array.length;
            if (f > 1){
                int continues = 0;
                for (int h = 0; h < f-1; h++) {
                    if (array[h] < array[h + 1]) {
                        int helper = array[h];
                        array[h] = array[h + 1];
                        array[h + 1] = helper;
                        continues = 1;
                    }
                }
                if(continues == 0){
                    break;
                }
            }
            else {
                break;
            }
        }
    }
    public static int[] AddElement(int[] array, int element) {
        int before = array.length + 1;
        int[] newarray = new int[before];
        System.arraycopy(array, 0, newarray, 0, before - 1);
        newarray[before - 1] = element;
        return newarray;}
    public static void main(String[] args) throws IOException {
        File input = new File(args[0]);
        File out = new File(args[1]);
        FileWriter outputfile = new FileWriter(out);
        PrintWriter output = new PrintWriter(outputfile);
        Scanner operation = new Scanner(input);
        int mode = 0;
        while (operation.hasNextLine()){
            String row = operation.nextLine();
            String[] rowlist = row.split(" ");
            try {
                int exceptionInt = Integer.parseInt(rowlist[0]);
                if (mode == 0) {
                    int[] armstrongs = new int[0];
                    String armstrong = "";
                    for (int i = 100; i < Integer.parseInt(rowlist[0]); i++) {
                        int sum = 0;
                        String[] digitlist = Integer.toString(i).split("");
                        for (String s : digitlist) {
                            sum += Math.pow(Integer.parseInt(s), digitlist.length);
                        }
                        if (sum == i) {
                            armstrongs = AddElement(armstrongs, sum);
                        }
                    }
                    mode = 1;
                    for (int d : armstrongs) {
                        armstrong += d + " ";
                    }
                output.write(armstrong+"\n");
                }
                else if (mode == 1) {
                    int[] theList = new int[0];
                    while (true) {
                        int exceptionInt_1 = Integer.parseInt(rowlist[0]);
                        if (Integer.parseInt(rowlist[0]) < 0) {
                            break;}
                        theList = AddElement(theList, Integer.parseInt(rowlist[0]));
                        row = operation.nextLine();
                        rowlist = row.split(" ");
                        String printing = "";
                        Arrays.sort(theList);
                        for (int l : theList) {
                            printing += Integer.toString(l) + " ";}
                        output.write(printing+"\n");
                        //System.out.println(printing);


                    }
                    mode = 2;
                }

                else if (mode == 2) {
                    int[] theList = new int[0];
                    while (true){
                        int exceptionInt_1 = Integer.parseInt(rowlist[0]);
                        if (Integer.parseInt(rowlist[0]) < 0) {
                            break;}
                        theList = AddElement(theList, Integer.parseInt(rowlist[0]));
                        row = operation.nextLine();
                        rowlist = row.split(" ");
                        String printing = "";
                        SortDescending(theList);
                        for (int l : theList) {
                            printing += Integer.toString(l) + " ";}
                        output.write(printing+"\n");
                        //System.out.println(printing);
                        }
                    mode = 3;
                }

            }
            catch (Exception e){
                output.write(row+"\n");
                //System.out.println(row);
            }
    }
    output.close();




}}








