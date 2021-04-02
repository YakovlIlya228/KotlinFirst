package com.example.kotlinfirst.ui.activities

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.kotlinfirst.R
import com.example.kotlinfirst.ui.MyApp
import com.example.kotlinfirst.ui.Screens
import com.example.kotlinfirst.ui.fragments.NewsFragment
import com.github.terrakok.modo.android.ModoRender
import com.github.terrakok.modo.android.init
import com.github.terrakok.modo.android.saveState
import com.github.terrakok.modo.replace
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    val modo = MyApp.instance.modo

    private val modoRender by lazy { ModoRender(this, R.id.hostfragment) }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        modo.init(savedInstanceState, Screens.LessonList())
        navigation_view.setOnNavigationItemSelectedListener {
            when(it.itemId){
                R.id.lessons_fragment -> modo.replace(Screens.LessonList())
                R.id.news_fragment -> modo.replace(Screens.News())
                R.id.code_editor_fragment -> modo.replace(Screens.CodeEditor())
            }
            return@setOnNavigationItemSelectedListener true
        }
    }

    override fun onResume() {
        super.onResume()
        modo.render = modoRender
    }

    override fun onPause() {
        modo.render = null
        super.onPause()
    }


    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        //add this if you want to restore app after process death
        modo.saveState(outState)
    }
}