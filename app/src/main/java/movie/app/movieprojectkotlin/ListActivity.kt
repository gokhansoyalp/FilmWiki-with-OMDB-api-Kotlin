package movie.app.movieprojectkotlin

import android.content.Intent
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.DefaultItemAnimator
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.Response
import com.android.volley.toolbox.BasicNetwork
import com.android.volley.toolbox.DiskBasedCache
import com.android.volley.toolbox.HurlStack
import com.android.volley.toolbox.StringRequest
import org.json.JSONObject

class ListActivity : AppCompatActivity() {
    lateinit var movieList : ArrayList<Movie>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_list)
        val data = intent.getStringExtra("Data")
        sendUrl(data.toString())

    }
    fun sendUrl(data: String){
        val rvMovie = findViewById<RecyclerView>(R.id.rv_movie)
        val url = "http://www.omdbapi.com/?t="+ data +"&plot=short&apikey=c3781ac6"
        val cache = DiskBasedCache(cacheDir, 1024 * 1024)
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }
        val stringRequest = StringRequest(Request.Method.GET,url, Response.Listener<String>{ response ->
            val movie = JSONObject(response)

            val title : String = movie.getString("Title")
            val desc : String = movie.getString("Plot")
            val year : String = movie.getString("Year")
            val genre : String = movie.getString("Genre")
            val duration : String = movie.getString("Runtime")
            val director : String = movie.getString("Director")
            val actor : String = movie.getString("Actors")
            val lang : String = movie.getString("Language")
            val country : String = movie.getString("Country")
            val award : String = movie.getString("Awards")
            val poster : String = movie.getString("Poster")

            movieList = ArrayList<Movie>()
            movieList.add(Movie(title, desc, year, genre, duration, director, actor, lang, country, award, poster))
            var position = 0
            
            val movieAdapter = ListAdapter(movieList)
            val layoutManager = LinearLayoutManager(this)
            rvMovie.layoutManager= layoutManager
            rvMovie.itemAnimator = DefaultItemAnimator()
            rvMovie.addItemDecoration(DividerItemDecoration(this,LinearLayoutManager.VERTICAL))
            rvMovie.adapter = movieAdapter
            rvMovie.isClickable

        },
                Response.ErrorListener{error ->

                })
        requestQueue.add(stringRequest)
    }

    fun responseAct(view: View) {
        val data = intent.getStringExtra("Data")
        val url1 = "http://www.omdbapi.com/?t="+ data +"&plot=short&apikey=c3781ac6"
        val cache = DiskBasedCache(cacheDir, 1024 * 1024)
        val network = BasicNetwork(HurlStack())
        val requestQueue = RequestQueue(cache, network).apply {
            start()
        }
        val stringRequest = StringRequest(Request.Method.GET,url1, Response.Listener<String>{ response ->
            val movie = JSONObject(response)

            val title : String = movie.getString("Title")
            val desc : String = movie.getString("Plot")
            val year : String = movie.getString("Year")
            val genre : String = movie.getString("Genre")
            val duration : String = movie.getString("Runtime")
            val director : String = movie.getString("Director")
            val actor : String = movie.getString("Actors")
            val lang : String = movie.getString("Language")
            val country : String = movie.getString("Country")
            val award : String = movie.getString("Awards")
            val poster : String = movie.getString("Poster")

            val m1 = Movie(title, desc, year, genre, duration, director, actor, lang, country, award, poster)
            //m1.setAll(title, desc, year, genre, duration, director, actor, lang, country, award, poster)

                val intent = Intent(this, DetailActivity::class.java ).apply {
                    putExtra("Title",m1.title)
                    putExtra("Desc",m1.desc)
                    putExtra("Year",m1.year)
                    putExtra("Genre",m1.genre)
                    putExtra("Duration",m1.duration)
                    putExtra("Director",m1.director)
                    putExtra("Actor",m1.actor)
                    putExtra("Lang",m1.lang)
                    putExtra("Country",m1.country)
                    putExtra("Award",m1.award)
                    putExtra("Poster",m1.poster)
                }
                startActivity(intent)
        },
                Response.ErrorListener{error ->

                })
        requestQueue.add(stringRequest)
    }
}