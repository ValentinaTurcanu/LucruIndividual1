package csv;
import org.apache.commons.csv.CSVFormat;
import org.apache.commons.csv.CSVPrinter;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.Arrays;
public class CSVWriter {
    private static final String SAMPLE_CSV_FILE_PATH = "create.csv";

    public static void main(String[] args) throws IOException {
        try (
                BufferedWriter writer = Files.newBufferedWriter(Paths.get(SAMPLE_CSV_FILE_PATH), StandardCharsets.UTF_8);

                CSVPrinter csvPrinter = new CSVPrinter(writer, CSVFormat.DEFAULT
                        .withHeader("ID", "Name", "E-mail", "Phone_number"));
        ) {
            csvPrinter.printRecord("1", "Tom Holland", "t.holland01@gmail.com", "00257785598");
            csvPrinter.printRecord("2", "Benedict Cumberbatch", "bk1976@gmail.com", "058745128745");
            csvPrinter.printRecord("3", "James MCavoy", "JamyMC@gmail.com", "054548784121");
            csvPrinter.printRecord(Arrays.asList("4", "Mark Zuckerberg", "MZCK@gmail.com", "054887988887"));

            csvPrinter.flush();
        }
    }
}
