package es.ua.eps.filmoteca

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import es.ua.eps.filmoteca.databinding.FragmentFilmDataBinding

class FilmDataFragment : Fragment() {
    private lateinit var bindings: FragmentFilmDataBinding
    companion object {
        const val EXTRA_FILM_TITLE = "EXTRA_FILM_TITLE"
    }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?): View? {
        bindings = FragmentFilmDataBinding.inflate(inflater, container, false)
        val view = bindings.root

        val extraIntent = requireActivity().intent
        val movieIndex = extraIntent.getIntExtra(EXTRA_FILM_TITLE, 0)
        val movie = FilmDataSource.films[movieIndex]

        if (movieIndex != -1) {
            bindings.details.text = movie.title
            bindings.director.text = movie.director
            bindings.year.text = movie.year.toString()
            bindings.poster.setImageResource(movie.imageResId)
        }
        return view
    }

    fun setDataItem(position: Int) {
        val movie = FilmDataSource.films[position]
        bindings.details.text = movie.title
        bindings.director.text = movie.director
        bindings.year.text = movie.year.toString()
        bindings.poster.setImageResource(movie.imageResId)
    }
}