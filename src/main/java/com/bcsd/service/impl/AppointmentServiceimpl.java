package com.bcsd.service.impl;

import com.bcsd.dao.AppointmentMeetDao;
import com.bcsd.entity.*;
import com.bcsd.service.AppointmentMeetService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Service("appointmentMeetService")
public class AppointmentServiceimpl implements AppointmentMeetService {

    @Autowired
    private AppointmentMeetDao appointmentMeetDao;

    //预定本地会议
    public void appointmentMeet(Remeet remeet,List<UserInternal> user) {

        for (UserInternal u:user){
            Mail mail=new Mail(u.getEmail(),remeet.getMeetName(),remeet.getMeetName(),remeet.getMeetDescription(),null,null,1,0,null);
            System.out.println(mail);

        }
        appointmentMeetDao.appointmentMeet(remeet);
    }


    public List<Remeet> findAll() {
        return appointmentMeetDao.findAll();
}

    public List<Remeet> findPage(int page, int size, String meetName) {
        PageHelper.startPage(page,size);
        return appointmentMeetDao.findAll(meetName);
    }

    //查询所有会议
    public List<Remeet> findPage(int page,int size) {
        PageHelper.startPage(page,size);
        return appointmentMeetDao.findAll();
    }



    public List<HistoryMeet> findPageHistory(Integer page, Integer size, Integer id,String meetName) {
        PageHelper.startPage(page,size);
        return appointmentMeetDao.findPageHistory(id,meetName);
    }

    public List<MeetUser> findHistoryUser(Integer page, Integer size, Integer id) {
        PageHelper.startPage(page,size);
        return appointmentMeetDao.findHistoryUser(id);
    }

    @Override
    public Remeet findOne(Integer id) {
        return appointmentMeetDao.findOne(id);
    }

    @Override
    public void update(Remeet remeet) {
        appointmentMeetDao.update(remeet);
    }


    @Override
    public void updateState(Integer id) {
        appointmentMeetDao.updateState(id);
    }

    @Override
    public List<Remeet> findMeetByUserId(Integer id) {
        return appointmentMeetDao.findMeetByUserId(id);
    }
}
