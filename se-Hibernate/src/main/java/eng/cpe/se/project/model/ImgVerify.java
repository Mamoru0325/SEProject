package eng.cpe.se.project.model;
// Generated Mar 1, 2023, 12:55:07 AM by Hibernate Tools 5.6.3.Final

/**
 * Imgverify generated by hbm2java
 */
public class ImgVerify implements java.io.Serializable {

	private int imgVerifyId;
	private RequestVerify requestverify;
	private String imgPath;

	public ImgVerify() {
	}

	public ImgVerify(RequestVerify requestverify, String imgPath) {
		this.requestverify = requestverify;
		this.imgPath = imgPath;
	}

	public int getImgVerifyId() {
		return this.imgVerifyId;
	}

	public void setImgVerifyId(int imgVerifyId) {
		this.imgVerifyId = imgVerifyId;
	}

	public RequestVerify getRequestverify() {
		return this.requestverify;
	}

	public void setRequestverify(RequestVerify requestverify) {
		this.requestverify = requestverify;
	}

	public String getImgPath() {
		return this.imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}

}