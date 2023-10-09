package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.result.ActivityResult
import androidx.activity.result.contract.ActivityResultContracts
import es.ua.eps.filmoteca.databinding.ActivityFilmDataBinding

class FilmDataActivity : AppCompatActivity() {

    private lateinit var bindings : ActivityFilmDataBinding
    private val CODIGO_ACTIVIDAD_A = 1

    companion object {
        const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"
    }

    private val startForResult =
        registerForActivityResult(
            ActivityResultContracts.StartActivityForResult()) { result: ActivityResult ->
            onActivityResult(CODIGO_ACTIVIDAD_A, result.resultCode, result.data)
        }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_film_data)

        bindings = ActivityFilmDataBinding.inflate(layoutInflater)
//        bindings.result.visibility = View.GONE

        with(bindings) {
            setContentView(root)

            val extraIntent = intent
            val title = extraIntent.getStringExtra(EXTRA_FILM_TITLE)
            details.text = title

            imdb.setOnClickListener {
                val viewIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.imdb.com/title/tt0449059/"))

                val chooser = Intent.createChooser(viewIntent, "@string/chooser")

                if (viewIntent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
            }

            edit.setOnClickListener {
                val miIntent = Intent(this@FilmDataActivity, FilmEditActivity::class.java)
//                startActivity(miIntent)

                if(Build.VERSION.SDK_INT >= 30) {
                    startForResult.launch(miIntent)
                }
                else {
                    @Suppress("DEPRECATION")
                    startActivityForResult(miIntent, CODIGO_ACTIVIDAD_A)
                }
            }

            main.setOnClickListener {
                val miIntent = Intent(this@FilmDataActivity, FilmListActivity::class.java)
                miIntent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(miIntent)
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        @Suppress("DEPRECATION")
        super.onActivityResult(requestCode, resultCode, data)

//        if (requestCode == CODIGO_ACTIVIDAD_A) {
//            if (resultCode == Activity.RESULT_OK) {
//                // Update the text view if the user pressed "Save"
//                bindings.result.text = getString(R.string.edited)
//                bindings.result.visibility = View.VISIBLE
//            }
//            else if (resultCode == Activity.RESULT_CANCELED) {
//                // Update the text view if the user pressed "Cancel"
//                bindings.result.text = getString(R.string.canceled)
//                bindings.result.visibility = View.VISIBLE
//            }
//        }
    }
}