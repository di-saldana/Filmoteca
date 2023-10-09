package es.ua.eps.filmoteca

import android.app.Activity
import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import es.ua.eps.filmoteca.databinding.ActivityFilmEditBinding

class FilmEditActivity : AppCompatActivity() {

    private lateinit var bindings : ActivityFilmEditBinding

    override fun onCreate(savedInstanceState: Bundle?) {

        bindings = ActivityFilmEditBinding.inflate(layoutInflater)

        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_film_edit)

        with(bindings) {
            setContentView(root)

            save.setOnClickListener {
                val dato = Uri.parse("https://www.linkedin.com/in/dianelys-saldana")
                val resultIntent = Intent(null, dato)
                setResult(Activity.RESULT_OK, resultIntent)
                finish()
            }

            cancel.setOnClickListener {
                // val resultIntent = Intent(this, FilmDataActivity::class.java)
                val resultIntent = Intent()
                setResult(Activity.RESULT_CANCELED, resultIntent)
                finish()
            }

            takePhotoButton.setOnClickListener{
                val resultIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
                startActivity(resultIntent)
            }

            selectImgButton.setOnClickListener {
                val resultIntent = Intent(MediaStore.ACTION_PICK_IMAGES)
                startActivity(resultIntent)
            }

        }
    }

}