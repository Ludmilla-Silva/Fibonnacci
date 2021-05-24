package com.ludmilla.fibonnacci

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    //data class sequencias(val posicao: Int)
    var posicao: EditText? = null
    lateinit var calcularsequencia: Button
    lateinit var resultado: TextView
    //var dadossequencia = mutableListOf<sequencias>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        posicao = findViewById(R.id.edtPosicao)
        calcularsequencia = findViewById(R.id.btncalcular)
        resultado = findViewById(R.id.txtresultado)

        calcularsequencia.setOnClickListener {

            val sequenciainserida = posicao?.text.toString()
            val sequenciaemnumero = sequenciainserida.toIntOrNull()
            if (sequenciainserida.isNotEmpty()) {
                resultado.text = (sequenciaemnumero?.let { it1 -> montarsequencia().take(it1).toList().toString() })

            } else {

                posicao?.error = "Favor digitar a posição!"

            }
            posicao?.setText ("");
        }

    }


    fun montarsequencia(): Sequence<ULong> {
        return generateSequence(Pair(0, 1), { Pair(it.second, it.first + it.second) }).map { it.first.toULong() }

        }
        //exibirsequencia(sequenciaemnumero, a = 1, b = 0)
    }








