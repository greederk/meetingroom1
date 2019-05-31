package com.bcsd.service.impl;

import com.bcsd.dao.MeetUserDao;
import com.bcsd.entity.MeetUser;
import com.bcsd.entity.Role;
import com.bcsd.entity.UserInternal;
import com.bcsd.service.MeetUserService;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author HOEP
 * @data 2019/4/24
 */
@Service("meetUserService")
@Transactional
public class MeetUserServiceImpl implements MeetUserService {

    private Logger logger = LoggerFactory.getLogger(getClass());

    @Autowired
    private MeetUserDao meetUserDao;





    public List<Map<String,String>> findAll(Integer page, Integer size, String username) {
        PageHelper.startPage(page, size);
        return meetUserDao.findAll(username);
    }

    public void add(MeetUser meetUser) {
        //对密码进行加密处理
        //meetUser.setPassword(bCryptPasswordEncoder.encode(meetUser.getPassword()));
        meetUserDao.add(meetUser);
    }


    public Map<String,String> findById(Integer Id) {
        return meetUserDao.findById(Id);
    }

    public void update(MeetUser meetUser) {
        //对密码进行加密处理
       // meetUser.setPassword(bCryptPasswordEncoder.encode(meetUser.getPassword()));
        meetUserDao.update(meetUser);
    }

    public void delete(Integer id) {
        meetUserDao.delete(id);
    }

    /**
     * 查询内部联系人
     *
     * @param page
     * @param size
     * @param internal
     * @return
     */

    public List<UserInternal> findInternal(Integer page, Integer size, String internal, String name) {
        PageHelper.startPage(page, size);
        List<UserInternal> list = meetUserDao.findInternal(internal, name);
        return list;
    }


    /**
     * 添加联系人
     *
     * @param internal
     */
    public void addInternal(UserInternal internal) {
        internal.setStatus(1);
        meetUserDao.addInternal(internal);
    }

    /**
     * 删除
     *
     * @param
     */

    @Transactional  //事务管理
    public void deleteInternal(Integer id) {
        meetUserDao.deleteInternal(id);
    }

    /**
     * 批量删除
     *
     * @param ids
     */

    @Transactional  //事务管理
    public void deleteInternal(Integer[] ids) {
        try {
            if (ids != null && ids.length > 0) {
                for (Integer id : ids) {
                    meetUserDao.deleteInternal(id);
                }
            }
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public UserInternal findOne(Integer id) {
        return meetUserDao.findOne(id);
    }


    @Override
    public List<Map<String ,String>> findDept() {
        return null;
    }

}
