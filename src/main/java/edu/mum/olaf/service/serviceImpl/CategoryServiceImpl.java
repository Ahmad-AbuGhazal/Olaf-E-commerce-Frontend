package edu.mum.olaf.service.serviceImpl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.repository.CategoryDao;
import edu.mum.olaf.service.CategoryService;
import org.springframework.transaction.annotation.Transactional;

@Service
@Transactional

public class CategoryServiceImpl implements CategoryService {
	@Autowired
    CategoryDao categoryDao;
	
	@Override
	@edu.mum.olaf.validation.ServiceValidation
	public void save(Category category) {
	    categoryDao.save(category);
	}

	@Override
	@edu.mum.olaf.validation.ServiceValidation
	public Category update(Category category) {
		return categoryDao.update(category);
	}

	@Override
	public Category findOne(long id) {
	
		return categoryDao.findOne(id);
	}

	@Override
	public List<Category> findAll() {
		return categoryDao.findAll();
	}
//	@Autowired
//	RemoteApi remoteApi;
//	@Override
//	public List<Category> findAll() {
//		RestTemplate restTemplate = remoteApi.getRestTemplate();
//		return Arrays.asList(restTemplate.exchange("http://localhost:8085/olafbackend/categories/", HttpMethod.GET, remoteApi.getHttpEntity(), Category[].class).getBody());
//	}
//	@Override
//	public Category findOne(long id) {
//			RestTemplate restTemplate = remoteApi.getRestTemplate();
//			return (restTemplate.exchange("http://localhost:8085/olafbackend/categories/"+ id, HttpMethod.GET, remoteApi.getHttpEntity(), Category.class)
//					.getBody());
//	}
//	@Override
//	public void save(Category category) {
//		// TODO Auto-generated method stub
//		
//	}
//	@Override
//	public Category update(Category category) {
//		// TODO Auto-generated method stub
//		return null;
//	}

}
