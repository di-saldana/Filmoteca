package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.filmoteca.databinding.ActivityFilmDataBinding

class FilmDataActivity : AppCompatActivity() {

    private lateinit var bindings : ActivityFilmDataBinding

    companion object {
        const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityFilmDataBinding.inflate(layoutInflater)
        with(bindings) {
            setContentView(root)

            val extraIntent = intent
            val movieIndex = extraIntent.getIntExtra(EXTRA_FILM_TITLE, 0)
            val movie = FilmDataSource.films[movieIndex]

            if (movieIndex != -1) {
                details.text = movie.title
                director.text = movie.director
                year.text = movie.year.toString()
                poster.setImageResource(movie.imageResId)
            }

            imdb.setOnClickListener {
                val imdbUrl = movie.imdbUrl

                if (!imdbUrl.isNullOrEmpty()) {
                    val viewIntent = Intent(Intent.ACTION_VIEW, Uri.parse(imdbUrl))
                    val chooser = Intent.createChooser(viewIntent, getString(R.string.chooser))
                    if (viewIntent.resolveActivity(packageManager) != null) {
                        startActivity(chooser)
                    }
                }
            }

            edit.setOnClickListener {
                val editIntent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
                editIntent.putExtra(EXTRA_FILM_TITLE, movieIndex)
                startActivity(editIntent)
            }

            main.setOnClickListener {
                val mainIntent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
                mainIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(mainIntent)
            }
        }
    }
}
