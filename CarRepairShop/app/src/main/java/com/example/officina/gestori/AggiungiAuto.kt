package com.example.officina.gestori

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.officina.dao.AppDatabase
import com.example.officina.dao.AutoDao
import com.example.officina.entities.Auto

class AggiungiAuto : AppCompatActivity() {

    private lateinit var binding: ActivityAggiungiAutoBinding
    private lateinit var db: AppDatabase
    private lateinit var autoDao: AutoDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAggiungiAutoBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(applicationContext)
        autoDao = db.autoDao()

        binding.btnSalvaAuto.setOnClickListener {
            val numeroTelaio = binding.etNumeroTelaio.text.toString()
            val targa = binding.etTarga.text.toString()
            val marca = binding.etMarca.text.toString()
            val modello = binding.etModello.text.toString()

            if (targa.isNotEmpty() && marca.isNotEmpty() && modello.isNotEmpty()) {
                val auto = Auto(id = 0, numeroTelaio = numeroTelaio, targa = targa, marca = marca, modello = modello, clienteId = 0)
                autoDao.insertAllAuto(auto)

                Toast.makeText(
                    applicationContext,
                    "Auto aggiunta correttamente",
                    Toast.LENGTH_SHORT
                ).show()
                finish()
            } else {
                Toast.makeText(
                    applicationContext,
                    "Inserisci tutti i dati",
                    Toast.LENGTH_SHORT
                ).show()
            }
        }
    }
}