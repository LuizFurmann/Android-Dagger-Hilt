package com.example.portifolio.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.Filter
import android.widget.Filterable
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import com.example.portifolio.databinding.CardItemBinding
import com.example.portifolio.model.User
import java.util.Locale


class UserAdapter : RecyclerView.Adapter<UserAdapter.MyViewHolder>(), Filterable {

    var listUser: ArrayList<User> = ArrayList()
    var filteredListItems: ArrayList<User> = ArrayList()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view  = CardItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val account = listUser.get(position)
        holder.bind(account)

        holder.itemView.setOnClickListener {
            Toast.makeText(holder.itemView.context, "User ${account.name}", Toast.LENGTH_SHORT).show()
        }
    }

    override fun getItemCount(): Int {
        return listUser.size
    }

    fun updateList(listUser: List<User>?) {
        filteredListItems.clear()
        this.listUser.clear()
        this.listUser.addAll(listUser!!)
        this.filteredListItems.addAll(listUser)
    }

    override fun getFilter(): Filter {
        return object : Filter() {
            override fun performFiltering(charSequence: CharSequence): FilterResults {
                val searchText = charSequence.toString().lowercase(Locale.getDefault())
                listUser.clear()
                if (searchText.isEmpty()) {
                    listUser.addAll(filteredListItems)
                } else {
                    for (item in filteredListItems) {
                        if (searchText.isNotEmpty() && item.name.lowercase(Locale.getDefault()).contains(searchText)) {
                            listUser.add(item)
                        }
                    }
                }
                val filterResults = FilterResults()
                filterResults.values = listUser
                return filterResults
            }

            override fun publishResults(charSequence: CharSequence, filterResults: FilterResults) {
                @Suppress("UNCHECKED_CAST")
                listUser = filterResults.values as ArrayList<User>
                notifyDataSetChanged()
            }
        }
    }

    class MyViewHolder(private val binding: CardItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun bind(user: User) {
            binding.name.text = user.name
            //            Glide.with(thumbImage)
//                .load(user.owner.avatar_url)
//                .into(thumbImage)
        }




    }
}