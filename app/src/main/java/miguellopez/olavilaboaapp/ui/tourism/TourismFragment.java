package miguellopez.olavilaboaapp.ui.tourism;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import miguellopez.olavilaboaapp.databinding.FragmentGalleryBinding;
import miguellopez.olavilaboaapp.databinding.FragmentTourismBinding;

public class TourismFragment extends Fragment {

    private FragmentTourismBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        TourismViewModel tourismViewModel =
                new ViewModelProvider(this).get(TourismViewModel.class);

        binding = FragmentTourismBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textTourism;
        tourismViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}