package image.businesslogic;

/*
 * エンコード方法を調べるクラスです
 */
public class CheckEncodeType {

	public static int Check(String encodeType) {

		if ( encodeType == "base64") {

			// Base64の場合
			int encodeNumber = 1;
			return encodeNumber;

		} else if (encodeType == "URI64") {

			// URI64の場合
			int encodeNumber = 2;
			return encodeNumber;


		} else {

			// それ以外（エラー）
			int encodeNumber = 0;
			return encodeNumber;
		}
	}

}
