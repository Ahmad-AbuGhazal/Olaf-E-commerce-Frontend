package edu.mum.olaf.repository.repositoryImpl;

import java.util.List;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import edu.mum.olaf.repository.GenericDao;

public abstract class GenericDaoImpl<T> implements GenericDao<T> {

	@PersistenceContext
    protected EntityManager entityManager;

    protected Class<T> daoType;

	public void setDaoType(Class<T> type) {
			daoType = type;
	}
   
    public void save( T entity ){
    System.out.println(this.daoType.getName());	
     entityManager.persist( entity );
     }

    public void delete( T entity ){
        entityManager.remove( entity );
     }

	public void delete(Long id) {
        T entity = findOne( id );
        delete( entity );  
    }

	@Override
	public T findOne( Long id ){
	    return (T) entityManager.find( daoType, id );
	 }
	
	@SuppressWarnings("unchecked")
	@Override
	public List<T> findAll(){
		      return entityManager.
		    		  createQuery( "from " + daoType.getName())
		              .getResultList();
		   }
	
	@Override
	public T update( T entity ){
	      return entityManager.merge( entity );
	   }

 }