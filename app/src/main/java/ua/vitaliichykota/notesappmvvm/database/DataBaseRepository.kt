package ua.vitaliichykota.notesappmvvm.database

import androidx.lifecycle.LiveData
import ua.vitaliichykota.notesappmvvm.models.Note

interface DataBaseRepository {

    val readAll: LiveData<List<Note>>

    suspend fun create(note: Note, onSuccess: () -> Unit)

    suspend fun update(note: Note, onSuccess: () -> Unit)

    suspend fun delete(note : Note, onSuccess: () -> Unit)
}
