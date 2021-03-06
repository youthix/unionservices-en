package org.repository.DAOInterface;

import java.util.ArrayList;

import org.presentation.dto.criteria.Criteria;
import org.repository.entity.CategoryBO;
import org.repository.entity.UserBO;

public interface ICategoryDAO {

	public void addCategory(CategoryBO categoryBO);

	public ArrayList<CategoryBO> fetchCategory(Criteria criteriaObj);
	
	public ArrayList<CategoryBO> fetchCategoryById(String id);
	
	public void update(CategoryBO categoryBO);
	
	public void delete(String id);

}
