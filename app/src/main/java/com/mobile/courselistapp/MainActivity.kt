package com.mobile.courselistapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.MaterialTheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.mobile.courselistapp.coursepage.Course
import com.mobile.courselistapp.coursepage.CourseCard
import com.mobile.courselistapp.ui.theme.CourseListAppTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            CourseListAppTheme {
                MainScreen()
            }
        }
    }
}

@Composable
fun MainScreen() {
    val sampleCourses = listOf(
        Course("Intro to Programming", "CS101", 3, "Learn the basics of programming.", "None"),
        Course("Data Structures", "CS201", 4, "Explore arrays, trees, and graphs.", "CS101"),
        Course("Databases", "CS301", 3, "Learn SQL and relational databases.", "CS201"),
        Course(
            "Operating System",
            "CS301",
            4,
            "Learn an operating system’s various functional modules.",
            "None"
        )
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.background)
            .padding(8.dp)
    ) {
        LazyColumn {
            items(sampleCourses) { course ->
                CourseCard(course)
            }
        }
    }
}
