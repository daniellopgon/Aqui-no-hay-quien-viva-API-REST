package edu.iesam.anhqv_api.features.anhqv_api.presentation

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import edu.iesam.anhqv_api.databinding.ItemCharacterBinding
import edu.iesam.anhqv_api.features.anhqv_api.domain.Character
import coil.load

class CharacterAdapter(
    private val dataSet: List<Character>,
    private val onItemClick: (Character) -> Unit
) : RecyclerView.Adapter<CharacterAdapter.ViewHolder>() {
    class ViewHolder(
        private val binding = ItemCharacterBinding
    ) : RecyclerView.ViewHolder(binding.root) {

        fun bind(character: Character, onItemClick: (Character) -> Unit) {
            binding.name.text = character.name
            binding.surname.text = character.surname
            binding.image.load(character.imageUrl) {
                crossfade(true)
            }
            binding.root.setOnClickListener {
                onItemClick(character)
            }
        }
    }


    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        val binding = ItemCharacterBinding
            .inflate(
                LayoutInflater.from(viewGroup.context),
                viewGroup,
                false
            )

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {
        holder.bind(dataSet[position],onItemClick)
    }

    override fun getItemCount() = dataSet.size

}