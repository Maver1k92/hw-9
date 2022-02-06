import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

public class UserReader {
    public static void main(String[] args) throws FileNotFoundException {
        Scanner scanner = new Scanner(new File("file.txt"));
        List<String> lines = new ArrayList<String>();
        while (scanner.hasNextLine()) {
            lines.add(scanner.nextLine());
        }
        lines.remove(0);// удаляю лишнюю для меня инфу в 0 элементе
        //System.out.println(lines);// проверяю что у меня записано в Листе
        for(String user: lines){
           // System.out.println(user);
        }
        String[] usersList = new String[lines.size()];
        for(int i = 0; i < lines.size(); i++){
            usersList[i] = lines.get(i);
        }
       // System.out.println(Arrays.toString(usersList));
        String string = lines.get(0);



        List<User> users = new ArrayList<>();
        for (String row : lines) {
            String[] array = row.split(" ");
            String name = array[0];
            int age = Integer.parseInt(array[1]);
            users.add(new User(name, age));

        }
        Gson gson = new GsonBuilder().setPrettyPrinting().create();
        String json = gson.toJson(users);
        System.out.println(json);
    }
}




