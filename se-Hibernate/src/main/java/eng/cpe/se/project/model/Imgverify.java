package eng.cpe.se.project.model;
// Generated Mar 7, 2023, 11:29:50 PM by Hibernate Tools 5.6.3.Final

/**
 * Imgverify generated by hbm2java
 */
public class ImgVerify implements java.io.Serializable {

	private Integer imgVerifyId;
	private RequestVerify requestVerify;
	private String imgPath;

	public ImgVerify() {
	}

	public ImgVerify(RequestVerify requestverify, String imgPath) {
		this.requestVerify = requestverify;
		this.imgPath = imgPath;
	}

	public Integer getImgVerifyId() {
		return imgVerifyId;
	}

	public void setImgVerifyId(Integer imgVerifyId) {
		this.imgVerifyId = imgVerifyId;
	}

	public RequestVerify getRequestVerify() {
		return requestVerify;
	}

	public void setRequestVerify(RequestVerify requestVerify) {
		this.requestVerify = requestVerify;
	}

	public String getImgPath() {
		return imgPath;
	}

	public void setImgPath(String imgPath) {
		this.imgPath = imgPath;
	}


}
