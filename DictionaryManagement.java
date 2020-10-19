package sample;

import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryManagement extends Dictionary{

        public DictionaryManagement () {
            insertFromFile();
        }

        public void insertFromCommandline() {
            int n;
            String temp1, temp2;
            Scanner scanner = new Scanner(System.in);
            n = scanner.nextInt();
            for(int i = 0; i < n; i++){
                Scanner sc = new Scanner(System.in);
                temp1 = sc.nextLine();
                temp2 = sc.nextLine();
                Word a = new Word(temp1, temp2);
                arr.add(a);
            }

        }

        public void insertFromFile() {
            Vector<String> vt = new Vector<String>();
            String fileName = "data.txt";
            File file = new File(fileName);
            Scanner sc;
            try {
                sc = new Scanner(file).useDelimiter("[\n\t]+");
                while (sc.hasNext()) {
                    String line = sc.next();
                    vt.add(line);
                }

                for (int i = 0; i < vt.size() - 1; i += 2) {
                    Word w = new Word();
                    w.setWord_target(vt.get(i));
                    w.setWord_explain(vt.get(i + 1));
                    arr.add(w);
                }
            } catch (FileNotFoundException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }

        }
        public void showAllWord(){
            System.out.println("NO\t|English\t\t|Vietnamese");
            int i = 1;
            for(Word temp : arr){
                System.out.println( i +"\t|"+ temp.getWord_target() + "\t\t|" + temp.getWord_explain());
                i++;
            }
        }

        public String dictionaryLookup(String in){
            String out = "";
            int check = 0;
                for(Word a: arr){
                    if(in.equals(a.getWord_target())) {
                        check = 1;

                        out = a.getWord_explain();
                        break;
                    }
                }
                if (check == 0) {
                    out = "Cannot find your word!!!";
                }

            return out;
        }

        public void dictionaryAdd(String target, String explain){

            Word temp = new Word(target,explain);
            arr.add(temp);
        }

        public void dictionaryFix(String target, String explain) {
            int check = 0;
            for(Word a: arr){
                if(a.getWord_target().equals(target)){
                    a.setWord_explain(explain);
                    check = 1;
                    break;
                }
            }
            if(check == 0){
                System.out.println("Cannot find your word!!");
                System.out.println("Import your word to the dictionary");
                Word temp = new Word(target,explain);
                arr.add(temp);
            }
        }

        public void dictionaryDelete(String target) {
            int check = 0;
            for(Word a: arr){
                if(a.getWord_target().equals(target)){
                    arr.remove(arr.indexOf(a));
                    check = 1;
                    break;
                }
            }
            if(check == 0 ) {
                System.out.println("Cannot find your word!!!");
            }
        }


        public void exportToFile(){
            try {
                FileWriter fileWriter = new FileWriter("data.txt");
                for(Word i : arr){
                    fileWriter.write(i.getWord_target());
                    fileWriter.write("\t");
                    fileWriter.write(i.getWord_explain());
                    fileWriter.write("\n");
                }
                fileWriter.close();
            } catch (Exception e) {

            }

        }

        public List<String> dictionarySearcher(String target) {
            List<String>  out = new ArrayList<>();

            for (Word a : arr) {
                if (a.getWord_target().contains(target)) {
                    out.add(a.getWord_target());

                }
            }
            return out;
        }





}


