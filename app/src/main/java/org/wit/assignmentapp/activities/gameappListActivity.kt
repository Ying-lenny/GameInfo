package org.wit.assignmentapp.activities

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.*
import kotlinx.android.synthetic.main.activity_gameapp_list.*
import kotlinx.android.synthetic.main.card_gameapp.view.*
import org.wit.assignmentapp.R
import org.wit.assignmentapp.main.MainApp
import org.wit.assignmentapp.models.gameappModels
import org.jetbrains.anko.startActivityForResult

class gameappListActivity: AppCompatActivity() {

    lateinit var app : MainApp


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gameapp_list)
        app = application as MainApp


        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = GameappAdapter(app.gamesInfo)


        toolbarMain.title = title
        setSupportActionBar(toolbarMain)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }


    override fun onOptionsItemSelected(item: MenuItem?): Boolean {
        when (item?.itemId) {
            R.id.item_add -> startActivityForResult<MainActivity>(0)
        }
        return super.onOptionsItemSelected(item)
    }

}

class GameappAdapter constructor(private var gamesInfo: List<gameappModels>) : RecyclerView.Adapter<GameappAdapter.MainHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MainHolder {
        return MainHolder(LayoutInflater.from(parent?.context).inflate(R.layout.card_gameapp, parent, false))
    }

    override fun onBindViewHolder(holder: MainHolder, position: Int) {
        val gameapp = gamesInfo[holder.adapterPosition]
        holder.bind(gameapp)
    }


    override fun getItemCount(): Int = gamesInfo.size

    class MainHolder constructor(itemView: View) : RecyclerView.ViewHolder(itemView) {

        fun bind(gameapp: gameappModels) {
            itemView.gameappTitle.text = gameapp.title
            itemView.description.text = gameapp.description
//            itemView.gameappSystem.text = gameapp.system
        }
    }
}

