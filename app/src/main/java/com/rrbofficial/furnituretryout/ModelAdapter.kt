package com.rrbofficial.furnituretryout

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.item_model.view.ivThumbnail
import kotlinx.android.synthetic.main.item_model.view.tvTitle

class ModelAdapter(
    val models: List<Model>
): RecyclerView.Adapter<ModelAdapter.ModelViewHolder>()
{
    inner class ModelViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ModelViewHolder {
    val view = LayoutInflater.from(parent.context).inflate(R.layout.item_model, parent, false)
        return ModelViewHolder(view)
    }

    override fun onBindViewHolder(holder: ModelViewHolder, position: Int) {
    holder.itemView.apply {
        ivThumbnail.setImageResource(models[position].imageResourceId)
        tvTitle.text = models[position].title
    }
    }

    override fun getItemCount(): Int  = models.size

}