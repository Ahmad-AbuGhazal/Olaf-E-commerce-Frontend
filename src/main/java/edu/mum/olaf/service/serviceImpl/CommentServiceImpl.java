package edu.mum.olaf.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import edu.mum.olaf.domain.Comment;
import edu.mum.olaf.repository.CommentDao;
import edu.mum.olaf.service.CommentService;

@Service
@org.springframework.transaction.annotation.Transactional
public class CommentServiceImpl implements CommentService {

	 @Autowired
	 CommentDao commentDao;
	
	
	@Override
	@edu.mum.olaf.validation.ServiceValidation
	public void save(Comment comment) {
		commentDao.save(comment);
	}

	@Override
	@edu.mum.olaf.validation.ServiceValidation
	public Comment update(Comment comment) {		
		return commentDao.update(comment);
	}

	@Override
	public Comment findOne(long id) {		
		return commentDao.findOne(id);
	}

	@Override
	public List<Comment> findAll() {		
		return commentDao.findAll();
	}

	@Override
	public List<Comment> findAllByItemId(Long itemId) {
		return commentDao.findAllByItemId(itemId);
	}

//	@Autowired
//	RemoteApi remoteApi;
//	
//	@Override
//	public void save(Comment comment) {
//		RestTemplate restTemplate = remoteApi.getRestTemplate();
//		HttpEntity<Comment> httpEntity = new HttpEntity<Comment>(comment, remoteApi.getHttpHeaders());
//		restTemplate.postForObject("http://localhost:8085/olafbackend/comments/add/", httpEntity, Comment.class);
//	}
//
//	@Override
//	public List<Comment> findAllByItemId(Long itemId) {		
//		RestTemplate restTemplate = remoteApi.getRestTemplate();		
//		return Arrays.asList(restTemplate.exchange("http://localhost:8085/olafbackend/comments/findAll/" + itemId, HttpMethod.GET, remoteApi.getHttpEntity(), Comment[].class).getBody());//Spring implementation
//		
//	}
//
//	//TODO: is that correct
//	@Override
//	public Comment update(Comment comment) {
//		RestTemplate restTemplate = remoteApi.getRestTemplate();
//		HttpEntity<Comment> httpEntity = new HttpEntity<Comment>(comment, remoteApi.getHttpHeaders());
//		return restTemplate.postForObject("http://localhost:8085/olafbackend/comments/edit/", httpEntity, Comment.class);
//	}
//
//	@Override
//	public Comment findOne(long id) {
//		// TODO Auto-generated method stub
//		return null;
//	}
//
//	@Override
//	public List<Comment> findAll() {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
