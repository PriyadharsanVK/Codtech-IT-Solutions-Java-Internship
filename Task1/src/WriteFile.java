import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class WriteFile {
    public void writeToFile(String filename, String text){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))){
            bw.write(text);
            bw.newLine();
            System.out.println("File Written Successfully");
        } catch (IOException e) {
            System.out.println("Error Occurred : "+e.getMessage());
        }
    }
}
