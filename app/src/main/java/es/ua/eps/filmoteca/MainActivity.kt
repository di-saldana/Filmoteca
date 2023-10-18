package es.ua.eps.filmoteca

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var bindings: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        if (savedInstanceState != null) return

        if (findViewById<View?>(R.id.fragment_container) != null) {
            val listFragment = FilmListFragment()
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, listFragment).commit()
        }
    }
}