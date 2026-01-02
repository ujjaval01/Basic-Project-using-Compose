package com.uv.practiceproject.apiCallingPager

import androidx.paging.Pager
import androidx.paging.PagingConfig
import com.uv.practiceproject.model.Product
import com.uv.practiceproject.paging.ProductPagingSource

class ProductPager {
    fun getProduct(): Pager<Int, Product>{
        return Pager(PagingConfig(pageSize = 10)){
            ProductPagingSource()
        }
    }
}