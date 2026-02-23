import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

public class ModifyFile {
    public void modifyFile(String filename, String text){
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename, true))){
            bw.write(text);
            bw.newLine();
            System.out.println("File Modified Successfully");
        } catch (IOException e) {
            System.out.println("Error Occurred : "+e.getMessage());
        }
    }
}
