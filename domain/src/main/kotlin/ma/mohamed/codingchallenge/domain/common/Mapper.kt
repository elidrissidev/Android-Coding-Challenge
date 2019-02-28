package ma.mohamed.codingchallenge.domain.common

/**
 * Base type of a Mapper which is responsible for mapping models to entities and vice versa.
 */
interface Mapper<Entity, Model> {
    fun toEntity(model: Model): Entity
    fun toModel(entity: Entity): Model
}