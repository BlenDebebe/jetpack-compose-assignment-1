package com.mobile.courselistapp.coursepage

import android.content.res.Configuration
import androidx.compose.animation.animateContentSize
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.compose.ui.tooling.preview.Preview
import com.mobile.courselistapp.ui.theme.CourseListAppTheme

@Composable
fun CourseCard(course: Course) {
    var isExpanded by rememberSaveable { mutableStateOf(false) }

    Card(
        modifier = Modifier
            .padding(8.dp)
            .fillMaxWidth()
            .clickable { isExpanded = !isExpanded },
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
                IconButton(onClick = { isExpanded = !isExpanded }) {
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
fun CourseCardPreview() {
    CourseListAppTheme {
        CourseCard(
            course = Course(
                title = "Sample Course",
                code = "CS999",
                creditHours = 3,
                description = "This is a sample course used in preview.",
                prerequisites = "None"
            )
        )
    }
}

@Preview(
    showBackground = true,
    uiMode = Configuration.UI_MODE_NIGHT_YES,
    name = "Dark Mode Preview"
)
@Composable
fun CourseCardDarkPreview() {
    CourseListAppTheme {
        CourseCard(
            course = Course(
                title = "Sample Course (Dark)",
                code = "CS888",
                creditHours = 4,
                description = "This is a sample course previewed in dark theme.",
                prerequisites = "Intro to Dark UIs"
            )
        )
    }
}
