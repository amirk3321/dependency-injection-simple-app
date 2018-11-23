package com.meer.dependencyinjection.data.model.db

class DataBaseFakeImp : Database {
    override val quoteDao: QuoteDao = QuoteDaoFakeImpl()
}