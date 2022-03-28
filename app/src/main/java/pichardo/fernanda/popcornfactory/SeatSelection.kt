package pichardo.fernanda.popcornfactory

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.InputType
import android.widget.*
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import kotlinx.android.synthetic.main.activity_seat_selection.*

class SeatSelection : AppCompatActivity() {
    var movies = ArrayList<Movie>()
    private lateinit var movie : Movie
    lateinit var titlemovie : String

    var asientosNoDisponibles = ArrayList<Int>()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_seat_selection)
        val title: TextView = findViewById(R.id.titleSeats)
        var posMovie = -1

        var bundle = intent.extras
        if (bundle != null){
            titlemovie = bundle.getString("name") ?: ""
            title.setText(bundle.getString("name"))
            posMovie = bundle.getInt("id")
        }
        cargar_movies()

        val config: Button = findViewById(R.id.confirm)

        confirm.setOnClickListener(){
            //añadir Logica para reservar el lugar seleccionado por el usuario
            //hacer nueva actividad donde se vea el resumen de la compra, es decir que se agregue el nombre del cliente y se vea el asiento que seleccionó
            seleccionar_cliente(posMovie)


        }

        val row1: RadioGroup = findViewById(R.id.row1)
        val row2: RadioGroup = findViewById(R.id.row2)
        val row3: RadioGroup = findViewById(R.id.row3)
        val row4: RadioGroup = findViewById(R.id.row4)

        row1.setOnCheckedChangeListener { group, checkedId ->

                if (checkedId > -1){
                    if(this.asientosNoDisponibles.contains(checkedId)) {
                        Toast.makeText(this, "El asiento no esta disponible.", Toast.LENGTH_SHORT).show()
                    } else {
                        row2.clearCheck()
                        row3.clearCheck()
                        row4.clearCheck()

                        row1.check(checkedId)
                        val radioButton = findViewById<RadioButton>(checkedId)
                        posMovie = radioButton.text.toString().toInt()
                    }

                }


        }

        row2.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                if(this.asientosNoDisponibles.contains(checkedId)) {
                    Toast.makeText(this, "El asiento no esta disponible.", Toast.LENGTH_SHORT).show()
                } else {
                    row1.clearCheck()
                    row3.clearCheck()
                    row4.clearCheck()

                    row2.check(checkedId)
                    val radioButton = findViewById<RadioButton>(checkedId)
                    posMovie = radioButton.text.toString().toInt()
                }

            }
        }

        row3.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                if(this.asientosNoDisponibles.contains(checkedId)) {
                    Toast.makeText(this, "El asiento no esta disponible.", Toast.LENGTH_SHORT).show()
                } else {
                    row1.clearCheck()
                    row2.clearCheck()
                    row4.clearCheck()

                    row3.check(checkedId)
                    val radioButton = findViewById<RadioButton>(checkedId)
                    posMovie = radioButton.text.toString().toInt()
                }

            }
        }

        row4.setOnCheckedChangeListener { group, checkedId ->
            if (checkedId > -1){
                if(this.asientosNoDisponibles.contains(checkedId)) {
                    Toast.makeText(this, "El asiento no esta disponible.", Toast.LENGTH_SHORT).show()
                } else {

                    row1.clearCheck()
                    row2.clearCheck()
                    row3.clearCheck()

                    row4.check(checkedId)
                    val radioButton = findViewById<RadioButton>(checkedId)
                    posMovie = radioButton.text.toString().toInt()
                }
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

        movie.seats.forEach { cliente ->
            if(cliente.seat == 1) {
                asientosNoDisponibles.add(R.id.r1)
                r1.setBackgroundResource(R.drawable.radio_disabled)
            } else if(cliente.seat == 2) {
                asientosNoDisponibles.add(R.id.r2)
                r2.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 3) {
                asientosNoDisponibles.add(R.id.r3)
                r3.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 4) {
                asientosNoDisponibles.add(R.id.r4)
                r4.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 5) {
                asientosNoDisponibles.add(R.id.r5)
                r5.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 6) {
                asientosNoDisponibles.add(R.id.r6)
                r6.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 7) {
                asientosNoDisponibles.add(R.id.r7)
                r7.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat ==8) {
                asientosNoDisponibles.add(R.id.r8)
                r8.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 9) {
                asientosNoDisponibles.add(R.id.r9)
                r9.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 10) {
                asientosNoDisponibles.add(R.id.r10)
                r10.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 11) {
                asientosNoDisponibles.add(R.id.r11)
                r11.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 12) {
                asientosNoDisponibles.add(R.id.r12)
                r12.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 13) {
                asientosNoDisponibles.add(R.id.r13)
                r13.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 14) {
                asientosNoDisponibles.add(R.id.r14)
                r14.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 15) {
                asientosNoDisponibles.add(R.id.r15)
                r15.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 16) {
                asientosNoDisponibles.add(R.id.r16)
                r16.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 17) {
                asientosNoDisponibles.add(R.id.r17)
                r17.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 18) {
                asientosNoDisponibles.add(R.id.r18)
                r18.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 19) {
                asientosNoDisponibles.add(R.id.r19)
                r19.setBackgroundResource(R.drawable.radio_disabled)

            }else if(cliente.seat == 20) {
                asientosNoDisponibles.add(R.id.r20)
                r20.setBackgroundResource(R.drawable.radio_disabled)

            }
        }
    }


    fun seleccionar_cliente(pos: Int) {
        val alertDialog : AlertDialog.Builder = this?.let {

            val editext_nombre = EditText(this)
            editext_nombre.setHint("Ingrese su nombre")
            editext_nombre.inputType = InputType.TYPE_CLASS_TEXT


            val builder = AlertDialog.Builder(it)
            builder.apply {
                setPositiveButton("RESERVAR",
                    DialogInterface.OnClickListener{ dialog, id ->
                        if(editext_nombre.text.toString().isEmpty()) {
                            Toast.makeText(this@SeatSelection, "Ingrese un nombre valido", Toast.LENGTH_SHORT).show()
                        } else {
                            guardar_seleccion(editext_nombre.text.toString(),pos)
                        }
                    })
                setNegativeButton("CANCELAR",
                    DialogInterface.OnClickListener{ dialog, id ->
                        dialog.dismiss()
                    })

                builder?.setMessage("Reservar Entrada").setTitle("AVISO")
                builder.setView(editext_nombre)
                builder.create()
            }
        }
        alertDialog.show()
    }


    fun guardar_seleccion(nombreCliente : String, pos : Int) {
        movies.forEach { movie ->
            if(movie.title == titlemovie) {
                movie.seats.add(Client(nombreCliente,"",pos))
            }
        }
        val preferencias = this?.getSharedPreferences("preferencias",Context.MODE_PRIVATE)
        val editor = preferencias?.edit()
        val gson : Gson = Gson()
        val json = gson.toJson(movies)
        editor?.putString("movies",json)
        editor?.apply ()

        val intent = Intent(this,CompraExitosa::class.java)
        intent.putExtra("cliente",nombreCliente)
        intent.putExtra("asiento",pos.toString())
        startActivity(intent)
        finish()
    }
}