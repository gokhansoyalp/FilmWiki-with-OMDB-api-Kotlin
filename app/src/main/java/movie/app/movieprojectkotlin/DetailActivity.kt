package movie.app.movieprojectkotlin

import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import com.squareup.picasso.Picasso

class DetailActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail)

        val tvTitle = findViewById<TextView>(R.id.tv_title)
        val tvDesc = findViewById<TextView>(R.id.tv_desc)
        val tvYear = findViewById<TextView>(R.id.tv_year)
        val tvGenre = findViewById<TextView>(R.id.tv_genre)
        val tvDuration = findViewById<TextView>(R.id.tv_duration)
        val tvDirector = findViewById<TextView>(R.id.tv_director)
        val tvActor = findViewById<TextView>(R.id.tv_actors)
        val tvLang = findViewById<TextView>(R.id.tv_language)
        val tvCountry = findViewById<TextView>(R.id.tv_country)
        val tvAward = findViewById<TextView>(R.id.tv_awards)
        val tvPoster = findViewById<ImageView>(R.id.iv_poster)


        tvTitle.text = intent.getStringExtra("Title")
        tvDesc.text = intent.getStringExtra("Desc")
        tvYear.text = intent.getStringExtra("Year")
        tvGenre.text = intent.getStringExtra("Genre")
        tvDuration.text = intent.getStringExtra("Duration")
        tvDirector.text = intent.getStringExtra("Director")
        tvActor.text = intent.getStringExtra("Actor")
        tvLang.text = intent.getStringExtra("Lang")
        tvCountry.text = intent.getStringExtra("Country")
        tvAward.text = intent.getStringExtra("Award")
        if (tvAward.text.equals("N/A")){
            tvAward.text = "There is no award !"
        }
        else{

        }

        val poster = intent.getStringExtra("Poster")

        if (poster.equals("N/A")){

        }
        else {
            Picasso.get().load(poster).into(tvPoster);
        }


    }
}