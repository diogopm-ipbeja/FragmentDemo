package pt.ipbeja.fragmentdemo

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import pt.ipbeja.fragmentdemo.databinding.FragmentFormBinding
import java.util.*

class FormFragment : Fragment() {

    private lateinit var binding: FragmentFormBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = FragmentFormBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Setup distance (number) picker
        with(binding.distancePicker) {
            minValue = 0
            maxValue = 5000
        }

        // Setup submit button
        binding.submitBtn.setOnClickListener {

            val name = binding.nameInput.text.toString()
            val country = binding.countryPicker.selectedItem as String
            val distance = binding.distancePicker.value

            // Podemos criar um objeto Date a partir da data inserida e passá-lo ao próximo fragment
            // Date é um 'Serializable', portanto podemos passar este objeto sem alterações
            // (ver argumentos no ficheiro de navegação app_graph.xml)
            val date = Calendar.getInstance().run {
                set(Calendar.DAY_OF_MONTH, binding.dobPicker.dayOfMonth)
                set(Calendar.MONTH, binding.dobPicker.month)
                set(Calendar.YEAR, binding.dobPicker.year)
                time
            }

            findNavController().navigate(FormFragmentDirections.actionFormFragmentToResultFragment(name, distance, date, country))

        }
    }
}