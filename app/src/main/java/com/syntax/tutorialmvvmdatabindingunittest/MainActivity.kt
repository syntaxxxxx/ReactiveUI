package com.syntax.tutorialmvvmdatabindingunittest

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import android.widget.AdapterView
import android.widget.ArrayAdapter
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.ViewModelProviders
import com.syntax.tutorialmvvmdatabindingunittest.model.AttributeValue
import com.syntax.tutorialmvvmdatabindingunittest.model.SetValueSpinner
import com.syntax.tutorialmvvmdatabindingunittest.model.SpinnerType
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    lateinit var viewModel: MainViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        viewModel = ViewModelProviders.of(this).get(MainViewModel::class.java)

        initUserInput()
        initSpinners()
        initSpinnerListeners()
        initLiveDataObservers()
    }

    private fun initLiveDataObservers() {
        viewModel.getAllValue().observe(this, Observer { value ->
            value?.let {
                tv_hasil.text = value.hasil.toString()
                edt_nama.setText(value.name)
            }
        })
    }

    private fun initUserInput() {
        edt_nama.addTextChangedListener(object : TextWatcher {
            override fun afterTextChanged(s: Editable?) {}
            override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {}
            override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
                viewModel.name = s.toString()
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
        value_b.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item, SetValueSpinner.VALUE_B
        )
        value_c.adapter = ArrayAdapter<AttributeValue>(
            this,
            android.R.layout.simple_spinner_dropdown_item, SetValueSpinner.VALUE_C
        )
    }
}
