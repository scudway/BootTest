package com.topic.Controllers;

import com.topic.Entities.Course;
import com.topic.Services.CourseService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class CourseController {

    @Autowired
    private CourseService service ;

    // get all course
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses")
    public List<Course> getAllCourses (@PathVariable String topicId){
        return service.getAllCourse(topicId);
    }

    // get particular course
    @RequestMapping(method = RequestMethod.GET, value = "/topics/{topicId}/courses/{courseId}")
    public Course getCourse (@PathVariable String topicId, @PathVariable String courseId){
        return service.getCourse(topicId,courseId);
    }

    // add new course
    @RequestMapping(method = RequestMethod.POST, value = "/topics/{topicId}/courses")
    public void addCourse (@RequestBody Course course){
        service.addCourse(course);
    }
    // update course
    @RequestMapping(method = RequestMethod.PUT, value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse (@RequestBody Course course ,@PathVariable String topicId,@PathVariable String courseId){
        service.updateCourse(course, topicId, courseId);
    }

    // delete course
    @RequestMapping(method = RequestMethod.DELETE, value = "/topics/{topicId}/courses/{courseId}")
    public void updateCourse (@PathVariable String topicId,@PathVariable String courseId){
        service.deleteCourse(topicId, courseId);
    }

}
