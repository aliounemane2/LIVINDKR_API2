package qualshore.livindkr.main.configSecurity;

/**
 * Created by User on 05/01/2018.
 */
public class SecurityConstant {

    public static final String SECRET = "SecretKeyToGenJWTs";
    public static final long EXPIRATION_TIME = 864_000_000; // 10 days
    public static final String TOKEN_PREFIX = "Bearer ";
    public static final String HEADER_STRING = "Authorization";
    public static final String SIGN_UP_URL = "/sign-up";
    public static final String COMPTE_DESACTIVE = "Le compte d'utilisateur est désactivé";
    public static final String LOGININCORRECT = "Le login ou le mot de passe est incorrecte";
    public static final String ACCES_DENIED = "Vous avez pas l'autorisation d'accéder à cette resource";
    public static final String IMG_JPG = "image/jpg";
    public static final String IMG_JPEG = "image/jpeg";
    public static final String IMG_PNG = "image/png";
    public static final String TOKEN = "Token invalide";
}

