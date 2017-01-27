package serviceImplTesting;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.MockitoAnnotations;
import org.mockito.stubbing.OngoingStubbing;
import org.springframework.beans.factory.annotation.Autowired;

import edu.mum.olaf.domain.Category;
import edu.mum.olaf.repository.CategoryDao;

public class CategoryServiceImplTest {
    @Autowired
	protected @Mock CategoryDao mockCategoryDao;

	@Before
	public void setup() {
		// setup declaration
		MockitoAnnotations.initMocks(this);
	}
/**
 * @see #mockCategoryDao
 */
	@Test
	public void testGetCategories() {

		// given 
		final Category category = new Category();
		final List<Category> categories = new ArrayList<>();
		categories.add(category);

		// execute
		mockCategoryDao.findAll();

		OngoingStubbing<List<Category>> ongoingStubbingCategory = Mockito.when(mockCategoryDao.findAll());
		ongoingStubbingCategory.thenCallRealMethod();
     
		
		/**  if we want to call real method we used ongoingStubbingCategory.thenCallRealMethod()
          *  when the implementation is done
          */
		
		
		// verify
		Mockito.verify(mockCategoryDao).findAll();

	}

}
