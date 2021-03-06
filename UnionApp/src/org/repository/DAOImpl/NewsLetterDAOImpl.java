package org.repository.DAOImpl;

import java.util.ArrayList;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import org.common.UnionAppMsgConstants;
import org.presentation.dto.criteria.Criteria;
import org.presentation.util.ServiceException;
import org.repository.DAOInterface.INewsLetterDAO;
import org.repository.entity.NewsLetterBO;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

@Repository
@Transactional
public class NewsLetterDAOImpl implements INewsLetterDAO {

	@PersistenceContext
	private EntityManager manager;

	public void createNewsLetter(NewsLetterBO newsLetterBO) {
		try {
			System.out.println("In createNewsLetter");
			manager.persist(newsLetterBO);
			System.out.println("Done createNewsLetter");
		} catch (Exception e) {
			ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT + e.getMessage());
			throw serviceExceptionObj;
		}
	}

	public void update(NewsLetterBO newsLetterBO) {
		try {
			System.out.println("InDAOAddUser");

			/*
			 * String SQL = "update " + UserBO.class.getName() +
			 * " u Set u.status='"+ userBO.getStatus()+"' where usname = '" +
			 * userBO.getUsname() + "'"; Query query = manager.createQuery(SQL);
			 * query.executeUpdate();
			 */

			manager.merge(newsLetterBO);

			System.out.println("DoneDAOAddUser");
		} catch (Exception e) {
			ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT + e.getMessage());
			throw serviceExceptionObj;
		}
	}

	@SuppressWarnings("unchecked")
	public ArrayList<NewsLetterBO> fetchNewsLetter(Criteria criteriaObj, String pageno) {

		System.out.println("In fetchNewsLetter");
		ArrayList<NewsLetterBO> NewsLetterBOList = null;

		int offsetno;

		int pageSize = 6;

		int pageNo = Integer.parseInt(pageno);

		if (null != pageno && pageno != "" && pageNo > 1) {

			offsetno = (pageNo - 1) * pageSize;
		} else {
			offsetno = 0;

		}

		try {

			if (null != criteriaObj.getCriteria() && criteriaObj.getCriteria().equalsIgnoreCase("True")) {
				if (criteriaObj.getFetchNewsLetterCriteriaObj() != null) {

					String searchCriteria = "";
					int index = -1;
					if (null != criteriaObj.getFetchNewsLetterCriteriaObj().getValue()
							&& criteriaObj.getFetchNewsLetterCriteriaObj().getValue() != "") {

						if (criteriaObj.getFetchNewsLetterCriteriaObj().getValue().contains(",")) {

							String[] idList = criteriaObj.getFetchNewsLetterCriteriaObj().getValue().split(",");

							for (String id : idList) {
								searchCriteria = searchCriteria + "'" + id + "',";
							}

							index = searchCriteria.lastIndexOf(",");
							if (index != -1) {
								searchCriteria = searchCriteria.substring(0, index);
							}

						} else {
							searchCriteria = "'" + criteriaObj.getFetchNewsLetterCriteriaObj().getValue() + "'";
						}

						String SQL = "select m from " + NewsLetterBO.class.getName() + " m where "
								+ criteriaObj.getFetchNewsLetterCriteriaObj().getName() + " in (" + searchCriteria
								+ ") order by m.nldate desc";

						NewsLetterBOList = (ArrayList<NewsLetterBO>) manager.createQuery(SQL).setFirstResult(offsetno) // offset
								.setMaxResults(pageSize) // limit
								.getResultList();
						;

					}

				} else {

					ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT);
					throw serviceExceptionObj;
				}
			} else {
				String SQL = "select m from " + NewsLetterBO.class.getName()
						+ " m where status not in ('delete') order by m.nldate desc ";
				NewsLetterBOList = (ArrayList<NewsLetterBO>) manager.createQuery(SQL).setFirstResult(offsetno) // offset
						.setMaxResults(pageSize) // limit
						.getResultList();
			}

			System.out.println("DoneDAOFetchUser");
		} catch (Exception e) {
			ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT + e.getMessage());
			throw serviceExceptionObj;
		}

		return NewsLetterBOList;
	}
	
	@SuppressWarnings("unchecked")
	public ArrayList<NewsLetterBO> fetchNewsLetterById(String id) {

		System.out.println("In fetchNewsLetterById");
		ArrayList<NewsLetterBO> newsLetterBOList = null;
		
		try {

			String SQL = "select m from " + NewsLetterBO.class.getName() + " m where nlid in (" 
						+ id + ") order by m.nldate desc";
			newsLetterBOList = (ArrayList<NewsLetterBO>) manager.createQuery(SQL).getResultList();			

			
		} catch (Exception e) {
			ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT + e.getMessage());
			throw serviceExceptionObj;
		}
		System.out.println("Done fetchNewsLetterById");
		return newsLetterBOList;
	}

	public Integer totalRecordCount(Criteria criteriaObj) {

		int count = 0;
		String SQL = "";

		try {

			if (null != criteriaObj.getCriteria() && criteriaObj.getCriteria().equalsIgnoreCase("True")) {
				if (criteriaObj.getFetchNewsLetterCriteriaObj() != null) {

					String searchCriteria = "";
					int index = -1;
					if (null != criteriaObj.getFetchNewsLetterCriteriaObj().getValue()
							&& criteriaObj.getFetchNewsLetterCriteriaObj().getValue() != "") {

						if (criteriaObj.getFetchNewsLetterCriteriaObj().getValue().contains(",")) {

							String[] idList = criteriaObj.getFetchNewsLetterCriteriaObj().getValue().split(",");

							for (String id : idList) {
								searchCriteria = searchCriteria + "'" + id + "',";
							}

							index = searchCriteria.lastIndexOf(",");
							if (index != -1) {
								searchCriteria = searchCriteria.substring(0, index);
							}

						} else {
							searchCriteria = "'" + criteriaObj.getFetchNewsLetterCriteriaObj().getValue() + "'";
						}

						SQL = "select m from " + NewsLetterBO.class.getName() + " m where "
								+ criteriaObj.getFetchNewsLetterCriteriaObj().getName() + " in (" + searchCriteria
								+ ") ";

					}

				} else {

					ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT);
					throw serviceExceptionObj;
				}
			} else {
				SQL = "select m from " + NewsLetterBO.class.getName()
						+ " m where status not in ('delete') ";

			}

			if (null != manager.createQuery(SQL).getResultList()) {
				count = manager.createQuery(SQL).getResultList().size();
			}

			System.out.println("DoneDAOFetchUser");
		} catch (Exception e) {
			ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT + e.getMessage());
			throw serviceExceptionObj;
		}

		return count;

	}

	public EntityManager getManager() {
		return manager;
	}

	public void setManager(EntityManager manager) {
		this.manager = manager;
	}

	@Override
	public void deleteOnCriteria(NewsLetterBO newsLetterBO, Criteria criteriaObj) {
		try {

			String SQL = "delete from " + NewsLetterBO.class.getName() + " where nlid = '" + newsLetterBO.getNlid()
					+ "'";

			Query query = manager.createQuery(SQL);
			query.executeUpdate();

			System.out.println("Done deleteOnCriteria");
		} catch (Exception e) {
			ServiceException serviceExceptionObj = new ServiceException(UnionAppMsgConstants.INSUFFICIENTINPUT + e.getMessage());
			throw serviceExceptionObj;
		}
	}
}
