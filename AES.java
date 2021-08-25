import java.awt.Transparency;
import java.awt.color.ColorSpace;
import java.awt.image.BufferedImage;
import java.awt.image.ColorModel;
import java.awt.image.ComponentColorModel;
import java.awt.image.DataBuffer;
import java.awt.image.DataBufferByte;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.security.*;
import javax.crypto.*;
import java.io.BufferedReader;
import java.io.ByteArrayInputStream;
import java.io.File;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.OutputStream;
import javax.imageio.ImageIO;
import static javax.swing.Spring.height;
import static javax.swing.Spring.width;


public class AES {
	public static void main(String[] args) throws IOException, NoSuchAlgorithmException, NoSuchPaddingException, InvalidKeyException, IllegalBlockSizeException, BadPaddingException {
		 File imgPath = new File("C:/Users/Shahzad/Desktop/image.jpg");
		 BufferedImage bufferedImage = ImageIO.read(imgPath);

		 // get DataBufferBytes from Raster
		 WritableRaster raster = bufferedImage .getRaster();
		 DataBufferByte data   = (DataBufferByte) raster.getDataBuffer();
		 byte[] image= data.getData();
		 
		 // generate a private AES key 
		 KeyGenerator keyGen = KeyGenerator.getInstance("AES");
		 keyGen.init(128);
		 Key key =keyGen.generateKey();
			
		 // get an AES cipher object and print 
		 Cipher cipher =Cipher.getInstance("AES/ECB/PKCS5Padding");
		 
		 // encrypt using the key 
		 cipher.init(Cipher.ENCRYPT_MODE,key);
		 byte[] cipherText =cipher.doFinal(image);
		 System.out.println( "Encrypted text: ");
		 System.out.println( new String(cipherText, "UTF-8"));
		 }
}
