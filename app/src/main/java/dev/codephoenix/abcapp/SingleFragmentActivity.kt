package dev.codephoenix.abcapp

import android.os.Bundle
import androidx.annotation.LayoutRes
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager
import kotlinx.android.synthetic.main.main_activity.*
import timber.log.Timber

abstract class SingleFragmentActivity : AppCompatActivity(), FragmentManager.OnBackStackChangedListener {

    protected abstract fun createFragment(): Fragment

    private val layoutResId: Int
        @LayoutRes
        get() = R.layout.main_activity

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(layoutResId)
        Timber.plant(Timber.DebugTree())
        supportFragmentManager.addOnBackStackChangedListener(this)

        //setting toolbar
        setSupportActionBar(toolbar)
        //home navigation

        val fragmentManager = supportFragmentManager
        var fragment = fragmentManager.findFragmentById(R.id.container)

        // ensures fragment already created will not be created
        if (fragment == null) {
            fragment = createFragment()
            // create and commit a fragment transaction
            fragmentManager.beginTransaction()
                .add(R.id.container, fragment)
                .commit()
        }
    }
    override fun onBackStackChanged() {
        shouldDisplayHomeUp()
    }

    fun shouldDisplayHomeUp(){
        val canGoBack: Boolean = supportFragmentManager.backStackEntryCount > 0
        supportActionBar?.setDisplayHomeAsUpEnabled(canGoBack)
    }

    override fun onSupportNavigateUp(): Boolean {
        supportFragmentManager.popBackStack()
        return true
    }
}
