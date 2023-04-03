package eng.cpe.se.project.service;

import java.io.File;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import eng.cpe.se.project.model.ImgPost;
import eng.cpe.se.project.model.Post;
import eng.cpe.se.project.model.User;
import eng.cpe.se.project.repository.PostRepository;

@Service
public class PostService {
	@Autowired
	private PostRepository postRepository;
	@Autowired
	private ImgPostService imgPostService;

	public void save(Post post) {
		postRepository.save(post);
	}

	public List<Post> findAll() {
		return (List<Post>) postRepository.findAll();
	}

	public Post findById(int id) {
		return postRepository.findById(id).get();
	}

	public void delete(int id) {
		Post post = findById(id);
		ImgPost imgPost = imgPostService.findByPost(post);
		File img = new File(imgPost.getImgPath());

		img.deleteOnExit();
		postRepository.deleteById(id);
	}

	public List<Post> findAll(int page, int value) {
		Pageable pageable = PageRequest.of(page - 1, value);
		return postRepository.findAll(pageable);
	}

	public List<Post> findAllByDateAndDoneReportStatus(int page, int value) {
		Pageable pageable = PageRequest.of(page - 1, value);
		return postRepository.findAllByDateAndDoneReportStatus(pageable);
	}

	public List<Post> findAllByPopulationAndDoneReportStatus(int page, int value) {
		Pageable pageable = PageRequest.of(page - 1, value);
		return postRepository.findAllByPopulationAndDoneReportStatus(pageable);
	}

	public List<Post> findAllByWaitingReportStatus(int page, int value) {
		Pageable pageable = PageRequest.of(page - 1, value);
		return postRepository.findAllByWaitingReportStatus(pageable);
	}

	public List<Post> findAllByFollowerandDate(int page, int value, User user) {
		Pageable pageable = PageRequest.of(page - 1, value);
		return postRepository.findAllByFollowerandDate(pageable, user);
	}

	public List<Post> findAllByPopulationfromFollower(int page, int value, User user) {
		Pageable pageable = PageRequest.of(page - 1, value);
		return postRepository.findAllByPopulationfromFollower(pageable, user);
	}
	
	public Post findByDateAndDoneReportStatus(User user) {
		return postRepository.findByDateAndDoneReportStatus(user);
	}
}
