package movie.app.movieprojectkotlin

import android.annotation.SuppressLint
import android.app.Activity
import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.View.inflate
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ListAdapter(private val movieList: ArrayList<Movie>) : RecyclerView.Adapter<ListAdapter.MovieViewHolder>(){
    inner class MovieViewHolder(movieItemView : View) : RecyclerView.ViewHolder(movieItemView){
        var tvTitle = movieItemView.findViewById<TextView>(R.id.tvMovieName)
        var tvDesc = movieItemView.findViewById<TextView>(R.id.tvMovieDesc)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MovieViewHolder {
        val movieItemInflater = LayoutInflater.from(parent.context)
        val movieItemView = movieItemInflater.inflate(R.layout.list_item,parent,false)
        return MovieViewHolder(movieItemView)
    }


    override fun getItemCount() = movieList.size


    override fun onBindViewHolder(holder: MovieViewHolder, position: Int) {
        val movieToDisplay = movieList.get(position)
        holder.tvTitle.text = movieToDisplay.title
        holder.tvDesc.text = movieToDisplay.desc
    }
}


//val myListAdapter = MyListAdapter(this,empArrayId,empArrayName,empArrayRole,empArrayTask,empArrayDeadline,empArraySpend)
//        listView.adapter = myListAdapter