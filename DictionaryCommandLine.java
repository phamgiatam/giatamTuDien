package sample;

import java.util.Scanner;

public class DictionaryCommandLine extends DictionaryManagement{

    public void DictionaryBasic(){
        //this.insertFromCommandline();
        //this.showAllWord();
    }
    public void DictionaryAdvanced(){
        //this.insertFromFile();
        //this.showAllWord();
        //this.dictionaryLookup();
        //this.dictionaryChange();
        /*
        System.out.println("Change your dictionary:");
        System.out.println("1. Add a word to the dictionary");
        System.out.println("2. Fix a word");
        System.out.println("3. Delete a word");
        Scanner scanner = new Scanner(System.in);
        System.out.println("Your selection: ");
        int selection = scanner.nextInt();
        if(selection == 1){
            this.dictionaryAdd();
        }
        else if(selection == 2){
            this.dictionaryFix();
        }
        else if(selection == 3){
            this.dictionaryDelete();
        }
         */
        this.exportToFile();
        //this.dictionarySearcher();
        this.showAllWord();
    }



}