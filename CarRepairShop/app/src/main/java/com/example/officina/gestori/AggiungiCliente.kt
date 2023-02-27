package com.example.officina.gestori

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.example.officina.dao.AppDatabase
import com.example.officina.dao.ClienteDao
import com.example.officina.entities.Cliente

class AggiungiCliente : AppCompatActivity() {

    private lateinit var binding: ActivityAggiungiClienteBinding
    private lateinit var db: AppDatabase
    private lateinit var clienteDao: ClienteDao

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityAggiungiClienteBinding.inflate(layoutInflater)
        setContentView(binding.root)

        db = AppDatabase.getDatabase(applicationContext)
        clienteDao = db.clienteDao()

        binding.btnSalvaCliente.setOnClickListener {
            val nome = binding.etNome.text.toString()
            val cognome = binding.etCognome.text.toString()
            val telefono = binding.etTelefono.text.toString()

            if (nome.isNotEmpty() && cognome.isNotEmpty()) {
                val cliente = Cliente(id = 0, nome = nome, cognome = cognome, telefono = telefono)
                clienteDao.insertAllCliente(cliente)

                Toast.makeText(
                    applicationContext,
                    "Cliente aggiunto correttamente",
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