import org.junit.jupiter.api.Test;

import java.io.File;
import java.io.FileFilter;

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
    public void listFiles_ananoumusFunction(){
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
}
