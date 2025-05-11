package com.mobile.courselistapp

import com.mobile.courselistapp.coursepage.Course

val SampleCourse= listOf(
    Course(
        title = "Introduction to Programming",
        code = "CS101",
        creditHours = 3,
        description = "Learn the basics of programming using Kotlin.",
        prerequisites = "None"
    ),
    Course(
        title = "Data Structures",
        code = "CS201",
        creditHours = 4,
        description = "Study of arrays, stacks, queues, trees, and graphs.",
        prerequisites = "CS101"
    ),
    Course(
        title = "Operating Systems",
        code = "CS301",
        creditHours = 3,
        description = "Concepts of process management, memory, and I/O.",
        prerequisites = "CS201"
    ),
    Course(
        title = "Databases",
        code = "CS401",
        creditHours = 3,
        description = "Introduction to relational databases and SQL.",
        prerequisites = "CS201"
    )
)
