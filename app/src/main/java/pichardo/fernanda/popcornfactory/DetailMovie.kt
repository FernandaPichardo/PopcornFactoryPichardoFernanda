package pichardo.fernanda.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_seat_selection.*


class DetailMovie : AppCompatActivity() {
    var movies = ArrayList<Movie>()
    lateinit var titlemovie : String
    private lateinit var movie : Movie
    var ns = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val bundle = intent.extras
        var id = -1
        var title = ""

        if(bundle != null){

            ns = bundle.getInt("numberSeats")
            title = bundle.getString("title")!!
            titlemovie = bundle.getString("title") ?: ""

            iv_movie_image.setImageResource(bundle.getInt("header"))
            tv_name_movie.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("synopsis"))
            id = bundle.getInt("pos")
        }
        cargar_movies()

        if (ns == 0){
            buy_tickets.isEnabled = false
        }else{
            buy_tickets.setOnClickListener{
                val intent: Intent = Intent(this,SeatSelection::class.java)

                intent.putExtra("id", id)
                intent.putExtra("name", title)
                this.startActivity(intent)
            }
        }
    }
    fun cargar_movies() {
        val preferencias = this?.getSharedPreferences("preferencias", Context.MODE_PRIVATE)
        val gson : Gson = Gson()
        val json = preferencias?.getString("movies",null)
        val type = object : TypeToken<ArrayList<Movie?>?>() {}.type
        movies = gson.fromJson(json,type)

        movies.forEach { movie ->
            if(movie.title == this.titlemovie) {
                this.movie = movie
            }
        }

        seats_left.setText("${ns - movie.seats.size} seats available")

    }

    override fun onStart() {
        super.onStart()
        cargar_movies()
    }
}