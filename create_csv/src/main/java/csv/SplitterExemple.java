package csv;
import java.io.BufferedReader;
import java.io.FileReader;

public class SplitterExemple {
    public static void main(String[] args)
    {
        //Input file which needs to be parsed
        String fileToParse = "create.csv";
        //BufferedReader fileReader = null;

        //Delimiter used in CSV file
        final String DELIMITER = ",";
        try(BufferedReader fileReader= new BufferedReader(new FileReader(fileToParse));)
        {
            String line = "";
            //Create the file reader
           // fileReader = new BufferedReader(new FileReader(fileToParse));

            //Read the file line by line
            while ((line = fileReader.readLine()) != null)
            {
                //Get all tokens available in line
                String[] tokens = line.split(DELIMITER);
                for(String token : tokens)
                {
                    //Print all tokens
                    System.out.println(token);
                }
            }
        }
        catch (Exception e) {
            e.printStackTrace();
        }
    }
}
