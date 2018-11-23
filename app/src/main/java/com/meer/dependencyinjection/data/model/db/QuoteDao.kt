package com.meer.dependencyinjection.data.model.db

import androidx.lifecycle.LiveData
import com.meer.dependencyinjection.data.model.Quotes

interface QuoteDao {
    fun  addQuote(quote : Quotes)
    fun getQuote() : LiveData<List<Quotes>>
}