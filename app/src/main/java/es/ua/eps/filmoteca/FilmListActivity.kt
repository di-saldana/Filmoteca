package es.ua.eps.filmoteca

import MovieListAdapter
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca.databinding.ActivityFilmListBinding

class FilmListActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityFilmListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActivityFilmListBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(R.layout.activity_film_list)

            // Custom Adapter
            val lista = findViewById<ListView>(R.id.customListLayout)
            val movieAdapter = MovieListAdapter(this@FilmListActivity, FilmDataSource.films)
            lista.adapter = movieAdapter

            lista.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
                val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
                intent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, position)
                startActivity(intent)
            }
        }
    }
}
