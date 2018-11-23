package com.meer.dependencyinjection.data.model.db

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import com.meer.dependencyinjection.data.model.Quotes

class QuoteDaoFakeImpl : QuoteDao{


    private val mList= mutableListOf<Quotes>()
    private val mListLive = MutableLiveData<List<Quotes>>()

    init {
        mListLive.value=mList
    }
    override fun addQuote(quote: Quotes) {
        mList.add(quote)
        mListLive.value=mList
    }

    override fun getQuote() = mListLive as LiveData<List<Quotes>>


}