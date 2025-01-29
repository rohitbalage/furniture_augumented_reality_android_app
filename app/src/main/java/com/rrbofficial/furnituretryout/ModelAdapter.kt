package com.rrbofficial.furnituretryout

import android.graphics.Color
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_model.view.ivThumbnail
import kotlinx.android.synthetic.main.item_model.view.tvTitle

const val SELECTED_MODEL_COLOR = Color.YELLOW
const val UNSELECTED_MODEL_COLOR = Color.LTGRAY

class ModelAdapter(
    val models: List<Model>
): RecyclerView.Adapter<ModelAdapter.ModelViewHolder>()
{

    val selectedModel = MutableLiveData<Model>()
    private  var selectedModelIndex = 0

    inner class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {

        if(selectedModelIndex == holder.layoutPosition)
        {
            holder.itemView.setBackgroundColor(SELECTED_MODEL_COLOR)
            selectedModel.value = models[holder.adapterPosition]
        }
        else
        {
            holder.itemView.setBackgroundColor(UNSELECTED_MODEL_COLOR)
        }

    holder.itemView.apply {
        ivThumbnail.setImageResource(models[position].imageResourceId)
        tvTitle.text = models[position].title

        setOnClickListener {
            selectModel(holder)
        }
    }
    }

    override fun getItemCount(): Int  = models.size


    private fun selectModel(holder: ModelViewHolder)
    {
        if(selectedModelIndex != holder.layoutPosition)
        {
            holder.itemView.setBackgroundColor(SELECTED_MODEL_COLOR)
            notifyItemChanged(selectedModelIndex)
            selectedModel.value = models[holder.adapterPosition]
            selectedModelIndex = holder.layoutPosition
        }
    }
}