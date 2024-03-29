package com.example.myapplication

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.myapplication.databinding.FragmentBlankBinding
import net.objecthunter.exp4j.ExpressionBuilder

class BlankFragment : Fragment(R.layout.fragment_blank) {

    private lateinit var binding: FragmentBlankBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        binding = FragmentBlankBinding.inflate(inflater, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding.btn0.setOnClickListener { adicionarValor("0") };
        binding.btn1.setOnClickListener { adicionarValor("1") };
        binding.btn2.setOnClickListener { adicionarValor("2") };
        binding.btn3.setOnClickListener { adicionarValor("3") };
        binding.btn4.setOnClickListener { adicionarValor("4") };
        binding.btn5.setOnClickListener { adicionarValor("5") };
        binding.btn6.setOnClickListener { adicionarValor("6") };
        binding.btn7.setOnClickListener { adicionarValor("7") };
        binding.btn8.setOnClickListener { adicionarValor("8") };
        binding.btn9.setOnClickListener { adicionarValor("9") };
        binding.btnMult.setOnClickListener { adicionarValor("*") };
        binding.btnPonto.setOnClickListener { adicionarValor(",") };
        binding.btnSoma.setOnClickListener { adicionarValor("+") };
        binding.btnPi.setOnClickListener { adicionarValor("3,14159") };
        binding.btnLimpar.setOnClickListener { limpar() };
        binding.btnQuadrado.setOnClickListener { adicionarValor("²") };
        binding.btnSub.setOnClickListener { adicionarValor("-") };
        binding.btnPcts.setOnClickListener { adicionarValor("%") };
        binding.btnResult.setOnClickListener { calcular() };
        binding.btnDiv.setOnClickListener { adicionarValor("/") };
    }

    private fun calcular() {
        var textAtual = binding.textResult.text.toString()
        var resultado = ExpressionBuilder(textAtual).build().evaluate()
        binding.textResult.text = resultado.toString()
    }

    private fun adicionarValor(valor: String) {
        var textAtual = binding.textResult.text.toString()
        binding.textResult.text = textAtual + valor
    }

    private fun limpar() {
        binding.textResult.text = ""
    }

}