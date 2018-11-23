package com.meer.dependencyinjection.ui.quote

import androidx.lifecycle.ViewModel
import com.meer.dependencyinjection.data.model.Quotes
import com.meer.dependencyinjection.data.model.repository.QuoteRepository

class ViewModelQuotes(private val repository: QuoteRepository) : ViewModel() {

    fun addQuotes(quotes: Quotes)=repository.addQuote(quotes)
    fun getQuotes() = repository.getQuote()
}