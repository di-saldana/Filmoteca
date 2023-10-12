package es.ua.eps.filmoteca

import MovieListAdapter
import android.os.Bundle
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
        }
    }
}
