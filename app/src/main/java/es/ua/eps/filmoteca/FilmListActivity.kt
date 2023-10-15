package es.ua.eps.filmoteca

import FilmListAdapter
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.filmoteca.databinding.ActivityFilmListBinding

class FilmListActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityFilmListBinding

    var recyclerView: RecyclerView? = null
    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActivityFilmListBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(R.layout.activity_film_list)

            // Custom Adapter - ListView
            val lista = findViewById<ListView>(R.id.customListLayout)
            val movieAdapter = FilmListAdapter(this@FilmListActivity, FilmDataSource.films)
            lista.adapter = movieAdapter

            lista.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
                val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
                intent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, position)
                startActivity(intent)
            }

//            // Recycler View
//            recyclerView = findViewById(R.id.movieListRV)
//            layoutManager = LinearLayoutManager(this@FilmListActivity)
//            recyclerView?.setLayoutManager(layoutManager)
//
//            // Adapter Recycler View
//            val filmAdapter = FilmListAdapterRV(FilmDataSource.films)
//            recyclerView?.adapter = filmAdapter
//
//            filmAdapter.setOnItemClickListener { film ->
//                Toast.makeText(this@FilmListActivity,
//                    "Pulsado " + film.title, Toast.LENGTH_LONG).show()
//            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_film_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_film -> {
                val intent = Intent(this@FilmListActivity, FilmEditActivity::class.java)
                startActivity(intent)
                return true
            }
            R.id.action_about -> {
                // Handle "About" menu item click
                val intent = Intent(this@FilmListActivity, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}
