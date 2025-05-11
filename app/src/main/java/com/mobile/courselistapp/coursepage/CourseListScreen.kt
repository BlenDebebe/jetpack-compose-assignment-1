package com.mobile.courselistapp.coursepage

import android.content.res.Configuration
import androidx.compose.foundation.layout.*
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.mobile.courselistapp.ui.theme.CourseListAppTheme


@Composable
fun CourseListScreen(courses: List<Course>) {
    // Save expanded state for each course
    var expandedStates by rememberSaveable {
        mutableStateOf(List(courses.size) { false })
    }

    LazyColumn(modifier = Modifier.padding(8.dp)) {
        items(courses.size) { index ->
            val course = courses[index]
            CourseCardWithState(
                course = course,
                isExpanded = expandedStates[index],
                onExpandedChange = { newExpanded ->
                    expandedStates = expandedStates.toMutableList().apply {
                        this[index] = newExpanded
                    }
                }
            )
        }
    }
}

@Composable
fun CourseCardWithState(
    course: Course,
    isExpanded: Boolean,
    onExpandedChange: (Boolean) -> Unit
) {
    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { onExpandedChange(!isExpanded) },
        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp),
        colors = CardDefaults.cardColors(containerColor = MaterialTheme.colorScheme.surface)
    ) {
        Column(
            modifier = Modifier
                .padding(16.dp)
                .animateContentSize()
        ) {
            Text(course.title, style = MaterialTheme.typography.headlineSmall)

            Row(
                modifier = Modifier
                    .padding(top = 4.dp)
                    .fillMaxWidth(),
                horizontalArrangement = Arrangement.SpaceBetween
            ) {
                Text(course.code, style = MaterialTheme.typography.bodyMedium)
                Text("${course.creditHours} Credits", style = MaterialTheme.typography.bodyMedium)
            }

            if (isExpanded) {
                Spacer(modifier = Modifier.height(8.dp))
                Text("Description: ${course.description}", style = MaterialTheme.typography.bodyMedium)
                Text("Prerequisites: ${course.prerequisites}", style = MaterialTheme.typography.bodyMedium)
            }

            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(top = 8.dp),
                horizontalArrangement = Arrangement.End
            ) {
                IconButton(onClick = { onExpandedChange(!isExpanded) }) {
                    Icon(
                        imageVector = if (isExpanded) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (isExpanded) "Show less" else "Show more"
                    )
                }
            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun CourseListScreenPreview() {
    CourseListAppTheme {
        CourseListScreen(
            courses = listOf(
                Course("Kotlin Basics", "CS101", 3, "Learn Kotlin from scratch.", "None"),
                Course(
                    "Compose Essentials",
                    "CS201",
                    4,
                    "Understand Jetpack Compose fundamentals.",
                    "CS101"
                ),
                Course("Advanced UI", "CS301", 3, "Dive into UI animations and state.", "CS201")
            )
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Course List Dark Mode"
)
@Composable
fun CourseListScreenDarkPreview() {
    CourseListAppTheme {
        CourseListScreen(
            courses = listOf(
                Course("Kotlin Basics", "CS101", 3, "Learn Kotlin from scratch.", "None"),
                Course(
                    "Compose Essentials",
                    "CS201",
                    4,
                    "Understand Jetpack Compose fundamentals.",
                    "CS101"
                ),
                Course("Advanced UI", "CS301", 3, "Dive into UI animations and state.", "CS201")
            )
        )
    }
}
