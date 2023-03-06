package eng.cpe.se.project.model;
// Generated Mar 5, 2023, 12:22:12 AM by Hibernate Tools 5.6.3.Final

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Imgverify generated by hbm2java
 */
public class ImgVerify implements java.io.Serializable {

	private int imgVerifyId;
	@JsonIgnore
	private RequestVerify requestVerify;
	private String imgPath;

	public ImgVerify() {
	}

	public ImgVerify(RequestVerify requestverify, String imgPath) {
		this.requestVerify = requestverify;
		this.imgPath = imgPath;
	}
	
	public void clone(ImgVerify other) {
		this.imgPath = other.imgPath;
	}

	public int getImgVerifyId() {
		return imgVerifyId;
	}

	public void setImgVerifyId(int imgVerifyId) {
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
