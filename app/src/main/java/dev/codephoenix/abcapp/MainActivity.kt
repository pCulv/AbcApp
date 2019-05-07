package dev.codephoenix.abcapp


import androidx.fragment.app.Fragment
import dev.codephoenix.abcapp.ui.main.MainFragment

class MainActivity : SingleFragmentActivity() {
    override fun createFragment(): Fragment = MainFragment.newInstance()


}