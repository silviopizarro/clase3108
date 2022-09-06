package cursos.alain.clase3108;

import android.os.Bundle;
import android.provider.MediaStore;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;

import cursos.alain.clase3108.databinding.FragmentFirstBinding;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding binding;

    private EditText txt_numberOne, txt_numberTwo, txt_respuesta;
    private RadioButton rad_sum, rad_substract, rad_multiply, rad_divide;
    private RadioGroup rad_group;
    private CheckBox checkBox_sum, checkBox_sub, checkBox_mul, checkBox_div;

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {

        binding = FragmentFirstBinding.inflate(inflater, container, false);
        txt_numberOne = (EditText) binding.numberOne;
        txt_numberTwo = (EditText) binding.numberTwo;
        txt_respuesta = (EditText) binding.txtResultado;

        rad_sum = (RadioButton) binding.sum;
        rad_substract = (RadioButton) binding.substract;
        rad_multiply = (RadioButton) binding.multiply;
        rad_divide = (RadioButton) binding.divide;

        rad_group = (RadioGroup) binding.group;


        checkBox_sum = (CheckBox) binding.chbSum;
        checkBox_sub = (CheckBox) binding.chbSubs;
        checkBox_mul = (CheckBox) binding.chbMul;
        checkBox_div = (CheckBox) binding.chbDiv;

        return binding.getRoot();

    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        /**
         binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
        NavHostFragment.findNavController(FirstFragment.this)
        .navigate(R.id.action_FirstFragment_to_SecondFragment);
        }
        });
         **/

        binding.buttonFirst.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                NavHostFragment.findNavController(FirstFragment.this).navigate(R.id.action_FirstFragment_to_SecondFragment);
            }
        });

        binding.calculate.setOnClickListener((View v)->{
            /**
            if(rad_sum.isChecked()){
                sum();
            }else if (rad_substract.isChecked()){
                sub();
            }else if (rad_multiply.isChecked()){
                multiply();
            }else if (rad_divide.isChecked()){
                div();
            }else{
                showMessage();
            }
             **/



            if(checkBox_sum.isChecked() && checkBox_sub.isChecked() && checkBox_mul.isChecked() && checkBox_div.isChecked()) {
                mensajeResultado();
            }else if(checkBox_sum.isChecked() && checkBox_sub.isChecked()) {
                resSumYSub();
            }else if(checkBox_sum.isChecked() && checkBox_mul.isChecked()) {
                resSumYMul();
            }else if(checkBox_sum.isChecked() && checkBox_div.isChecked()) {
                resSumYDiv();
            }else if(checkBox_sub.isChecked() && checkBox_mul.isChecked()) {
                resSubYMul();
            }else if(checkBox_sub.isChecked() && checkBox_div.isChecked()) {
                resSubYDiv();
            }else if(checkBox_mul.isChecked() && checkBox_div.isChecked()){
                resMulYDiv();
            }else if(checkBox_sum.isChecked()){
                sum();
            }else if (checkBox_sub.isChecked()){
                sub();
            }else if(checkBox_mul.isChecked()){
                multiply();
            }else if(checkBox_div.isChecked()) {
                div();
            }else{
                showMessage();
            }


        });
    }

    public void showMessage(){

        Toast.makeText(this.getContext(), "No se ha seleccionado ninguna operación", Toast.LENGTH_SHORT).show();
    }

    public String sum(){
        double val1 = Integer.parseInt(txt_numberOne.getText().toString());
        double val2 = Integer.parseInt(txt_numberTwo.getText().toString());
        double sum = val1 + val2;
        String res = String.valueOf(sum);
        txt_respuesta.setText(res);

        return res;
    }

    public String mensajeResultado(){
        String valSum = sum();
        String valSub = sub();
        String valMul = multiply();
        String valDiv = div();
        
        String resultado = "Suma = "+valSum+ "\nResta = "+valSub+ "\nMultiplicación = "+valMul+ "\nDivisión = "+valDiv;
        txt_respuesta.setText(resultado);
        return resultado;

    }

    public String resSumYSub(){
        String valSum = sum();
        String valSub = sub();

        String resultado = "Suma = "+valSum+ ", resta = "+valSub;
        txt_respuesta.setText(resultado);
        return resultado;

    }

    public String resSumYMul(){
        String valSum = sum();
        String valMul = multiply();

        String resultado = "Suma = "+valSum+ ", multiplicación = "+valMul;
        txt_respuesta.setText(resultado);
        return resultado;

    }

    public String resSumYDiv(){
        String valSum = sum();
        String valDiv = div();
        String resultado = "Suma = "+valSum+ ", división = "+valDiv;
        txt_respuesta.setText(resultado);
        return resultado;

    }

    public String resSubYMul(){
        String valSub = sub();
        String valMul = multiply();

        String resultado = "Resta = "+valSub+ ", multiplicación = "+valMul;
        txt_respuesta.setText(resultado);
        return resultado;

    }

    public String resSubYDiv(){
        String valSub = sub();
        String valDiv = div();

        String resultado = "Resta = "+valSub+ ", división = "+valDiv;
        txt_respuesta.setText(resultado);
        return resultado;

    }

    public String resMulYDiv(){

        String valMul = multiply();
        String valDiv = div();

        String resultado = "Multiplicación = "+valMul+ "\nDivisión = "+valDiv;
        txt_respuesta.setText(resultado);
        return resultado;

    }


    public String sub(){
        double val1 = Integer.parseInt(txt_numberOne.getText().toString());
        double val2 = Integer.parseInt(txt_numberTwo.getText().toString());
        double sub = val1 - val2;
        String res = String.valueOf(sub);
        txt_respuesta.setText(res);

        return res;
    }

    public String multiply(){
        double val1 = Integer.parseInt(txt_numberOne.getText().toString());
        double val2 = Integer.parseInt(txt_numberTwo.getText().toString());
        double mul = val1 * val2;
        String res = String.valueOf(mul);
        txt_respuesta.setText(res);

        return res;
    }

    public String div(){
        double val1 = Integer.parseInt(txt_numberOne.getText().toString());
        double val2 = Integer.parseInt(txt_numberTwo.getText().toString());
        String res = "";
        if (val2!=0){
            double div = val1 / val2;
            res = String.valueOf(div);
            txt_respuesta.setText(res);
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