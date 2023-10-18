package es.ua.eps.filmoteca

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import es.ua.eps.filmoteca.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity(), FilmListFragment.OnItemSelectedListener {
    private lateinit var bindings: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        bindings = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindings.root)

        if (savedInstanceState != null) return

        if (findViewById<View?>(R.id.fragment_container) != null) {
            val listFragment = FilmListFragment()
            listFragment.arguments = intent.extras
            supportFragmentManager.beginTransaction()
                .add(R.id.fragment_container, listFragment).commit()
        }
    }

    override fun onItemSelected(position: Int) {
        var dataFragment = supportFragmentManager
            .findFragmentById(R.id.filmDataContainer) as FilmDataFragment?

        if (dataFragment != null) {
            dataFragment.setDataItem(position)
        } else {
            dataFragment = FilmDataFragment()
            val args = Bundle()
            args.putInt(FilmDataFragment.EXTRA_FILM_TITLE, position)
            dataFragment.arguments = args

            val t = supportFragmentManager.beginTransaction()
            t.replace(R.id.fragment_container, dataFragment)
            t.addToBackStack(null)
            t.commit()
        }
    }

}