package com.demo.margaritamvvmkoinflow_14_08_2024.view

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.demo.margaritamvvmkoinflow_14_08_2024.R
import com.demo.margaritamvvmkoinflow_14_08_2024.model.Drinks
import com.demo.margaritamvvmkoinflow_14_08_2024.utils.ApiState
import com.demo.margaritamvvmkoinflow_14_08_2024.viewmodel.MargaritaViewModel
import kotlinx.coroutines.launch
import org.koin.androidx.viewmodel.ext.android.viewModel

class MainActivity : AppCompatActivity() {

    private lateinit var margaritaAdapter: MargaritaAdapter
    private lateinit var recyclerView: RecyclerView
  //  private val margaritaViewModel:MargaritaViewModel by viewModel()
  private val margaritaViewModel = ViewModelProvider(this).get(MargaritaViewModel::class.java)

    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        recyclerView = findViewById(R.id.recycler_view)
        recyclerView.layoutManager = LinearLayoutManager(this)


        lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED){
                margaritaViewModel.margaritaFlow.collect{
                    when(it){
                        is ApiState.Success->{
                            margaritaAdapter = MargaritaAdapter(it.data.drinks)
                            recyclerView.adapter = margaritaAdapter
                        }
                        is ApiState.Failure->{
                            Log.d("Api Failure response",it.msg.toString())
                        }
                        is ApiState.Loading->{
                            Log.d("Api Loading response","")
                        }
                        is ApiState.Empty->{
                            Log.d("Api Empty response","")
                        }
                    }
                }
            }
        }
    }
}