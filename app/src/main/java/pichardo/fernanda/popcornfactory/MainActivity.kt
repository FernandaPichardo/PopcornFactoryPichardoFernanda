package pichardo.fernanda.popcornfactory

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import kotlinx.android.synthetic.main.activity_detail_movie.*
import kotlinx.android.synthetic.main.activity_detail_movie.view.*
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.movie.view.*

class MainActivity : AppCompatActivity() {

    var adapter: MovieAdapter? = null
    var movies = ArrayList<Movie>()
    var adapter2: SerieAdapter? = null
    var series = ArrayList<Movie>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        loadMovies()

        adapter = MovieAdapter(this, movies)
        gridView.adapter = adapter

        adapter2 = SerieAdapter(this,series)
        gridView2.adapter = adapter2

    }

    fun loadMovies(){
        movies.add(Movie("Big Hero 6", R.drawable.bighero, R.drawable.headerbighero,"When a devastating event befalls the city of San Fransokyo and catapults Hiro into the midst of danger, he turns to Baymax and his close friends adrenaline junkie Go Go Tomago, neatnik Wasabi, chemistry whiz Honey Lemon and fanboy Fred. Determined to uncover the mystery, Hiro transforms his friends into a band of high-tech heroes called \"Big Hero 6.\""))
        movies.add(Movie("1917", R.drawable.uno, R.drawable.unoheader,"British trenches somewhere in France. World war has been going on for the third year, heroic illusions have dissipated; general mood - boredom and fatigue. Stuff the belly, sleep, return home to Christmas Eve. On another quiet day, when nothing happens, two young soldiers, Blake and Schofield, are summoned to the general, who instructs them to send an important message to Colonel MacKenzie in the Second Devonshire Battalion, whose telephone connection was cut off by the enemy." ))
        movies.add(Movie("Leap year", R.drawable.leapyear, R.drawable.leapyearheader, "A woman who has an elaborate scheme to propose to her boyfriend on Leap Day, an Irish tradition which occurs every time the date February 29 rolls around, faces a major setback when bad weather threatens to derail her planned trip to Dublin. With the help of an innkeeper, however, her cross-country odyssey just might result in her getting engaged."))
        movies.add(Movie("Men in Black", R.drawable.mib, R.drawable.mibheader, "Based off of the comic book. Unbeknownst to other people, there is a private agency code named MiB. This agency is some kind of extra terrestrial surveillance corporation. Then, one of the agency's finest men only going by the name \"K\" (Tommy Lee Jones) , is recruiting for a new addition to the agency. He has chosen James Edwards (Will Smith) of the N.Y.P.D. Then, one day, a flying saucer crashes into Earth. This was an alien a part of the \"Bug\" race. He takes the body of a farmer (Vincent D'Onofrio) and heads to New York. He is searching for a super energy source called \"The Galaxy\". Now, Agents J and K must stop the bug before it can escape with the galaxy."))
        movies.add(Movie("Toy Story", R.drawable.toystory, R.drawable.toystoryheader, "Toy Story is about the 'secret life of toys' when people are not around. When Buzz Lightyear, a space-ranger, takes Woody's place as Andy's favorite toy, Woody doesn't like the situation and gets into a fight with Buzz. Accidentaly Buzz falls out the window and Woody is accused by all the other toys of having killed him. He has to go out of the house to look for him so that they can both return to Andys room. But while on the outside they get into all kind of trouble while trying to get home."))
        movies.add(Movie("Inception", R.drawable.inception, R.drawable.inceptionheader, "Dom Cobb is a skilled thief, the absolute best in the dangerous art of extraction, stealing valuable secrets from deep within the subconscious during the dream state, when the mind is at its most vulnerable. Cobb's rare ability has made him a coveted player in this treacherous new world of corporate espionage, but it has also made him an international fugitive and cost him everything he has ever loved. Now Cobb is being offered a chance at redemption. One last job could give him his life back but only if he can accomplish the impossible, inception. Instead of the perfect heist, Cobb and his team of specialists have to pull off the reverse: their task is not to steal an idea, but to plant one. If they succeed, it could be the perfect crime. But no amount of careful planning or expertise can prepare the team for the dangerous enemy that seems to predict their every move. An enemy that only Cobb could have seen coming."))

        series.add(Movie("Dr. House", R.drawable.drhouse, R.drawable.househeader, "The series follows the life of anti-social, pain killer addict, witty and arrogant medical doctor Gregory House (Hugh Laurie) with only half a muscle in his right leg. He and his team of medical doctors try to cure complex and rare diseases from very ill ordinary people in the United States of America."))
        series.add(Movie("Smalville", R.drawable.smallville, R.drawable.smallvilleheader, "The numerous miraculous rescues by the local wonder boy Clark have aroused suspicions amongst colonials of Smallville. Interestingly, the boy has managed to downplay his acts of various heroic egresses in the past. They say he&#39;s either too fast or has a penchant for finding trouble. He was found by Martha and Jonathan Kent on the day of the Meteor Shower, and subsequently adopted. Clark&#39;s friend Lex Luthor, the only heir of Luthorcorp, has been secretly investigating grounds for Clark&#39;s outlandish valor. However, on the face of it, Clark just seems a normal boy who&#39;s slightly more secretive than usual."))
        series.add(Movie("Dr. Who", R.drawable.drwho, R.drawable.drwhoheader, "Traveling across time and space, the immortal time-lord known as &#39;The Doctor&#39; travels across the\n" + "universe with his many companions and his loyal shape-shifting space-ship: The TARDIS. The\n" + "Doctor faces many threats across many generations: from The Daleks, The Cybermen and his time-\n" + "lord adversary The Master to the sinister Davros, creator of The Daleks."))
        series.add(Movie("Bones", R.drawable.bones, R.drawable.bonesheader, "Dr. Temperance Brennan is a brilliant, but lonely, anthropologist whom is approached by an\n" + "ambitious FBI agent, named Seely Booth, to help the bureau solve a series of unsolved crimes by\n" + "identifying the long-dead bodies of missing persons by their bone structure. But both Agent Booth\n" + "\n" + "and Dr. Brennan and her team come up again a variety of interference from red tape, corruption,\n" + "and local noncooperation."))
        series.add(Movie("Suits", R.drawable.suits, R.drawable.suitsheader, "While running from a drug deal gone bad, brilliant young college dropout Mike Ross slips into a job\n" + "interview with one of New York City&#39;s best legal closers, Harvey Specter. Tired of cookie-cutter law-\n" + "school grads, Harvey takes a gamble by hiring Mike on the spot after recognizing his raw talent and\n" + "photographic memory. Mike and Harvey are a winning team. Although Mike is a genius, he still has\n" + "a lot to learn about law; and while Harvey might seem like an emotionless, cold-blooded shark,\n" + "Mike&#39;s sympathy and concern for their cases and clients will help remind Harvey why he went into\n" + "law in the first place. Mike&#39;s other allies in the office include the firm&#39;s best paralegal Rachel and\n" + "Harvey&#39;s no-nonsense assistant Donna. Proving to be an irrepressible duo and invaluable to the\n" + "practice, Mike and Harvey must keep their secret from everyone including managing partner\n" + "Jessica and Harvey&#39;s archnemesis Louis, who seems intent on making Mike&#39;s life as difficult as\n" + "possible."))
        series.add(Movie("Friends", R.drawable.friends, R.drawable.friendsheader, "Rachel Green, Ross Geller, Monica Geller, Joey Tribbiani, Chandler Bing and Phoebe Buffay are\n" + "six 20 something year-olds, living off of one another in the heart of New York City. Over the course\n" + "of ten years, this average group of buddies goes through massive mayhem, family trouble, past and\n" + "future romances, fights, laughs, tears and surprises as they learn what it really means to be a\n" + "friend."))
    }
}

