package controller;

import model.ClassRoom;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import service.IClassRoomService;
import service.IStudentService;

import java.util.ArrayList;

@Controller
public class StudentController {
    @Autowired
    IStudentService iStudentService;

    @Autowired
    IClassRoomService iClassRoomService;

    @ModelAttribute
    public ArrayList<ClassRoom> listClassroom(){
        return iClassRoomService.findAll();
    }

    @GetMapping("/show")
    private ModelAndView show(@RequestParam(defaultValue = "0")int pageNumber){
        ModelAndView modelAndView=new ModelAndView("show");
        modelAndView.addObject("list",iStudentService.findAll(PageRequest.of(pageNumber,3)));
        return modelAndView;
    }





}
