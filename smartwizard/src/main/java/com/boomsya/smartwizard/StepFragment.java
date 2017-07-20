package com.boomsya.smartwizard;

import android.os.Bundle;
import android.support.v4.app.Fragment;

public abstract class StepFragment extends Fragment {
	public abstract void GetDataFromPrevStep(Bundle dest);
}
