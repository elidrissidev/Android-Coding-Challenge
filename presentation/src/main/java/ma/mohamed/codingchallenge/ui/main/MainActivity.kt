package ma.mohamed.codingchallenge.ui.main

import android.os.Bundle
import dagger.android.support.DaggerAppCompatActivity
import ma.mohamed.codingchallenge.R

class MainActivity : DaggerAppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(findViewById(R.id.toolbar))
    }
}
