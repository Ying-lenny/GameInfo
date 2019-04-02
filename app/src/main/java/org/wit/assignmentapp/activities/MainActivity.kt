package org.wit.assignmentapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.assignmentapp.R
import org.wit.assignmentapp.main.MainApp
import org.wit.assignmentapp.models.gameappModels

class MainActivity : AppCompatActivity(), AnkoLogger {

    var gameInfo = gameappModels()
    lateinit var app : MainApp

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = application as MainApp

        btnAdd.setOnClickListener() {
            gameInfo.title = gameappTitle.text.toString()
            gameInfo.description = gameappDescription.text.toString()
            if (gameInfo.title.isNotEmpty()) {
                app.gamesInfo.add(gameInfo.copy())
                info("add Button Pressed: $gameappTitle")
                app.gamesInfo.forEach {info("add Button Pressed: ${it}")}
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            else {
                toast ("Please Enter a title")
            }
        }
    }
}
