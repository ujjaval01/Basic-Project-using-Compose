package com.uv.practiceproject.paging

import androidx.paging.PagingSource
import androidx.paging.PagingState
import com.uv.practiceproject.apiCallingPager.fetchAllProducts
import com.uv.practiceproject.model.Product
import java.lang.Exception

class ProductPagingSource: PagingSource<Int, Product>() {
    override fun getRefreshKey(state: PagingState<Int, Product>): Int? {
        return null
    }

    override suspend fun load(params: LoadParams<Int>): LoadResult<Int, Product> {
        return try {
            val currentPage = params.key?: 0
            val response = fetchAllProducts()
            LoadResult.Page(
                data = response,
                prevKey = if (currentPage == 0) null else currentPage - 1,
                nextKey = if (response.isEmpty()) null else currentPage + 1
            )
        }catch (e: Exception){
            LoadResult.Error(e)

        }
    }

}