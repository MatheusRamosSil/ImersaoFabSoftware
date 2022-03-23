package com.example.appimersao

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val note = Note("1", "titulo", "descricao")

        val noteDatabase = NoteDatabase()

        val notaAtualizada = mapOf( "title" to "Novo titulo",
                                    "descricao" to "Nova descriçâo")

        //noteDatabase.criarNovaNota(note)

        //noteDatabase.atualizarNota("Passe o id da nota do firebase ",notaAtualizada)

        //noteDatabase.excluirNota("Passe o id da nota do firebase ")

        //noteDatabase.lerNota("Passe o id da nota do firebase ")

        noteDatabase.lerTodasAsNotas()


    }
}