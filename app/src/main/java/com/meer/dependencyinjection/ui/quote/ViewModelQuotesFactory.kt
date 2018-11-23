package com.meer.dependencyinjection.ui.quote

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.meer.dependencyinjection.data.model.repository.QuoteRepository

class ViewModelQuotesFactory(private val quoteRepository: QuoteRepository)
    :ViewModelProvider.NewInstanceFactory(){
    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return ViewModelQuotes(quoteRepository) as T
    }
}