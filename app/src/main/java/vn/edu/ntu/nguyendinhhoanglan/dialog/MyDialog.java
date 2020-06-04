package vn.edu.ntu.nguyendinhhoanglan.dialog;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import vn.edu.ntu.nguyendinhhoanglan.dialog.IConfirmData;


public class MyDialog extends DialogFragment {
    IConfirmData confirmData;

    public MyDialog(IConfirmData confirmData) {
        this.confirmData = confirmData;
    }

    @NonNull
    @Override
    public Dialog onCreateDialog(@Nullable Bundle savedInstanceState) {
        AlertDialog.Builder dialog = new AlertDialog.Builder(getActivity());
        dialog.setTitle("Confirming");
        dialog.setMessage("Are you sure?");
        dialog.setPositiveButton("Yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(confirmData != null)
                    confirmData.confirm(true);
            }
        });
        dialog.setNegativeButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                if(confirmData != null)
                    confirmData.confirm(false);
            }
        });

        return dialog.create();
    }
}
