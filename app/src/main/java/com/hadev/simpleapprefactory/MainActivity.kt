package com.hadev.simpleapprefactory

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.activity_main.*

val DUMMY_TASK_LIST = MutableList(2) { index ->
    Task(
        taskId = index,
        taskTitle = "Task Title $index",
        taskDesc = "This is Task Description for Task $index",
        taskDuration = "00:${index}9 - 00:${index}0",
        startTime = "0$index:00"
    )
}

val DUMMY_CALENDAR_LIST = MutableList(10) { index ->
    Day(
        id = index,
        name = index.let { if (it % 2 == 0) "T" else "S" },
        dayOfMonth = index.toString()
    )
}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupBottomNavBar()
        setupCalendarList()
        setupTaskList()
    }

    private fun setupCalendarList() {
        val rv = calendar_section.findViewById<RecyclerView>(R.id.date_list)
        rv.adapter = CalendarAdapter().apply { submitList(DUMMY_CALENDAR_LIST) }
    }

    private fun setupTaskList() {
        val rv = task_list_section.findViewById<RecyclerView>(R.id.task_list)
        rv.adapter = TasksAdapter().apply { submitList(DUMMY_TASK_LIST) }
    }

    private fun setupBottomNavBar() {
        val addTaskButton = bottom_nav_bar.findViewById<ImageView>(R.id.add_task_icon)
        addTaskButton.setOnClickListener { v ->
            AddTaskDialog().show(supportFragmentManager, AddTaskDialog.TAG)
        }
    }
}