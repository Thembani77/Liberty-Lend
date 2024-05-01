package com.example.libertylend;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;

import io.github.muddz.styleabletoast.StyleableToast;

public class myDialog extends DialogFragment {

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder builder = new AlertDialog.Builder(getContext());
        builder.setIcon(R.drawable.banklogo);
        builder.setTitle("Information")
                .setMessage("Do you want to exit the application?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        Toast.makeText(getActivity(),"Quick One, What do you think about our app?",Toast.LENGTH_SHORT).show();

                        System.exit(0);
                    }

                })
                .setNegativeButton("No", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        StyleableToast.makeText(getActivity(), "Thank you for choosing us", Toast.LENGTH_SHORT, R.style.dialog).show();
                    }
                });

        return  builder.create();

    }
}
