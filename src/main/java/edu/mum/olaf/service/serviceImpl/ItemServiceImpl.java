package edu.mum.olaf.service.serviceImpl;
import java.util.List;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;

import edu.mum.olaf.domain.Item;
import edu.mum.olaf.repository.ItemDao;
import edu.mum.olaf.service.ItemService;


@Service
@Transactional
public class ItemServiceImpl  implements ItemService{
	
	@Autowired
	ItemDao itemDao;
	
	
//@edu.mum.olaf.validation.ServiceValidation
	@Transactional
	@Override
	public void save(Item item) {
		itemDao.save(item);
	}

	@Override
	//@edu.mum.olaf.validation.ServiceValidation
	public Item update(Item item) {
		return itemDao.update(item);
	}

	@Override
	public Item findOne(long id) {
		return itemDao.findOne(id);
	}

	@Override
	public List<Item> findAll() {
		return itemDao.findAll();
	}

	@Override
	public List<Item> findAllBySellerId(Long sellerId) {
		return itemDao.findAllBySellerId(sellerId);
	}
	}
