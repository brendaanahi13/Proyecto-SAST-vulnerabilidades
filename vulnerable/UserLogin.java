public class UserLogin {

    static String password = "admin123";

    public static void main(String[] args) {

        try {

            String username = args[0];

            Runtime.getRuntime().exec("ping " + username);

        } catch(Exception e){
            e.printStackTrace();
        }
    }
}