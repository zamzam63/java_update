import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;
import java.util.*;
import java.util.function.BiConsumer;
import java.util.logging.Logger;

public class FileFilterTest {

    File root = new File("src");

    @Test
    public void listFiles_AllFiles(){
        File[] directories = root.listFiles();
        if (directories != null){
            for (File file : directories){
                System.out.println(file);
            }
        }
    }

    @Test
    public void listFiles_anonInnerClass(){
        File[] directories = root.listFiles(new FileFilter(){
            @Override
            public boolean accept(File pathname) {
                return pathname.isDirectory();
            }
        });
        if (directories != null){
            for (File file : directories){
                System.out.println(file);
            }
        }
    }

    @Test
    public void listFiles_withLambdaFunction(){
        //File[] directories = root.listFiles(pathname -> pathname.isDirectory());
        File[] directories = root.listFiles(File::isDirectory);
        if (directories != null){
            for (File file : directories){
                System.out.println(file);
            }
        }
    }

    @Test
    public void listFiles_withLambdaFunctionBlock(){
        File[] directories = root.listFiles(pathname -> {
            return pathname.isDirectory();
        });
        if (directories != null){
            for (File file : directories){
                System.out.println(file);
            }
        }
    }

    @Test
    public void iterableWithConsumer(){
        List<String> strings = Arrays.asList("asa", "121", "dasda");
        //loop over strings
        for (String s: strings){
            System.out.println(s);
        }

        strings.forEach(System.out::println);
        // no method reference equivalent:
        strings.forEach(string -> System.out.println("the word is  " + string));

        Map<String, Integer> map = new HashMap<>();
        map.put("hey", 2);
        map.put("hey22", 3);
        map.put("h2121212", 5);
        map.forEach((key, value) -> System.out.println(key + " maps to " + value));

        Logger logger = Logger.getLogger("logger");
        map.forEach((key, value) -> logger.info(key + " maps to " + value));

        //function "composition" -> put two lambdas together
        BiConsumer<String, Integer> consolePrint = (key, value) -> System.out.println(key + " maps to " + value);
        BiConsumer<String, Integer> loggerInfoPrint = (key, value) -> logger.info(key + " maps to " + value);
        map.forEach(consolePrint.andThen(loggerInfoPrint));
    }
}
