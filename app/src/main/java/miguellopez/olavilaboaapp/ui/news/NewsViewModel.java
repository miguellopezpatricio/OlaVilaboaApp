package miguellopez.olavilaboaapp.ui.news;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import miguellopez.olavilaboaapp.R;

public class NewsViewModel extends ViewModel {

    private final MutableLiveData<Integer> mText;

    public NewsViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue(R.string.menu_news);
    }

    public LiveData<Integer> getText() {
        return mText;
    }
}