package ru.otus.daggerhomework

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.replace
import javax.inject.Inject

class MainActivity : FragmentActivity() {

    lateinit var activityComponent: MainActivityComponent

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        activityComponent = DaggerMainActivityComponent.factory().create(this)
    }

    override fun onResume() {
        super.onResume()
        supportFragmentManager.beginTransaction().replace(R.id.producer, ProducerFragment()).commit()
        supportFragmentManager.beginTransaction().replace(R.id.receiver, ReceiverFragment()).commit()
    }
}