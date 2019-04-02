package org.wit.assignmentapp.main

import android.app.Application
import org.jetbrains.anko.AnkoLogger
import org.jetbrains.anko.info
import org.wit.assignmentapp.models.gameappModels

class MainApp : Application(),AnkoLogger {

    val gamesInfo = ArrayList<gameappModels>()

    override fun onCreate() {
        super.onCreate()
        info("Game App Started")
        gamesInfo.add(gameappModels("Nier","About it"))

    }
}