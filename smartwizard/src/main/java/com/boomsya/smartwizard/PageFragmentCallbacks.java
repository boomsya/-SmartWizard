package com.boomsya.smartwizard;

import android.os.Bundle;

public interface PageFragmentCallbacks {
    Page onGetPage(String key);
    Integer getPagescount();
}
