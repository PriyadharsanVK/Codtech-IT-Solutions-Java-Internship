import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class ReadFile {
    public void readFile(String filename){
        try(BufferedReader br = new BufferedReader(new FileReader(filename))){
            String text;
            while((text = br.readLine()) != null){
                System.out.println(text);
            }
        }
        catch (IOException e){
            System.out.println("Error Occurred : "+e.getMessage());
        }
    }
}
