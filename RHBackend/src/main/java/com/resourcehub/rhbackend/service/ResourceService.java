package com.resourcehub.rhbackend.service;

import com.resourcehub.rhbackend.model.Resource;
import com.resourcehub.rhbackend.model.Course;
import com.resourcehub.rhbackend.model.User;
import com.resourcehub.rhbackend.repository.ResourceRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ResourceService {

    private final ResourceRepository resourceRepository;
    private final CourseService courseService;
    private final UserService userService;

    public ResourceService(ResourceRepository resourceRepository,
                           CourseService courseService,
                           UserService userService) {
        this.resourceRepository = resourceRepository;
        this.courseService = courseService;
        this.userService = userService;
    }

    public Resource addResource(String title, String type, String fileUrl,
                                Integer year, String courseCode, Long uploaderId) {

        Course course = courseService.getCourseByCode(courseCode);
        User uploader = userService.getUserById(uploaderId);

        Resource resource = new Resource(
                title,
                type,
                fileUrl,
                year,
                course,
                uploader
        );

        return resourceRepository.save(resource);
    }

    public List<Resource> getResourcesByCourse(String courseCode) {
        Course course = courseService.getCourseByCode(courseCode);
        return resourceRepository.findByCourse(course);
    }

    public List<Resource> getResourcesByCourseAndYear(String courseCode, Integer year) {
        Course course = courseService.getCourseByCode(courseCode);
        return resourceRepository.findByCourseAndYear(course, year);
    }
}
