package com.hadev.simpleapprefactory

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.DialogFragment

class AddTaskDialog : DialogFragment() {
    companion object {
        const val TAG = "AddTaskDialog"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_add_task, null, false)
    }

    override fun getTheme() = R.style.DialogTheme
}