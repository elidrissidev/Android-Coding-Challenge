package ma.mohamed.codingchallenge.ui.main

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import dagger.android.support.DaggerFragment
import ma.mohamed.codingchallenge.R
import ma.mohamed.codingchallenge.ui.main.adapter.RepoAdapter

class MainFragment : DaggerFragment() {

    private lateinit var recyclerView: RecyclerView
    private lateinit var repoAdapter: RepoAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        val view = inflater.inflate(R.layout.fragment_main, container, false)
        recyclerView = view.findViewById(R.id.recycler_view)
        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        repoAdapter = RepoAdapter({
            Toast.makeText(activity, it.name, Toast.LENGTH_LONG).show()
        }, {})
        recyclerView.apply {
            layoutManager = LinearLayoutManager(activity, RecyclerView.VERTICAL, false)
            adapter = adapter
        }
    }
}