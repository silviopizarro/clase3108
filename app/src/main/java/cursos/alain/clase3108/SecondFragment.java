package cursos.alain.clase3108;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.Spinner;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import cursos.alain.clase3108.databinding.FragmentSecondBinding;

public class SecondFragment extends Fragment {

    private FragmentSecondBinding binding;

    private EditText txt_num1, txt_num2, txt_resp2;
    private Spinner sp_operations;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentSecondBinding.inflate(inflater, container, false);

        txt_num1 = (EditText) binding.number1;
        txt_num2 = (EditText) binding.number2;
        txt_resp2 = (EditText) binding.txtResp2;
        sp_operations = (Spinner) binding.spOperations;

        String [] operations=
                {
                    "Sumar",
                    "Restar",
                    "Multiplicar",
                    "Dividir",
        };

        /**ArrayAdapter<String> adapter = new ArrayAdapter<>(this.getContext(), androidx.appcompat.R.layout.support_simple_spinner_dropdown_item,operations);
        sp_operations.setAdapter(adapter);
         **/

        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this.getContext(), R.layout.desingspinner,operations);
        adapter2.setDropDownViewResource(R.layout.dropdown_item);
        sp_operations.setAdapter(adapter2);
        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        binding.buttonSecond.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this)
                        .navigate(R.id.action_SecondFragment_to_FirstFragment);
            }
        });

        binding.buttonThird.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(SecondFragment.this).navigate(R.id.action_SecondFragment_to_thirdFragment);
            }
        });

        binding.btnCalc.setOnClickListener((View v) ->
        {
           String numberOne = txt_num1.getText().toString();
           String numberTwo = txt_num2.getText().toString();


           if (numberOne.isEmpty() || numberTwo.isEmpty()){
               showMessageEmpty();
           }else{
               String selected = sp_operations.getSelectedItem().toString();

               switch (selected){
                   case "Sumar": {
                       sum();
                       break;
                   }
                   case "Restar":{
                       sub();
                       break;
                   }
                   case "Multiplicar":{
                       multiply();
                       break;
                   }
                   case "Dividir":{
                       div();
                       break;
                   }
                   default:{
                       showMessageEmpty();
                   }
               }
           }



        });
    }

        public void showMessageEmpty(){
            Toast.makeText(this.getContext(), "Todos los campos son obligatorios", Toast.LENGTH_SHORT).show();
        }

        public String sum(){
            double val1 = Integer.parseInt(txt_num1.getText().toString());
            double val2 = Integer.parseInt(txt_num2.getText().toString());
            double sum = val1 + val2;
            String res = String.valueOf(sum);
            txt_resp2.setText(res);

            return res;
        }

    public String sub(){
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double sub = val1 - val2;
        String res = String.valueOf(sub);
        txt_resp2.setText(res);

        return res;
    }

    public String multiply(){
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        double mul = val1 * val2;
        String res = String.valueOf(mul);
        txt_resp2.setText(res);

        return res;
    }

    public String div(){
        double val1 = Integer.parseInt(txt_num1.getText().toString());
        double val2 = Integer.parseInt(txt_num2.getText().toString());
        String res = "";
        if (val2!=0){
            double div = val1 / val2;
            res = String.valueOf(div);
            txt_resp2.setText(res);
        }else{
            Toast.makeText(this.getContext(), "No se puede dividir por 0", Toast.LENGTH_SHORT).show();

        }
        return res;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }

}