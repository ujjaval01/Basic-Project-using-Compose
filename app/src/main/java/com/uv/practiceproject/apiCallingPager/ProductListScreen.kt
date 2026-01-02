package com.uv.practiceproject.apiCallingPager

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Card
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import androidx.paging.compose.collectAsLazyPagingItems
import coil.compose.AsyncImage
import com.uv.practiceproject.model.Product

import androidx.paging.LoadState
import androidx.compose.foundation.layout.Box
import androidx.compose.material3.CardDefaults
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.style.TextOverflow
import com.uv.practiceproject.R


@Composable
fun ProductSkeletonItem() {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Column(modifier = Modifier.padding(16.dp)) {

            // Image skeleton
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp)
                    .background(color = colorResource(R.color.lightGray))
            )

            Spacer(modifier = Modifier.height(8.dp))

            // Title skeleton
            Box(
                modifier = Modifier
                    .fillMaxWidth(0.6f)
                    .height(20.dp)
                    .background(color = colorResource(R.color.lightGray))
            )

            Spacer(modifier = Modifier.height(6.dp))

            // Description skeleton
            Box(
                modifier = Modifier
                    .fillMaxWidth()
                    .height(16.dp)
                    .background(color = colorResource(R.color.lightGray))
            )

            Spacer(modifier = Modifier.height(6.dp))

            Box(
                modifier = Modifier
                    .fillMaxWidth(0.4f)
                    .height(16.dp)
                    .background(color = colorResource(R.color.lightGray))
            )
        }
    }
}

@Composable
fun ProductListScreen(
    modifier: Modifier = Modifier,
    viewModel: ProductViewModel
) {
    val productItem = viewModel.productFlow.collectAsLazyPagingItems()

    when {
        // 🔄 First page loading → Skeleton
        productItem.loadState.refresh is LoadState.Loading -> {
            ProductSkeletonList()
        }

        // ❌ Error state
        productItem.loadState.refresh is LoadState.Error -> {
            Text(
                text = "Something went wrong",
                modifier = Modifier.padding(16.dp),
                color = MaterialTheme.colorScheme.error
            )
        }

        // ✅ Data loaded
        else -> {
            LazyColumn(modifier = modifier.padding(8.dp)) {
                items(productItem.itemCount) { index ->
                    productItem[index]?.let {
                        ProductItem(product = it)
                    }
                }

                // 🔽 Bottom pagination skeleton (optional)
                if (productItem.loadState.append is LoadState.Loading) {
                    item {
                        repeat(2) {
                            ProductSkeletonItem()
                        }
                    }
                }
            }
        }
    }
}


@Composable
fun ProductSkeletonList() {
    LazyColumn(
        modifier = Modifier.padding(8.dp)
    ) {
        items(6) {
            ProductSkeletonItem()
        }
    }
}



@Composable
fun ProductItem(product: Product) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 8.dp)
    ) {
        // Product item content
        Column (modifier = Modifier.padding(16.dp)){
            AsyncImage(
                model = product.thumbnail,
                contentDescription = null,
                modifier = Modifier
                    .fillMaxWidth()
                    .height(120.dp),
                contentScale = ContentScale.Crop
            )
            Spacer(modifier = Modifier.height(8.dp))

            Text(text = product.title, style = MaterialTheme.typography.titleMedium)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = product.description,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 3,
                overflow = TextOverflow.Ellipsis)
            Spacer(modifier = Modifier.height(4.dp))
            Text(text = "Price: $${product.price}",
                style = MaterialTheme.typography.bodyMedium)
        }
    }
}