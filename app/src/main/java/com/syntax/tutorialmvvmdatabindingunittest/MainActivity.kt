package com.syntax.tutorialmvvmdatabindingunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProviders
import com.syntax.tutorialmvvmdatabindingunittest.model.AttributeValue
import com.syntax.tutorialmvvmdatabindingunittest.model.SetValueSpinner
import com.syntax.tutorialmvvmdatabindingunittest.model.SpinnerType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    // deklarasi your binding
    lateinit var binding: com.syntax.tutorialmvvmdatabindingunittest.databinding.ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        // inisialisasi layout your binding
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        // binding to view model
        // because we want ViewModel can communication with layout
        binding.viewmodel = viewModel

        initSpinners()
        initSpinnerListeners()
        initLiveDataObservers()
    }

    private fun initLiveDataObservers() {

        // update your data to UI
        viewModel.getAllValue().observe(this, Observer { value ->
            value?.let {
                tv_hasil.text = value.hasil.toString()
                edt_nama.setText(value.name)
            }
        })
        viewModel.getSaveLiveData().observe(this, Observer {

            // update your data to UI
            it?.let {
                if (it) {
                    Toast.makeText(this, "ada data", Toast.LENGTH_SHORT).show()
                } else{
                    Toast.makeText(this, "harus di isi semua", Toast.LENGTH_SHORT).show()
                }
            }
        })
    }

    private fun initSpinnerListeners() {
        value_a.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.isSpinnerSelected(SpinnerType.VALUE_A, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        value_b.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.isSpinnerSelected(SpinnerType.VALUE_B, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
        value_c.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(parent: AdapterView<*>?, view: View?, position: Int, id: Long) {
                viewModel.isSpinnerSelected(SpinnerType.VALUE_C, position)
            }

            override fun onNothingSelected(parent: AdapterView<*>?) {}
        }
    }

    private fun initSpinners() {
        value_a.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item, SetValueSpinner.VALUE_A
        )
        value_b.adapter = ArrayAdapter<AttributeValue       >(
            this,
            android.R.layout.simple_spinner_dropdown_item, SetValueSpinner.VALUE_B
        )
        value_c.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item, SetValueSpinner.VALUE_C
        )
    }
}
