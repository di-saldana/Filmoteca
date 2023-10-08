package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
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
                // Toast.makeText(this@AboutActivity, R.string.toast, Toast.LENGTH_LONG).show()

                val viewIntent = Intent(Intent.ACTION_VIEW,
                    Uri.parse("https://www.linkedin.com/in/dianelys-saldana"))

                val chooser = Intent.createChooser(viewIntent, getString(R.string.chooser))

                if (viewIntent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
            }

            supportButton.setOnClickListener {
                // Toast.makeText(this@AboutActivity, R.string.toast, Toast.LENGTH_LONG).show()

                val viewIntent = Intent(Intent.ACTION_SENDTO,
                    Uri.parse("mailto:dsl42@alu.ua.es"))

                val chooser = Intent.createChooser(viewIntent, getString(R.string.chooser))

                if (viewIntent.resolveActivity(packageManager) != null) {
                    startActivity(chooser)
                }
            }

            backButton.setOnClickListener {
                // Toast.makeText(this@AboutActivity, R.string.toast, Toast.LENGTH_LONG).show()

                finish()
            }
        }
    }
}