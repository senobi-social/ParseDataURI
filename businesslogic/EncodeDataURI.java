package image.businesslogic;


import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.util.Base64;

public class EncodeDataURI {

	public static String DataToURI() {

	    // 変換元のファイル
	    File file = new File("C:\\Users\\blues\\Downloads\\note\\ケーキ\\ケーキ.jpg");

	    try {

	    	// ファイルのコンテンツタイプをしらべる
	    	// 実装時にはDBからメディアタイプを取得することになる
	    	String contentType = Files.probeContentType(file.toPath());

	    	// ファイルのエンコード方法をしらべる
	    	// 実装時にはDBからメディアタイプを取得することになる
	    	String rule = "base64";
	    	StringBuilder encoding = new StringBuilder();
	    	encoding.append(";");
	    	encoding.append(rule);
	    	encoding.append(",");

	    	String encoded = encoding.toString();

		    // ファイル内容をbyte[]に読み込む
		    byte[] data = Files.readAllBytes(file.toPath());

		    // byte[]をbase64文字列に変換する(java8)
		    String base64str = Base64.getEncoder().encodeToString(data);

		    // data URIを作る
		    StringBuilder uri = new StringBuilder();
		    uri.append("data:");
		    uri.append(contentType);
		    uri.append(encoded);
		    uri.append(base64str);

		    String DataURI = uri.toString();

		    return DataURI;

	    } catch (IOException e) {

	    	e.printStackTrace();

	    	return "エラーが発生しました。";
	    }


	}

}
