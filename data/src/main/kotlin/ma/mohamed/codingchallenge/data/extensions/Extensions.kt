package ma.mohamed.codingchallenge.data.extensions

import androidx.lifecycle.MutableLiveData

/**
 * Returns a [MutableLiveData] with a default value.
 */
fun <T> mutableLiveDataOf(default: T): MutableLiveData<T> = MutableLiveData<T>().apply { postValue(default) }