package filemanipulation;

import java.io.IOException;
import java.lang.reflect.InaccessibleObjectException;
import java.nio.file.Files;
import java.nio.file.NoSuchFileException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class HumanFileManager {
    private List<Human> humans= new ArrayList<>();

    public List<Human> getHumans() {
        return humans;
    }

    public void readHumansFromFile(Path path){
        try{
            List<String> input = read(path);
            for (String s:input) {
                String[] data = s.split(";");
                humans.add(new Human(data[0],data[1]));
            }
        }
        catch (NoSuchFileException nse){
            throw new IllegalStateException("Can't read file!",nse);
        }
    }

    private List<String> read(Path path) throws NoSuchFileException {
        try{
            return Files.readAllLines(path);
        }
        catch (IOException ioe){
            throw new NoSuchFileException("humanstest.csv");
        }
    }

    public void writeMaleHumansToFile(Path path) throws IOException{
            List<String> result = new ArrayList<>();
            for (Human h:humans) {
                if(h.getIdentityNumber().startsWith("1")||h.getIdentityNumber().startsWith("3")){
                    String line = h.getName()+";"+h.getIdentityNumber();
                    result.add(line);

                }
            }
            Files.write(path, result);


    }
}
