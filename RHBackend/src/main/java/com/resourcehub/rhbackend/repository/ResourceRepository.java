package com.resourcehub.rhbackend.repository;

import com.resourcehub.rhbackend.model.Resource;
import com.resourcehub.rhbackend.model.Course;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface ResourceRepository extends JpaRepository<Resource, Long> {

    List<Resource> findByCourse(Course course);

    List<Resource> findByCourseAndYear(Course course, Integer year);

    List<Resource> findByResourceType(String resourceType);
}
