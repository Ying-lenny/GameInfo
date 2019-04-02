package org.wit.assignmentapp.activities

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.card_gameapp.*
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.jetbrains.anko.toast
import org.wit.assignmentapp.R
import org.wit.assignmentapp.main.MainApp
import org.wit.assignmentapp.models.gameappModels

class MainActivity : AppCompatActivity(), AnkoLogger
{

    var gameInfo = gameappModels()
    lateinit var app : MainApp

    // CHecking GitHub pushes

    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        app = application as MainApp

        if (intent.hasExtra("gameinfo_edit"))
        {
            gameInfo = intent.extras.getParcelable<gameappModels>("gameinfo_edit")
            card_gameappTitle.setText(gameInfo.title)
            card_description.setText(gameInfo.description)
        }

        btnAdd.setOnClickListener()
        {
            gameInfo.title = gameappTitle.text.toString()
            gameInfo.description = gameappDescription.text.toString()

            if (gameInfo.title.isNotEmpty())
            {
                app.gamesInfo.create(gameInfo.copy())
                info("add Button Pressed: $gameInfo.Title")
//                app.gamesInfo.findAll().forEach {info("add Button Pressed: ${it}")}
                setResult(AppCompatActivity.RESULT_OK)
                finish()
            }
            else
            {
                toast ("Please Enter a title")
            }
        }

        toolbarAdd.title = title
        setSupportActionBar(toolbarAdd)

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_gameinfo, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_cancel -> {
                finish()
            }
        }
        return super.onOptionsItemSelected(item)
    }
}
