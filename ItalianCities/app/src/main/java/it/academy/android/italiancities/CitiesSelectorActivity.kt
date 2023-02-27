package it.academy.android.italiancities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.Menu
import android.view.MenuItem
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import it.academy.android.italiancities.adapters.ProvinceAdapter
import it.academy.android.italiancities.dao.MemoryCitiesDao
import it.academy.android.italiancities.dao.MemoryProvincesDao
import it.academy.android.italiancities.services.CitiesService
import it.academy.android.italiancities.services.CitiesServiceImpl

class CitiesSelectorActivity : AppCompatActivity() {

    companion object {
        const val TAG = "CitiesSelectorActivity"
    }

    private fun getService(): CitiesService =
        CitiesServiceImpl(MemoryProvincesDao(), MemoryCitiesDao())

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cities_selector)
    }

    override fun onResume() {
        super.onResume()

        // ottengo un riferimento al servizio
        getService()
            // mi prendo tutte le province
            .getProvinces().run {
                // creo l'adapter
                val ad = ProvinceAdapter(this) {
                    showCities(it.acronym)
                }
                // per la RecyclerView mi serve anche un layout manager, perché essa non lo prevede
                // di default
                val lm = LinearLayoutManager(applicationContext).apply {
                    orientation = RecyclerView.VERTICAL
                }
                findViewById<RecyclerView>(R.id.list_provinces).apply {
                    adapter = ad
                    layoutManager = lm
                }
            }
    }

    private fun showCities(acronym: String) {
        Log.d(TAG, "Hai cliccato su $acronym")
        // ottengo un riferimento al servizio
        // ottengo le città della provincia selezionata
        // prepato la recyclerview
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.main_menu, menu)
        Log.d(TAG, "Ho creato il menu")
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        Log.d(TAG, "Hai cliccato su ${item.title}")
        if (item.itemId == R.id.load_cities) {
            startActivity(Intent(this, ActivityCitiesLoader::class.java))
        }
        return super.onOptionsItemSelected(item)
    }
}