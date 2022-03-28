package pichardo.fernanda.popcornfactory

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_compra_exitosa.*

class CompraExitosa : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_compra_exitosa)
        text_cliente.text = intent.getStringExtra("cliente") ?: ""
        text_asiento.text = "Asiento reservado : " + (intent.getStringExtra("asiento")?:"")
        confirm.setOnClickListener {
            finish()
        }
    }
}