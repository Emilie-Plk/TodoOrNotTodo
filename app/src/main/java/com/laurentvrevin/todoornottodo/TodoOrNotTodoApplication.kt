package com.laurentvrevin.todoornottodo

import android.app.Application
import android.content.Context
import android.util.Log
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class TodoOrNotTodoApplication:Application(){
    override fun onCreate() {
        super.onCreate()

    //Le code ci-dessous me sert uniquement pour les tests de la bdd
    // Remplace "nom_de_ta_base_de_donnees" par le nom réel de ta base de données
    //deleteAndRecreateDatabase(this, "todo_database")
    }
    private fun deleteAndRecreateDatabase(context: Context, dbName: String) {
        val dbFile = context.getDatabasePath(dbName)
        if (dbFile.exists()) {
            // Supprime la base de données existante
            val deleted = context.deleteDatabase(dbName)
            if (deleted) {
                // Log de confirmation après suppression réussie
                Log.d("DatabaseReset", "La base de données $dbName a été supprimée avec succès.")
            } else {
                // Log en cas d'échec de la suppression
                Log.d("DatabaseReset", "Échec de la suppression de la base de données $dbName.")
            }
        } else {
            // Log si la base de données n'existe pas
            Log.d("DatabaseReset", "La base de données $dbName n'existe pas, aucune suppression nécessaire.")
        }
    }
}