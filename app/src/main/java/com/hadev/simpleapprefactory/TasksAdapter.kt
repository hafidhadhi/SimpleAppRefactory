package com.hadev.simpleapprefactory

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.task_item.view.*

data class Task(
    val taskId: Int,
    val taskTitle: String? = null,
    val taskDesc: String? = null,
    val taskDuration: String? = null,
    val startTime: String? = null,
    val isCompleted: Boolean = false,
)

class TasksAdapter : ListAdapter<Task, TasksAdapter.ViewHolder>(TaskDiffCallback()) {
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        companion object {
            fun from(parent: ViewGroup): ViewHolder {
                val layoutInflater = LayoutInflater.from(parent.context)
                val view = layoutInflater.inflate(R.layout.task_item, parent, false)
                return ViewHolder(view)
            }
        }

        fun bind(item: Task) {
            with(itemView) {
                task_title.text = item.taskTitle
                task_desc.text = item.taskDesc
                task_duration.text = item.taskDuration
                hour_txt.text = item.startTime
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        return ViewHolder.from(parent)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val item = getItem(position)
        holder.bind(item)
    }

}

class TaskDiffCallback : DiffUtil.ItemCallback<Task>() {
    override fun areItemsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem.taskId == newItem.taskId
    }

    override fun areContentsTheSame(oldItem: Task, newItem: Task): Boolean {
        return oldItem == newItem
    }
}
