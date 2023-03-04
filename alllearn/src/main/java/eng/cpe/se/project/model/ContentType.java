package eng.cpe.se.project.model;
// Generated Mar 5, 2023, 12:22:12 AM by Hibernate Tools 5.6.3.Final

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.fasterxml.jackson.annotation.JsonIgnore;

/**
 * Contenttype generated by hbm2java
 */
public class ContentType implements java.io.Serializable {

	private int contentTypeId;
	private String typeName;
	@JsonIgnore
	private List<Post> posts = new ArrayList<Post>();
	@JsonIgnore
	private List<Course> courses = new ArrayList<Course>();

	public ContentType() {
	}

	public ContentType(String typeName) {
		this.typeName = typeName;
	}

	public ContentType(String typeName, List<Post> posts,List<Course> courses) {
		this.typeName = typeName;
		this.posts = posts;
		this.courses = courses;
	}
	
	public void clone(ContentType other) {
		this.typeName = other.typeName;
	}

	public int getContentTypeId() {
		return contentTypeId;
	}

	public void setContentTypeId(int contentTypeId) {
		this.contentTypeId = contentTypeId;
	}

	public String getTypeName() {
		return typeName;
	}

	public void setTypeName(String typeName) {
		this.typeName = typeName;
	}

	public List<Post> getPosts() {
		return posts;
	}

	public void setPosts(List<Post> posts) {
		this.posts = posts;
	}

	public List<Course> getCourses() {
		return courses;
	}

	public void setCourses(List<Course> courses) {
		this.courses = courses;
	}


}
