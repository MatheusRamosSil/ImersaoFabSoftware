package com.example.appimersao

import android.util.Log
import com.google.firebase.database.ktx.database
import com.google.firebase.ktx.Firebase

class NoteDatabase {

    private  var referenciaDoBancoDeDados = Firebase.database.reference


    fun criarNovaNota(note:Note){
        referenciaDoBancoDeDados.child("Notas").child(gerarIdAutomatico()).setValue(note)
            .addOnCompleteListener { data ->
                Log.i("Tudo ok save", "nota ${data.isSuccessful}")
            }
            .addOnFailureListener { exception ->
                Log.i("Error in sava","Erro ao salvar nota", exception)
            }
    }

    fun lerTodasAsNotas(){
        referenciaDoBancoDeDados.child("Notas").get()
            .addOnSuccessListener { data ->
                Log.i("Tudo ok save", "nota ${data.value}")
            }
            .addOnFailureListener { exception ->
                Log.i("Error ao ler","Erro ao ler todas as nota", exception)
            }

    }


    fun atualizarNota(idNote : String, noteMap : Map<String,String>){
        referenciaDoBancoDeDados.child("Notas").child(idNote).updateChildren(noteMap)
            .addOnCompleteListener {
                Log.i("Tudo ok update", "nota ${it.isSuccessful}")
            }
            .addOnFailureListener {
                Log.i("Error in update","Erro ao atualizar dados", it )
            }

    }


    fun excluirNota(idNota:String){
        referenciaDoBancoDeDados.child("Notas").child(idNota).removeValue()
            .addOnCompleteListener {
                if(it.isSuccessful){
                    Log.i("Nota deletada", "tudo certo ao excluir a nota ")
                }
            }
            .addOnFailureListener {
                Log.i("Error ao excluir", "algo errado em ", it)
            }
    }

    fun lerNota(idNota: String){
        referenciaDoBancoDeDados.child("Notas").child(idNota).get()
            .addOnSuccessListener {
                Log.i("Ler dado", " todas as nota ${it.value}")
            }
            .addOnFailureListener {
                Log.i("Error ao ler", "Erro ao ler todas as nota", it)
            }
    }



    private fun gerarIdAutomatico(): String {
        val idAutomatico = Firebase.database.getReference("Notas").push().key
        return idAutomatico.toString()
    }

}