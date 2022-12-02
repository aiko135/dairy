package ktepin.penzasoft.dairy.vm

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class CreateRecordViewModel : ViewModel() {
    private val _text = MutableLiveData<String>().apply {
        value = "This is crate record Fragment"
    }
    val text: LiveData<String> = _text
}