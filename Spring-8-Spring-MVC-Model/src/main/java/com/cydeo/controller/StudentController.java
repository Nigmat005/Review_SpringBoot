package com.cydeo.controller;

import com.cydeo.model.Student;
import com.cydeo.utils.Gender;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.*;
import java.util.stream.Collectors;

@Controller
@RequestMapping(value = {"/student","/"}) //or
public class StudentController {

    @GetMapping(value = {"/welcome"})
    public String welcomeStudent(Model model){
        String studentName="Nigmat";
        String subject="SpringBoot";
        String goal="Full Stack Developer";
//
//        // model will help bring data(variables) to view page
        model.addAttribute("emptyName", null);
        model.addAttribute("studentName", studentName);
        model.addAttribute("subject",subject);
        model.addAttribute("goal",goal);
        return "/student/studentWelcomePage";
    }

    @GetMapping("/showId")
    public String randomId(Model model){
        model.addAttribute("Id", UUID.randomUUID().getMostSignificantBits());
        return "/student/showId";
    }

    @GetMapping("/showIdList")
    public String randomIdList(Model model){
        int[] arrayIds=new int[10];
        // put random 10 ids into array
        for (int i=0; i<10;i++){
            int randomId=new Random().nextInt(1000, 9000);
            arrayIds[i]=randomId;
        }
        List<Integer> list = Arrays.stream(arrayIds)
                .boxed().toList();  //toList VS collect(Collectors.toList());  toList is stored as immutable, collect(Collectors.toList()) would stored object as mutable.


        model.addAttribute("list", list);
        model.addAttribute("singleId", new Random().nextInt(100,1000));
        model.addAttribute("iteratorFlag", true);
        return "/student/showIdList";
    }


    @RequestMapping(value = "/table",method = RequestMethod.GET)
    public String showTable(Model model){
        List<Student> studentList= new ArrayList<>();
        Student mike=new Student("Mike", "Smith",45 , Gender.MALE);
        Student tom=new Student("Tom", "Hanks",65 , Gender.MALE);
        Student ammy=new Student("Ammy", "Bryan",25 , Gender.FEMALE);

        studentList.add(mike);
        studentList.add(tom);
        studentList.add(ammy);

        model.addAttribute("studentList",studentList);
        return "/student/studentTable";
    }

}
