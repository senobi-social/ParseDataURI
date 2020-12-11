package image.businesslogic;

/*
 *  画像のメタ情報を取得するクラスです
 */

public class ImageMetadata {

	public static String ContentType(String dataURI) {

		// コンテンツタイプの切り出し
		String ContentType = dataURI.substring(dataURI.indexOf(":") + 1, dataURI.indexOf(";"));

		return ContentType;
	}

	public static String EncodeType(String dataURI) {

		// エンコードタイプの切り出し
		String EncodeType = dataURI.substring(dataURI.indexOf(";") + 1, dataURI.indexOf(","));

		return EncodeType;
	}

	public static String Buffer(String dataURI) {

		// バッファの切り出し
		String Buffer = dataURI.substring(dataURI.indexOf(",") + 1);

		return Buffer;
	}

}
