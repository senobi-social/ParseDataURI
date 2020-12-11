package image.businesslogic;

/*
 * dataURIをもとにデータの抽出からデータの保存まで行います
 */
public class ExtractManager {

	public static void main(String[] args) {

		// テストデータ
		String testdata = "data:image/jpeg;base64,/base64test";

		// DataURIからメタデータを取得
		String contentType = ImageMetadata.ContentType(testdata);
		String encodeType = ImageMetadata.EncodeType(testdata);
		String buffer = ImageMetadata.Buffer(testdata);

		// バッファをデコードする
		byte[] decodeData = DecodeDataURI.Decoding(buffer);


		// コンソール表示用（テスト時のみ）
		System.out.println(testdata);
		System.out.println(contentType);
		System.out.println(encodeType);
		System.out.println(buffer);
		System.out.println(decodeData);



	}

}
