package image.businesslogic;

/*
 * DataURIに成形するクラスです
 */
public class AppendDataURI {

	public static String append(String contentType, String encodeType, String encodedData) {

		// dataURIを作る
		StringBuilder object = new StringBuilder();
	    object.append("data:");
	    object.append(contentType);
	    object.append(";");
	    object.append(encodeType);
	    object.append(",");
	    object.append(encodedData);

	    String DataURI = object.toString();

		return DataURI;

	}
}
