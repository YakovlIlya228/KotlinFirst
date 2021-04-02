package com.example.kotlinfirst.ui

import androidx.fragment.app.Fragment
import com.example.kotlinfirst.ui.fragments.CodeEditorFragment
import com.example.kotlinfirst.ui.fragments.LessonListFragment
import com.example.kotlinfirst.ui.fragments.NewsFragment
import com.github.terrakok.modo.android.AppScreen
import kotlinx.android.parcel.Parcelize

object Screens {
    @Parcelize
    class CodeEditor: AppScreen("code_editor"){
        override fun create(): Fragment = CodeEditorFragment()
    }
    @Parcelize
    class LessonList: AppScreen("lesson_list"){
        override fun create(): Fragment = LessonListFragment()
    }
    @Parcelize
    class News: AppScreen("news"){
        override fun create(): Fragment = NewsFragment()
    }
}