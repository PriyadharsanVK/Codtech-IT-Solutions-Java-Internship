import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        File fi = null;
        try{
            fi = new File("Notepad.txt");
            if(fi.createNewFile())
                System.out.println("File Created : "+ fi.getName());
            else
                System.out.println("File Already Exists");
        }
        catch (IOException e){
            System.out.println("Error Occured : "+ e.getMessage());
        }

        while(true){
            System.out.println("******File Handling Utility******");
            System.out.println("1.Write to File");
            System.out.println("2.Read to File");
            System.out.println("3.Modify a File");
            System.out.println("4.Delete File");
            System.out.println("5.Exit");

            System.out.print("Enter your Choice : ");
            int ch = sc.nextInt();
            sc.nextLine();

            if(ch == 1){
                System.out.print("Enter the Text to Write in the File : ");
                String text = sc.nextLine();
                WriteFile wf = new WriteFile();
                wf.writeToFile("Notepad.txt", text);
            }

            else if(ch == 2){
                System.out.println("*****File Content*****");
                ReadFile rf = new ReadFile();
                rf.readFile("Notepad.txt");
            }

            else if(ch == 3){
                System.out.print("Enter the Text to Append in the File : ");
                String text = sc.nextLine();
                ModifyFile mf = new ModifyFile();
                mf.modifyFile("Notepad.txt", text);
            }

            else if(ch == 4){
                if(fi.delete())
                    System.out.println("File Deleted Successfully");
                else
                    System.out.println("File not Found or Cannot Delete!");
            }

            else if(ch == 5){
                System.out.println("Exiting Program.....");
                break;
            }
        }
    }
}