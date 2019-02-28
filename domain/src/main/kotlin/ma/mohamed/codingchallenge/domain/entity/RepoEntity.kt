package ma.mohamed.codingchallenge.domain.entity

data class RepoEntity(
    val name: String,
    val description: String,
    val url: String,
    val owner: UserEntity,
    val starsCount: Int
)