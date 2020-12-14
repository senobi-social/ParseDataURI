package image.businesslogic;

import java.net.InetSocketAddress;

import com.datastax.oss.driver.api.core.CqlIdentifier;
import com.datastax.oss.driver.api.core.CqlSession;

import image.dataaccess.Images;
import image.dataaccess.InsertImageData;

/*
 * dataURIをもとにデータの抽出からデータのセットまで行います
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

		// デコードしたバイト配列をString型に変換する
		String content = ByteArrayToString.Change(decodeData);

		// 名前を取得する
		String name = "None";


		// コンソール表示用（テスト時のみ）
		System.out.println(testdata);
		System.out.println(contentType);
		System.out.println(encodeType);
		System.out.println(buffer);
		System.out.println(decodeData);
		System.out.println(name);

		// データのセット
		// データ本体のダイジェストは別のマネージャークラスで行う
		Images beanOfImages = new Images();
		beanOfImages.setCotentType(contentType);
		beanOfImages.setEncodeType(encodeType);
		beanOfImages.setContent(content);
		beanOfImages.setName(name);

		beanOfImages.setDigest("test");


		/*
		 * ここからデータアクセス層の領域
		 * この処理はdataaccessパッケージで行う
		 */

		/* Cassandraへの接続 */
        try (CqlSession session = CqlSession.builder()
        		.addContactPoint(new InetSocketAddress("192.168.131.16", 9042))
        		.withAuthCredentials("susui", "bluesky")
                .withKeyspace(CqlIdentifier.fromCql("timer"))
                .withLocalDatacenter("dc1")
                .build()) {

        	System.out.println("DBに正常にアクセスしました"); // サーバー側コンソール

        	try {

        		// データの挿入処理
            	InsertImageData insert =  new InsertImageData();
            	insert.Insert(session, beanOfImages);

            	// サーバー側コンソール
            	String success = "成功しました";
            	System.out.println(success);


        	} catch(Exception e ) {

        		// サーバー側コンソール
        		String error = "SQL処理をミスりました";
        		System.out.println(error);
        	}


        } catch (Exception e) {

        	// サーバー側コンソール
        	String error = "接続できませんでした";
        	System.out.println(error);

        }



	}

}
