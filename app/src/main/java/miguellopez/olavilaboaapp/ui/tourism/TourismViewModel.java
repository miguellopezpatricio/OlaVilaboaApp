package miguellopez.olavilaboaapp.ui.tourism;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import miguellopez.olavilaboaapp.R;

public class TourismViewModel extends ViewModel {

    private final MutableLiveData<Integer> mText;

    public TourismViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.menu_tourism);
    }

    public LiveData<Integer> getText() {
        return mText;
    }
}