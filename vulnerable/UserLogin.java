import java.sql.*;

public class UserLoginFixed {

    public static void main(String[] args) {

        try {

            String username = args[0];

            if(!username.matches("[a-zA-Z0-9]+")){
                throw new IllegalArgumentException("Usuario inválido");
            }

            String password = System.getenv("DB_PASSWORD");

            Connection conn = DriverManager.getConnection(
                "jdbc:mysql://localhost:3306/testdb",
                "admin",
                password
            );

            String query = "SELECT * FROM users WHERE username = ?";
            PreparedStatement stmt = conn.prepareStatement(query);
            stmt.setString(1, username);

            ResultSet rs = stmt.executeQuery();

            while(rs.next()){
                System.out.println("Usuario encontrado");
            }

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}
