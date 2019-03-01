package ma.mohamed.codingchallenge.data.api

import io.reactivex.Single
import ma.mohamed.codingchallenge.data.model.PagedResponseModel
import ma.mohamed.codingchallenge.data.model.RepoModel
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface GitHubService {

    @Headers("Accept: application/json")
    @GET("search/repositories?q=created:>{fromDate}")
    fun getRepos(
        @Path("fromDate") fromDate: String,
        @Query("page") page: Int,
        @Query("sort") sortBy: String = "stars",
        @Query("order") order: String = "desc"
    ): Single<PagedResponseModel<RepoModel>>
}