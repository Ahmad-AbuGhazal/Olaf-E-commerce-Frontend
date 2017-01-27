package edu.mum.olaf.repository.repositoryImpl;


import javax.persistence.Query;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;

import edu.mum.olaf.domain.User;
import edu.mum.olaf.repository.UserDao;

@Repository
@Service
public class UserDaoImpl extends GenericDaoImpl<User> implements UserDao {

	public UserDaoImpl() {
		super.setDaoType(User.class );
		}

	@Override
	public User findByUserName(String username) {
	Query query=entityManager.createQuery("Select u from User u  where u.userCredentials.username=:user");
	return  (User)query.setParameter("user", username).getSingleResult();
	}
	
}
