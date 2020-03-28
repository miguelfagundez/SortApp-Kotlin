package com.devproject.miguelfagundez.sortapp_kotlin.view

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import androidx.recyclerview.widget.LinearLayoutManager
import com.devproject.miguelfagundez.sortapp_kotlin.R
import com.devproject.miguelfagundez.sortapp_kotlin.adapters.SortAdapter
import com.devproject.miguelfagundez.sortapp_kotlin.viewmodel.SortViewModel
import kotlinx.android.synthetic.main.activity_main.*


/********************************************
 * MainActivity - Launcher activity
 * This is the first activity
 * @author: Miguel Fagundez
 * @date: March 27th, 2020
 * @version: 1.0
 * *******************************************/
class MainActivity : AppCompatActivity() {

    // ViewModel component - manage UI data
    lateinit var viewModel:SortViewModel

    // Adapter - RecyclerView
    // The recyclerView reference is used directly using synthetics
    lateinit var adapter : SortAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupViewModel()
        bindViews()
    }

    //*******************************
    // Creating ViewModel component
    //*******************************
    private fun setupViewModel() {
        viewModel = ViewModelProviders.of(this).get(SortViewModel::class.java)
        viewModel.listBlocks?.observe(this@MainActivity, Observer {
            adapter.dataHasChanged()
        })
    }

    // Connecting initial views
    private fun bindViews() {
        adapter = SortAdapter(viewModel.isAscending)
        adapter.createBlocks(viewModel.listBlocks?.value)
        adapter.dataHasChanged()

        sortListRecycleView.layoutManager = LinearLayoutManager(this)
        sortListRecycleView.adapter = adapter
    }


    //*************************************************
    // Menu inflater - Action Bar
    //*************************************************
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    //*************************************************
    // Actions when menu item is pressed
    //*************************************************
    override fun onOptionsItemSelected(item: MenuItem): Boolean {

        // Optimization change - Avoiding to create the same data many times
        viewModel.isChanged = false

        when(item.itemId){
            R.id.menu_order_asc, R.id.menu_order_asc_arrow -> {
                if (!viewModel.isAscending){
                    viewModel.isAscending = true
                    viewModel.isChanged = true
                }
            }
            R.id.menu_order_desc, R.id.menu_order_desc_arrow -> {
                if (viewModel.isAscending){
                    viewModel.isAscending = false
                    viewModel.isChanged = true
                }
            }
        }
        // Avoinding change adapter and recyclerview many times with
        // the same option value
        when (viewModel.isChanged){
            true -> {
                adapter = SortAdapter(viewModel.isAscending)
                adapter.createBlocks(viewModel.listBlocks?.value)
                adapter.dataHasChanged()

                sortListRecycleView.layoutManager = LinearLayoutManager(this)
                sortListRecycleView.adapter = adapter
                Toast.makeText(this, "Data changed successfully!", Toast.LENGTH_SHORT).show()
            }
            else -> {Toast.makeText(this, "Data is already sorted!", Toast.LENGTH_SHORT).show()}
        }

        return super.onOptionsItemSelected(item)
    }

}
