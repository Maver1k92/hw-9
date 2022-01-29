import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Pattern;

public class ValidPhonePrinter {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.txt"));
        List<String> lines = new ArrayList<String>();
        while (scanner.hasNextLine()){
            lines.add(scanner.nextLine());
        }
        String[] arr = lines.toArray(new String[0]);
        Pattern p = Pattern.compile("^\\(?(\\d{3})\\)?[- ]?(\\d{3})[-](\\d{4})$");
        for(int i =0; i< arr.length; i++){
            String result = arr[i];
            if(p.matcher(result).matches()){
                System.out.println(result);
            }
        }
    }
}
