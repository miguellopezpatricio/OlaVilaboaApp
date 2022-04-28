package miguellopez.olavilaboaapp.ui.eat;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class EatViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public EatViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ONDE COMER / WHERE TO EAT.");
    }

    public LiveData<String> getText() {
        return mText;
    }
}