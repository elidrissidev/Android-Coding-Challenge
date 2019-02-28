package ma.mohamed.codingchallenge.data.model

import com.google.gson.annotations.SerializedName

data class RepoModel(
    @SerializedName("id") val id: Long,
    @SerializedName("name") val name: String,
    @SerializedName("description") val description: String,
    @SerializedName("html_url") val url: String,
    @SerializedName("owner") val owner: UserModel,
    @SerializedName("stargazers_count") val starsCount: Int
)