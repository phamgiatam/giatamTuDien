
import java.io.IOException;
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

        public void insertFromFile(){
            Scanner sc = null;
            Vector<String> vector = new Vector<String>();
            String temp;
            try {
                sc = new Scanner(Paths.
                        get("C:\\Users\\ACER SUPPORT\\Documents\\dictionaries.txt"),
                        "UTF-8");//Open to read
                while (sc.hasNext()) {
                    temp = sc.next();
                    vector.add(temp);
                }
                for (int i = 0; i < vector.size(); i += 2) {
                    Word w = new Word();
                    w.setWord_target(vector.get(i));
                    w.setWord_explain(vector.get(i + 1));
                    arr.add(w);
                }
            } catch (IOException e) {
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
            System.out.println("Select: ");
            System.out.println("1. English to Vietnamese");
            System.out.println("2. Vietnamese to English");
            System.out.println("3. Exit");
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



}


