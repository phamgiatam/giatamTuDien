import java.util.Scanner;
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
        public void showAllWord(){
            System.out.println("NO\t| English\t\t|Vietnamese");
            int i = 1;
            for(Word a : arr){
                System.out.println( i +"\t"+ a.getWord_target() + "\t\t|" +a.getWord_explain());
                i++;
            }
        }



}


