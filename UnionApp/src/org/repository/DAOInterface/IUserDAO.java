package org.repository.DAOInterface;

import java.util.ArrayList;

import org.presentation.dto.fetchcriteria.Criteria;
import org.presentation.dto.user.User;
import org.repository.entity.UserBO;

public interface IUserDAO {

	public void addUser(UserBO userBO);

	//public UserBO fetchUserByParam(User userdto);
	
	public void update(UserBO userBO);

	public ArrayList<UserBO> fetchUser(Criteria criteriaObj);

}
