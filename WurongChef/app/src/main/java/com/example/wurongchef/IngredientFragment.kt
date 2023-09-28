package com.example.wurongchef

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import android.widget.ImageButton
import android.widget.Toast

class IngredientFragment : Fragment() {

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        val view = inflater.inflate(R.layout.fragment_ingredient, container, false)

        val floatingButton = view.findViewById<ImageButton>(R.id.floatingButton)

        floatingButton.setOnClickListener {
            // 버튼이 클릭되었을 때 수행할 동작을 여기에 작성
            Toast.makeText(requireContext(), "Floating button clicked in IngredientFragment", Toast.LENGTH_SHORT).show()


        }

        return view
    }
}