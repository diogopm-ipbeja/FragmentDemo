package pt.ipbeja.fragmentdemo

import android.os.Bundle
import android.text.format.DateFormat
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import androidx.navigation.fragment.navArgs
import pt.ipbeja.fragmentdemo.databinding.ResultFragmentBinding

class ResultFragment : Fragment() {

    private val dateFormat = "dd/MM/yyyy"

    private val args : ResultFragmentArgs by navArgs()

    private lateinit var binding: ResultFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = ResultFragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {

        with(binding) {
            name.text = args.name

            // Recebemos um objeto do tipo Date, podemos formatar esse objeto numa String (ver atributo dateFormat)
            dob.text = DateFormat.format(dateFormat, args.dateOfBirth)

            // Podemos obter a string "plural" usando o objeto resources e passando-lhe a quantidade e os argumentos a injetar na String
            // Neste e em muitos casos, os argumentos são exactamente os mesmos
            val distanceText = resources.getQuantityString(R.plurals.distance, args.distance, args.distance)
            distance.text = distanceText
            country.text = args.country
        }

        binding.finishBtn.setOnClickListener {

            // Visto que é o passo final do formulário, ao pressionar no botão é desejável que se
            // volte ao passo inicial, neste caso é o StartFragment
            findNavController().popBackStack(R.id.startFragment, false)
        }

    }
}