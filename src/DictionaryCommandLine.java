public class DictionaryCommandLine extends DictionaryManagement{
    public void DictionaryBasic(){
        DictionaryManagement dtm = new DictionaryManagement();
        dtm.insertFromCommandline();
        dtm.showAllWord();
    }

}