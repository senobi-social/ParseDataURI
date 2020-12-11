package image.businesslogic;

import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.util.Base64;

/*
 *  DataURIのデコードをするクラスです
 */

public class DecodeDataURI {

	public static byte[] Decoding(String buffer) {

		Charset charset = StandardCharsets.UTF_8;

		// バイト配列に変換
		byte[] buff = buffer.getBytes(charset);

		// デコード
		byte[] decodeData = Base64.getDecoder().decode(buff);


		return decodeData;

	}

}
