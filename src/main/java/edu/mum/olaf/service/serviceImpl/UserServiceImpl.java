package edu.mum.olaf.service.serviceImpl;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.stereotype.Service;

import edu.mum.olaf.domain.User;
import edu.mum.olaf.repository.UserDao;
import edu.mum.olaf.service.UserService;
@Service
@org.springframework.transaction.annotation.Transactional
public class UserServiceImpl implements UserService {
   
	@Autowired
    UserDao userDao;
    
	@Override
	public User save(User user) {
		userDao.save(user);
		return user;
	}

	@Override
	public User update(User user) {
		return userDao.update(user);
	}
	
	@Override
	public User findOne(long id) {
		return userDao.findOne(id);
	}

	@PreAuthorize("hasRole('ROLE_ADMIN')")
	@Override
	public List<User> findAll() {
			return userDao.findAll();
	}

	@Override
	public User findByUserName(String username) {
	return userDao.findByUserName(username);
	}

//	@Autowired 
//	RemoteApi remoteApi;
//	@Override
//	public User findOne(long id) {
//		RestTemplate restTemplate = remoteApi.getRestTemplate();
//		return (restTemplate.exchange("http://localhost:8085/olafbackend/secure/users/"+ id, HttpMethod.GET, remoteApi.getHttpEntity(), User.class)
//				.getBody());
//		
//}

//	@Override
//	public User findUserByUserName(String username) {
//		RestTemplate restTemplate = remoteApi.getRestTemplate();
//		return (restTemplate.exchange("http://localhost:8085/olafbackend/secure/users/user/"+ username, HttpMethod.GET, remoteApi.getHttpEntity(), User.class)
//				.getBody());
//	}
}