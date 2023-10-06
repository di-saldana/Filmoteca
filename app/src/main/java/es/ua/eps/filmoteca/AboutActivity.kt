package es.ua.eps.filmoteca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import es.ua.eps.filmoteca.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var bindings : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_about)

        bindings = ActivityAboutBinding.inflate(layoutInflater)
        with(bindings) {
            setContentView(root)

            webButton.setOnClickListener {
                Toast.makeText(this@AboutActivity, R.string.toast, Toast.LENGTH_LONG).show()
            }

            supportButton.setOnClickListener {
                Toast.makeText(this@AboutActivity, R.string.toast, Toast.LENGTH_LONG).show()
            }

            backButton.setOnClickListener {
                Toast.makeText(this@AboutActivity, R.string.toast, Toast.LENGTH_LONG).show()
            }
        }
    }
}