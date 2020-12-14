package image.businesslogic;

import java.util.Base64;

/*
 * Base64にエンコードするクラスです
 */
public class EncodeBase64 {

	public static String encode(byte[] binaryData) {


		// バイナリデータをString型にしたものをbase64にエンコードする
		String encodedData = Base64.getEncoder().encodeToString(binaryData);

		return encodedData;
	}

}
