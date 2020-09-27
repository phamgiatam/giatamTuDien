

public class DictionaryCommandLine extends DictionaryManagement{
    public void DictionaryBasic(){
        DictionaryManagement dtm = new DictionaryManagement();
        dtm.insertFromCommandline();
        dtm.showAllWord();
    }
    public void DictionaryAdvanced(){
        DictionaryManagement dtm1 = new DictionaryManagement();
        dtm1.insertFromFile();
        dtm1.showAllWord();
        dtm1.dictionaryLookup();
    }

}