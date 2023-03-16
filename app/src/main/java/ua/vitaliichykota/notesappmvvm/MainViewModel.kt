package ua.vitaliichykota.notesappmvvm

import android.app.Application
import android.util.Log
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import kotlinx.coroutines.sync.Mutex
import ua.vitaliichykota.notesappmvvm.models.Note
import ua.vitaliichykota.notesappmvvm.utils.TYPE_FIREBASE
import ua.vitaliichykota.notesappmvvm.utils.TYPE_ROOM

class MainViewModel(application: Application) : AndroidViewModel(application) {
    val readTest: MutableLiveData<List<Note>> by lazy {
        MutableLiveData<List<Note>>()
    }

    val dbType: MutableLiveData<String> by lazy {
        MutableLiveData<String>(TYPE_ROOM  )
    }

    init {
        readTest.value =
            when(dbType.value){
                TYPE_ROOM -> {
                    listOf<Note>(
                        Note(title = "Note 1", subtitle = "1"),
                        Note(title = "Note 2", subtitle = "2"),
                        Note(title = "Note 3", subtitle = "3"),
                        Note(title = "Note 4", subtitle = "5")
                    )
                }
                TYPE_FIREBASE -> listOf()
                else -> listOf()
            }
    }

    fun initDataBase(type: String) {
        dbType.value = type
        Log.d("checkData", "MainViewModel initDataBase with type $type")
    }


}

class MainViewModelFactory(private val application: Application) : ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(MainViewModel::class.java)) {
            return MainViewModel(application = application) as T
        }
        throw IllegalArgumentException("Unknown ViewModelClass")
    }
}