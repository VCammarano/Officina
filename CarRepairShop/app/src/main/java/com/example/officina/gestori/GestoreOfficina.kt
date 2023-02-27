package com.example.officina.gestori

import com.example.officina.dao.AppDatabase
import com.example.officina.entities.Auto
import com.example.officina.entities.Cliente
import com.example.officina.entities.Intervento

class GestoreOfficina(private val db: AppDatabase) {

    // Metodi di gestione clienti

    fun aggiungiCliente(nome: String, cognome: String, telefono: String) {
        val nuovoCliente = Cliente(0, nome, cognome, telefono)
        return db.clienteDao().insertAllCliente(nuovoCliente)
    }

    fun getElencoClienti(): List<String> {
        return db.clienteDao().getAllClienti().map { "${it.nome} ${it.cognome}" }
    }

    fun getClienteById(id: Int): Cliente? {
        return db.clienteDao().getClienteById(id)
    }

    fun modificaCliente(cliente: Cliente) {
        db.clienteDao().updateCliente(cliente)
    }

    fun eliminaCliente(cliente: Cliente) {
        db.clienteDao().deleteCliente(cliente)
    }

    // Metodi di gestione auto

    fun aggiungiAuto(id: Int, numeroTelaio: String, marca: String, modello: String, targa: String, clienteId: Int) {
        val nuovoAuto = Auto(0, numeroTelaio, marca, modello, targa, 0)
        return db.autoDao().insertAllAuto(nuovoAuto)
    }

    fun getElencoAuto(idCliente: Int): List<String> {
        return db.autoDao().getAutoByCliente(idCliente).map { "${it.marca} ${it.modello} (${it.targa})" }
    }

    fun getAutoById(id: Int): Auto? {
        return db.autoDao().getAutoById(id)
    }

    fun modificaAuto(auto: Auto) {
        db.autoDao().updateAuto(auto)
    }

    fun eliminaAuto(auto: Auto) {
        db.autoDao().deleteAuto(auto)
    }

    // Metodi di gestione interventi

    fun aggiungiIntervento(id: Int, descrizione: String, durata: Int, dataArrivo: Long, dataConsegna: Long, idAuto: Int) {
        val auto = db.autoDao().getAutoById(idAuto)
        if (auto != null) {
            val nuovoIntervento = Intervento(0, descrizione, durata, dataArrivo, dataConsegna, 0)
            return db.interventoDao().insertAllInterventi(nuovoIntervento)
        }
        throw IllegalArgumentException("Auto non trovata con id $idAuto")
    }

    fun getInterventiByAuto(idAuto: Int): List<Intervento> {
        return db.interventoDao().getInterventiByAuto(idAuto)
    }

    fun getInterventoById(id: Int): Intervento? {
        return db.interventoDao().getIntervento(id)
    }

    fun modificaIntervento(intervento: Intervento) {
        db.interventoDao().updateIntervento(intervento)
    }

    fun eliminaIntervento(intervento: Intervento) {
        db.interventoDao().deleteIntervento(intervento)
    }
}