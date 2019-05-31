package com.bcsd.service;

import com.bcsd.entity.Mail;
import com.bcsd.entity.UserInternal;

import java.util.List;


public interface AddUserService {

   UserInternal findByUserId(int id);
}
