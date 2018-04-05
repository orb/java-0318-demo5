package letmein;

// https://www.owasp.org/index.php/Hashing_Java
import java.security.NoSuchAlgorithmException;
import java.security.spec.InvalidKeySpecException;
import javax.crypto.SecretKey;
import javax.crypto.SecretKeyFactory;
import javax.crypto.spec.PBEKeySpec;

public class PasswordHash {

    private static byte[] hashPassword(final char[] password, final byte[] salt, final int iterations, final int keyLength) {

        try {
            SecretKeyFactory skf = SecretKeyFactory.getInstance("PBKDF2WithHmacSHA512");
            PBEKeySpec spec = new PBEKeySpec(password, salt, iterations, keyLength);
            SecretKey key = skf.generateSecret(spec);
            byte[] res = key.getEncoded();
            return res;
            
        } catch (NoSuchAlgorithmException | InvalidKeySpecException e) {
            throw new RuntimeException(e);
        }
    }

    private static String hex(byte[] bytes) {
        String hex = "";
        for (byte b : bytes) {
            hex = hex + String.format("%02x", b);
        }
        return hex;
    }

    // for this assignment, using a static salt is acceptable
    
    private static final String STATIC_SALT = "1234"; 
    
    public static String hashPassword(String password) { 
        return hex(hashPassword(password.toCharArray(), STATIC_SALT.getBytes(), 8192, 256));
    }
    
    public static void main(String[] args) {
        //System.out.println(hashPassword("badpassword", "1234"));
        
        String passwordHash= "353bc8f31e34a73455d839d23e541ff864400835a17d4bd076dc88bdf5d7238d";
        
        if (passwordHash.equals(hashPassword("catsarecool"))) {
            System.out.println("Awesome, it's you!");
        } else {
            System.out.println("Go away hacker!");
        }
    }
}
