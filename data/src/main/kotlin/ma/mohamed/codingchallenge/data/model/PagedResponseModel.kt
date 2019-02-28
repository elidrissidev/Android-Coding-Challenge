package ma.mohamed.codingchallenge.data.model

import com.google.gson.annotations.SerializedName

data class PagedResponseModel<T>(@SerializedName("items") val items: List<T>)