package es.ua.eps.filmoteca

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.core.app.NavUtils
import es.ua.eps.filmoteca.databinding.ActivityAboutBinding

class AboutActivity : AppCompatActivity() {
    private lateinit var bindings : ActivityAboutBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        // setContentView(R.layout.activity_about)

        bindings = ActivityAboutBinding.inflate(layoutInflater)
        with(bindings) {
            setContentView(root)

            supportActionBar?.setDisplayHomeAsUpEnabled(true)

            actionBar?.setHomeButtonEnabled(true)
            actionBar?.setDisplayHomeAsUpEnabled(true)

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

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_film_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            android.R.id.home -> {
                NavUtils.navigateUpTo(
                    this,
                    Intent(this@AboutActivity, FilmListActivity::class.java)
                )
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

}