package monster.sasakisan.tohoku_tech_dojo_day3

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.LinearLayoutManager
import com.xwray.groupie.GroupAdapter
import com.xwray.groupie.GroupieViewHolder
import monster.sasakisan.tohoku_tech_dojo_day3.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private val binding by lazy {
        DataBindingUtil.setContentView<ActivityMainBinding>(this, R.layout.activity_main)
    }

    private val groupAdapter = GroupAdapter<GroupieViewHolder>()
    private val todoList = mutableListOf<String>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding.recyclerView.apply {
            adapter = groupAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        binding.button.setOnClickListener {
            val text = binding.editText.text.toString()
            Toast.makeText(this, text, Toast.LENGTH_SHORT).show()
            todoList.add(text)
            bindList()
        }
    }

    private fun bindList() {
        groupAdapter.clear()
        val todoItems = todoList.map {
            TodoItem(it)
        }
        groupAdapter.update(todoItems)
    }
}
