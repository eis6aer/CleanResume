package com.developer76.cleanresume

import android.os.Bundle
import com.google.android.material.bottomnavigation.BottomNavigationView
import androidx.appcompat.app.AppCompatActivity
import com.developer76.cleanresume.home.ContactFragment
import com.developer76.cleanresume.home.ProjectsFragment
import com.developer76.cleanresume.home.ResumeFragment
import com.developer76.cleanresume.mvp.main.MainContract
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : AppCompatActivity() {

    @Inject
    lateinit var presenter: MainContract.Presenter

    private val onNavigationItemSelectedListener = BottomNavigationView.OnNavigationItemSelectedListener { item ->
        when (item.itemId) {
            R.id.navigation_home -> {
                presenter.navigateToPage(ResumeFragment.RESUME_PAGE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_dashboard -> {
                presenter.navigateToPage(ProjectsFragment.PROJECTS_PAGE)
                return@OnNavigationItemSelectedListener true
            }
            R.id.navigation_notifications -> {
                presenter.navigateToPage(ContactFragment.CONTACT_PAGE)
                return@OnNavigationItemSelectedListener true
            }
        }
        false
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val navView: BottomNavigationView = findViewById(R.id.nav_view)
        navView.setOnNavigationItemSelectedListener(onNavigationItemSelectedListener)
        presenter.init()
    }

    override fun onResume() {
        super.onResume()
    }
}
