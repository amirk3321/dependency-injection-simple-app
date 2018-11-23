package com.meer.dependencyinjection.ui.quote

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.meer.dependencyinjection.R
import com.meer.dependencyinjection.data.model.Quotes
import kotlinx.android.synthetic.main.activity_quote.*
import org.kodein.di.KodeinAware
import org.kodein.di.android.closestKodein
import org.kodein.di.generic.instance
import java.lang.StringBuilder

class QuoteActivity : AppCompatActivity(),KodeinAware{
    override val kodein by closestKodein()

    private val viewModelQuotesFactory : ViewModelQuotesFactory by instance()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_quote)
        onInitilizeUI()
    }

    private fun onInitilizeUI() {
        val viewmodel=ViewModelProviders.of(this,viewModelQuotesFactory)
            .get(ViewModelQuotes::class.java)
        viewmodel.getQuotes()
            .observe(this, Observer { it ->
                val bulider=StringBuilder()
                it.forEach {
                    bulider.append("$it\n\n")
                }
                quote_tv.text=bulider.toString()
            })
        addQuotebtn.setOnClickListener {
            val quotes =
                Quotes(auther.text.toString(), quote_auther.text.toString())
            viewmodel.addQuotes(quotes)

            auther.setText("")
            quote_auther.setText("")
        }


    }
}
//Class Structure
/*
#Data package
    db - child pkg of Data
        Qoutedao - interface
        QuoteDaoFakeImp - class
        Database - Interface
        dbFakeImp - Class
    model - child pkg of Data
        quote - data class
    repository - child pkg of Data
        QuoteRepository - interface
        QuoteRepositoryImp - class
            primary constructor (quoteDao interface reference)
  #ui package
    quote - child pkg of ui
        QuoteViewmodel - class
        QuoteViewModelFactory - class
        QuoteActivity - class UI
  #root level package
    quoteapplication -class extends application() , kodeinaware
*/
//Loose Coupling
/*
Loose coupling is achieved by means of a design that promotes single-responsibility and separation of concerns.

A loosely-coupled class can be consumed and tested independently of other (concrete) classes.

Interfaces are a powerful tool to use for decoupling. Classes can communicate through interfaces rather than other concrete classes, and any class can be on the other end of that communication simply by implementing the interface.
*/
//Tight Coupling
/*

down vote
accepted
Tight coupling is when a group of classes are highly dependent on one another.

This scenario arises when a class assumes too many responsibilities, or when one concern is spread over many classes rather than having its own class.
*/