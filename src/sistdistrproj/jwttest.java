package sistdistrproj;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;


public class jwttest {
    public static void main(String[] args) {
        try {
            Algorithm algorithm = Algorithm.HMAC256("DISTRIBUIDOS");
            String token = JWT.create()
                    .withClaim("id", "eu")
                    .sign(algorithm);
            System.out.println(token);
        } catch (JWTCreationException exception) {
            exception.printStackTrace();
        }
    }
}
