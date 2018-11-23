package com.meer.dependencyinjection.data.model.repository

import com.meer.dependencyinjection.data.model.Quotes
import com.meer.dependencyinjection.data.model.db.QuoteDao

class QuoteRepositoryImp(private  val quoteDao: QuoteDao) : QuoteRepository {
    override fun getQuote() = quoteDao.getQuote()

    override fun addQuote(quotes: Quotes) {
        quoteDao.addQuote(quotes)
    }
}