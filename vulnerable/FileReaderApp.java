import java.io.*;
import java.sql.*;

public class FileReaderAppFixed {

    public static void main(String[] args) {

        try {

            String filename = args[0];
            String userId = args[1];

            if(!filename.matches("[a-zA-Z0-9._-]+")){
                throw new IllegalArgumentException("Archivo inválido");
            }

            BufferedReader br = new BufferedReader(
                new FileReader("/data/files/" + filename)
            );

            String line;
            while((line = br.readLine()) != null){
                System.out.println(line);
            }

            String password = System.getenv("DB_PASSWORD");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/app",
                "root",
                password
            );

            String query = "DELETE FROM users WHERE id = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setInt(1, Integer.parseInt(userId));

            stmt.execute();

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
