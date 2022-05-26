import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class CaesarCipherTest {

    private CaesarCipher.CaesarCipher caesarCipher;
    private String plainText;
    private String encrypted;

    @Before
    public void init(){
        plainText = "Hello World";
        encrypted = "Khoor Zruog";
    }

    @Test
    public void testEncode_rotationThree(){
        caesarCipher = new CaesarCipher.CaesarCipher(3);
        Assert.assertEquals(encrypted, caesarCipher.encrypt(plainText));
    }

    @Test
    public void testDeCode_rotationThree(){
        caesarCipher = new CaesarCipher.CaesarCipher(3);
        Assert.assertEquals(plainText, caesarCipher.decrypt(encrypted));
    }

    @Test
    public void testEncode_rotationTwentySix(){
        caesarCipher = new CaesarCipher.CaesarCipher(26);
        Assert.assertEquals(plainText, caesarCipher.encrypt(plainText));
    }

    @Test
    public void testDecode_rotationTwentySix(){
        caesarCipher = new CaesarCipher.CaesarCipher(26);
        Assert.assertEquals(plainText, caesarCipher.decrypt(plainText));
    }
}
