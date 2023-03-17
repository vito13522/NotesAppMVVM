package ua.vitaliichykota.notesappmvvm.database

import androidx.lifecycle.LiveData
import ua.vitaliichykota.notesappmvvm.database.room.dao.NoteRoomDao
import ua.vitaliichykota.notesappmvvm.models.Note

class RoomRepository(private val noteRoomDao: NoteRoomDao) : DataBaseRepository {
    override val readAll: LiveData<List<Note>>
        get() = noteRoomDao.getAllNotes()

    override suspend fun create(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.addNote(note = note)
    }

    override suspend fun update(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.updateNote(note)
    }

    override suspend fun delete(note: Note, onSuccess: () -> Unit) {
        noteRoomDao.deleteNote(note)
    }
}