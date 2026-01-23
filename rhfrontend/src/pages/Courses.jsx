import { useEffect, useState } from "react";
import { getCourses } from "../services/api";

function Courses() {
  const [courses, setCourses] = useState([]);

  useEffect(() => {
    getCourses().then((data) => setCourses(data));
  }, []);

  return (
    <div>
      <h2>Available Courses</h2>

      <ul>
        {courses.map((course) => (
          <li key={course.id}>
            <strong>{course.courseCode}</strong> – {course.courseName}
          </li>
        ))}
      </ul>
    </div>
  );
}

export default Courses;
