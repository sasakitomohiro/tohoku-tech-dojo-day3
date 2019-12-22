package monster.sasakisan.tohoku_tech_dojo_day3

import com.xwray.groupie.databinding.BindableItem
import monster.sasakisan.tohoku_tech_dojo_day3.databinding.ItemTodoBinding

data class TodoItem(val text: String) : BindableItem<ItemTodoBinding>() {
    override fun getLayout() = R.layout.item_todo

    override fun bind(viewBinding: ItemTodoBinding, position: Int) {
        viewBinding.textView.text = text
    }
}
