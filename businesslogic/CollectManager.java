package image.businesslogic;

public class CollectManager {

	public static void main(String[] args) {

		// プレゼンテーション層から画像のURI（アクセスキー）を取得
		// それをもとにデータアクセス層から必要データを持ってくる
		// ここではテスト用データを使う
		String contentType = "image/jpeg";
		String encodeType = "base64";

		String str = "This is a test data";
		byte[] binaryData = str.getBytes();


		// 1. エンコード方法を調べる
		int encodeNumber = CheckEncodeType.Check(encodeType);

		// 2. エンコード方法にもとづいてエンコードする
		if (encodeNumber == 1) {

			// Base64のエンコードを行う
			String encodedData = EncodeBase64.encode(binaryData);

			// DataURIへの整形を行う
			String DataURI = AppendDataURI.append(contentType, encodeType, encodedData);
			System.out.println(DataURI);

		} else if (encodeNumber == 2) {

			// URI64のエンコードを行う
			String encodedData = "";

			String DataURI = AppendDataURI.append(contentType, encodeType, encodedData);
			System.out.println(DataURI);

		} else {

			// エラー発生
			String encodedData = "";
			String error = "指定されたエンコード方法は認められません";
			System.out.println(error);

			String DataURI = AppendDataURI.append(contentType, encodeType, encodedData);
			System.out.println(DataURI);

		}

	}
}
