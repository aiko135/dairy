package ktepin.penzasoft.dairy.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import ktepin.penzasoft.dairy.model.Record
import ktepin.penzasoft.dairy.model.RecordEntity
import ktepin.penzasoft.dairy.model.RecordRepository
import org.koin.java.KoinJavaComponent

class HomeViewModel : ViewModel() {

    private val recordRepository: RecordRepository by KoinJavaComponent.inject(RecordRepository::class.java)

    private val _recordList = MutableLiveData<List<Record>>().apply {
        value = ArrayList()
    }
    val recordList: LiveData<List<Record>> = _recordList

    fun loadRecords(){
        viewModelScope.launch(Dispatchers.IO) {
            val recordsRaw = recordRepository.getAll()
            val recordsOutput : ArrayList<Record> = ArrayList()
            if(recordsRaw.isNotEmpty()){
                for(r in recordsRaw){
                    recordsOutput.add(RecordEntity.toRecord(r))
                }
            }
            _recordList.postValue(recordsOutput)
        }
    }
}