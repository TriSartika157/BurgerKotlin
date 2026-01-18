package com.example.burgerkotlin.ui.role.admin.main.order_management

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.view.menu.MenuAdapter
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.burgerkotlin.R
import com.example.burgerkotlin.databinding.FragmentDashboardBinding
import com.example.burgerkotlin.databinding.FragmentOrderBinding
import com.example.burgerkotlin.model.MenuModels
import com.example.burgerkotlin.model.MenuResponse
import com.example.burgerkotlin.ui.auth.viewmodel.AuthViewModel
import com.example.burgerkotlin.ui.role.admin.NavigationActivity
import kotlin.getValue

class OrderFragment : Fragment() {

    private var _binding: FragmentOrderBinding? = null
    private val binding get() = _binding!!

    private val viewModel: MenuViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        _binding = FragmentOrderBinding.inflate(inflater, container, false)
        val root: View = binding.root
        return root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        binding.btnSimpan.setOnClickListener {
            val et_nama_burger = binding.etNamaBurger.text.toString()
            val et_deskripsi = binding.etDeskripsi.text.toString()
            val et_harga = binding.etHarga.text.toString()
            val linkUpload = binding.linkUpload.text.toString()

            if (et_nama_burger.isNotEmpty() && et_deskripsi.isNotEmpty() && et_harga.isNotEmpty() && linkUpload.isNotEmpty()) {
                viewModel.menuCreate(
                    MenuModels(
                        et_nama_burger,
                        et_deskripsi,
                        et_harga.toInt(),
                        linkUpload
                    )
                ) { success, message ->
                    runCatching {
                        Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
                        if (success) {
                            Toast.makeText(requireActivity(), message, Toast.LENGTH_SHORT).show()
                            binding.etNamaBurger.setText("")
                            binding.etDeskripsi.setText("")
                            binding.etHarga.setText("")
                           binding.linkUpload.setText("")
                        } else {
                            Toast.makeText(
                                requireActivity(),
                                "Gagal Simpan Menu",
                                Toast.LENGTH_SHORT
                            )
                                .show()
                        }
                    }
                }
            } else {
                Toast.makeText(requireActivity(), "Cek Menu Burger", Toast.LENGTH_SHORT).show()
            }

            binding.rvMenu.layoutManager = LinearLayoutManager(requireActivity())
            viewModel.getMenu { data, response ->
                runCatching {
                    if (data) {
                        binding.rvMenu.adapter = AdapterMenu(response) { menu ->
                            Toast.makeText(requireActivity(), menu.name, Toast.LENGTH_SHORT).show()
                        }
                    }
                }
            }
        }
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

}