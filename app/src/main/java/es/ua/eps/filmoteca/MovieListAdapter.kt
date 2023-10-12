import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.ImageView
import android.widget.TextView
import es.ua.eps.filmoteca.Film
import es.ua.eps.filmoteca.R

class MovieListAdapter(context: Context, movies: List<Film>) : ArrayAdapter<Film>(context, R.layout.film_list_item, movies) {
    override fun getView(position: Int, convertView: View?, parent: ViewGroup): View {

        var view: View = convertView?: LayoutInflater.from(this.context)
            .inflate(R.layout.film_list_item, parent, false)

        val moviePosterImage = view.findViewById(R.id.moviePoster) as ImageView
        val movieTitleText = view.findViewById(R.id.movieTitle) as TextView
        val movieDirectorText = view.findViewById(R.id.movieDirector) as TextView

        getItem(position)?.let {
            moviePosterImage.setImageResource(it.imageResId)
            movieTitleText.text = it.title
            movieDirectorText.text = it.director
        }

        return view
    }
}
