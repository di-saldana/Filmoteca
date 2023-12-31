package es.ua.eps.filmoteca

import FilmListAdapter
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ListView

class FilmListFragment : Fragment() {
    interface OnItemSelectedListener {
        fun onItemSelected(position: Int)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_film_list, container, false)

        val listView = view.findViewById<ListView>(R.id.customListLayout)
        val movieAdapter = FilmListAdapter(requireActivity(), FilmDataSource.films)
        listView.adapter = movieAdapter

        listView.setOnItemClickListener { parent: AdapterView<*>, view: View, position: Int, id: Long ->
            // TODO: Implementar luego
            if (activity is OnItemSelectedListener) {
                // Call the onItemSelected method of the hosting activity (MainActivity)
                (activity as OnItemSelectedListener).onItemSelected(position)
            }
        }

        return view
    }
}
