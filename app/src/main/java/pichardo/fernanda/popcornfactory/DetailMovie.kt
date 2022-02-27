package pichardo.fernanda.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_detail_movie.*


class DetailMovie : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_detail_movie)

        val bundle = intent.extras

        if(bundle != null){
            iv_movie_image.setImageResource(bundle.getInt("header"))
            tv_name_movie.setText(bundle.getString("title"))
            tv_movie_desc.setText(bundle.getString("synopsis"))
        }
    }
}