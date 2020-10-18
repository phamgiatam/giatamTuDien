
import java.io.*;
import java.nio.file.Paths;
import java.sql.SQLOutput;
import java.util.Scanner;
import java.util.Vector;

public class DictionaryManagement extends Dictionary{

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

                for (int i = 0; i < vt.size(); i += 2) {
                    Word w = new Word();
                    w.setWord_target(vt.get(i));
                    w.setWord_explain(vt.get(i + 1));
                    arr.add(w);
                }
            } catch (FileNotFoundException e) {

                e.printStackTrace();
            }

        }
        public void showAllWord(){
            System.out.println("NO\t| English\t\t|Vietnamese");
            int i = 1;
            for(Word temp : arr){
                System.out.println( i +"\t|"+ temp.getWord_target() + "\t\t|" + temp.getWord_explain());
                i++;
            }
        }

        public void dictionaryLookup(){
            System.out.println("Select the kind you want to look up: ");
            System.out.println("1. English to Vietnamese");
            System.out.println("2. Vietnamese to English");
            System.out.println("Your selection: ");
            Scanner scanner = new Scanner(System.in);
            int selection = scanner.nextInt();
            int check = 0;
            if(selection == 1) {
                System.out.println("Your word: ");
                Scanner sc1 = new Scanner(System.in);
                String str = sc1.nextLine();
                for(Word a: arr){
                    if(str.equals(a.getWord_target())) {
                        check = 1;
                        System.out.println("The result: ");
                        System.out.println(a.getWord_target() + "   " + a.getWord_explain());
                        break;
                    }
                }
                if (check == 0) {
                    System.out.println("Cannot find your word!!!");
                }
            }
            else if(selection == 2) {
                Scanner sc2 = new Scanner(System.in);
                System.out.println("Your word: ");
                String str = sc2.nextLine();
                for(Word a: arr){
                    if(str.equals(a.getWord_explain())) {
                        check = 1;
                        System.out.println("The result: ");
                        System.out.println(a.getWord_target() + "   " + a.getWord_explain());
                        break;
                    }
                }
                if (check == 0) {
                    System.out.println("Cannot find your word!!!");
                }
            }
        }

        public void dictionaryChange(){
            System.out.println("Change your dictionary:");
            System.out.println("1. Add a word to the dictionary");
            System.out.println("2. Fix a word");
            System.out.println("3. Delete a word");
            Scanner scanner = new Scanner(System.in);
            System.out.println("Your selection: ");
            int selection = scanner.nextInt();

            if(selection == 1){
                String target, explain;
                Scanner sc = new Scanner(System.in);
                System.out.println("English : ");
                target = sc.nextLine();
                System.out.println("Vietnamese : ");
                explain = sc.nextLine();
                Word temp = new Word(target,explain);
                arr.add(temp);
            }

            else if(selection == 2){
                String target, explain;
                System.out.println("Import the word you want to fix: ");
                Scanner sc2 = new Scanner(System.in);
                target = sc2.nextLine();
                System.out.println("Import the fixed explain: ");
                explain = sc2.nextLine();
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

            else if(selection == 3){
                String target;
                int check = 0;
                System.out.println("Import the word you want to delete: ");
                Scanner sc3 = new Scanner(System.in);
                target = sc3.nextLine();
                for(Word a: arr){
                    if(a.getWord_target().equals(target)){
                        arr.remove(arr.indexOf(a));
                        check = 1;
                        System.out.println("Deleted");
                        break;
                    }
                }
                if(check == 0 ) {
                    System.out.println("Cannot find your word!!!");
                }


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




}


