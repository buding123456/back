package dr.jsj.util;

import com.thoughtworks.xstream.core.util.Base64Encoder;
import sun.misc.BASE64Encoder;

import javax.crypto.*;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.SecureRandom;

/**
 * Created by lenovo on 2019/4/1.
 */
public class DESUtil {
    static Key key;
    static String KETYSTR="www";
    static{
        try {
            KeyGenerator keyGenerator=KeyGenerator.getInstance("DES");
            SecureRandom secureRandom=SecureRandom.getInstance("SHA1PRNG");
            secureRandom.setSeed(KETYSTR.getBytes());
            keyGenerator.init(secureRandom);
            key=keyGenerator.generateKey();
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        }
    }
    public static String jm(String passpre){
        String res="";
        BASE64Encoder base64Encoder=new BASE64Encoder();
        try {
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.ENCRYPT_MODE,key);
            byte[] b=cipher.doFinal(passpre.getBytes());
            res= base64Encoder.encode(b);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }
        return res;
    }
    public static String jjm(String passlast){
        String res="";
        Base64Encoder base64Encoder=new Base64Encoder();
        byte[] b=base64Encoder.decode(passlast);
        try {
            Cipher cipher=Cipher.getInstance("DES");
            cipher.init(Cipher.DECRYPT_MODE,key);
            byte[] paspre=cipher.doFinal(b);
            res=new String(paspre);
        } catch (NoSuchAlgorithmException e) {
            e.printStackTrace();
        } catch (NoSuchPaddingException e) {
            e.printStackTrace();
        } catch (InvalidKeyException e) {
            e.printStackTrace();
        } catch (BadPaddingException e) {
            e.printStackTrace();
        } catch (IllegalBlockSizeException e) {
            e.printStackTrace();
        }

        return res;
    }
    public static void main(String[] args){
        System.out.println(jm("1234567"));
        System.out.println(jm("root"));
    }
}
