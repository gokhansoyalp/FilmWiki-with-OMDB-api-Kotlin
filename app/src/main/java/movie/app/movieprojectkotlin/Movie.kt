package movie.app.movieprojectkotlin

class Movie {

    var title: String? = null
    var desc: String? = null
    var year: String? = null
    var genre: String? = null
    var duration: String? = null
    var director: String? = null
    var actor: String? = null
    var lang: String? = null
    var country: String? = null
    var award: String? = null
    var poster: String? = null

    constructor(title: String,desc: String,year: String,genre: String,duration: String,director: String,actor: String,lang: String,country: String,award: String,poster: String){
        this.title = title
        this.desc = desc
        this.year = year
        this.genre = genre
        this.duration = duration
        this.director = director
        this.actor = actor
        this.lang = lang
        this.country = country
        this.award = award
        this.poster = poster
    }
    fun setAll(title: String,desc: String,year: String,genre: String,duration: String,director: String,actor: String,lang: String,country: String,award: String,poster: String ){
        this.title = title
        this.desc = desc
        this.year = year
        this.genre = genre
        this.duration = duration
        this.director = director
        this.actor = actor
        this.lang = lang
        this.country = country
        this.award = award
        this.poster = poster

    }
}