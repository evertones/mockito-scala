package org.evertones.utils

import org.springframework.data.domain.{Page, PageRequest, Pageable}

import scala.collection.JavaConverters._

object PageableCollection {

    /**
      * The default size for page.
      */
    val DefaultPageSize = 1000

    /**
      * Convenience method to create a new `PageableCollection` from a method that takes a
      * `Pageable` and returns a `Page` of type `T`.
      *
      * @param callback
      * a callback to use while traversing the `Page`s
      * @return an iterable `PageableCollection`
      */
    def apply[T](callback: Pageable => Page[T]): PageableCollection[T] = {
        new PageableCollection(callback, DefaultPageSize)
    }
}

class PageableCollection[T](callback: Pageable => Page[T], pageSize: Int) extends Iterable[T] {

    override def iterator: Iterator[T] = {
        new PageableIterator(callback, pageSize)
    }

    class PageableIterator(callback: Pageable => Page[T], pageSize: Int) extends Iterator[T] {

        /**
          * Cursor used to check if the end of the current `Page` has been completely
          * traversed.
          */
        var cursor: Int = _

        /**
          * The current `Page`.
          */
        var page: Page[T] = _

        /**
          * The content of the current `Page`.
          */
        var data: List[T] = _

        // load the first page
        loadData(0)

        /**
          * Loads the data for a `Page`.
          *
          * @param pageNumber
          * the page number to load data for
          */
        private def loadData(pageNumber: Int): Unit = {
            // reset the cursor
            cursor = 0
            page = callback(new PageRequest(pageNumber, pageSize))
            data = page.getContent.asScala.toList
        }

        /**
          * Checks if the `Page` has more data.
          *
          * @return a `boolean` indicating if there is more data to process
          */
        override def hasNext: Boolean = {
            // Check that current dataset hasn't been fully traversed
            if (data.nonEmpty && cursor < data.size) {
                true
            }
            // Otherwise check that the next page is not empty
            else {
                loadData(page.getNumber + 1)

                data.nonEmpty
            }
        }

        /**
          * Move the cursor to the next element in the `Page` data.
          *
          * @return The `Page` data element at the cursor.
          */
        override def next(): T = {
            val element = data(cursor)
            cursor = cursor + 1

            element
        }
    }

}
