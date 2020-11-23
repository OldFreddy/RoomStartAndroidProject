package com.oldfredddy.roomstartandroidproject

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.oldfredddy.roomstartandroidproject.App.Companion.database
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch
import kotlinx.coroutines.withContext
import kotlin.concurrent.thread

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dbDao = database?.employeeDao()
        var listEmployee: List<Employee>
        var oneEmployee: Employee? = null


        val employee: Employee = Employee(null, "sad;lkfgh;ldfh", 1000)

        GlobalScope.launch {

            dbDao?.insert(employee)
            listEmployee = dbDao?.getAll()!!
            oneEmployee = listEmployee[0]

            withContext(Dispatchers.Main) {
                tvSalary.text = oneEmployee?.salary.toString()
            }

        }

//
//        val thread = Thread {
//
//            val employee: Employee = Employee(1, "John Smith", 10000)
//            dbDao?.insert(employee)
//            listEmployee = dbDao?.getAll()!!
//            oneEmployee = listEmployee[0]
//
//            runOnUiThread {
//
//                tvSalary.text = oneEmployee?.salary.toString()
//            }
//        }
//
//        thread.start()


    }
}