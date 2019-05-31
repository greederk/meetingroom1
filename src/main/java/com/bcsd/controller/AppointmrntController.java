package com.bcsd.controller;

import com.bcsd.entity.*;
import com.bcsd.service.AppointmentMeetService;
import com.bcsd.service.MeetUserService;
import com.bcsd.service.ReMeetRoomService;
import com.bcsd.entity.MeetRoom;
import com.bcsd.entity.Remeet;
import com.bcsd.entity.UserInternal;
import com.bcsd.service.*;
import com.bcsd.util.DateChange;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/appointreet")
public class AppointmrntController {

    @Autowired
    private AppointmentMeetService appointmentMeetService;

    /**
     * 查询我的预定会议
     *
     * @param page
     * @param size
     * @return
     */
    @RequestMapping("myappointmeet")
    public ModelAndView myappointmeet(Integer page, Integer size) {
        if (page == null || page == 0) {
            page = 1;
        }
        if (size == null || size == 0) {
            size = 10;
        }
        ModelAndView vm = new ModelAndView();
        List<Remeet> meets = appointmentMeetService.findPage(page, size);
        PageInfo pageInfo = new PageInfo<Remeet>(meets);
        vm.addObject("pageInfo", pageInfo);
        vm.setViewName("page/meeting/meettable");
        return vm;
    }


}
