package com.bcsd.service;


import com.bcsd.entity.*;

import java.util.List;
import java.util.Map;


public interface AppointmentMeetService {

    //预约本地会议添加
    void appointmentMeet(Remeet remeet, List<UserInternal> user);


    //根据用户Id查询所有预约的会议
    List<Remeet> findAll();

    List<Remeet> findPage(int index, int size, String meetName);

    List<Remeet> findPage(int index, int size);


    //查询会议
    Remeet findOne(Integer id);

    //修改会议
    void update(Remeet remeet);

    void updateState(Integer id);

    List<Remeet> findMeetByUserId(Integer id);
}
