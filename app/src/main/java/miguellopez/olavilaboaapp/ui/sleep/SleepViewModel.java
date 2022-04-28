package miguellopez.olavilaboaapp.ui.sleep;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class SleepViewModel extends ViewModel {

    private final MutableLiveData<String> mText;

    public SleepViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("ONDE DURMIR / WHERE TO SLEEP");
    }

    public LiveData<String> getText() {
        return mText;
    }
}