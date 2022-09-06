package cursos.alain.clase3108;

import android.os.Bundle;

import androidx.annotation.FloatRange;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import cursos.alain.clase3108.databinding.FragmentSecondBinding;
import cursos.alain.clase3108.databinding.FragmentThirdBinding;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ThirdFragment #newInstance} factory method to
 * create an instance of this fragment.
 */
public class ThirdFragment extends Fragment {

    private FragmentThirdBinding binding;


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        // return inflater.inflate(R.layout.fragment_third, container, false);

        binding = FragmentThirdBinding.inflate(inflater, container, false);
        return binding.getRoot();
    }

    @Override
    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this).navigate(R.id.action_thirdFragment_to_SecondFragment);
            }
        });

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(ThirdFragment.this).navigate(R.id.action_thirdFragment_to_FirstFragment);
            }

        });

    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}