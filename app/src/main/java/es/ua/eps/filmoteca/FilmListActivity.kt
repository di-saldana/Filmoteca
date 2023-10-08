package es.ua.eps.filmoteca

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import es.ua.eps.filmoteca.databinding.ActivityFilmListBinding

class FilmListActivity : AppCompatActivity() {

    private lateinit var bindings : ActivityFilmListBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_film_list)

        bindings = ActivityFilmListBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(root)

            p1.setOnClickListener {
                val miIntent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
                miIntent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, getString(R.string.p1extra))
                startActivity(miIntent)
            }

            p2.setOnClickListener {
                val miIntent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
                miIntent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, getString(R.string.p2extra))
                startActivity(miIntent)
            }

            about.setOnClickListener {
                val miIntent = Intent(this@FilmListActivity, AboutActivity::class.java)
                startActivity(miIntent)
            }

        }

    }
}