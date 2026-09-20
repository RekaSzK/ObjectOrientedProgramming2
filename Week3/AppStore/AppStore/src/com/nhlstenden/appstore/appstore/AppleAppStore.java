package com.nhlstenden.appstore.appstore;

import com.nhlstenden.appstore.data.App;
import com.nhlstenden.appstore.data.Currency;

public class AppleAppStore extends AppStore
{
    private static final double STORE_SHARE = 0.7;

    public AppleAppStore(Currency currency)
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

        if (app.getContainsNudity())
        {
            throw new IllegalArgumentException("The Apple App Store does not accept apps containing nudity.");
        }

        this.addApp(app);
    }

    @Override
    public double getStoreShare()
    {
        return STORE_SHARE;
    }
}