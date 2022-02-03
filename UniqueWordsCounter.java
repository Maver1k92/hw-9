import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
import java.util.HashMap;

public class UniqueWordsCounter {
    public static void main(String[] args) throws IOException {
        //Читаю файл
        String fileName ="words.txt";
        String contents = readUsingFiles(fileName);
        contents = contents.replaceAll("\r", " ");
        contents = contents.replaceAll("\\s+", " ");
        contents = contents.trim();
        String[] words = contents.split(" ");
        System.out.println(Arrays.toString(words));//Вывожу в консоль что записал
        System.out.println(words.length);

        // Считаю количество повторяющихся слов
        HashMap<String,Integer> keyValue = new HashMap<String,Integer>();

        for(int i = 0; i < words.length; i++){
            if(keyValue.containsKey(words[i])){
                int counter = keyValue.get(words[i]);
                keyValue.put(words[i],counter+1 );
            }
            else {
                keyValue.put(words[i], 1 );
            }
        }
        System.out.println(keyValue);//вывожу в консоль сколько каких слов насчитал




    }

    private static String readUsingFiles(String fileName) throws IOException {
        return new String(Files.readAllBytes(Paths.get(fileName)));
    }
}




