package com.bcsd.service;

import com.bcsd.entity.MeetUser;
import com.bcsd.entity.UserInternal;

import java.util.List;
import java.util.Map;

/**
 * @author HOEP
 * @data 2019/4/24
 */
public interface MeetUserService  {
	List<Map<String, String>> findAll(Integer page, Integer size, String username);

	void add(MeetUser meetUser);

	Map<String, String> findById(Integer Id);

	void update(MeetUser meetUser);

	void delete(Integer id);

	UserInternal findOne(Integer id);


    List<Map<String ,String>> findDept();
}
