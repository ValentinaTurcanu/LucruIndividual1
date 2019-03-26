package csv;
import com.opencsv.CSVWriter;

import java.io.IOException;
import java.io.Writer;
import java.nio.file.Files;
import java.nio.file.Paths;
public class CSVWriter1 {

        private static final String STRING_ARRAY_SAMPLE = "open.csv";

        public static void main(String[] args) throws IOException {
            try (
                    Writer writer = Files.newBufferedWriter(Paths.get(STRING_ARRAY_SAMPLE));

                    CSVWriter csvWriter = new CSVWriter(writer,
                            CSVWriter.DEFAULT_SEPARATOR,
                            CSVWriter.NO_QUOTE_CHARACTER,
                            CSVWriter.DEFAULT_ESCAPE_CHARACTER,
                            CSVWriter.DEFAULT_LINE_END);
            )
            {
                String[] headerRecord = {"Name", "Email", "Phone", "Country"};
                csvWriter.writeNext(headerRecord);

                csvWriter.writeNext(new String[]{"Tom Holland", "t.holland01@gmail.com", "00257785598", "UK"});
                csvWriter.writeNext(new String[]{ "Benedict Cumberbatch", "bk1976@gmail.com", "058745128745", "UK"});
                csvWriter.writeNext(new String[]{ "James MCavoy", "JamyMC@gmail.com", "054548784121", "UK"});
                csvWriter.writeNext(new String[]{"Mark Zuckerberg", "MZCK@gmail.com", "054887988887", "USA"});
            }
        }
    }

