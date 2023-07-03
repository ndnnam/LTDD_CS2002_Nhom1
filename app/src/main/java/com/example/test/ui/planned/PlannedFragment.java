package com.example.test.ui.planned;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import com.example.test.databinding.FragmentPlannedBinding;

public class PlannedFragment extends Fragment {

    private FragmentPlannedBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        PlannedViewModel slideshowViewModel =
                new ViewModelProvider(this).get(PlannedViewModel.class);

        binding = FragmentPlannedBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.txtPlanned;
        slideshowViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}