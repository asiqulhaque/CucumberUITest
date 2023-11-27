package utilities;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadTestDataFile {

    public static String getDatFromFile(String value) throws IOException {

        FileReader reader=new FileReader( System.getProperty("user.dir") +"\\Test DataFile.properties");
        Properties props=new Properties();
        props.load(reader);
        String userData = props.getProperty(value);
        return userData ;
    }

}
