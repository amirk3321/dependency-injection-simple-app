package com.meer.dependencyinjection.data.model.repository

import androidx.lifecycle.LiveData
import com.meer.dependencyinjection.data.model.Quotes

interface QuoteRepository {
    fun getQuote() : LiveData<List<Quotes>>
    fun addQuote(quotes: Quotes)
}