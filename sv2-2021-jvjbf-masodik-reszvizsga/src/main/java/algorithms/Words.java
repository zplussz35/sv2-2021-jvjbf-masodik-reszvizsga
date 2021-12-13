package algorithms;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class Words {

    private List<String> words = new ArrayList<>();

    public void addWord(String word){
        if(word.contains(" ") ||"".equals(word)){
            throw new IllegalArgumentException("It should be one word!");
        }
        if(!word.toLowerCase().equals(word)){
            throw new IllegalArgumentException("Word should be lower case!");
        }
        words.add(word);

    }

    public List<String> getWords() {
        return words;
    }

    public boolean isThereAWordTwice(){
        for (int i = 0; i < words.size()-1; i++) {
            for (int j = i+1; j < words.size(); j++) {
                if (words.get(i).equals(words.get(j))) {
                    return true;
                }
            }
        }
        return false;
    }


}
