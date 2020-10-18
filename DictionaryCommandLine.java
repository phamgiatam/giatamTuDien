import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement{

    public void DictionaryBasic(){
        this.insertFromCommandline();
        this.showAllWord();
    }
    public void DictionaryAdvanced(){
        this.insertFromFile();
        this.showAllWord();
        this.dictionaryLookup();
        this.dictionaryChange();
        this.exportToFile();
        this.dictionarySearcher();
        this.showAllWord();
    }

    public void dictionarySearcher() {
        String target;
        int check = 0;
        Scanner sc3 = new Scanner(System.in);
        System.out.println("Search : ");
        target = sc3.nextLine();
        for (Word a : arr) {
            if (a.getWord_target().contains(target)) {
                System.out.println(a.getWord_target() + " -> " + a.getWord_explain());
                check = 1;
                break;
            }
        }
        if(check == 0 ) System.out.println("Cannot find your word!!!");

    }


}