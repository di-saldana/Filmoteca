package es.ua.eps.filmoteca

object FilmDataSource {
    val films: MutableList<Film> = mutableListOf<Film>()

    init {
        films.add(Film().apply {
            title = "Little Miss Sunshine"
            director = "Jonathan Dayton, Valerie Faris"
            imageResId = R.drawable.lms_poster
            comments = ""
            format = Film.FORMAT_DVD
            genre = Film.GENRE_COMEDY
            imdbUrl = "https://www.imdb.com/title/tt0449059/"
            year = 2006
        })

        films.add(Film().apply {
            title = "Booksmart"
            director = "Olivia Wilde"
            imageResId = R.drawable.booksmart_poster
            comments = ""
            format = Film.FORMAT_BLURAY
            genre = Film.GENRE_COMEDY
            imdbUrl = "https://www.imdb.com/title/tt1489887/"
            year = 2019
        })

        films.add(Film().apply {
            title = "Interstellar"
            director = "Christopher Nolan"
            imageResId = R.drawable.interstellar_poster
            comments = ""
            format = Film.FORMAT_DIGITAL
            genre = Film.GENRE_SCIFI
            imdbUrl = "https://www.imdb.com/title/tt0816692/"
            year = 2014
        })

        films.add(Film().apply {
            title = "Eternal Sunshine of the Spotless Mind"
            director = "Michel Gondry"
            imageResId = R.drawable.eternal_sunshine_poster
            comments = ""
            format = Film.FORMAT_DVD
            genre = Film.GENRE_DRAMA
            imdbUrl = "https://www.imdb.com/title/tt0338013/"
            year = 2004
        })

        films.add(Film().apply {
            title = "Aftersun"
            director = "Carla Simón"
            imageResId = R.drawable.aftersun_poster
            comments = ""
            format = Film.FORMAT_BLURAY
            genre = Film.GENRE_DRAMA
            imdbUrl = "https://www.imdb.com/title/tt1819579/"
            year = 2012
        })

        films.add(Film().apply {
            title = "Shrek"
            director = "Andrew Adamson, Vicky Jenson"
            imageResId = R.drawable.shrek_poster
            comments = ""
            format = Film.FORMAT_DVD
            genre = Film.GENRE_COMEDY
            imdbUrl = "https://www.imdb.com/title/tt0126029/"
            year = 2001
        })

        films.add(Film().apply {
            title = "Everything, everywhere all at once"
            director = "Daniel Kwan, Daniel Scheinert"
            imageResId = R.drawable.eeao_poster
            comments = ""
            format = Film.FORMAT_DIGITAL
            genre = Film.GENRE_SCIFI
            imdbUrl = "https://www.imdb.com/title/tt10366206/"
            year = 2022
        })

        films.add(Film().apply {
            title = "Little Women"
            director = "Greta Gerwig"
            imageResId = R.drawable.little_women_poster
            comments = ""
            format = Film.FORMAT_BLURAY
            genre = Film.GENRE_DRAMA
            imdbUrl = "https://www.imdb.com/title/tt3281548/"
            year = 2019
        })

        films.add(Film().apply {
            title = "Frances Ha"
            director = "Noah Baumbach"
            imageResId = R.drawable.frances_ha_poster
            comments = ""
            format = Film.FORMAT_DIGITAL
            genre = Film.GENRE_COMEDY
            imdbUrl = "https://www.imdb.com/title/tt2347569/"
            year = 2012
        })

        films.add(Film().apply {
            title = "Monster's Inc"
            director = "Pete Docter, David Silverman, Lee Unkrich"
            imageResId = R.drawable.monsters_inc_poster
            comments = ""
            format = Film.FORMAT_BLURAY
            genre = Film.GENRE_COMEDY
            imdbUrl = "https://www.imdb.com/title/tt0198781/"
            year = 2001
        })
    }
}
