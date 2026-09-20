package com.nhlstenden.appstore.appstore;

import com.nhlstenden.appstore.data.App;
import com.nhlstenden.appstore.data.Currency;

public class GooglePlayStore extends AppStore
{
    private static final double STORE_SHARE = 1.0;

    public GooglePlayStore(Currency currency)
    {
        super(currency);
    }

    @Override
    public void uploadApp(App app)
    {
        if (app == null)
        {
            throw new IllegalArgumentException("App cannot be null.");
        }

        this.addApp(app);
    }

    @Override
    public double getStoreShare()
    {
        return STORE_SHARE;
    }
}