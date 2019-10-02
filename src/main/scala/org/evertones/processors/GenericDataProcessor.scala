package org.evertones.processors

abstract class GenericDataProcessor[T, U] {

    def process(entity: T): U

    def process(iterable: Iterable[T]): List[U] = {
        iterable.map(element => process(element)).toList
    }
}
