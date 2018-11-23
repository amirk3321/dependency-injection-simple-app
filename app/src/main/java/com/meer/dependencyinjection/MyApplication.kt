package com.meer.dependencyinjection

import android.app.Application
import com.meer.dependencyinjection.data.model.db.DataBaseFakeImp
import com.meer.dependencyinjection.data.model.db.Database
import com.meer.dependencyinjection.data.model.db.QuoteDao
import com.meer.dependencyinjection.data.model.repository.QuoteRepository
import com.meer.dependencyinjection.data.model.repository.QuoteRepositoryImp
import com.meer.dependencyinjection.ui.quote.ViewModelQuotesFactory
import org.kodein.di.Kodein
import org.kodein.di.KodeinAware
import org.kodein.di.generic.bind
import org.kodein.di.generic.instance
import org.kodein.di.generic.provider
import org.kodein.di.generic.singleton

class MyApplication : Application(),KodeinAware {
    override val kodein = Kodein.lazy {
        bind<Database>() with singleton { DataBaseFakeImp() }
        bind<QuoteDao>() with singleton { instance<Database>().quoteDao }
        bind<QuoteRepository>() with singleton { QuoteRepositoryImp(instance()) }
        bind() from  provider { ViewModelQuotesFactory(instance()) }
    }
}