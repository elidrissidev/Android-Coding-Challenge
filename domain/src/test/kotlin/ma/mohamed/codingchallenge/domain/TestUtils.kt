package ma.mohamed.codingchallenge.domain

import ma.mohamed.codingchallenge.domain.entity.PagedResponseEntity
import ma.mohamed.codingchallenge.domain.entity.RepoEntity
import ma.mohamed.codingchallenge.domain.entity.UserEntity
import kotlin.random.Random

object TestUtils {

    val REPOS_RESPONSE = PagedResponseEntity(
        (1..10).map {
            RepoEntity(
                it.toLong(),
                "repository $it",
                "description of repo $it",
                "url $it",
                UserEntity("user $it", "url", "avatar"),
                it * Random.nextInt(100)
            )
        }
    )
}