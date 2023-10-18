package es.ua.eps.filmoteca

import FilmListAdapter
import android.content.Intent
import android.view.View
import android.widget.AdapterView
import android.widget.ListView
import android.os.Bundle
import android.view.ActionMode
import android.view.Menu
import android.view.MenuItem
import android.widget.AbsListView
import androidx.appcompat.app.AppCompatActivity
//import androidx.recyclerview.widget.RecyclerView
import es.ua.eps.filmoteca.databinding.ActivityFilmListBinding

class FilmListActivity : AppCompatActivity() {

    private lateinit var bindings: ActivityFilmListBinding
    private var movieAdapter: FilmListAdapter? = null

//    var recyclerView: RecyclerView? = null
//    var layoutManager: RecyclerView.LayoutManager? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        bindings = ActivityFilmListBinding.inflate(layoutInflater)

        with(bindings) {
            setContentView(R.layout.activity_film_list)

            val listView = findViewById<ListView>(R.id.customListLayout)
            listView.choiceMode = ListView.CHOICE_MODE_MULTIPLE_MODAL
            listView.setMultiChoiceModeListener(object : AbsListView.MultiChoiceModeListener {

                override fun onCreateActionMode(mode: ActionMode, menu: Menu): Boolean {
                    val inflater = mode.menuInflater
                    inflater.inflate(R.menu.menu_contextual, menu)
                    return true
                }

                override fun onPrepareActionMode(mode: ActionMode, menu: Menu): Boolean {
                    return false
                }

                override fun onActionItemClicked(mode: ActionMode, item: MenuItem): Boolean {
                    when (item.itemId) {
                        R.id.action_delete -> {
                            val selectedItems = listView.checkedItemPositions
                            val positions = ArrayList<Int>()

                            for (i in 0 until selectedItems.size()) {
                                val position = selectedItems.keyAt(i)
                                if (selectedItems.valueAt(i)) {
                                    positions.add(position)
                                }
                            }

                            accionConItemsSeleccionados(positions)
                            selectedItems.clear()
                            mode.finish()
                            return true
                        }
                        else -> return false
                    }
                }

                override fun onDestroyActionMode(mode: ActionMode) {
                    listView.setBackgroundResource(android.R.color.transparent)
                }

                override fun onItemCheckedStateChanged(mode: ActionMode, position: Int, id: Long, checked: Boolean) {
                    val view = listView.getChildAt(position)

                    if (checked) {
                        view?.setBackgroundResource(R.color.lightGray)
                    } else {
                        view?.setBackgroundResource(android.R.color.transparent)
                    }
                }
            })

            // Custom Adapter - ListView
            movieAdapter = FilmListAdapter(this@FilmListActivity, FilmDataSource.films)
            listView.adapter = movieAdapter

            listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
                val intent = Intent(this@FilmListActivity, FilmDataActivity::class.java)
                intent.putExtra(FilmDataActivity.EXTRA_FILM_TITLE, position)
                startActivity(intent)
            }

//            // Recycler View
//            recyclerView = findViewById(R.id.movieListRV)
//            layoutManager = LinearLayoutManager(this@FilmListActivity)
//            recyclerView?.setLayoutManager(layoutManager)
//
//            // Adapter Recycler View
//            val filmAdapter = FilmListAdapterRV(FilmDataSource.films)
//            recyclerView?.adapter = filmAdapter
//
//            filmAdapter.setOnItemClickListener { film ->
//                Toast.makeText(this@FilmListActivity,
//                    "Pulsado " + film.title, Toast.LENGTH_LONG).show()
//            }

        }
    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        menuInflater.inflate(R.menu.menu_film_list, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_add_film -> {
                val newMovie = Film()
                newMovie.title = getString(R.string.newFilm)
                newMovie.director = getString(R.string.newDir)
                newMovie.imageResId = R.drawable.poster

                FilmDataSource.films.add(newMovie)
                movieAdapter?.notifyDataSetChanged()

                return true
            }
            R.id.action_about -> {
                val intent = Intent(this@FilmListActivity, AboutActivity::class.java)
                startActivity(intent)
                return true
            }
            else -> return super.onOptionsItemSelected(item)
        }
    }

    private fun accionConItemsSeleccionados(selectedItems: ArrayList<Int>) {
        for (i in selectedItems.reversed()) {
            FilmDataSource.films.removeAt(i)
            movieAdapter?.notifyDataSetChanged()
        }
    }
}