class SerieAdapter: BaseAdapter{

    var series = ArrayList<Movie>()
    var context2: Context? = null

    constructor(context: Context,  series: ArrayList<Movie>){
        this.context2 = context
        this.series = series
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var serie = series[p0]
        var inflator2 = context2!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view2 = inflator2.inflate(R.layout.movie, null)
        view2.iv_movie.setImageResource(serie.image)
        view2.tv_name.setText(serie.title)


        view2.iv_movie.setOnClickListener(){
            var intent2 = Intent(context2, DetailMovie::class.java)
            intent2.putExtra("title",serie.title)
            intent2.putExtra("image",serie.image)
            intent2.putExtra("header",serie.header)
            intent2.putExtra("synopsis",serie.synopsis)
            context2!!.startActivity(intent2)
        }

        return view2
    }

    override fun getItem(p0: Int): Any {
        return series[p0]
    }

    override fun getCount(): Int {
        return series.size
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

}

class MovieAdapter: BaseAdapter{

    var movies = ArrayList<Movie>()
    var context: Context? = null

    constructor(context: Context, movies: ArrayList<Movie>){
        this.context = context
        this.movies = movies
    }

    override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
        var movie = movies[p0]
        var inflator = context!!.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view = inflator.inflate(R.layout.movie, null)
        view.iv_movie.setImageResource(movie.image)
        view.tv_name.setText(movie.title)

        view.iv_movie.setOnClickListener(){
            var intent = Intent(context, DetailMovie::class.java)
            intent.putExtra("title",movie.title)
            intent.putExtra("image",movie.image)
            intent.putExtra("header",movie.header)
            intent.putExtra("synopsis",movie.synopsis)
            context!!.startActivity(intent)
        }

        return view
    }

    override fun getItem(p0: Int): Any {
        return movies[p0]
    }

    override fun getCount(): Int {
        return movies.size
    }

    override fun getItemId(p0: Int): Long {
        return p0.toLong()
    }

}