package es.ua.eps.filmoteca

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class FilmListAdapterRV(private val films: List<Film>) :
    RecyclerView.Adapter<FilmListAdapterRV.ViewHolder?>() {

    // Listener Recycler View
    private var listener: (film: Film) -> Unit = {}

    fun setOnItemClickListener(listener: (film: Film) -> Unit) {
        this.listener = listener // Guardamos una referencia al listener
    }

    class ViewHolder(v: View) : RecyclerView.ViewHolder(v) {
        var title: TextView
        var director: TextView
        var filmPoster: ImageView

        init {
            title = v.findViewById(R.id.filmTitle)
            director = v.findViewById(R.id.filmDirector)
            filmPoster = v.findViewById(R.id.posterImg)
        }

        fun bind(l: Film) {
            title.text = l.title
            director.text = l.director
            filmPoster.setImageResource(l.imageResId)
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v: View = LayoutInflater.from(parent.getContext())
            .inflate(R.layout.film_list_item_rv, parent, false)
        val holder = ViewHolder(v)

        // Listener Recycler View
        v.setOnClickListener {
            val position: Int = holder.adapterPosition
            listener(films[position])
        }

        return holder
    }

    override fun getItemCount(): Int {
        return films.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(films[position])
    }

}