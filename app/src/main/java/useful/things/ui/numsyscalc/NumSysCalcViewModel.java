package useful.things.ui.numsyscalc;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

public class NumSysCalcViewModel extends ViewModel {

    private MutableLiveData<String> mText;

    public NumSysCalcViewModel() {
        mText = new MutableLiveData<>();
        mText.setValue("This is send fragment");
    }

    public LiveData<String> getText() {
        return mText;
    }
}