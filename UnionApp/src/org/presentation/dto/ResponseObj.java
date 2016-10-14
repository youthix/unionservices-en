package org.presentation.dto;

import javax.xml.bind.annotation.XmlRootElement;

import org.presentation.dto.feature.ActivityList;
import org.presentation.dto.feature.MeetingList;
import org.presentation.dto.feature.NewsLetterList;
import org.presentation.dto.feature.SuggestionIdeaList;
import org.presentation.dto.user.UserList;
@XmlRootElement(name = "resparam")
//@JsonSerialize(include=JsonSerialize.Inclusion.NON_NULL)
public class ResponseObj {

	
	private UserList UserListObj;
	
	private MeetingList MeetingListObj;
	
	private ActivityList activityListObj;
	
	private NewsLetterList newsLetterListObj;
	
	private SuggestionIdeaList suggestionIdeaListObj;
	
	private String totalPage;
	
	ResStatus resStatus;


	public ResStatus getResStatus() {
		return resStatus;
	}

	public void setResStatus(ResStatus resStatus) {
		this.resStatus = resStatus;
	}

	public UserList getUserListObj() {
		return UserListObj;
	}

	public void setUserListObj(UserList userListObj) {
		UserListObj = userListObj;
	}

	public MeetingList getMeetingListObj() {
		return MeetingListObj;
	}

	public void setMeetingListObj(MeetingList meetingListObj) {
		MeetingListObj = meetingListObj;
	}


	public ActivityList getActivityListObj() {
		return activityListObj;
	}

	public void setActivityListObj(ActivityList activityListObj) {
		this.activityListObj = activityListObj;
	}

	public String getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(String totalPage) {
		this.totalPage = totalPage;
	}

	public NewsLetterList getNewsLetterListObj() {
		return newsLetterListObj;
	}

	public void setNewsLetterListObj(NewsLetterList newsLetterListObj) {
		this.newsLetterListObj = newsLetterListObj;
	}

	public SuggestionIdeaList getSuggestionIdeaListObj() {
		return suggestionIdeaListObj;
	}

	public void setSuggestionIdeaListObj(SuggestionIdeaList suggestionIdeaListObj) {
		this.suggestionIdeaListObj = suggestionIdeaListObj;
	}
	
	
}
