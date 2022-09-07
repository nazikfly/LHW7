package com.geektech.lhw7

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.geektech.lhw7.databinding.ItemRmBinding

class CharacterAdapter(
    private val data: ArrayList<CharacterModel>,
    private val onClick: (model: CharacterModel) -> Unit
) :
    RecyclerView.Adapter<CharacterAdapter.RMViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RMViewHolder {
        return RMViewHolder(
            ItemRmBinding.inflate(
                LayoutInflater.from(parent.context),
                parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: RMViewHolder, position: Int) {
        holder.bind(data[position])
    }

    override fun getItemCount(): Int = data.size

    inner class RMViewHolder(private val binding: ItemRmBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(characterModel: CharacterModel) {

            characterModel.image?.let { binding.imageCharacter.setImageResource(it) }
            binding.characterName.text = characterModel.name
            binding.characterStatus.text = characterModel.status
            itemView.setOnClickListener {
                onClick(characterModel)
            }
        }
    }

}


