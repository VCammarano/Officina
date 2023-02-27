package com.android.academy.todolist

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.ListView
import android.widget.TextView
import android.widget.Toast

class ToDoAdapter(
    private val ctx: Context, // contesto di activity nel quale la classe lavora
    private val list: List<ToDo> // gli elementi da visualizzare
) : BaseAdapter() {

    // restituisce il totale degli elementi da visualizzare
    override fun getCount(): Int = list.size

    // restituisce l'elemento in posizione 'position'
    override fun getItem(position: Int): Any = list[position]

    // restituisce la "chiave" dell'elemento in posizione 'position'
    override fun getItemId(position: Int): Long = list[position].id

    // restituisce la vista pronta per visualizzare l'elemento in posizione 'position'
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        // recupero il dato da presentare
        // getItem restituisce Any quindi con 'as' lo converto in ToDo
        val todo: ToDo = getItem(position) as ToDo
        // compiti:
        // recupera il layout per l'elemento
        // lo deve renderizzare opportunamente
        // in pratica crea una View rappresentata dall'xml identificato dalla risorsa
        val view =
            if (todo.complete)
                LayoutInflater.from(ctx).inflate(R.layout.todo_layout, null)
            else
                LayoutInflater.from(ctx).inflate(R.layout.todo_layout_odds, null)
        // deve scrive in esso i valori da rappresentare
        // identifico il campo nel quale presentare il titolo del Todo
        view.findViewById<TextView>(R.id.subject).text = todo.subject
        view.findViewById<CheckBox>(R.id.completed).isChecked = todo.complete
        view.findViewById<TextView>(R.id.date).text =
            "${todo.date.toLocalDate()} alle ore ${todo.date.toLocalTime()}"
        view.setOnClickListener {
            Toast.makeText(ctx, "Hai cliccato su ${todo.subject}", Toast.LENGTH_LONG).show()
        }
        return view
    }

}

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // il servizio che fornisce l'accesso ai dati
        val service: ToDoService = SimpleToDoService()
        // il componente che gestisce la visualizzazione della lista
        val list = findViewById<ListView>(R.id.todo_list)
        // il componente che estrae uno ad uno i dati forniti dal servizio
        // e li scrive in una vista che sarà poi visualizzata dalla lista
//        val adapter = ArrayAdapter<ToDo>(
//            this, // contesto di attivazione (activity)
//            android.R.layout.simple_expandable_list_item_1, // layout di ogni dato visualizzato
//            service.getToDo() // la lista da visualizzare
//        )
        val adapter = ToDoAdapter(this, service.getToDo())
        // collegamento tra adapter (fornitore di dati) e lista (presentazione delle righe)
        list.adapter = adapter
    }
}