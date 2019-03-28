package dev.codephoenix.abcapp

import android.support.v4.app.Fragment
import dev.codephoenix.abcapp.ui.main.MainFragment

class MainActivity : SingleFragmentActivity() {

    override fun createFragment(): Fragment = MainFragment.newInstance()
}