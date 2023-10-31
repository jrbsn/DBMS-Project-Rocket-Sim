import java.io.*;

//not fleshed out in this commit

public class excelerator {
    public void csvImport(){// make required changes to imports to grab csv data
        String csvFile = "path_to_your_file.csv";
        String line;
        String csvSplitBy = ",";  // delimiter

        try (BufferedReader br = new BufferedReader(new FileReader(csvFile))) {
            while ((line = br.readLine()) != null) {
                // use comma as separator
                String[] values = line.split(csvSplitBy);
                for (String value : values) {
                    System.out.print(value + " ");
                }
                System.out.println();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

