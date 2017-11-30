package com.mycompany.myproject.web.controller;

import com.mycompany.myproject.dto.*;
import com.mycompany.myproject.service.svc.*;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Scope;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.net.URI;
import java.sql.Date;
import java.util.ArrayList;
import java.util.List;

@Controller
@SessionAttributes("user")
@Scope("request")
//@RequestMapping("/management")
public class ManagerController {

    private static final Logger logger = LoggerFactory.getLogger(TrainController.class);

    @Autowired
    private ManagerService managerService;

    @Autowired
    private UserService userService;



    @CrossOrigin
    @RequestMapping(value = "/addStationRest", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
    public @ResponseBody
    ResponseEntity<String> stationInfo(@RequestBody String msg, HttpServletResponse response) {
        msg.toString();
        ResponseEntity myResponse = new ResponseEntity(HttpStatus.OK);
        return myResponse;
    }



}
