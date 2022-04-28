package miguellopez.olavilaboaapp.ui.eat;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.ViewModelProvider;

import miguellopez.olavilaboaapp.databinding.FragmentEatBinding;
import miguellopez.olavilaboaapp.databinding.FragmentGalleryBinding;

public class EatFragment extends Fragment {

    private FragmentEatBinding binding;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        EatViewModel eatViewModel =
                new ViewModelProvider(this).get(EatViewModel.class);

        binding = FragmentEatBinding.inflate(inflater, container, false);
        View root = binding.getRoot();

        final TextView textView = binding.textEat;
        eatViewModel.getText().observe(getViewLifecycleOwner(), textView::setText);
        return root;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        binding = null;
    }
}