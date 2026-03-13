import java.io.*;
import java.sql.*;

public class FileReaderApp {

    static String apiKey = "12345-ABCDE"; // Hardcoded API Key

    public static void main(String[] args) {

        try {

            String filename = args[0];
            String userId = args[1];

            // Path Traversal
            BufferedReader br = new BufferedReader(
                new FileReader("/data/files/" + filename)
            );

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app",
                "root",
                "root"
            );

            Statement stmt = conn.createStatement();

            // SQL Injection
            String query = "DELETE FROM users WHERE id = " + userId;
            stmt.execute(query);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
