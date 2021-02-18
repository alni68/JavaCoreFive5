package JavaCoreFive;

import java.io.*;

public class DZ5 {
    private static Object IOException;
    private String[] header;
    private int[][] data;

    public static void main(String[] args) throws IOException, InterruptedException {
        File file=new File("./3.csv");
        File tempFile=new File("./3.csv");
        tempFile.createNewFile();
        System.out.println(file.isFile());

        String[] header=new String[]{"Value 1", "Value 2", "Value 3"};
        Integer[][] data={
                {100, 200, 123},
                {300, 400, 500},
        };

        try (BufferedWriter writer=new BufferedWriter(new FileWriter("./3.csv"))) {
            for (int i=0; i < 3; i++) {
                writer.write(header[i] + ";");
            }
            writer.write("\n");
            for (int i=0; i < 2; i++) {
                for (int j=0; j < 3; j++) {
                    writer.write(data[i][j] + ";");
                }
                writer.write("\n");
            }
        } catch (IOException e) {
            e.printStackTrace();
        }


        try (BufferedReader reader=new BufferedReader(new FileReader("./3.csv"))) {
            String str;
            while ((str=reader.readLine()) != null) {
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}


