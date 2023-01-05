package com.example.bottomsheet;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;

import com.google.android.material.bottomsheet.BottomSheetDialogFragment;

public class BottomSheet extends BottomSheetDialogFragment {

    BottomSheetListener mListener;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.bottom_sheet, container, false);

        EditText inputUser = view.findViewById(R.id.input);
        Button submit = view.findViewById(R.id.submit);

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mListener.onClicked(inputUser.getText().toString());
            }
        });

        return view;
    }

    public interface BottomSheetListener{
        void onClicked(String text);
    }

    @Override
    public void onAttach(@NonNull Context context) {
        super.onAttach(context);

        try{
            mListener = (BottomSheetListener) context;
        }catch(ClassCastException e){
            throw new ClassCastException(context.toString() + "Interface must be implemented");
        }
    }
}
