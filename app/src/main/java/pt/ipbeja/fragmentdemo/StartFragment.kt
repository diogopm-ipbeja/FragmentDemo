package pt.ipbeja.fragmentdemo

import androidx.lifecycle.ViewModelProvider
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.fragment.findNavController
import pt.ipbeja.fragmentdemo.databinding.StartFragmentBinding

class StartFragment : Fragment() {

    private lateinit var binding: StartFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View = StartFragmentBinding.inflate(inflater).let {
        this.binding = it
        it.root
    }


    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        this.binding.startBtn.setOnClickListener {
            findNavController().navigate(StartFragmentDirections.actionStartFragmentToFormFragment())
        }
    }

}


