package com.xr6software.githubapp.view;

import android.os.Bundle;
import android.text.InputFilter;
import android.util.Log;
import android.view.View;
import android.view.inputmethod.EditorInfo;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.xr6software.githubapp.R;
import com.xr6software.githubapp.databinding.ActivityMainBinding;
import com.xr6software.githubapp.viewmodel.MainActivityViewModel;

public class MainActivity extends AppCompatActivity {

    private MainActivityViewModel viewModel;
    private ActivityMainBinding viewBinding;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        viewBinding = ActivityMainBinding.inflate(getLayoutInflater());
        View view = viewBinding.getRoot();
        setContentView(view);

        viewModel =  new ViewModelProvider(this).get(MainActivityViewModel.class);

        setUserInputMaxLength();
        setOnClickListeners();
        setObservers();

    }

    private void setUserInputMaxLength() {

        int maxLength = 4;
        viewBinding.maEdittext0Usrinput.setFilters(new InputFilter[] {new InputFilter.LengthFilter(maxLength)});

    }

    private void setObservers() {
        viewModel.getRollValue().observe(this, new Observer<Integer>() {
            @Override
            public void onChanged(Integer integer) {
                viewBinding.maTxtvw1Result.setText(integer.toString());
            }
        });
    }

    private void setOnClickListeners(){

        viewBinding.maBtn0.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                viewBinding.maEdittext0Usrinput.onEditorAction(EditorInfo.IME_ACTION_DONE);
                if (checkUserInput()) {
                    viewModel.createDice(viewBinding.maEdittext0Usrinput.getText().toString());
                }
                else {showErrorMsg();}
            }
        });

    }

    private boolean checkUserInput(){
        return ( viewBinding.maEdittext0Usrinput.getText().toString().length() > 0 );
    }

    private void showErrorMsg() {
        Toast.makeText(this, getResources().getString(R.string.ma_input_msg), Toast.LENGTH_SHORT).show();
    }

}